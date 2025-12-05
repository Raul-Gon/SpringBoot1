type TiendaProps = {
    articulo: string
    precio: number
    stock: boolean
}



function Tienda({articulo, precio, stock}: TiendaProps) {
  return (
    <div>
        <div className= {stock? 'enStock' : 'agotado'}>
            <p className={stock? '' : 'agotado'}>{articulo}</p>
            <p>{precio} €</p>
            <p>{stock? '✅ En stock' : '❌ Agotado'}</p>
        </div>
    </div>
  )
}

export default Tienda