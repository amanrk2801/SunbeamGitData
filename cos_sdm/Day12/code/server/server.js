const express = require('express')
const cors = require('cors')
const db = require('./db')
const utils = require('./utils')

const app = express()
app.use(cors())

app.get('/product', (request, response) => {
  const statement = `select id, title, price from product;`
  db.pool.query(statement, (error, result) => {
    response.send(utils.createResult(error, result))
  })
})

app.listen(4000, () => {
  console.log(`server started on port 4000`)
})
