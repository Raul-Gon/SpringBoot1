import { useState } from "react"

function EstadoUsuario() {

    const [estado, setEstado] = useState<string>('despierto')

  return (
    <>
        <hr/>
        <h2>Componente para Alternar entre TRES Estados de Usuarios</h2>

        <button onClick={() => {
            if(estado === 'despierto'){
                setEstado('descansando')
            }else if(estado === 'descansando'){
                setEstado('durmiendo')
            }else{
                setEstado('despierto')
            }
        }}>{estado === 'despierto' ?  'Descansar' : estado === 'descansando' ? 'Dormir' : 'Despertar'}</button>
        
        <p>Estado del usuario es: {estado}</p>

        <br />
        <small>Fin del componente para alternar entre TRES estados.</small>
        <hr/>
    </>
  )
}

export default EstadoUsuario