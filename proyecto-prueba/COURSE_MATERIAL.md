
# Material del Curso: Construyendo una Aplicación con Spring Boot

Este documento explica, paso a paso, cada una de las capas y componentes que hemos implementado en este proyecto. Está diseñado como material educativo para entender la estructura de una aplicación moderna con Spring Boot.

---

### Capítulo 1: El Corazón de los Datos - La Entidad (`Entity`)

**¿Qué es?**  
Una Entidad es una clase Java que representa una tabla en nuestra base de datos. Es el pilar fundamental de nuestro modelo de datos. Usamos la especificación **JPA (Java Persistence API)** para definirla.

**En nuestro proyecto:**  
El archivo `entity/Pregunta.java` es nuestra única entidad.

```java
@Entity // Le dice a JPA: "Esta clase corresponde a una tabla en la BD".
public class Pregunta {

    @Id // Marca este campo como la clave primaria (Primary Key).
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Le dice a la BD que genere el valor por nosotros (autoincremental).
    private Long id;

    @NotBlank // Anotación de validación: este campo no puede estar vacío.
    private String enunciado;

    private boolean respuesta;
    
    // ... constructores, getters y setters
}
```

**Orden de implementación:** Es lo **primero** que se define después de la configuración inicial del proyecto, ya que toda la aplicación girará en torno a este modelo de datos.

---

### Capítulo 2: El Guardián de los Datos - El Repositorio (`Repository`)

**¿Qué es?**  
Un Repositorio es una interfaz que se encarga exclusivamente de la comunicación con la base de datos (operaciones CRUD: Crear, Leer, Actualizar, Borrar). **Spring Data JPA** nos da una potencia increíble: con solo definir la interfaz, Spring crea automáticamente la implementación en tiempo de ejecución.

**En nuestro proyecto:**  
El archivo `repository/PreguntaRepository.java` es nuestro repositorio.

```java
@Repository // Anotación (opcional pero recomendada) que lo marca como un bean de acceso a datos.
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {

    // Spring Data JPA nos regala métodos como:
    // - save(Pregunta p)
    // - findById(Long id)
    // - findAll()
    // - deleteById(Long id)
    // - ¡Y muchos más!

    // También podemos añadir consultas personalizadas, como esta para obtener preguntas aleatorias.
    @Query(value = "SELECT * FROM pregunta ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Pregunta> findRandomPreguntas(@Param("count") int count);
}
```

**Orden de implementación:** Justo **después de la Entidad**. Una vez que tienes el modelo de datos, necesitas una forma de acceder a él.

---

### Capítulo 3: El Cerebro de la Aplicación - La Capa de Servicio (`Service`)

**¿Qué es?**  
La capa de Servicio contiene la **lógica de negocio** de la aplicación. Su función es orquestar las llamadas a uno o más repositorios, aplicar reglas, realizar cálculos y, en general, resolver los problemas de negocio. Desacopla al controlador de los detalles de la base de datos.

**En nuestro proyecto:**  
La interfaz `service/PreguntaService.java` define el contrato, y `service/impl/PreguntaServiceImpl.java` lo implementa.

```java
@Service // Marca esta clase como un componente de lógica de negocio.
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    // Usamos inyección por constructor: es una buena práctica que asegura que el servicio
    // siempre tendrá las dependencias que necesita.
    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    @Transactional // Anotación clave: asegura que un método se ejecute en una única transacción de BD.
    public ResultadoRespuestaDTO verificarRespuesta(Long preguntaId, boolean respuestaUsuario) {
        // 1. Llama al repositorio para obtener los datos.
        Pregunta pregunta = preguntaRepository.findById(preguntaId)
                .orElseThrow(() -> new ResourceNotFoundException(...));

        // 2. Aplica la lógica de negocio.
        boolean esCorrecta = pregunta.isRespuesta() == respuestaUsuario;
        String mensaje = esCorrecta ? "¡Respuesta correcta!" : "Respuesta incorrecta.";

        // 3. Devuelve un resultado.
        return new ResultadoRespuestaDTO(preguntaId, esCorrecta, mensaje);
    }
    // ... otros métodos
}
```

**Orden de implementación:** **Después del Repositorio**. El servicio utiliza el repositorio para funcionar.

---

### Capítulo 4: La Puerta al Mundo (API) - El Controlador REST (`RestController`)

**¿Qué es?**  
Un `RestController` expone la funcionalidad de nuestra aplicación a través de endpoints HTTP, permitiendo que otras aplicaciones (frontends de JavaScript, apps móviles, otros backends) se comuniquen con nosotros. Habla en un lenguaje universal: JSON.

**En nuestro proyecto:**  
El archivo `controller/PreguntaController.java` gestiona nuestra API.

```java
@RestController // Combinación de @Controller y @ResponseBody. Convierte las respuestas a JSON automáticamente.
@RequestMapping("/preguntas") // Todas las URLs de este controlador empezarán con "/preguntas".
public class PreguntaController {

    private final PreguntaService preguntaService;
    // ... y el Mapper

    @GetMapping("/{id}") // Responde a peticiones GET en "/preguntas/{id}"
    public ResponseEntity<PreguntaDTO> getPreguntaById(@PathVariable Long id) {
        // 1. Llama al servicio para obtener el resultado.
        Pregunta pregunta = preguntaService.findById(id)
                .orElseThrow(...);
        
        // 2. Convierte la entidad a DTO (ver siguiente capítulo).
        // 3. Devuelve una respuesta HTTP con el DTO y un código de estado (200 OK).
        return ResponseEntity.ok(preguntaMapper.toPreguntaDTO(pregunta));
    }
    // ... otros endpoints (POST, PUT, DELETE)
}
```

**Orden de implementación:** **Después del Servicio**. El controlador es un cliente de la capa de servicio.

---

### Capítulo 5: El Contrato de la API - Los DTOs y el Mapper

**¿Qué es un DTO?**  
Un **DTO (Data Transfer Object)** es una clase simple que define la estructura de los datos que se envían o reciben a través de la API. Su uso es una **práctica fundamental** para no exponer nuestro modelo de base de datos (`Entity`) al mundo exterior. Esto nos da seguridad y flexibilidad.

**¿Qué es un Mapper?**  
Es una clase de utilidad cuya única responsabilidad es convertir objetos `Entity` a `DTO` y viceversa.

**En nuestro proyecto:**  
*   `dto/PreguntaDTO.java`: Lo que enviamos al cliente.
*   `dto/PreguntaRequestDTO.java`: Lo que recibimos del cliente, con validaciones (`@NotBlank`).
*   `mapper/PreguntaMapper.java`: El conversor.

```java
// DTO para enviar datos (usando un 'record' de Java 17 para ser concisos)
public record PreguntaDTO(Long id, String enunciado, boolean respuesta) {}

// Mapper
@Component // Lo marcamos como un bean de Spring para poder inyectarlo.
public class PreguntaMapper {
    public PreguntaDTO toPreguntaDTO(Pregunta pregunta) {
        return new PreguntaDTO(pregunta.getId(), ...);
    }
    // ...
}
```

**Orden de implementación:** **Junto con el `RestController`**. Se crean para definir el "contrato" que el controlador va a cumplir.

---

### Capítulo 6: Manejo de Errores en la API - Excepciones Globales

**¿Qué es?**  
En lugar de que cada método del controlador maneje sus propios errores en bloques `try-catch`, centralizamos toda la lógica de manejo de errores en una única clase. Esto nos da respuestas de error consistentes y un código mucho más limpio.

**En nuestro proyecto:**  
`exception/handler/GlobalExceptionHandler.java`.

```java
@RestControllerAdvice // Le dice a Spring: "Vigila todos los @RestController y si ocurre una excepción, avísame".
public class GlobalExceptionHandler {

    // Este método se ejecutará si se lanza una ResourceNotFoundException en cualquier controlador.
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        // Construye un DTO de error estandarizado.
        ErrorResponseDTO errorResponse = new ErrorResponseDTO(...);
        // Devuelve una respuesta HTTP con el DTO y el código 404 Not Found.
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    // ... otros manejadores para errores de validación, etc.
}
```

**Orden de implementación:** Se puede añadir en cualquier momento, pero es bueno hacerlo **temprano en el desarrollo de la API** para estandarizar los errores desde el principio.

---

### Capítulo 7: La Ventana al Mundo (Web) - El Controlador de Vistas y Thymeleaf

**¿Qué es?**  
A diferencia de un `RestController` que devuelve JSON, un `@Controller` tradicional devuelve el nombre de una vista (una plantilla HTML) para que sea renderizada y mostrada en un navegador. **Thymeleaf** es el motor de plantillas que usamos para procesar esos HTML, permitiéndonos insertar datos dinámicamente.

**En nuestro proyecto:**  
*   `controller/view/PreguntaViewController.java` y `JuegoViewController.java`.
*   Todas las plantillas en `src/main/resources/templates/`.

```java
@Controller // ¡No "Rest"!
@RequestMapping("/view/preguntas")
public class PreguntaViewController {

    private final PreguntaService preguntaService;

    @GetMapping
    public String listPreguntas(Model model, Pageable pageable) {
        // 1. Llama al servicio para obtener los datos.
        Page<Pregunta> paginaPreguntas = preguntaService.findAll(pageable);
        
        // 2. Añade los datos al "Model". El modelo es un mapa que Thymeleaf podrá leer.
        model.addAttribute("paginaPreguntas", paginaPreguntas);
        
        // 3. Devuelve el nombre del archivo HTML que debe ser renderizado.
        return "preguntas/list";
    }
}
```

**Orden de implementación:** Se puede implementar en paralelo a la API REST, o después, una vez que la lógica de negocio en el servicio ya es sólida.

---

### Capítulo 8: La Red de Seguridad - Pruebas Unitarias y de Integración

**¿Qué son?**  
Las pruebas son código que prueba nuestro código, asegurando que funciona como se espera y previniendo errores futuros (regresiones).

*   **Pruebas Unitarias:** Prueban una única clase de forma aislada. Usamos **Mockito** para simular (`mock`) sus dependencias.
*   **Pruebas de Integración:** Prueban cómo varias partes de la aplicación funcionan juntas.

**En nuestro proyecto:**  
*   `service/impl/PreguntaServiceImplTest.java` (Test Unitario):
    *   Usa `@Mock` para simular el `PreguntaRepository`.
    *   Verifica que la lógica del servicio es correcta sin tocar la base de datos.
*   `controller/PreguntaControllerTest.java` (Test de Integración):
    *   Usa `@WebMvcTest` para probar solo la capa web.
    *   Usa `@MockBean` para simular el `PreguntaService`.
    *   Usa `MockMvc` para simular peticiones HTTP y verificar las respuestas JSON.

**Orden de implementación:** Idealmente, **se escriben junto con el código de la aplicación (TDD)**. En la práctica, a menudo se añaden después de implementar una funcionalidad para asegurar su calidad antes de pasar a la siguiente.

---

### Capítulo 9: La Documentación Interactiva - Swagger (OpenAPI)

**¿Qué es?**  
En lugar de documentar nuestra API a mano, usamos una herramienta que la documenta automáticamente a partir del propio código. **Springdoc** es la librería que lo hace posible, generando una página web interactiva (Swagger UI) donde se pueden ver y probar todos los endpoints.

**En nuestro proyecto:**  
Simplemente añadimos una dependencia en el `pom.xml`:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

¡Y ya está! Con solo esto, la documentación se genera automáticamente en `http://localhost:8080/swagger-ui.html`.

**Orden de implementación:** Se puede añadir en **cualquier momento**. Es muy útil tenerla desde el principio del desarrollo de la API.

---

### Capítulo 10: La Configuración del Proyecto - `pom.xml` y `application.properties`

**¿Qué son?**  
*   **`pom.xml`**: El corazón de un proyecto Maven. Define las "coordenadas" del proyecto (nombre, versión) y, lo más importante, gestiona todas las **dependencias** (las librerías que usamos, como Spring Boot, H2, Thymeleaf, etc.).
*   **`application.properties`**: El archivo de configuración principal de Spring Boot. Aquí definimos cómo se conecta a la base de datos, el puerto del servidor, la configuración de JPA, etc.

**Orden de implementación:** Es lo **primerísimo** que se configura al crear el proyecto. Define los cimientos sobre los que se construye todo lo demás.
