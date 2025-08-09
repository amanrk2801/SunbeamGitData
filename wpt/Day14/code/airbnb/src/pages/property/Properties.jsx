import React, { useEffect, useState } from 'react'
import { getAllProperties as getAllPropertiesFromServer } from '../../services/property'
import { toast } from 'react-toastify'
import Property from '../../components/Property'

function Properties() {
  // all properties
  const [properties, setProperties] = useState([])

  const getAllProperties = async () => {
    const result = await getAllPropertiesFromServer()
    if (!result) {
      toast.error('Error while loading all properties')
    } else {
      if (result['status'] == 'success') {
        setProperties(result['data'])
        console.log(result['data'])
      } else {
        toast.error(result['error'])
      }
    }
  }

  useEffect(() => {
    getAllProperties()
  }, [])

  return (
    <>
      <div className='container'>
        <h2 className='page-header'>Properties</h2>

        <div className='row'>
          {properties.map((property) => {
            return (
              <Property
                isMyProperty={false}
                property={property}
                key={property['id']}
              />
            )
          })}
        </div>
      </div>
    </>
  )
}

export default Properties
