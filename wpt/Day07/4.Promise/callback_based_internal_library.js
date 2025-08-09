//designed by senior developer (dummy libraries)
function getEmployeeById(empid, fn) {
    // xhr code
    const emp = { empid: 1, name: "Anil", salary: 10000, deptno: 10 }
    if (empid == 1)
        fn(emp, null)
    else
        fn(null, { "error": "Employee not found" })
}

function getDeptDetailsById(deptno, fn) {
    // xhr code
    const dept = { deptno: 10, dname: "Development", location: "Mumbai" }
    if (deptno == 10)
        fn(dept, null)
    else
        fn(null, { "error": "dept not found" })
}