import React, { useEffect } from 'react'
import Navbar from '../components/Navbar'

function Profile() {
  useEffect(() => {
    console.log('Profile is mounted')

    return () => {
      // this function will be called just before component get unmounted
      console.log('Profile is getting unloaded')
    }
  }, [])

  return (
    <div>
      <Navbar />
      <h2 className='page-header'>Profile</h2>
    </div>
  )
}

export default Profile
