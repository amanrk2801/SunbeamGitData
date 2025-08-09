const express = require('express')
const router = express.Router()
const pool = require('../db/mysql')
const result = require('../utils/result')

router.get('/', (req, res) => {
    const sql = `SELECT * FROM product`
    pool.query(sql, (error, data) => {
        res.send(result.createResult(error, data))
    })
})

router.post('/', (req, res) => {
    const { name, price } = req.body
    const sql = `INSERT INTO product(name,price) VALUES(?,?)`
    pool.query(sql, [name, price], (error, data) => {
        res.send(result.createResult(error, data))
    })
})
module.exports = router