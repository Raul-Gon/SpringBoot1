type SaludoFlexiblesProps = {
    nombre: string
    edad: number
}

function SaludosFlexibles({ nombre, edad }: SaludoFlexiblesProps) {
  return (
    <div>
        <h2>Hola soy {nombre}</h2>
        <p>Tengo {edad} años</p>
    </div>
  )
}

export default SaludosFlexibles