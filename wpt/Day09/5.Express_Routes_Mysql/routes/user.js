const express = require('express')
const pool = require('../db/mysql')
const result = require('../utils/result')
const router = express.Router()

router.post('/signup', (req, res) => {
    //destructuring of an object
    const { name, email, password } = req.body

    // const name = req.body.name
    // const email = req.body.email
    // const password = req.body.password

    const sql = `INSERT INTO user(name,email,password) VALUES(?,?,?)`
    pool.query(sql, [name, email, password], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

router.post('/signin', (req, res) => {
    const { email, password } = req.body
    const sql = `SELECT * FROM user WHERE email = ? AND password = ?`
    pool.query(sql, [email, password], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

module.exports = router
