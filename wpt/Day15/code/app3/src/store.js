import { configureStore } from '@reduxjs/toolkit'
import counterSlice from './features/counter.slice'

// create a store
export const store = configureStore({
  reducer: {
    // add the counter slice
    counter: counterSlice,
  },
})
