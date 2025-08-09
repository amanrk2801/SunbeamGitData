import React, { useEffect } from 'react'
import Navbar from '../components/Navbar'

function Home() {
  // component did mount event
  useEffect(() => {
    // this function will be called as soon as the component gets mounted
    console.log('Home is mounted')

    return () => {
      // this function will be called just before component get unmounted
      console.log('Home is getting unloaded')
    }
  }, [])

  return (
    <div>
      <Navbar />
      <h2 className='page-header'>Home</h2>
    </div>
  )
}

export default Home
