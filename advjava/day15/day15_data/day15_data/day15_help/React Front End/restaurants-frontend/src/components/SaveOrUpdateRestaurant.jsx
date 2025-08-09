import React, { useState, useEffect } from 'react';
import {
  updateRestaurant,
  addNewRestaurant,
  getRestaurantById,
} from '../services/RestaurantService';
import { useNavigate, useParams } from 'react-router-dom';

const AddRestaurantComponent = () => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');
  const [city, setCity] = useState('');
  const [address, setAddress] = useState('');
  const navigate = useNavigate();
  const { restaurantId } = useParams();
  const title = 'Add';
  //add new state object to hold validation errors (client side)
  const [errors, setErrors] = useState({
    name: '',
    description: '',
  });
  useEffect(() => {
    if (restaurantId) {
      //make REST API call to get restaurant details
      getRestaurantById(restaurantId)
        .then((response) => {
          setName(response.data.name);
          setDescription(response.data.description);
          setAddress(response.data.address);
          setCity(response.data.city);
        })
        .catch((err) => {
          console.error(err);
        });
    }
  }, [restaurantId]);
  //useEffect hook added for logging errors !
  useEffect(() => {
    console.log('Errors:', errors);
  }, [errors]);
  //add validation rules
  function validateForm() {
    //copy errors object in errorCopy
    const errorsCopy = { ...errors };
    let valid = true;
    if (name.trim()) {
      errorsCopy.name = '';
    } else {
      valid = false;
      errorsCopy.name = 'Restaurant Name is required !';
    }
    if (description.trim()) {
      errorsCopy.description = '';
    } else {
      valid = false;
      errorsCopy.description = 'Description is required !';
    }
    if (address.trim()) {
      errorsCopy.address = '';
    } else {
      valid = false;
      errorsCopy.address = 'Restaurant Address is required !';
    }
    if (city.trim()) {
      errorsCopy.city = '';
    } else {
      valid = false;
      errorsCopy.city = 'Restaurant City is required !';
    }
    setErrors(errorsCopy);
    return valid;
  }
  function createNewRestaurant() {
    //create restaurant object
    const restaurant = { name, description, address, city };
    console.log(restaurant);
    addNewRestaurant(restaurant)
      .then((response) => {
        console.log(response.data);
        navigate('/restaurants');
      })
      .catch((err) => {
        console.error(err);
      });
  }
  function updateRestaurantDetails() {
    //create restaurant object
    const restaurant = { name, description, address, city };
    console.log('update ' + restaurant);
    updateRestaurant(restaurantId, restaurant)
      .then((response) => {
        console.log(response.data);
        navigate('/restaurants');
      })
      .catch((err) => {
        console.error(err);
      });
  }
  //JS function to save restaurant details
  /*
  1. create restaurant object from the state
  2. invoke RestaurantService's addRestaurant n pass this 
  3. navigate to list restaurants
  */
  function saveOrUpdateRestaurantDetails(e) {
    e.preventDefault();
    //check for validation errors
    if (validateForm()) {
      if (restaurantId) {
        //update restaurant
        updateRestaurantDetails();
      } else {
        createNewRestaurant();
      }
    } else {
      console.error(`validation errors ${errors}`);
    }
  }
  return (
    <div className='container'>
      <div className='row justify-content-center'>
        <div className='col-md-6'>
          <div className='card'>
            <h3 className='card-header'>
              {restaurantId ? 'Update' : 'Add'} Restaurant Details
            </h3>
            <div className='card-body'>
              <form>
                <div className='form-row mb-3'>
                  <label className='col-form-label'>Name</label>
                  <input
                    type='text'
                    className={`form-control ${
                      errors.name ? 'is-invalid' : ''
                    }`}
                    placeholder='Enter Restaurant Name'
                    name='name'
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                  />
                  {errors.name && (
                    <div className='invalid-feedback'>{errors.name}</div>
                  )}
                </div>
                <div className='form-row mb-3'>
                  <label className='col-form-label'>Description</label>
                  <input
                    type='text'
                    className={`form-control ${
                      errors.description ? 'is-invalid' : ''
                    }`}
                    placeholder='Enter Restaurant Description'
                    name='description'
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                  />
                  {errors.description && (
                    <div className='invalid-feedback'>{errors.description}</div>
                  )}
                </div>
                <div className='mb-3'>
                  <label className='form-label'>Address</label>
                  <input
                    type='text'
                    className={`form-control ${
                      errors.address ? 'is-invalid' : ''
                    }`}
                    placeholder='Enter Restaurant Address'
                    name='address'
                    value={address}
                    onChange={(e) => setAddress(e.target.value)}
                  />
                  {errors.city && (
                    <div className='invalid-feedback'>{errors.city}</div>
                  )}
                </div>
                <div className='mb-3'>
                  <label className='form-label'>City</label>
                  <input
                    type='text'
                    className={`form-control ${
                      errors.city ? 'is-invalid' : ''
                    }`}
                    placeholder='Enter Restaurant City'
                    name='city'
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                  />
                  {errors.city && (
                    <div className='invalid-feedback'>{errors.city}</div>
                  )}
                </div>
                <div className='d-grid gap-2'>
                  <button
                    className='btn btn-success'
                    onClick={saveOrUpdateRestaurantDetails}
                  >
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default AddRestaurantComponent;
