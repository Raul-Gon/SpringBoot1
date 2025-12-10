

type Persona = {
    id: number
    nombre: string
    edad: number
}

function ListaPersonas() {

    const personas: Persona[] = [{id: 1, nombre: 'Ana', edad: 18}, {id: 2, nombre: 'Jose', edad: 28}, {id: 3, nombre: 'Pedro', edad: 11}]
    
  return (
    <>
        <hr />
        <h2>Componentes Listado de Personas</h2>
        <ul>
            {personas.map(p => <li key={p.id}>{p.nombre}: {p.edad}</li>)}
        </ul>

        <small>Fin componente listado personas</small>
        <hr />
    </>
  )
}

export default ListaPersonas