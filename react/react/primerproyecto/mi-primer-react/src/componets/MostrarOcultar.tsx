import { useState } from "react"

function MostrarOcultar() {
    const [visible, setVisible] = useState<boolean>(false)

  return (
    <>
        <hr></hr>
        <h2>Ejemplo mostrar - ocultar</h2>
        <button onClick={() => {setVisible(!visible)}}>{visible ?  'Ocultar' : 'Mostrar'}</button>
        <br/>
        {visible && <p>Texto a Ocultar</p>}
        <small>Fin del componente siempre visible</small>
        <hr></hr>
    </>
  )
}

export default MostrarOcultar