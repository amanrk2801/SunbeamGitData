const express = require('express')

const app = express()


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


app.get('/user', (req, res) => {
    res.send(users)
})

app.get('/product', (req, res) => {
    res.send(products)
})

app.listen(4000, 'localhost', () => {
    console.log('server started at port 4000')
})