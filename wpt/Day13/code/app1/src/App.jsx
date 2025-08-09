import React from 'react'
import Login from './pages/Login'
import Register from './pages/Register'
import { ToastContainer } from 'react-toastify'
import Home from './pages/Home'
import { Route, Routes } from 'react-router-dom'
import AboutUs from './pages/AboutUs'
import ContactUs from './pages/ContactUs'
import Profile from './pages/Profile'
import MyProperties from './pages/MyProperties'
import AddProperty from './pages/AddProperty'
import Dummy from './pages/Dummy'

function App() {
  return (
    <>
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
          element={<Home />}
        />
        <Route
          path='about-us'
          element={<AboutUs />}
        />
        <Route
          path='contact-us'
          element={<ContactUs />}
        />
        <Route
          path='profile'
          element={<Profile />}
        />
        <Route
          path='add-property'
          element={<AddProperty />}
        />

        <Route
          path='my-properties'
          element={<MyProperties />}
        />
        <Route
          path='dummy'
          element={<Dummy />}
        />
      </Routes>
      <ToastContainer />
    </>
  )
}

export default App
