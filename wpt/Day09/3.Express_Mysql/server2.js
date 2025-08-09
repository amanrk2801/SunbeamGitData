const express = require('express')
const mysql = require('mysql2')

const app = express()

const pool = mysql.createPool({
    host: "localhost",
    user: 'root',
    password: 'root',
    database: 'kdac_db'
})

app.get('/user', (req, res) => {
    const sql = `SELECT * FROM user`
    pool.query(sql, (error, data) => {
        if (data)
            res.send(data)
        else
            res.send(error)
    })
})

app.get('/product', (req, res) => {
    const sql = `SELECT * FROM product`
    pool.query(sql, (error, data) => {
        if (data)
            res.send(data)
        else
            res.send(error)
    })
})

app.listen(4000, 'localhost', () => {
    console.log('server started at port 4000')
})