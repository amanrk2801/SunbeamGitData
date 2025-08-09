import Person from './components/Person'
import Car from './components/Car'
import Computer from './components/Computer'

// though it is possible to keep multiple
// components in one file, it is not recommended
function DummyComponent() {
  return (
    <div>
      <h2>Dummy Component</h2>
    </div>
  )
}

export const myVar = 100
export const num = 200

function App() {
  const person1 = {
    name: 'jim rohn',
    address: 'USA',
    profession: 'author',
  }

  const person2 = {
    name: 'tim cook',
    address: 'USA',
    profession: 'Apple CEO',
  }

  const car = {
    model: 'XUV',
    company: 'mahindra',
  }

  const computer = {
    brand: 'Apple',
    model: 'MacBook Pro',
    cpu: 'M3 Pro',
    memory: '16GB',
  }

  return (
    <div>
      <h2>App Component</h2>
      <DummyComponent />
      <hr />
      <Person
        name={person1['name']}
        address={person1['address']}
        profession={person1['profession']}
      />
      <hr />
      <Person
        name={person2['name']}
        address={person2['address']}
        profession={person2['profession']}
      />
      <hr />
      <Car
        model={car['model']}
        company={car['company']}
      />
      <hr />
      <Computer
        brand={computer['brand']}
        cpu={computer['cpu']}
        model={computer['model']}
        memory={computer['memory']}
      />
    </div>
  )
}

export default App
