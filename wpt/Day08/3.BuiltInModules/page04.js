const http = require('http')

const server = http.createServer((request, response) => {
    if (request.method == "GET")
        response.end("Get Api Called")
    else if (request.method == "POST")
        response.end("POST Api Called")
    else if (request.method == "PUT")
        response.end("PUT Api Called")
    else
        response.end("DELETE Api Called")

})

server.listen(4000, 'localhost', () => {
    console.log("Server started at 4000")
})