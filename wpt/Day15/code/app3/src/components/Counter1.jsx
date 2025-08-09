import React from 'react'
import { useSelector } from 'react-redux'

function Counter1() {
  // get the count from store using selector reference
  const { count } = useSelector((store) => store.counter)

  return (
    <div>
      <h1>Counter 1</h1>
      <div>count: {count}</div>
    </div>
  )
}

export default Counter1
