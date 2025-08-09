function App() {
  const name = 'Jim Rohn'

  const author = {
    name: 'brian tracy',
    bookName: 'No Excuse',
    price: '$100',
  }

  const cars = [
    { model: 'i20', company: 'hyundai', price: 12 },
    { model: 'triber', company: 'renault', price: 10 },
    { model: 'nano', company: 'tata', price: 2.5 },
    { model: 'X5', company: 'BMW', price: 45 },
    { model: 'Innova', company: 'toyota', price: 30 },
  ]

  const persons = [
    { name: 'person1', age: 20 },
    { name: 'person2', age: 10 },
    { name: 'person3', age: 24 },
    { name: 'person4', age: 28 },
    { name: 'person5', age: 30 },
  ]

  return (
    <div>
      <h2>App Component</h2>
      <div>name: {name}</div>
      <hr />
      <h4>Author info</h4>
      <div>
        <div>name: {author['name']}</div>
        <div>book name: {author['bookName']}</div>
        <div>book price: {author['price']}</div>
      </div>
      <hr />
      <h4>Cars</h4>
      <table className='table table-striped'>
        <thead>
          <tr>
            <th>Model</th>
            <th>Company</th>
            <th>Price</th>
          </tr>
        </thead>
        <tbody>
          {cars.map((car) => {
            return (
              <tr key={car['model']}>
                <td>{car['model']}</td>
                <td>{car['company']}</td>
                <td>{car['price']}</td>
              </tr>
            )
          })}
        </tbody>
      </table>
      <hr />
      <h4>Persons</h4>
      {persons.map((person) => {
        return (
          <ul
            className='list-group'
            key={person['name']}
          >
            <li className='list-group-item'>
              <div>name: {person['name']}</div>
              <div>age: {person['age']}</div>
            </li>
          </ul>
        )
      })}
    </div>
  )
}

export default App
