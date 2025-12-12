import './App.css'
import AlternarContenido from './componets/AlternarContenido'
import Calculador from './componets/Calculador'
import CalculadoraPropinas from './componets/CalculadoraPropinas'
import ComparacionaFetchVsAxios from './componets/ComparacionaFetchVsAxios'
import Contador from './componets/Contador'
import ContadorConHistoria from './componets/ContadorConHistoria'
import ContadorConHistoria2 from './componets/ContadorConHistoria2'
import EjemploParametro from './componets/EjemploParametro'
import EstadoUsuario from './componets/EstadoUsuario'
import Input from './componets/Input'
import ListaDinamica from './componets/ListaDinamica'
import ListaNombre from './componets/ListaNombre'
import ListaPersonas from './componets/ListaPersonas'
import Listas from './componets/Listas'
import MiComponente from './componets/MiComponente'
import MostrarOcultar from './componets/MostrarOcultar'
import MuchosEstadosUsuario from './componets/MuchosEstadosUsuario'
import SaludosFlexibles from './componets/SaludosFlexibles'
import TareasConInput from './componets/TareasConInput'
import Tienda from './componets/Tienda'
import MultipleApis from './componets/MultipleApis';

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

      <MiComponente />
      <MostrarOcultar />
      <AlternarContenido />
      <EstadoUsuario />
      <MuchosEstadosUsuario />
      <Input />
      <EjemploParametro />
      <ListaNombre />
      <ListaPersonas />
      <ListaDinamica />
      <TareasConInput />
      <ContadorConHistoria />
      <ContadorConHistoria2 />
      <CalculadoraPropinas />
      <Listas />
      <ComparacionaFetchVsAxios />
      <MultipleApis />

    </div>
  )
}

export default App
