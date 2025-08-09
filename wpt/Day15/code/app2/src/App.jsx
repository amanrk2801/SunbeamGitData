import React, { useState } from 'react'
import Counter1 from './components/Counter1'
import Counter2 from './components/Counter2'
import { CounterContext } from './counter.context'

function App() {
  const [counter, setCounter] = useState(0)

  return (
    <div>
      <CounterContext value={{ counter, setCounter }}>
        <Counter1 />
        <hr />
        <Counter2 />
      </CounterContext>
    </div>
  )
}

export default App
