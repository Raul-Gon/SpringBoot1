import { useState, type FormEvent } from "react"
import './CRUDUsuarios.css'
import axios from "axios"


interface Local {
    id: number
    nombreCompleto: string
    direccionCompleta: string
    metrosCuadrados: number
    precioAlquiler: number
}

// Sin id, ni datos autogenerados si procediera
interface LocalForm {
    nombreCompleto: string
    direccionCompleta: string
    metrosCuadrados: number
    precioAlquiler: number
}


function CRUDLocales() {
    const BASE_URL = 'http://localhost:8080/api/locales'

    // status
    // usuario que se muestra
    const [local, setLocal] = useState<Local | null>(null)
    // lista de usuarios que se muestra
    const [locales, setLocales] = useState<Local[]>([])
    // cargando ...
    const [loading, setLoading] = useState<boolean>(false)
    // error
    const [error, setError] = useState<string | null>(null)

    // Nuevos estados para el formulario
    const formDataEnBlanco = {
        nombreCompleto: "",
        direccionCompleta: "",
        metrosCuadrados: 0,
        precioAlquiler: 0
    }
    const [formData, setFormData] = useState<LocalForm>(formDataEnBlanco)
    const [editingId, setEditingId] = useState<number | null>(null)


    // Leer un customer por id
    const findLocalById = async (id: number) => {
        setError(null)
        setLoading(true)
        try {
            const response = await axios.get<Local>(`${BASE_URL}/${id}`)
            setLocal(response.data)
        } catch (error) {
            console.error(error)
            setError('Error al encontrar el Local')
        } finally {
            setLoading(false)
        }
    }

    const deleteLocalById = async (id: number) => {
        if (!confirm(`¿Seguro que quieres borrar el Local ${id}?`)) return
        setError(null)
        setLoading(true)
        try {
            await axios.delete<Local>(`${BASE_URL}/${id}`)
            setLocales(locales.filter(c => c.id !== id))
            if (local?.id === id) setLocal(null)

        } catch (error) {
            console.error(error)
            setError('Error al borrar el Local')
        } finally {
            setLoading(false)
        }
    }

    const findAllLocales = async () => {
        setError(null)
        setLoading(true)
        try {
            const response = await axios.get<Local[]>(BASE_URL)
            setLocales(response.data)
        } catch (error) {
            console.error(error)
            setError('Error al cargar los Locales')
        } finally {
            setLoading(false)
        }
    }

const createLocal = async (localData: LocalForm) => {
        if (!confirm(`¿Seguro que quieres crear el cliente?`)) return
        setError(null)
        setLoading(true)
        try {
            const response = await axios.post<Local>(BASE_URL, localData)
            setLocales([...locales, response.data])
            resetForm()
        } catch (error) {
            console.error(error)
            setError('Error al crear el Local')
        } finally {
            setLoading(false)
        }
}

    const handleSubmit = (e: FormEvent) => {
        e.preventDefault()
        
        if (!formData.nombreCompleto.trim() || !formData.direccionCompleta.trim() || !formData.metrosCuadrados || !formData.precioAlquiler) {
            setError('Por favor, completa todos los campos')
            return
        }

        if (editingId) {
            updateLocal(editingId, formData)
        } else {
            createLocal(formData)
        }
    }

    const updateLocal = async (id: number, customerData: LocalForm) => {
        setError(null)
        setLoading(true)
        try {
            const response = await axios.put<Local>(`${BASE_URL}/${id}`, customerData)
            setLocales(locales.map(c => c.id === id ? response.data : c))
            if (local?.id === id) setLocal(response.data)
            resetForm()
        } catch (error) {
            console.error(error)
            setError('Error al actualizar el Local')
        } finally {
            setLoading(false)
        }
    }   

const resetForm = () => {
    setEditingId(null)
    setFormData(formDataEnBlanco)
} 

const handleEdit = (c: Local) => {
    setFormData({
        nombreCompleto: c.nombreCompleto,
        direccionCompleta: c.direccionCompleta,
        metrosCuadrados: c.metrosCuadrados,
        precioAlquiler: c.precioAlquiler
    })
    setEditingId(c.id)
}

  return (
    <div>
        <h2>CRUD de Locales{loading && <span> cargando...</span>}</h2>

            {error && <strong>{error}</strong>}

        <h3>Creación de Locales</h3>
        <form onSubmit={handleSubmit}>
                    <div>
                        <label>
                            Nombre Completo: 
                            <input 
                                type="text" 
                                value={formData.nombreCompleto}
                                onChange={e => setFormData({...formData, nombreCompleto: e.target.value})}
                                disabled={loading}
                                placeholder="Nombre completo del Local..."
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Dirección Completa: 
                            <input 
                                type="text" 
                                value={formData.direccionCompleta}
                                onChange={(e) => setFormData({...formData, direccionCompleta: e.target.value})}
                                disabled={loading}
                                placeholder="Dirección del local..."
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Metros Cuadrados del local: 
                            <input 
                                type="text" 
                                value={formData.metrosCuadrados}
                                onChange={(e) => setFormData({...formData, metrosCuadrados: Number(e.target.value)})}
                                disabled={loading}
                                placeholder="Metros del local..."
                            />
                        </label>
                    </div>
                    <div>
                        <label>
                            Precio de Alquiler: 
                            <input 
                                type="text" 
                                value={formData.precioAlquiler}
                                onChange={(e) => setFormData({...formData, precioAlquiler: Number(e.target.value)})}
                                disabled={loading}
                                placeholder="Precio de alquiler..."
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
        <button disabled={loading} onClick={() => setLocal(null)}>Ocultar Local</button>
        {
            local 
            && 
            <ul>
                <li>Id: {local.id}</li>
                <li>Nombre: {local.nombreCompleto}</li>
                <li>Direccion: {local.direccionCompleta}</li>
                <li>Metros 2: {local.metrosCuadrados}</li>
                <li>Precio alquiler: {local.precioAlquiler}</li>
            </ul>
        }
        <h3>Lista de los Locales</h3>
        <button disabled={loading} onClick={findAllLocales}>Actualizar lista</button>
        {
            locales.length !==0 
            &&
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Metros 2</th>
                        <th>Precio de alquiler</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        locales.map(c => 
                            <tr key={c.id}>
                                <td>{c.id}</td>
                                <td>{c.nombreCompleto}</td>
                                <td>{c.direccionCompleta}</td>
                                <td>{c.metrosCuadrados}</td>
                                <td>{c.precioAlquiler}</td>
                                <td>
                                    <button className="actions" 
                                        disabled={loading}
                                        onClick={() => findLocalById(c.id)}>Ver</button>
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

export default CRUDLocales