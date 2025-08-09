// requirement: get square of each number and collect all of them in
//   a new array

function function1() {
  // array of numbers
  const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

  // create an empty array
  const squares = []

  // loop over the array and get square of each number
  for (const number of numbers) {
    squares.push(number ** 2)
  }

  console.log(`numbers: ${numbers}`)
  console.log(`squares: ${squares}`)
}

// function1()

function function2() {
  // array of numbers
  const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

  // using map function
  // const squares = numbers.map((number) => {
  //   return number ** 2
  // })

  const squares = numbers.map((number) => number ** 2)
  const cubes = numbers.map((number) => number ** 3)

  console.log(`numbers: ${numbers}`)
  console.log(`squares: ${squares}`)
  console.log(`cubes: ${cubes}`)
}

// function2()

function function3() {
  // array of objects
  const persons = [
    { name: 'John', age: 20, address: 'pune' },
    { name: 'Jen', age: 10, address: 'karad' },
    { name: 'David', age: 30, address: 'pune' },
    { name: 'Arnold', age: 9, address: 'karad' },
  ]

  // get every person's address in a new collection
  // select address from persons;
  const addresses = persons.map((person) => person['address'])
  console.log(`addresses: `, addresses)
}

function3()
