const express = require('express')
const router = express.Router()

router.get('/', (req, res) => {
    res.send('user get')
})

router.post('/', (req, res) => {
    res.send('user post')
})

router.put('/', (req, res) => {
    res.send('user put')
})

router.delete('/', (req, res) => {
    res.send('user delete')
})

module.exports = router