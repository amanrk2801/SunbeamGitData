import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { decrementAction, incrementAction } from '../features/counter.slice'

function Counter2() {
  // get the count from store
  const { count } = useSelector((store) => store.counter)

  // get the dispatch function reference
  const dispatch = useDispatch()

  const onIncrement = () => {
    // invoke the increment action
    dispatch(incrementAction())
  }

  const onDecrement = () => {
    // invoke decrement action
    dispatch(decrementAction())
  }

  return (
    <div>
      <h1>Counter 2</h1>
      <div>count: {count}</div>
      <div>
        <button onClick={onIncrement}>increment</button>
        <button onClick={onDecrement}>decrement</button>
      </div>
    </div>
  )
}

export default Counter2
