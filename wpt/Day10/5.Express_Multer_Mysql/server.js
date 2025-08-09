const express = require('express')
const multer = require('multer')
const mysql = require('mysql2')

const app = express()
const upload = multer({ dest: "images" })

const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'kdac_db'
})

app.use(express.static("./images"))
app.use(express.json())
app.post('/category', upload.single('icon'), (req, res) => {
    const { title, details } = req.body
    const sql = `INSERT INTO category(title,details,image) VALUES(?,?,?)`
    pool.query(sql, [title, details, req.file.filename], (error, data) => {
        if (data)
            res.send(data)
        else
            res.send(error)
    })
    // console.log(title)
    // console.log(details)
    // console.log(req.file.filename)
    // res.send()
})

app.listen(4000, 'localhost', () => {
    console.log('server started')
})