import { createSlice } from '@reduxjs/toolkit'

// create a slice
const counterSlice = createSlice({
  // unique name to identify the slice inside the store
  name: 'counter',

  // state to be maintained by the slice
  initialState: {
    count: 10,
  },

  // collection of actions and their respective reducers
  reducers: {
    // incrementAction is the action
    // the function is the reducer
    incrementAction: (state) => {
      // update the state
      state.count += 1
    },
    decrementAction: (state) => {
      state.count -= 1
    },
  },
})

// export actions
export const { incrementAction, decrementAction } = counterSlice.actions

// export the reducers
export default counterSlice.reducer
