function function1() {
  console.log(`inside function1`)
}

// calling a function with function name
// function1()

// function reference
const myFunction1 = function1

// calling the same function with function reference
// myFunction1()

function function2(parameter) {
  // parameter is a function reference
  // const parameter = function1
  console.log(`inside function2`)
  console.log(`parameter = ${parameter}, type = ${typeof parameter}`)

  // make a call to the function
  parameter()
}

// function2(10)
// function2('test')
// function2(true)
// function2()

// passing a function named function1 to another function named function2
// function2(function1)
