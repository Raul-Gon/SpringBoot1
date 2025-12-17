import { useState, type FormEvent } from "react"
import './CRUDUsuarios.css'
import axios from "axios"


interface Propietario {
    id: number
    nombre: string
    dni: string
    telefono: number
    email: string
}

// Sin id, ni datos autogenerados si procediera
interface PropietarioForm {
    nombre: string
    dni: string
    telefono: number
    email: string
}


function CRUDPropietarios() {
    const BASE_URL = 'http://69401e55993d68afba6b0b6d.mockapi.io/api/mock/propietarios'


    // status
    // usuario que se muestra
    const [propietario, setPropietario] = useState<Propietario | null>(null)
    // lista de usuarios que se muestra
    const [propietarios, setPropietarios] = useState<Propietario[]>([])
    // cargando ...
    const [loading, setLoading] = useState<boolean>(false)
    // error
    const [error, setError] = useState<string | null>(null)

    // Nuevos estados para el formulario
    const formDataEnBlanco = {
        nombre: "",
        dni: "",
        telefono: 0,
        email: ""
    }
    const [formData, setFormData] = useState<PropietarioForm>(formDataEnBlanco)
    const [editingId, setEditingId] = useState<number | null>(null)


    // Leer un customer por id
    const findPropietarioById = async (id: number) => {
        setError(null)
        setLoading(true)
        try {
            const response = await axios.get<Propietario>(`${BASE_URL}/${id}`)
            setPropietario(response.data)
        } catch (error) {
            console.error(error)
            setError('Error al encontrar el Propietario')
        } finally {
            setLoading(false)
        }
    }

    const deleteLocalById = async (id: number) => {
        if (!confirm(`¿Seguro que quieres borrar el Propietario ${id}?`)) return
        setError(null)
        setLoading(true)
        try {
            await axios.delete<Propietario>(`${BASE_URL}/${id}`)
            setPropietarios(propietarios.filter(c => c.id !== id))
            if (propietario?.id === id) setPropietario(null)

        } catch (error) {
            console.error(error)
            setError('Error al borrar el propietario')
        } finally {
            setLoading(false)
        }
    }

    const findAllLocales = async () => {
        setError(null)
        setLoading(true)
        try {
            const response = await axios.get<Propietario[]>(BASE_URL)
            setPropietarios(response.data)
        } catch (error) {
            console.error(error)
            setError('Error al cargar los propietarios')
        } finally {
            setLoading(false)
        }
    }

const createLocal = async (localData: PropietarioForm) => {
        if (!confirm(`¿Seguro que quieres crear el propietario?`)) return
        setError(null)
        setLoading(true)
        try {
            const response = await axios.post<Propietario>(BASE_URL, localData)
            setPropietarios([...propietarios, response.data])
            resetForm()
        } catch (error) {
            console.error(error)
            setError('Error al crear el Propietario')
        } finally {
            setLoading(false)
        }
}

    const handleSubmit = (e: FormEvent) => {
        e.preventDefault()
        
        if (!formData.dni.trim() || !formData.email.trim() || !formData.dni || !formData.telefono) {
            setError('Por favor, completa todos los campos')
            return
        }

        if (editingId) {
            updatePropietario(editingId, formData)
        } else {
            createLocal(formData)
        }
    }

    const updatePropietario = async (id: number, customerData: PropietarioForm) => {
        setError(null)
        setLoading(true)
        try {
            const response = await axios.put<Propietario>(`${BASE_URL}/${id}`, customerData)
            setPropietarios(propietarios.map(c => c.id === id ? response.data : c))
            if (propietario?.id === id) setPropietario(response.data)
            resetForm()
        } catch (error) {
            console.error(error)
            setError('Error al actualizar el Propietario')
        } finally {
            setLoading(false)
        }
    }   

const resetForm = () => {
    setEditingId(null)
    setFormData(formDataEnBlanco)
} 

const handleEdit = (c: Propietario) => {
    setFormData({
        nombre: c.nombre,
        dni: c.dni,
        telefono: c.telefono,
        email: c.email
    })
    setEditingId(c.id)
}

  return (
    <div>
        <h2>CRUD de Propietarios{loading && <span> cargando...</span>}</h2>

            {error && <strong>{error}</strong>}

        <h3>Creación de Propietarios</h3>
        <form onSubmit={handleSubmit}>
                    <div>
                        <label>
                            Nombre: 
                            <input 
                                type="text" 
                                value={formData.nombre}
                                onChange={e => setFormData({...formData, nombre: e.target.value})}
                                disabled={loading}
                                placeholder="Nombre..."
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            D.N.I.: 
                            <input 
                                type="text" 
                                value={formData.dni}
                                onChange={(e) => setFormData({...formData, dni: e.target.value})}
                                disabled={loading}
                                placeholder="D.N.I...."
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Telefono: 
                            <input 
                                type="text" 
                                value={formData.telefono}
                                onChange={(e) => setFormData({...formData, telefono: Number(e.target.value)})}
                                disabled={loading}
                                placeholder="Telefono..."
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Email: 
                            <input 
                                type="text" 
                                value={formData.email}
                                onChange={(e) => setFormData({...formData, email: e.target.value})}
                                disabled={loading}
                                placeholder="Email..."
                            />
                        </label>
                    </div>
                    <button type="submit" disabled={loading}>
                        {editingId ? 'Actualizar' : 'Crear'}
                    </button>
                    {editingId && (
                        <button type="button" onClick={resetForm} disabled={loading}>
                            Cancelar edición
                        </button>
                    )}
                </form>
        
        <h3>Información de Locales</h3>
        <button disabled={loading} onClick={() => setPropietario(null)}>Ocultar Local</button>
        {
            propietario 
            && 
            <ul>
                <li>Id: {propietario.id}</li>
                <li>Nombre: {propietario.nombre}</li>
                <li>D.N.I.: {propietario.dni}</li>
                <li>Telefono: {propietario.telefono}</li>
                <li>Email: {propietario.email}</li>
            </ul>
        }
        <h3>Lista de los Propietarios</h3>
        <button disabled={loading} onClick={findAllLocales}>Actualizar lista</button>
        {
            propietarios.length !==0 
            &&
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>D.N.I.</th>
                        <th>Telefono</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        propietarios.map(c => 
                            <tr key={c.id}>
                                <td>{c.id}</td>
                                <td>{c.nombre}</td>
                                <td>{c.dni}</td>
                                <td>{c.telefono}</td>
                                <td>{c.email}</td>
                                <td>
                                    <button className="actions" 
                                        disabled={loading}
                                        onClick={() => findPropietarioById(c.id)}>Ver</button>
                                    <button className="actions" 
                                        disabled={loading}
                                        onClick={() => handleEdit(c)}>Editar</button>
                                    <button className="actions" 
                                        disabled={loading}
                                        onClick={() => deleteLocalById(c.id)}>Borrar</button>                           
                                </td>
                            </tr>
                        )
                    }
                </tbody>
            </table>
        }
    </div>
  )
}

export default CRUDPropietarios