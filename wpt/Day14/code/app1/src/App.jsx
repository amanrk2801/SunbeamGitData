import React, { useState } from 'react'
import Login from './pages/Login'
import Register from './pages/Register'
import { ToastContainer } from 'react-toastify'
import Home from './pages/Home'
import { Navigate, Route, Routes } from 'react-router-dom'
import AboutUs from './pages/AboutUs'
import ContactUs from './pages/ContactUs'
import Profile from './pages/Profile'
import MyProperties from './pages/MyProperties'
import AddProperty from './pages/AddProperty'
import Dummy from './pages/Dummy'
import { AuthContext } from './contexts/auth.context'

function App() {
  const [user, setUser] = useState(null)

  return (
    <>
      <AuthContext value={{ user, setUser }}>
        <Routes>
          <Route
            path='/'
            element={<Login />}
          />
          <Route
            path='register'
            element={<Register />}
          />
          <Route
            path='home'
            element={user ? <Home /> : <Navigate to='/' />}
          />
          <Route
            path='about-us'
            element={user ? <AboutUs /> : <Navigate to='/' />}
          />
          <Route
            path='contact-us'
            element={user ? <ContactUs /> : <Navigate to='/' />}
          />
          <Route
            path='profile'
            element={user ? <Profile /> : <Navigate to='/' />}
          />
          <Route
            path='add-property'
            element={user ? <AddProperty /> : <Navigate to='/' />}
          />

          <Route
            path='my-properties'
            element={user ? <MyProperties /> : <Navigate to='/' />}
          />
          <Route
            path='dummy'
            element={user ? <Dummy /> : <Navigate to='/' />}
          />
        </Routes>
      </AuthContext>

      <ToastContainer />
    </>
  )
}

export default App
