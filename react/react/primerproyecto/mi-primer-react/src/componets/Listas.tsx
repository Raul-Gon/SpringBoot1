import { useState } from "react"

type Tarea = {
    id: number
    nombre: string
    completada: boolean
}

function Listas() {

    const listaTareasIniciales: Tarea[] = [{id: 1, nombre: 'Tarea 1', completada: false}, {id: 2, nombre: 'Tarea b', completada: true}]
    const [tareas, setTareas] = useState<Tarea[]>(listaTareasIniciales)
    const [textoTarea, setTextoTarea] = useState<string>('')

    const actualizarTareaCompletada = (id: number): void => {
        setTareas(tareas.map(t => {return t.id === id ? {...t, completada: !t.completada} : t}))
    }

    const borrarTarea = (id: number): void => {
        setTareas(tareas.filter(t => t.id !== id))
    }

    const addTarea = (): void => {
        const nombreTarea = textoTarea
        let maxId = 0
        tareas.map(t => maxId = t.id > maxId ? t.id : maxId) 
        setTareas([...tareas, {id: maxId + 1, nombre: nombreTarea, completada: false}])
        setTextoTarea('')
    }

return (
    <>
        <hr />

        <h2>Tareas:</h2>

        <h3>Lista de tareas:</h3>
        
        <input type="text" placeholder="Nombre tarea..." value={textoTarea} onChange={(e) => {setTextoTarea(e.target.value)}} />
        <button onClick={addTarea}>Añadir</button>

        {tareas.map(t => <>
                            <li key={t.id}>{t.id}: {t.nombre}</li>
                            <input type="checkbox" checked={t.completada} onClick={() => {actualizarTareaCompletada(t.id)}}/>
                            <button onClick={() => {borrarTarea(t.id)}}>Borrar</button>
                        </>
                            )}


        <hr />
    </>
  )
}

export default Listas