
function ListaNombre() {

    const nombres: string[] = ['Ana', 'Pedro', 'Jose', 'Maria']

  return (
    <>
        <hr />
        <h2>Lista de nombres</h2>
        
        <ul>
            {nombres.map((n: string, i: number) => <li key={i}>Nombre: {n}</li>)}
        </ul>

        <small>Fin de la Lista de nombres</small>
        <hr />
    </>
  )
}

export default ListaNombre