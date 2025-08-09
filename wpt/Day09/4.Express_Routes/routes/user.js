const express = require('express')

// router object is used to create multiple routes
const router = express.Router()

const users = [
    { uid: 1, name: "Anil", age: 30 },
    { uid: 2, name: "Mukesh", age: 32 },
    { uid: 3, name: "Ramesh", age: 35 },
    { uid: 4, name: "Suresh", age: 40 },
    { uid: 5, name: "Ram", age: 45 }
]

//routes
router.get('/', (req, res) => {
    res.send(users)
})

router.post('/', (req, res) => {
    res.send('user post')
})

module.exports = router