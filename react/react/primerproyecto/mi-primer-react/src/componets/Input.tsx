import { useState } from "react"

function Input() {

    const [texto, setTexto] = useState<string>('')

  return (
    <>
        <hr/>
        <h2>Componentes para ejemplo onChange</h2>

        <input 
            type="text" 
            placeholder="Introduce un texto ..."
            onChange={(e) =>{setTexto(e.target.value)}}
        />
        
        <p>Texto: {texto}</p>
        
        <br/>
        <small>Fin componente para ejemplo onChange</small>
        <hr/>
    </>
  )
}

export default Input