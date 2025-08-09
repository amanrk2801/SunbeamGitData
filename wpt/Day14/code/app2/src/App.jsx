import React, { createContext, useState } from 'react'
import Component1 from './components/Component1'
import Component2 from './components/Component2'
import Component3 from './components/Component3'

// create context to share the data
export const CounterContext = createContext()

function App() {
  // state to maintain the counter
  const [counter, setCounter] = useState(10)

  return (
    <div>
      <CounterContext value={{ counter, setCounter }}>
        <h1 className='page-header'>App Component</h1>
        <hr />
        <Component1 />
        <hr />
        <Component2 />
        <hr />
      </CounterContext>

      <Component3 />
    </div>
  )
}

export default App
