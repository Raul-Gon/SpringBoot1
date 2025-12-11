import { useState, type JSX } from "react"
import './ContadorConHistoria.css'

type ItemHistorial = {
    id: number
    valor: number
    fecha: Date
}


function ContadorConHistoria(): JSX.Element {
    const [valor, setValor] = useState<number>(0)
    const [historial, setHistorial] = useState<ItemHistorial[]>([{
        id: 1, 
        valor: 0, 
        fecha: new Date()
    }])

    const aumentar = (n: number) => {
        let maximoId = 0;
        historial.forEach(e => maximoId = e.id > maximoId ? e.id: maximoId)
        const newValor = valor + n
        setValor(newValor)
        setHistorial([...historial, {
            id: maximoId + 1, 
            valor: newValor, 
            fecha: new Date()
        }])
        
    }

    const resetear = () => {
        setValor(0)
        setHistorial([{
            id: 1, 
            valor: 0, 
            fecha: new Date()
        }])
        // inicializar el histórico con la entrada del 0
    }

    return (
    <div>
        <hr />
        <h2>Contador con historia</h2>
        <h3>Contador: {valor}</h3>
        <button onClick={()=>aumentar(-1)}>-</button>
        <button onClick={resetear}>0</button>
        <button onClick={()=>aumentar(1)}>+</button>
        <h3>Histórico del contador</h3>
        <ul>
            {historial.map(e => <li key={e.id}>{e.id} - {e.valor} - {e.fecha.toISOString()}</li>)}
        </ul>
        <h4>Cantidad de elementos del histórico: {historial.length}</h4>
        <hr />
    </div>
  )
}

export default ContadorConHistoria