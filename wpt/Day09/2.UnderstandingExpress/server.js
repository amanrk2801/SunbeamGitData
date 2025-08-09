const express = require('express')

// create the object of an express
const app = express() // app is a object thats why we use app.get, app.post, app.put, app.delete

//route 
// method , path
app.get('/user', (request, response) => {
    // request is the incoming request from the client
    // response is the outgoing response to the client
    response.send("Fetch all users.")
})

app.post('/user', (req, res) => {
    res.send('Create a new user.')
})

app.put('/user', (req, res) => {
    res.send('Replace an existing user completely.')
})

app.patch('/user', (req, res) => {
    res.send('Update parts of an existing user.')
})

app.delete('/user', (req, res) => {
    res.send('Remove a user permanently.')
})

// CRUD operations for products
app.get('/products', (req, res) => {
    res.send("Get all products");
});

app.post('/products', (req, res) => {
    res.send("Create a new product");
});

app.put('/products/:id', (req, res) => {
    res.send(`Replace product with ID ${req.params.id}`);
});

app.patch('/products/:id', (req, res) => {
    res.send(`Update product with ID ${req.params.id}`);
});

app.delete('/products/:id', (req, res) => {
    res.send(`Delete product with ID ${req.params.id}`);
});

app.listen(4000, 'localhost', () => {
    console.log('express server started at port 4000')
})

