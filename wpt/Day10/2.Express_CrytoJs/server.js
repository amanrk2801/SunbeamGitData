const express = require('express')
const productRouter = require('./routes/product')
const userRouter = require('./routes/user')

const app = express()

app.use(express.json())
app.use('/product', productRouter)
app.use('/user', userRouter)

app.listen(4000, 'localhost', () => {
    console.log('server started...')
})