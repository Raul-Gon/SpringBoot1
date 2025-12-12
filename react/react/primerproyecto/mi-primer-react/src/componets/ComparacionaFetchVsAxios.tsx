import axios from "axios"
import { useState } from "react"
import { api } from "../services/axios"

interface User {
    id: number
    name: string
    email: string
    phone: string
}

function ComparacionaFetchVsAxios() {

    const [userFecth, setuserFecth] = useState<User | null>(null)
    const [userAxios, setuserAxios] = useState<User | null>(null)
    
    //FETCH normal
    const obtenerDatosConFetch = async () =>{
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/users/2')
            if(!response.ok) throw new Error('https: error: ' + response.status)
            
            const data = await response.json()
            setuserFecth(data)
        
        } catch (error) {
            console.error('Error en fetch: ' + error)            
        }        
    }
    
    //con AXIOS
    const obtenerDatosConAxios = async () => {
        try {
            const response = await axios.get<User>('https://jsonplaceholder.typicode.com/users/1')
            setuserAxios(response.data)
        } catch (error) {
            
            console.error('Error en Axios: ' + error) 
        }        
    }

    //Con AXIOS utilizando el archivo axios.ts que esta en la carpeta services
    const obtenerDatosConAxios2 = async () => {
        try {
            const response = await api.get<User>('/users/1')
            setuserAxios(response.data)
        } catch (error) {
            
            console.error('Error en Axios: ' + error) 
        }        
    }

  return (
    <>
        <hr />
        <h2><u>Comparar fetch axios</u></h2>
        <h3>Peticion fetch</h3>
        <button onClick={obtenerDatosConFetch} >Petición Fetch</button>
        {userFecth && <p>Fetch: {userFecth.name}</p>}

        <hr style={{ // Usamos 'border-top' para controlar el estilo del borde superior
            borderTop: '3px dashed red', 
            // Eliminamos el borde por defecto que puede causar líneas dobles
            borderBottom: 'none', 
            borderLeft: 'none',
            borderRight: 'none',
            // Aseguramos que el fondo sea transparente si es necesario
            backgroundColor: 'transparent',
            // Eliminamos el margen por defecto para que solo se vea la línea
            margin: '1rem 0'
        }}/>

        <h3>Peticion Axios</h3>
        <button onClick={obtenerDatosConAxios} >Petición Axios</button>
        {userAxios && <p>Axios: {userAxios.name}</p>}

        <hr />
    </>
  )
}

export default ComparacionaFetchVsAxios