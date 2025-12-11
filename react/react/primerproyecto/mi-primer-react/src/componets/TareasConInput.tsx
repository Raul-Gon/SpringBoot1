import { useState } from "react"

function TareasConInput() {

    const [tareas, setTareas] = useState<string[]>([])
    const [newTarea, setNewTarea] = useState<string>('')

    const nuevaTarea = (tarea: string): void => {
        setTareas([...tareas, tarea])
        setNewTarea ('')
    }

  return (
    <>
        <hr />
        <h2>Componente para añadir una Tarea co un input de forma dinamica</h2>

        <label htmlFor="inTarea"></label>
        <br />
        <input name="inTarea" type="text" placeholder="Escribe aqui tu tarea ..." value={newTarea} onChange={(e) => {setNewTarea(e.target.value)}}/>
        <br />
        <button onClick={() => {nuevaTarea(newTarea)}}>AÑADIR TAREA</button>
        <br />
        <ul>
            {tareas.map((t, i)  => <li key={i}>{t}</li>)}
        </ul>
        
        <small>Fin del Componente para añadir una Tarea co un input de forma dinamica</small>
        <hr />
    </>
  )
}

export default TareasConInput