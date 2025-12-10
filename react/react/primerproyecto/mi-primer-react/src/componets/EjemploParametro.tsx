import { useState } from "react"


function EjemploParametro() {

    const [color, setColor] = useState<string>('verde')

    const cambiarColor = (color: string): void => {
        if (color === 'rojo' || color === 'amarillo' || color === 'verde'){
            setColor(color)
        }else{
            setColor('rojo')
        }
    }

  return (
    <>
        <hr/>
        <h2>Componente de Ejemplo de un evento que llama a una funcion con un parametro</h2>

        <button onClick={() => {cambiarColor('rojo')}}>Rojo</button>
        <button onClick={() => cambiarColor('amarillo')}>Amarillo</button>
        <button onClick={() => cambiarColor('verde')}>Verde</button>

        <p>{color}</p>

        <small>Fin del Componente de evento con funcion con parametro</small>
        <hr/>
    </>
  )
}

export default EjemploParametro