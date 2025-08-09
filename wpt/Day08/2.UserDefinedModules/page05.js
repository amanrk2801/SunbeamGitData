const math = require('./Math3')

console.log(math) // { myadd: [Function: myadd], mysub: [Function: mysub] }
console.log(typeof (math)) // object
console.log(math.myadd(10, 20))
console.log(math.mysub(100, 20))