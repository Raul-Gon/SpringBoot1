import { useState } from "react"

function CalculadoraPropinas() {

    const [porciento, setPorciento] = useState<number>(10)
    const [cuenta, setCuenta] = useState<number>(0)
    let porcentaje :number = cuenta * porciento / 100
    let total : number = cuenta + porcentaje

    

  return (
    <div>
        <hr />

        <h2><u>Calculador de Propinas</u></h2>

        <h3>Importe de la cuenta:</h3>
        <input type="text" placeholder="total de tu cuenta ..." value={cuenta} onChange={(e) => {setCuenta(parseFloat(e.target.value) || 0)}}/>

        <h3>Porcentaje de la propina:</h3>
        <button onClick={() => {setPorciento(10)}}>10 %</button>
        <button onClick={() => {setPorciento(15)}}>15 %</button>
        <button onClick={() => {setPorciento(20)}}>20 %</button>

        <h3>Desglose:</h3>
        <p>Propina &#40; {porciento} % &#41; : {porcentaje} €</p>
        <p>Total a pagar: {total} €</p>

        <hr />
    </div>
  )
}

export default CalculadoraPropinas