const express = require('express')
const cors = require('cors')

const app = express()
app.use(cors())

app.get('/', (request, response) => {
  response.send('welcome to express application')
})

app.get('/products', (request, response) => {
  response.send([
    { id: 1, title: 'product 1', price: 100 },
    { id: 2, title: 'product 2', price: 200 },
    { id: 3, title: 'product 3', price: 300 },
    { id: 4, title: 'product 4', price: 400 },
    { id: 5, title: 'product 5', price: 500 },
  ])
})

app.listen(4000, () => {
  console.log(`server started on port 4000`)
})
