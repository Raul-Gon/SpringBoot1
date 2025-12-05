import './App.css'
import Calculador from './componets/Calculador'
import Contador from './componets/Contador'
import SaludosFlexibles from './componets/SaludosFlexibles'
import Tienda from './componets/Tienda'

function App() {

  return (
    <div className= "container">
      
      <h1>Mi primer componente</h1>
      <SaludosFlexibles nombre= 'Raul' edad= {30} />
      
      <div className='tienda'>
        <h2>🛒 Mi Tienda Online</h2>
        <p className='parrafo'>Los mejores productos al mejor precio</p>
        <Tienda articulo='Camiseta' precio={124} stock= {true} />
        <Tienda articulo='Pantalones' precio={24} stock= {false} />
        <Tienda articulo='Tobilleras' precio={324} stock= {true} />
        <Tienda articulo='Reloj' precio={1024} stock= {true} />
        <Tienda articulo='Zapatos' precio={10} stock= {false} />
      </div>
      
      <div className='divContadores'>
        <div>
          <h2>Mi primera app de contadores</h2>
          <p>Esto es una app de contadores</p>
        </div>
        <Contador />
        <Contador />
        <Contador />
      </div>

      <div className='divCalculadores'>
        <div>
          <h2>Mi primera app de CALCULADOR</h2>
          <p>Esto es una app de calculador</p>
        </div>
        <Calculador />
      </div>

    </div>
  )
}

export default App
