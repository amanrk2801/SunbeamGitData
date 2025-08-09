function add(n1, n2) {
    const result = n1 + n2
    console.log("Addition = " + result)
}

function sub(n1, n2) {
    const result = n1 - n2
    console.log("Substraction = " + result)
}


// module.exports = add
// module.exports = sub
module.exports = { add, sub }