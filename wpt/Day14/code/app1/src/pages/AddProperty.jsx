import React, { useEffect, useState } from 'react'
import Navbar from '../components/Navbar'
import { getCategories } from '../services/category'
import { toast } from 'react-toastify'

function AddProperty() {
  // create state member for storing categories
  const [categories, setCategories] = useState([])

  const onLoadCategories = async () => {
    const result = await getCategories()
    if (!result) {
      toast.error('Error while loading categories')
    } else {
      if (result['status'] == 'success') {
        setCategories(result['data'])
      } else {
        toast.error(result['error'])
      }
    }
  }

  useEffect(() => {
    onLoadCategories()
    console.log(`Add Properties is mounted`)

    return () => {
      // this function will be called just before component get unmounted
      console.log('AddProperties is getting unloaded')
    }
  }, [])

  return (
    <div>
      <Navbar />
      <div className='container'>
        <h2 className='page-header'>Add Property</h2>

        <div className='form'>
          <div className='mb-3'>
            <label htmlFor=''>Category</label>
            <select className='form-control'>
              {categories.map((category) => {
                return (
                  <option
                    key={category['id']}
                    value={category['id']}
                  >
                    {category['title']}
                  </option>
                )
              })}
            </select>
          </div>
        </div>
      </div>
    </div>
  )
}

export default AddProperty
