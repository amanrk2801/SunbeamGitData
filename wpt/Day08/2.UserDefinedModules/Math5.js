function add(n1, n2) {
    const result = n1 + n2
    console.log("Addition = " + result)
}

function sub(n1, n2) {
    const result = n1 - n2
    console.log("Substraction = " + result)
}

function mul(n1, n2) {
    const result = n1 * n2
    console.log("Multiplication = " + result)
}



module.exports = add // Exporting a function
module.exports.mysub = sub // Exporting as object
