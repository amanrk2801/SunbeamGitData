function function1() {
  // number
  let num = 100
  console.log(`num: ${num}, type = ${typeof num}`)

  // string
  num = '100'
  console.log(`num: ${num}, type = ${typeof num}`)

  // boolean
  num = true
  console.log(`num: ${num}, type = ${typeof num}`)

  // undefined
  num = undefined
  console.log(`num: ${num}, type = ${typeof num}`)
}

// function1()

function function2() {
  const array = [10, 20, 30, 40, 50]
  console.log(`array: ${array}, type = ${typeof array}`)
}

function2()
