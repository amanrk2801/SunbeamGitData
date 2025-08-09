const math = require('./Math4')
console.log(math) // { add: [Function: add], sub: [Function: sub] }
console.log(typeof (math)) // object
// math(10,20); // type error: math is not a function
math.add(10, 20) // 30