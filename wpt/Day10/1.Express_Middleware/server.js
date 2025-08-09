const express = require('express')
const productRouter = require('./routes/product')
const userRouter = require('./routes/user')

const app = express()

// add a middleware that will convert every request body to the json object
app.use(express.json())

//middleware
// function that executes for every single request
// app.use is used to add the middleware to the express application
app.use((req, res, next) => {
    //It is used to add the common logic that is required for all the routes
    //res.setHeader()
    console.log('This is a middleware')
    // after middleware completes its execution to look for the exact 
    // matching route use this next()
    next()
})

app.use('/product', productRouter)
app.use('/user', userRouter)

app.listen(4000, 'localhost', () => {
    console.log('server started...')
})