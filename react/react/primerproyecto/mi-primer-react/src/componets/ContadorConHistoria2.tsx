import { useState } from "react"

type LineaHistorico =  {
    id: number
    valor: number
    fecha: Date
}

function ContadorConHistoria2() {

    const valorInicial = 0
    const lineaHistoricoInicial = {id: 1, valor: valorInicial, fecha: new Date()}
    const [valor, setValor] = useState<number>(valorInicial)
    const [historico, setHistorico] = useState<LineaHistorico[]>([lineaHistoricoInicial])
    
    const reset = (): void => {
        setValor(0)
        setHistorico([lineaHistoricoInicial])
    }

    const incrementar = (): void => {
        const valorNuevo = valor + 1
        setValor(valorNuevo)
        setHistorico([...historico, {id: (historico.length + 1), valor: valorNuevo, fecha: new Date()}])
    }

    const decrementar = (): void => {
        const valorNuevo = valor - 1
        if (valorNuevo !== -1){
            setValor(valorNuevo)
            setHistorico([...historico, {id: (historico.length - 1), valor: valorNuevo, fecha: new Date()}])
        }
    }

  return (
    <div>
        <hr />

        <h2>Contador con historia:</h2>
        <h3>Contador: {valor}</h3>
        <button onClick={() =>{decrementar()}}>-</button>
        <button onClick={reset}>0</button>
        <button onClick={() => {incrementar()}}>+</button>

        <h3>Historico de cambios.</h3>
        <ul>
            {historico.map(item => {return <li>{item.id} - {item.valor} - {item.fecha.toISOString()}</li>})}
        </ul>

        <hr />
    </div>
  )
}

export default ContadorConHistoria2