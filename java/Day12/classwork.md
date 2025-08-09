# Day16 - Classwork

##
# demo01 - Stream/Optional
* `Stream<Double>`//Arrays.stream(); 
    * skip()
    * limit()
* `Stream<String>`//list.stream(); 
list.add("A sequence of elements supporting sequential and parallel aggregate operations.");
list.add("In addition to Stream, which is a stream of object references, there are primitive specializations for IntStream.");
list.add("To perform a computation, stream operations are composed into a stream pipeline.");	
    * map(lowercase) 
    * flatMap()
    
* `Stream<Integer>`
    * reduce() ( use Set ( TreeSet) ,set.stream() ) (Collections.addAll) ( convert set to Stream first and then use reduce)
    
* `Stream<Integer> strm = Stream.iterate(); 
    * print table of number
* `Stream<Integer> strm = Stream.generate(() -> r.nextInt(100));`
    * random number stream ( Random r = new Random) 
*  collect in a list(Collectors.tolist) 
*  collect (distinct) in a set

* Stream of primitive values
    *// primitive streams are more efficient -- because no boxing/unboxing done for each arithmetic	
    * Create a stream of wrapperclass ( use Stream.iterate(1, i->i+1)) 
    * try Creating stream of primitive ( Compiler Error)
    *IntStream strm = IntStream.of(1,2,3,4,5); 
     
## demo02 - Method references
// lambda expr = short-hand implementation of SAM (functional interface)
// method ref = short-hand of lambda expr
* static method reference // static method of a class --> ClassName.method(arg1, arg2); i.e. static method called on ClassName
* non-static method reference // non-static method of a class --> arg1.method(arg2); i.e. non-static method called on arg1
* object method reference // non-static method to call on obj --> obj.method(arg); i.e. non-static method called on given object
* constructor reference// param-less constructor is called after creating object of given class.

## demo04 - Reflection
*// get class metadata -- java.lang.Class object
// String className; --> c = Class.forName(className);
* inspect metadata(Class.forName(className))


## demo03 - enum
* enum Arithmetic
* Menu driven program
* enum fields


## demo02 - Annotations
* String(value , designation , company())
* Pre-defined annotations
* Custom annotations 


## demo03 - File class ( java.io.File) 
/*
1. Input a path from user.( java.io.File) 
2. If path is invalid, print error.
3. If path is of directory, display contents of that directory.
4. If path is of file, display information about that file.
*/
* Get file/directory information

## demo04 - File class
* create directory
* create file
* delete file


## demo05 - File Copy
* FileInputStream
* FileOutputStream

