import { useState } from "react"

function MuchosEstadosUsuario() {
    const estados = ['durmiendo', 'despierto', 'desayuno', 'trabajando', 'de ocio', 'cenando']

    const [numEstado, setNumEstado] = useState<number>(0)

    /*
    function cambiarEstado(){
        if (numEstado === estados.length - 1){
            setNumEstado(0)
        }else{
            setNumEstado(numEstado + 1)
        }            
    }
        ESTO DE AQUI ARRIBA ES LO MISMO QUE LO SIGUIENTE
    */

    const cambiarEstado = (): void => {
       setNumEstado(numEstado === estados.length -1 ? 0 : numEstado +1)
    }

  return (
    <div>        
        <hr/>
        <h2>Componente para MUCHOS ESTADOS DISTINTOS</h2>
        <button onClick={cambiarEstado}>Cambiar ESTADO</button>
        <p>El estado del usuario es: {estados[numEstado]}</p>

        <small>Fin del Componente para multiples estados</small>
        <hr/>
    </div>
  )
}

export default MuchosEstadosUsuario