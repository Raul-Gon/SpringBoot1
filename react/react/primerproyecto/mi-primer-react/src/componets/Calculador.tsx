import { useState } from "react"

function Calculador() {
    
    const [valor, setValor] = useState<number>(5)
    const masDos = ():void => {
        if ((valor + 2) <= 100)  setValor(valor +2) 
    }

    function reset():void {
        setValor(5)
    }

  return (
    <>
        <h3>Calculador: {valor}</h3>
        <button onClick={()=>{(valor * 2) <= 100 ? setValor(valor * 2) : setValor(100)}}>*2</button>
        <button onClick={masDos}>+2</button>
        <button onClick= {reset}>Reset</button>
    </>
  )
}

export default Calculador