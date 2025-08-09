const express = require('express')
const productRouter = require('./routes/product')
const userRouter = require('./routes/user')

const app = express()

// add the middleware

// It will convert the request body to the json object for all incoming requests 
app.use(express.json())

app.use('/product', productRouter)
app.use('/user', userRouter)

app.listen(4000, 'localhost', () => {
    console.log('server started')
})