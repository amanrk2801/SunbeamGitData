import React from 'react'
import { config } from '../config'
import { useNavigate } from 'react-router-dom'

function Property({ property, isMyProperty }) {
  const image = `${config.serverURL}/${property['profileImage']}`

  // get navigate function reference
  const navigate = useNavigate()
  const onDetails = () => {
    // go to the property details screen
    // along with the selected property (state)
    navigate('/home/property-details', { state: property })
  }

  return (
    <div className='col-3'>
      <div className='card'>
        <img
          src={image}
          className='card-img-top'
          alt=''
          style={{ height: 200 }}
        />
        <div className='card-body'>
          <h5 className='card-title'>{property['title']}</h5>
          <div>{property['address']}</div>
          <div>
            <span style={{ fontWeight: 'bold' }}>₹ {property['rent']}</span> per
            night
          </div>
        </div>
        <div className='card-footer d-flex justify-content-between'>
          <button
            onClick={onDetails}
            className='btn btn-success'
          >
            details
          </button>
          {isMyProperty && <button className='btn btn-danger'>delete</button>}
        </div>
      </div>
    </div>
  )
}

export default Property
