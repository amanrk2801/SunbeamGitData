const http = require('http')

const server = http.createServer((req, res) => {
    const method = req.method
    const url = req.url
    if (url == '/user') {
        if (method == "GET") {
            res.end(`{"name":"Anil","mobile":"9876543210","age":30}`)
        }
        else if (method == 'POST') {
            res.end('User Post method called')
        }
        else if (method == 'PUT') {
            res.end('User PUT method called')
        }
        else {
            res.end('User DELETE method called')
        }
    }
    else if (url == '/product') {
        if (method == 'GET') {
            res.end(`{pid:1,name:"Pen",price:10}`)
        }
        else if (method == "POST") {
            res.end("Product POST method called")
        }
        else if (method == "PUT") {
            res.end("Product PUT method called")
        }
        else {
            res.end("Product DELETE method called")
        }
    }
    else {
        res.end('Invalid PATH')
    }
})

server.listen(4000, 'localhost', () => {
    console.log('server started at port 4000')
})