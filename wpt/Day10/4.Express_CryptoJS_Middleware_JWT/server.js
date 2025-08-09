const express = require('express')
const jwt = require('jsonwebtoken')
const productRouter = require('./routes/product')
const userRouter = require('./routes/user')
const result = require('./utils/result')
const config = require('./utils/config')

const app = express()

app.use(express.json())
//authorization
app.use((req, res, next) => {
    if (req.url == '/user/signup' || req.url == '/user/signin')
        next()
    else {
        const token = req.headers.token
        if (token) {
            try {
                const payload = jwt.verify(token, config.secret)
                req.headers.id = payload.id
                next()
            } catch (error) {
                res.send(result.createErrorResult('Token is Invalid'))
            }
        }
        else
            res.send(result.createErrorResult('Token is Missing'))
    }
})
app.use('/product', productRouter)
app.use('/user', userRouter)

app.listen(4000, 'localhost', () => {
    console.log('server started...')
})