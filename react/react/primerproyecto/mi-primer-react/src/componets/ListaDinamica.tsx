import { useState } from "react"


function ListaDinamica() {

    const [tareas, setTareas] = useState<string[]>([])

    const nuevaTarea = () => {
        setTareas([...tareas, 'Tarea-' + (tareas.length + 1)])
    }

  return (
    <>
        <hr />
        <h2>Lista Dinámica con tareas automáticas</h2>
        
        <button onClick={nuevaTarea}>Añadir tarea</button>
        <br />

        <ul>
            {tareas.map((t, i)  => <li key={i}>{t}</li>)}
        </ul>


        <small>Fin del componente de listas dinamicas</small>
        <hr />
    </>
  )
}

export default ListaDinamica