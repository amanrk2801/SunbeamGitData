import React, { useContext } from 'react'
import { CounterContext } from '../App'

function Component2() {
  const { counter, setCounter } = useContext(CounterContext)

  const onIncrement = () => {
    setCounter(counter + 1)
  }

  const onDecrement = () => {
    setCounter(counter - 1)
  }
  return (
    <div style={{ textAlign: 'center' }}>
      <h1 className='page-header'>Component 2</h1>
      <div>counter: {counter}</div>
      <div>
        <button onClick={onIncrement}>Increment</button>
        <button onClick={onDecrement}>Decrement</button>
      </div>
    </div>
  )
}

export default Component2
