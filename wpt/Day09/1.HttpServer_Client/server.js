const http = require('http')

const users = [
    { uid: 1, name: "Anil", age: 30 },
    { uid: 2, name: "Mukesh", age: 32 },
    { uid: 3, name: "Ramesh", age: 35 },
    { uid: 4, name: "Suresh", age: 40 },
    { uid: 5, name: "Ram", age: 45 }
]

const products = [
    { pid: 1, name: "Pen", price: 10 },
    { pid: 2, name: "Pencil", price: 5 },
    { pid: 3, name: "Book", price: 50 },
    { pid: 4, name: "Eraser", price: 10 },
    { pid: 5, name: "Sharpner", price: 15 }
]

const server = http.createServer((request, response) => {
    if (request.method == 'GET' && request.url == '/user') {
        //response.writeHead(200, "OK", { "content-type": "text/html" })
        //response.write("<h1>Hello</h1>")
        //response.write("<h2>Welcome to sunbeam</h2>")
        // response.end("<h1>Hello</h1>")

        // we need to allow the client browser to access the resource from cross origin
        // to do so add the below header
        response.setHeader('Access-Control-Allow-Origin', '*')
        response.writeHead(200, "OK", { "content-type": "application/json" })
        response.write(JSON.stringify(users))
        response.end()
    }
    else if (request.method == 'GET' && request.url == '/product') {
        response.setHeader('Access-Control-Allow-Origin', '*')
        response.writeHead(200, "OK", { "content-type": "application/json" })
        response.write(JSON.stringify(products))
        response.end()

    }
    else {
        response.end("Invalid Path")
    }
})

server.listen(4000, 'localhost', () => {
    console.log('server started at port 4000')
})