import React, { useContext } from 'react'
import { CounterContext } from '../App'

function Component3() {
  // since this component is not added inside the CounterContext
  // the value here will be undefined
  const value = useContext(CounterContext)
  console.log(`value = `, value)

  const onIncrement = () => {
    // setCounter(counter + 1)
  }

  const onDecrement = () => {
    // setCounter(counter - 1)
  }
  return (
    <div style={{ textAlign: 'center' }}>
      <h1 className='page-header'>Component 3</h1>
      {/* <div>counter: {counter}</div> */}
      <div>
        <button onClick={onIncrement}>Increment</button>
        <button onClick={onDecrement}>Decrement</button>
      </div>
    </div>
  )
}

export default Component3
