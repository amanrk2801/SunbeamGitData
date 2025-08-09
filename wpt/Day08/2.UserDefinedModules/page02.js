function f1() {
    console.log("Inside f1")
}

function add(n1, n2) {
    const result = n1 + n2
    console.log("Addition - " + result)
}

function square(n) {
    return n * n
}

f1()
add(10, 20)
const sqr = square(5)
console.log(sqr)