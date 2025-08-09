import React, { useContext } from 'react'
import { CounterContext } from '../counter.context'

function Counter2() {
  const { counter, setCounter } = useContext(CounterContext)

  const onUpdate = () => {
    setCounter(counter + 1)
  }

  return (
    <div>
      <h1>Counter2</h1>
      <div>Counter: {counter}</div>
      <div>
        <button onClick={onUpdate}>update</button>
      </div>
    </div>
  )
}

export default Counter2
