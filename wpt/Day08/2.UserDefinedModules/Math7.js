const PI = 3.14

const obj = {
    prop1: "value1",
    prop2: "value2"
}

const myadd = function (n1, n2) {
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



// module.exports = PI // in page09 the math will be a variable
// module.exports = obj // in page09 the math will be an object
// module.exports = myadd // in page09 the math will be an function
// module.exports.mysub = sub //in page09 the math will be an object
// module.exports = { mul } //in page09 the math will be an object
module.exports = { PI, obj, myadd, sub, mul } //in page09 the math will be an object

