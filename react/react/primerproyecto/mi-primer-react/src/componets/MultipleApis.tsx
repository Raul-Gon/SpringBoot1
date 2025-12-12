import { useState } from "react"
import { apiProducts, apiUsers } from "../services/axios"

interface User {
    id: number
    name: string
    email: string
    phone: string
}

interface Product {
    id: number
    title: string
    price: number
    category: string
}

function MultipleApis() {

    const [loading, setLoading] = useState<boolean>(false)

    const [users, setUsers] = useState<User[]>([])

    const [products, setProducts] = useState<Product[]>([])

    const obtenerDatosUsers = async () => {
        setLoading(true)
        try {
            const response = await apiUsers.get<User[]>('/users')
            setUsers(response.data)
        } catch (error) {
            
            console.error('Error al obtener los usuarios: ' + error) 
        } finally {
            setLoading(false)    
        }
    }

    const verUser = async (id: number) => {
        setLoading(true)
        try {
            const response = await apiUsers.get<User>('/users/' + id)
            setUsers([response.data])
        } catch (error) {
            
            console.error(`Error al obtener el usuario ${id}: ${error}`) 
        } finally {
            setLoading(false)    
        }
    }

    const obtenerDatosProducts = async () => {
        setLoading(true)
        try {
            const response = await apiProducts.get<Product[]>('/products')
            setProducts(response.data)
        } catch (error) {
            
            console.error('Error al obtener los productos: ' + error) 
        } finally {
            setLoading(false)    
        }       
    }

  return (
    <div>
        <hr />

        <h3><u>Peticion Axios de USERS</u></h3>
        <button onClick={obtenerDatosUsers} disabled={loading}>{loading ? 'Cargando....' : 'Petición USERS'}</button>
        {users.length !== 0 &&                  
                <table border={1}>
                    <thead>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        {users.length !== 1 && 
                            <th>Acciones</th>
                        }
                        
                    </thead>
                    <tbody>
                        {users.map(u =>
                            <tr key={u.id}>
                                <td>{u.id}</td>
                                <td>{u.name}</td>
                                <td>{u.email}</td>
                                <td>{u.phone}</td>
                                {users.length !== 1 && 
                                    <td><button onClick={() => {verUser(u.id)}}>Ver</button></td>
                                }
                            </tr>
                        )}
                    </tbody>
                </table>
               /* <div key={user.id}>
                    <p><u>Usuario:</u></p>
                    <p>Id: {user.id}</p>
                    <p>Nombre: {user.name}</p>
                    <p>Email: {user.email}</p>
                    <p>Teléfono: {user.phone}</p>
                    <br />
                </div> */
        }

        <hr style={{borderTop: '3px dashed red', borderBottom: 'none', borderLeft: 'none', borderRight: 'none', backgroundColor: 'transparent', margin: '1rem 0'}}/>

        <h3><u>Peticion Axios de Productos</u></h3>
        <button onClick={obtenerDatosProducts} disabled={loading}>{loading ? 'Cargando....' : 'Petición PRODUCTS'}</button>
        {products.length !== 0 && products.map(product =>                 
                <div key={product.id}>
                    <p><u>Productos:</u></p>
                    <p>Id: {product.id}</p>
                    <p>Titulo: {product.title}</p>
                    <p>Numero: {product.price}</p>
                    <p>Categoria: {product.category}</p>
                    <br />
                </div>
        )}

        <hr />
    </div>
  )
}

export default MultipleApis