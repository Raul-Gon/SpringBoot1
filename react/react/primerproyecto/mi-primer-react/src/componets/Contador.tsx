import { useState } from "react";

function Contador() {
    const [valor, setValor] = useState<number>(0)
  return (
    <div className="divContador">
        <h3>Contador: {valor}</h3>
        <button className="botonContador" onClick={()=>{setValor(valor + 1)}}>+1</button>
        <button className="botonContador" onClick={()=>{setValor(valor !== 0 ?   valor - 1 : valor)}}>-1</button>
        <button className="botonContador" onClick={()=>{setValor(0)}}>Reset</button>
    </div>
  )
}

export default Contador