const fs = require('fs')

function writeIntoFile() {
    fs.writeFileSync("file1.txt", "Node.js is a free, open-source, cross-platform JavaScript runtime environment that lets developers create servers, web apps, command line tools and scripts.")
}

// writeIntoFile()

function readingFileUsingSync() {
    // Task-1
    console.log("File reading started...")
    const data = fs.readFileSync("file1.txt")
    console.log("File reading finished...")
    console.log("data - " + data)

    //Task-2
    console.log("Math calculation started...")
    const result = 328942 * 632743
    console.log("Math calculation finished...")
    console.log("Result - " + result)
}


function readingFileUsingAsync() {
    // Task-1
    console.log("File reading started...")
    // Asynchronous file reading
    // The first argument is the file name, the second argument is a callback function
    fs.readFile("file1.txt", (err, data) => {
        console.log("File reading finished...")
        console.log("data - " + data)
    })

    //Task-2
    console.log("Math calculation started...")
    const result = 328942 * 632743
    console.log("Math calculation finished...")
    console.log("Result - " + result)

}

// readingFileUsingSync()
readingFileUsingAsync()