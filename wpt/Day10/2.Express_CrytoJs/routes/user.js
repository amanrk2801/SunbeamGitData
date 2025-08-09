const express = require('express')
const cryptoJs = require('crypto-js')
const pool = require('../db/mysql')
const result = require('../utils/result')

const router = express.Router()

router.get('/', (req, res) => {
    const sql = `SELECT * FROM user`
    pool.query(sql, (error, data) => {
        res.send(result.createResult(error, data))
    })
})


router.post('/signup', (req, res) => {
    const { name, email, password } = req.body
    const encryptedPassword = cryptoJs.SHA256(password).toString()
    const sql = `INSERT INTO user(name,email,password) VALUES(?,?,?)`
    pool.query(sql, [name, email, encryptedPassword], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

router.post('/signin', (req, res) => {
    const { email, password } = req.body
    const encryptedPassword = cryptoJs.SHA256(password).toString()
    const sql = `SELECT * FROM user WHERE email = ? AND password = ?`
    pool.query(sql, [email, encryptedPassword], (error, data) => {
        if (data) {
            if (data.length != 0)
                res.send(result.createSuccessResult(data))
            else
                res.send(result.createErrorResult('Invalid email or password'))
        } else
            res.send(result.createErrorResult(error))
    })
})

router.put('/', (req, res) => {
    const { name, id } = req.body
    const sql = `UPDATE user SET name = ? WHERE id = ?`
    pool.query(sql, [name, id], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

router.delete('/:id', (req, res) => {
    const sql = `DELETE FROM user WHERE id = ?`
    pool.query(sql, [req.params.id], (error, data) => {
        res.send(result.createResult(error, data))
    })
})

module.exports = router