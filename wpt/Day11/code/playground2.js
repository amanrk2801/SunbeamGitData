let num1 = 100
console.log(`num1: ${num1}, type = ${typeof num1}`)

const num2 = num1
console.log(`num2: ${num2}, type = ${typeof num2}`)

num1 = 200
console.log(`num1: ${num1}, type = ${typeof num1}`)
console.log(`num2: ${num2}, type = ${typeof num2}`)

// here function1 is function variable called as function reference
function function1() {
  console.log('inside function1')
}
// function1()
console.log(`function1: ${function1}, type = ${typeof function1}`)

// function2 is a function reference
const function2 = function1

// calling function using function name
function1()

// calling function using function reference
function2()
