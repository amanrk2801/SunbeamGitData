const express = require('express')
const pool = require('../db/db')
const result = require('../utils/result')
const router = express.Router()

router.post('/', (req, res) => {
    const { propertyId, total, fromDate, toDate } = req.body
    const sql = `INSERT INTO bookings(userId,propertyId,fromDate,toDate,total)
    VALUES (?,?,?,?,?)`
    pool.query(sql, [req.headers.userId, propertyId, fromDate, toDate, total], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

router.get('/', (req, res) => {
    const sql = `SELECT * FROM bookings WHERE userId = ?`
    pool.query(sql, [req.headers.userId], (error, data) => {
        res.send(result.createResult(error, data))
    })
})
module.exports = router