const express = require('express')
const router = express.Router()

const products = [
    { pid: 1, name: "Pen", price: 10 },
    { pid: 2, name: "Pencil", price: 5 },
    { pid: 3, name: "Book", price: 50 },
    { pid: 4, name: "Eraser", price: 10 },
    { pid: 5, name: "Sharpner", price: 15 }
]

router.get('/', (req, res) => {
    res.send(products)
})


router.post('/', (req, res) => {
    res.send('product add')
})


module.exports = router