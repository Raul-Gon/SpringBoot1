import { useState } from "react"

function AlternarContenido() {

    const [claro, setClaro] = useState<boolean>(true)

  return (
    <>
        <hr/>

        <h2>Componente para alternar entre Claro y Oscuro</h2>
        <button onClick={() => {setClaro(!claro)}}>Cambiar estado</button>

        {
            claro ? (<p>Esto es claro</p>) : (<p>Esto es oscuro</p>)
        }


        <small>Fin del contenido del componente para alternar entre Claro y Oscuro</small>

        <hr/>
    </>
  )
}

export default AlternarContenido