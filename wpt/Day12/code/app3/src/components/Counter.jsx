import { useState } from 'react'

function Counter() {
  const [counter, setCounter] = useState(10)

  // click event handler
  const onIncrement = () => {
    setCounter(counter + 1)
  }

  const onDecrement = () => {
    setCounter(counter - 1)
  }

  return (
    <div>
      <h4>Counter</h4>

      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <div>counter: {counter}</div>
      <hr />
      <div>
        <button onClick={onIncrement}>Increment</button>
        <button onClick={onDecrement}>Decrement</button>
      </div>
    </div>
  )
}

export default Counter
