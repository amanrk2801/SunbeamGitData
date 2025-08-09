const express = require('express')
const pool = require('../db/mysql')
const result = require('../utils/result')
const router = express.Router()

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

router.put('/', (req, res) => {
    const { id, price } = req.body
    const sql = `UPDATE product SET price = ? WHERE id = ?`
    pool.query(sql, [price, id], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

router.delete('/:id', (req, res) => {
    const id = req.params.id
    const sql = `DELETE FROM product WHERE id = ?`
    pool.query(sql, [id], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

module.exports = router