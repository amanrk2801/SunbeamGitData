import React, { useEffect, useState } from 'react'
import Navbar from '../components/Navbar'

function Dummy() {
  const [n1, setN1] = useState(10)
  const [n2, setN2] = useState(20)

  const onUpdateN1 = () => {
    setN1(n1 + 1)
  }

  const onUpdateN2 = () => {
    setN2(n2 + 1)
  }

  useEffect(() => {
    // this function here will get called everytime when
    // the state changes
    console.log(`state changed..`)
  })

  useEffect(() => {
    // this function gets called when n1 changes
    console.log(`n1 changed..: ${n1}`)
  }, [n1])

  useEffect(() => {
    // this function gets called when n1 changes
    console.log(`n2 changed..: ${n2}`)
  }, [n2])

  return (
    <div>
      <Navbar />
      <div className='container'>
        <h1 className='page-header'>Dummy</h1>

        <div>n1: {n1}</div>
        <div>
          <button
            onClick={onUpdateN1}
            className='btn btn-success'
          >
            Update N1
          </button>
        </div>
        <div>n2: {n2}</div>
        <div>
          <button
            onClick={onUpdateN2}
            className='btn btn-success'
          >
            Update N2
          </button>
        </div>
      </div>
    </div>
  )
}

export default Dummy
