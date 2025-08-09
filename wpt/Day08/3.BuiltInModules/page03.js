const http = require('http')

// http  server is created  

const server = http.createServer((request, response) => {
    console.log("Backend Server called")
    console.log(request.url)
    console.log(request.method)
    response.end()
})

// server is listening on port 4000
server.listen(4000, "localhost", () => {
    console.log("Server started at port 4000")
})