
## demo01 - Java 8 Interfaces --- @FunctionalInterface
// Java 8 allows to write static methods in interface -- No need to additional helper/utility class
* Static methods
* Default methods
* interface Shape
    * calcArea()
    * calcPeri()
    * calcTotalArea()

## demo02 - Java 8 Interfaces
* interface Printable - show() //multiple interface inheritance will not lead to any ambiguity error
			       // because interfaces doesn't contain any definitions
* interface Displayable - show()
* Java 7 Interfaces - No ambiguity


* Default methods - Ambiguity 
// compiler error: duplicate show() method in FirstClass.
// if two interfaces have default method with same signature and a class is inherited from that interface,
//then it will lead to ambiguity.



* No ambiguity - After overriding method
// if two interfaces have default method with same signature and a class is inherited from that interface,
//	then it will lead to ambiguity.
// this problem can be resolved by overriding method in sub-class.



* Super class wins Super-interfaces clash! (no override) 
    * class Printable, interface Displayable
// when same signature method is inherited from a super-class
// and a super-interface, the super-class method gets precedance.
// no compiler error for ambiguity



* Method overriding above example 
// method overrriding -- method is called depending on type of object.









## demo03 - Lambda Expression
* Sort array using Comparator
    ```Java
    Employee[] arr = new Employee[] {
        new Employee(4, "B", "Clerk", "Sales", 723.44),
        new Employee(8, "X", "Manager", "Accounts", 823.23),
        new Employee(2, "P", "Clerk", "Research", 234.23),
        new Employee(9, "N", "Manger", "Sales", 252.53),
        new Employee(5, "D", "Clerk", "Accounts", 923.23),
        new Employee(1, "Q", "Analyst", "Research", 826.23),
        new Employee(7, "H", "Clerk", "Research", 845.24),
        new Employee(6, "A", "Analyst", "Research", 832.23),
        new Employee(3, "G", "Analyst", "Sales", 952.44)
    };
    ```
*EmployeeIdComparator  -- local class
*Employees sort by name ---- Anonymous Inner class (empNameComparator)
*Empolyees sort by Job : Anonymous Inner class Anonymous object 
*Empolyees sort by Job desc 
*Empolyees sort by name desc (type inference) 
*Empolyees sort by sal Asc
*Empolyees sort by sal desc 
*Emps list sorted by id in desc order:

**  Arrays.asList(arr); 

* Predifined Funtional Interfaces in java (Theory)


* use BinaryOperator<Integer> op1; 
*lambda expressions are referenced by functional interface reference.
*lambda arg scope is limited to lambda expression body/implementation.
*non-capturing lambda
*capturing lambda

*// capturing lambda - captures (attach) a variable out-side the lambda implementation.
// can capture variables that are final or effectively final.





## demo04 - Lambda expressions
## demo05 - Java Streams
		//Input : 1 , 2 , 3 , 4 , 5 , 6 , 7 , 8 , 9 , 10 
		//step1 : Square of each number : 1 , 4 , 9 , 16 , 25 , 36 , 49 , 64 , 81 , 100 
		//step2 : get all odd numbers : 1 , 9 , 25 , 49 , 81 
		//step3 : append "java" :  "java1" , "java9" , "java25" , "java49" , "java81"
		// print each element 
		
		

* Stream operations
    * filter()
    * map()
    * sorted()
    * map()
    * forEach()
* Stream execution






Shape[] arr = {
				new Rectangle(10, 2), 
				new Square(4.1),
				new Circle(3.1) 
		}; 