import { useEffect, useState } from 'react'
import { getProducts } from './services/product'

function App() {
  const [products, setProducts] = useState([])

  const getAllProducts = async () => {
    const result = await getProducts()
    if (result['status'] == 'success') {
      setProducts(result['data'])
    } else {
      alert(result['error'])
    }
  }

  useEffect(() => {
    getAllProducts()
  }, [])

  return (
    <div className='container'>
      <h1 className='page-header'>Products</h1>
      <table className='table table-stripped'>
        <thead>
          <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product) => {
            return (
              <tr key={product['id']}>
                <td>{product['id']}</td>
                <td>{product['title']}</td>
                <td>{product['price']}</td>
              </tr>
            )
          })}
        </tbody>
      </table>
    </div>
  )
}

export default App
