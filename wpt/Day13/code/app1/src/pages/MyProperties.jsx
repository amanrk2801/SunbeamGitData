import React from 'react'
import Navbar from '../components/Navbar'
import { Link } from 'react-router-dom'

function MyProperties() {
  return (
    <div>
      <Navbar />
      <h2 className='page-header'>My Properties</h2>
      <div className='container'>
        <Link
          to='/add-property'
          className='btn btn-warning'
        >
          Add
        </Link>
      </div>
    </div>
  )
}

export default MyProperties
