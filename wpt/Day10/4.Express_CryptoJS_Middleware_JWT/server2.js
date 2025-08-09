const express = require('express')
const jwt = require('jsonwebtoken')
const productRouter = require('./routes/product')
const userRouter = require('./routes/user')
const result = require('./utils/result')
const config = require('./utils/config')
const authorization = require('./routes/authorization')

const app = express()

app.use(express.json())
//authorization middleware
app.use(authorization)
app.use('/product', productRouter)
app.use('/user', userRouter)

app.listen(4000, 'localhost', () => {
    console.log('server started...')
})