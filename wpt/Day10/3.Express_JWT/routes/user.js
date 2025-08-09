const express = require('express')
const cryptoJs = require('crypto-js')
const jwt = require('jsonwebtoken')
const pool = require('../db/mysql')
const result = require('../utils/result')
const config = require('../utils/config')

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
            if (data.length != 0) {
                const payload = {
                    id: data[0].id
                }
                const token = jwt.sign(payload, config.secret)
                const userData = {
                    name: data[0].name,
                    email: data[0].email,
                    token: token
                }
                res.send(result.createSuccessResult(userData))
            }
            else
                res.send(result.createErrorResult('Invalid email or password'))
        } else
            res.send(result.createErrorResult(error))
    })
})

router.put('/', (req, res) => {
    const token = req.headers.token
    if (token) {
        try {
            const payload = jwt.verify(token, config.secret)
            const sql = `UPDATE user SET name = ? WHERE id = ?`
            pool.query(sql, [req.body.name, payload.id], (error, data) => {
                res.send(result.createResult(error, data))
            })
        } catch (error) {
            res.send(result.createErrorResult('Token is Invalid'))
        }
    }
    else
        res.send(result.createErrorResult('Token is missing'))

    //res.send()
})

router.delete('/', (req, res) => {
    const token = req.headers.token
    if (token) {
        try {
            const payload = jwt.verify(token, config.secret)
            const sql = `DELETE FROM user WHERE id = ?`
            pool.query(sql, [payload.id], (error, data) => {
                res.send(result.createResult(error, data))
            })
        } catch (error) {
            res.send(result.createErrorResult('Token is Invalid'))
        }
    }
    else
        res.send(result.createErrorResult('Token is Missing'))

})

module.exports = router