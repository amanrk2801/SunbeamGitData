//designed by senior developer (dummy libraries)

function getEmployeeById(empid) {
    const promise = new Promise((resolved, rejected) => {
        // xhr code
        const emp = { empid: 1, name: "Anil", salary: 10000, deptno: 10 }
        if (empid == 1)
            resolved(emp)
        else
            rejected({ "error": "Employee not found" })
    })
    return promise
}

function getDeptDetailsById(deptno) {
    const promise = new Promise((resolved, rejected) => {
        // xhr code
        const dept = { deptno: 10, dname: "Development", location: "Mumbai" }
        if (deptno == 10)
            resolved(dept)
        else
            rejected({ "error": "dept not found" })

    })
    return promise
}