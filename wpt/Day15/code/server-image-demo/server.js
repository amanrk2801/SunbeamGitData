const express = require('express')
const multer = require('multer')
const upload = multer({ dest: 'images' })
const cors = require('cors')

const app = express()

app.use(cors())

// convert the request body into json object
app.use(express.json({ limit: '10mb' }))

// convert the request body into json object
app.use(express.urlencoded({ extended: true, limit: '100mb' }))

app.post('/test', (request, response) => {
  console.log(request.body)
  response.send('ok')
})

app.post('/image', upload.single('photo'), (request, response) => {
  console.log('image uploaded: ', request.file)
  response.send('ok')
})

app.listen(4000, '0.0.0.0', () => {
  console.log(`server started on port 4000`)
})
