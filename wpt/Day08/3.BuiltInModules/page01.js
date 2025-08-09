const os = require('os')
// console.log(os)
console.log(typeof (os)) // object

console.log("arch - " + os.arch())
console.log("home dir - " + os.homedir())
console.log("host name - " + os.hostname())

console.log("platform - " + os.platform())
console.log("uptime - " + os.uptime())