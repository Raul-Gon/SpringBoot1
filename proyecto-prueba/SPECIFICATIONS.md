# Especificaciones del Proyecto: Preguntas y Respuestas

## 1. Especificación Funcional

**Documento:** Especificación Funcional  
**Proyecto:** Aplicación de Preguntas y Respuestas  
**Versión:** 1.0  

### 1.1. Resumen General

El sistema es una aplicación web que permite la gestión y la resolución de preguntas de verdadero o falso. Proporciona dos interfaces principales: una interfaz web para la administración de preguntas y para jugar, y una API REST para la interacción programática.

### 1.2. Características y Funcionalidades

#### 1.2.1. Gestión de Preguntas (CRUD)

Esta funcionalidad está disponible a través de una interfaz web con estilos de Bootstrap.

*   **Listar Preguntas:**
    *   El sistema muestra una lista paginada de todas las preguntas existentes en la base de datos.
    *   La lista muestra el ID, el enunciado y la respuesta (Verdadero/Falso) de cada pregunta.
    *   La lista permite la ordenación por cada una de sus columnas (ID, enunciado, respuesta).
    *   El usuario puede navegar entre las diferentes páginas de resultados.

*   **Crear una Pregunta:**
    *   El usuario puede acceder a un formulario para crear una nueva pregunta.
    *   Se debe proporcionar un enunciado y especificar si la respuesta es verdadera o falsa.
    *   El enunciado es un campo obligatorio.

*   **Ver una Pregunta:**
    *   El usuario puede ver los detalles de una pregunta específica en una página no editable.

*   **Editar una Pregunta:**
    *   El usuario puede modificar el enunciado y la respuesta de una pregunta existente.

*   **Eliminar una Pregunta:**
    *   El usuario puede eliminar una pregunta de la base de datos de forma permanente.

#### 1.2.2. Modo de Juego

Esta funcionalidad está disponible a través de una interfaz web.

*   **Juego de Pregunta Única:**
    *   El sistema presenta al usuario una pregunta aleatoria de la base de datos.
    *   El usuario responde haciendo clic en los botones "Verdadero" o "Falso".
    *   El sistema informa inmediatamente si la respuesta fue correcta o incorrecta.
    *   El usuario tiene la opción de jugar de nuevo con otra pregunta aleatoria.

*   **Simulación de Pregunta Específica:**
    *   Desde la lista de gestión, el usuario puede hacer clic en "Simular" en una pregunta específica para responderla directamente.
    *   Tras responder, el sistema informa del resultado y ofrece la opción de volver a la lista de gestión.

*   **Juego en Modo Partida:**
    *   El sistema presenta al usuario una partida con un número fijo de preguntas aleatorias (actualmente 5).
    *   El usuario responde a todas las preguntas en un único formulario.
    *   Al finalizar, el sistema corrige la partida y muestra una puntuación final (ej: "Has acertado 3 de 5 preguntas").
    *   El usuario tiene la opción de empezar una nueva partida.

#### 1.2.3. Documentación de la API

*   El sistema expone una interfaz web interactiva (Swagger UI) que documenta todos los endpoints de la API REST.
*   Esta interfaz permite a los desarrolladores ver los detalles de cada endpoint (URL, método HTTP, parámetros, cuerpos de petición/respuesta) y probarlos directamente desde el navegador.

---

## 2. Especificación Técnica Detallada

**Documento:** Especificación Técnica  
**Proyecto:** Aplicación de Preguntas y Respuestas  
**Versión:** 1.0  

### 2.1. Arquitectura y Tecnologías

*   **Framework Principal:** Spring Boot 3.2.5
*   **Lenguaje:** Java 17
*   **Gestión de Dependencias:** Apache Maven
*   **Base de Datos:**
    *   **Desarrollo:** H2 Database (en memoria). Se reinicia con cada ejecución de la aplicación.
    *   **Configuración:** `spring.jpa.hibernate.ddl-auto=create-drop`.
    *   **Población Inicial:** Se utiliza un archivo `import.sql` para cargar 25 preguntas al arrancar.
*   **Capa de Persistencia:** Spring Data JPA
*   **Capa Web:** Spring Web (MVC)
*   **Motor de Plantillas (Vistas):** Thymeleaf
*   **Estilos Frontend:** Bootstrap 5.3.3 (gestionado vía WebJars)
*   **Documentación API:** `springdoc-openapi` (Swagger UI)
*   **Pruebas:**
    *   JUnit 5
    *   Mockito
    *   Spring Boot Test (con `@WebMvcTest`)

### 2.2. Estructura del Proyecto (Package-by-Layer)

```
com.example.pregunta
├── controller
│   ├── PreguntaController.java      // API REST para el CRUD y juego
│   └── view
│       ├── JuegoViewController.java // Controlador para las vistas del juego
│       └── PreguntaViewController.java // Controlador para las vistas del CRUD
├── dto
│   ├── ErrorResponseDTO.java      // DTO para respuestas de error
│   ├── PreguntaDTO.java           // DTO para respuestas de la API
│   ├── PreguntaRequestDTO.java    // DTO para peticiones de creación/edición
│   ├── ResultadoRespuestaDTO.java // DTO para el resultado de una respuesta
│   └── RespuestaUsuarioDTO.java   // DTO para recibir la respuesta de un usuario
├── entity
│   └── Pregunta.java              // Entidad JPA
├── exception
│   ├── ResourceNotFoundException.java // Excepción personalizada para 404
│   └── handler
│       └── GlobalExceptionHandler.java // Manejador de excepciones global (@RestControllerAdvice)
├── mapper
│   └── PreguntaMapper.java          // Conversor entre Entity y DTO
├── repository
│   └── PreguntaRepository.java      // Interfaz de Spring Data JPA
├── service
│   ├── PreguntaService.java         // Interfaz del servicio
│   └── impl
│       └── PreguntaServiceImpl.java // Implementación de la lógica de negocio
└── PreguntaApplication.java       // Clase principal de Spring Boot
```

### 2.3. Modelo de Datos

*   **Entidad `Pregunta`**:
    *   `id`: `Long` (Clave primaria, autoincremental)
    *   `enunciado`: `String` (No nulo)
    *   `respuesta`: `boolean`

### 2.4. API REST (`PreguntaController`)

*   **`GET /preguntas`**: Devuelve una lista de `PreguntaDTO`.
*   **`GET /preguntas/{id}`**: Devuelve un `PreguntaDTO`. Lanza 404 si no existe.
*   **`POST /preguntas`**: Crea una pregunta.
    *   **Body:** `PreguntaRequestDTO`
    *   **Respuesta:** 201 Created, con cabecera `Location` y el `PreguntaDTO` creado.
*   **`PUT /preguntas/{id}`**: Actualiza una pregunta. Lanza 404 si no existe.
    *   **Body:** `PreguntaRequestDTO`
    *   **Respuesta:** 200 OK con el `PreguntaDTO` actualizado.
*   **`DELETE /preguntas/{id}`**: Elimina una pregunta. Lanza 404 si no existe.
    *   **Respuesta:** 204 No Content.
*   **`GET /preguntas/jugar/aleatoria`**: Devuelve un `PreguntaDTO` aleatorio.
*   **`GET /preguntas/jugar/aleatorias?cantidad={n}`**: Devuelve una lista de `n` `PreguntaDTO` aleatorios.
*   **`POST /preguntas/jugar/{id}/verificar`**: Verifica la respuesta de un usuario.
    *   **Body:** `RespuestaUsuarioDTO`
    *   **Respuesta:** 200 OK con un `ResultadoRespuestaDTO`.

### 2.5. Lógica de Negocio (`PreguntaServiceImpl`)

*   Implementa las operaciones CRUD básicas delegando en el `PreguntaRepository`.
*   **`findRandomPreguntas(int count)`**: Utiliza una consulta nativa (`SELECT ... ORDER BY RANDOM() LIMIT ...`) en el repositorio para obtener preguntas aleatorias.
*   **`verificarRespuesta(...)`**: Obtiene la pregunta por ID, compara la respuesta correcta con la del usuario y construye el `ResultadoRespuestaDTO`.

### 2.6. Capa de Vistas (Thymeleaf)

*   **Layout Común:** Se utiliza un archivo `fragments/layout.html` que define la estructura principal, la barra de navegación y la inclusión de los assets de Bootstrap.
*   **Vistas de CRUD (`/view/preguntas`):**
    *   `list.html`: Muestra la tabla de preguntas con paginación y ordenación. Utiliza `Pageable` y `Page` de Spring Data.
    *   `form.html`: Formulario para crear/editar.
    *   `view.html`: Vista de solo lectura.
*   **Vistas de Juego (`/view/jugar`):**
    *   `jugar.html`: Muestra una pregunta y un formulario con dos botones para responder.
    *   `resultado.html`: Muestra el resultado de la respuesta.
    *   `partida.html`: Muestra un formulario con múltiples preguntas.
    *   `resultado_partida.html`: Muestra la puntuación final de la partida.

### 2.7. Estrategia de Pruebas

*   **Pruebas Unitarias (`PreguntaServiceImplTest`)**:
    *   Utilizan `@ExtendWith(MockitoExtension.class)` y `@Mock` para aislar la capa de servicio.
    *   Se prueba la lógica de los métodos `save`, `findAll`, `deleteById` y `verificarRespuesta` (casos de éxito, fallo y error).
*   **Pruebas de Integración (`PreguntaControllerTest`)**:
    *   Utilizan `@WebMvcTest` para levantar un contexto web limitado al controlador.
    *   Utilizan `@MockBean` para simular las dependencias (`PreguntaService`, `PreguntaMapper`).
    *   Utilizan `MockMvc` para realizar peticiones HTTP simuladas y `jsonPath` para verificar las respuestas JSON.
    *   Se prueban los endpoints `GET /preguntas`, `POST /preguntas` y el manejo de errores 404.

### 2.8. Gestión de Excepciones (API REST)

*   **Mecanismo:** Se utiliza un manejador de excepciones global implementado en la clase `GlobalExceptionHandler`, anotada con `@RestControllerAdvice`.
*   **Formato de Respuesta de Error:** Todas las excepciones controladas devuelven un cuerpo JSON estandarizado, definido por el `ErrorResponseDTO`, que contiene: `timestamp`, `status`, `error`, `message` y `path`.
*   **Excepciones Manejadas:**
    *   **`ResourceNotFoundException`**:
        *   **Disparador:** Se lanza desde la capa de controlador cuando el servicio devuelve un `Optional` vacío (ej: al buscar una pregunta por un ID que no existe).
        *   **Respuesta HTTP:** `404 Not Found`.
    *   **`MethodArgumentNotValidException`**:
        *   **Disparador:** Se lanza automáticamente por Spring cuando fallan las validaciones de los DTOs de entrada anotados con `@Valid` (ej: un campo `@NotBlank` está vacío).
        *   **Respuesta HTTP:** `400 Bad Request`. El mensaje de error incluye los detalles de los campos que fallaron la validación.
    *   **`Exception` (Genérica)**:
        *   **Disparador:** Captura cualquier otra excepción no controlada explícitamente.
        *   **Respuesta HTTP:** `500 Internal Server Error`. Esto previene que la aplicación exponga trazas de error completas al cliente.
