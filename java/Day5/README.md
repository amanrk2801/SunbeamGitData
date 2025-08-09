# Java Revision Notes

## Part 1: Java Equals Method and Object Comparison

### Introduction
The `equals()` method is a fundamental method in Java used to compare objects for equality. It's defined in the `Object` class and can be overridden by subclasses to provide custom equality logic.

### Object Class equals() Method
- The default implementation in `Object` class compares object references (memory addresses)
- Returns `true` only if both references point to the same object in memory
- Syntax: `public boolean equals(Object obj)`

### Why Override equals()?
- Default implementation only checks if objects are the same instance
- Often, we need to compare objects based on their content/state
- Important for collections like `HashSet`, `HashMap`, etc., which rely on proper equals implementation

### Rules for Overriding equals()
1. **Reflexivity**: For any non-null reference value x, `x.equals(x)` should return `true`
2. **Symmetry**: For any non-null reference values x and y, `x.equals(y)` should return `true` if and only if `y.equals(x)` returns `true`
3. **Transitivity**: For any non-null reference values x, y, z, if `x.equals(y)` returns `true` and `y.equals(z)` returns `true`, then `x.equals(z)` should return `true`
4. **Consistency**: For any non-null reference values x and y, multiple invocations of `x.equals(y)` should consistently return `true` or `false` if no information used in equals comparisons is modified
5. **Non-nullity**: For any non-null reference value x, `x.equals(null)` should return `false`

### Proper Implementation of equals()
```java
@Override
public boolean equals(Object obj) {
    // 1. Check if the same object reference
    if (this == obj) return true;
    
    // 2. Check if null or different class
    if (obj == null || getClass() != obj.getClass()) return false;
    
    // 3. Cast to the appropriate type
    MyClass other = (MyClass) obj;
    
    // 4. Compare the relevant fields
    return Objects.equals(this.field1, other.field1) &&
           this.field2 == other.field2 &&
           // more field comparisons as needed
           Objects.equals(this.lastField, other.lastField);
}
```

### Important Considerations
1. **Always override hashCode() when overriding equals()**
   - If two objects are equal according to equals(), they MUST have the same hashCode() value
   - This is essential for proper functioning in hash-based collections

2. **Use getClass() vs instanceof**
   - `getClass()` - Compares the exact class of objects (strict)
   - `instanceof` - Allows comparison with subclasses (more flexible but can violate symmetry)

3. **Use Objects.equals() for null-safe comparisons**
   - Avoids potential NullPointerException when comparing fields

4. **Consider using Objects.hash() for implementing hashCode()**
   - Provides a convenient way to generate hash codes for multiple fields

### Common Mistakes
1. Using the wrong parameter type (should be Object)
2. Forgetting to override hashCode()
3. Not maintaining symmetry with subclasses
4. Not handling null properly
5. Comparing mutable fields that change over time (affects consistency)

### equals() vs ==
- `==` operator: Compares references (memory addresses) for objects
- `equals()` method: By default compares references, but can be overridden to compare contents

### Performance Considerations
- Start with the cheapest comparisons first (like primitive fields)
- Check for null before calling methods on potentially null objects
- For arrays, use `Arrays.equals()` or `Arrays.deepEquals()` as appropriate

### Example Implementation
```java
public class Person {
    private final String name;
    private final int age;
    private final String[] hobbies;
    
    // Constructor and other methods...
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Person person = (Person) o;
        
        if (age != person.age) return false;
        if (!Objects.equals(name, person.name)) return false;
        return Arrays.equals(hobbies, person.hobbies);
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + Arrays.hashCode(hobbies);
        return result;
    }
}
```

## Part 2: Java Interfaces

### Introduction to Interfaces
An interface in Java is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types. Interfaces cannot be instantiated—they can only be implemented by classes or extended by other interfaces.

### Key Characteristics of Interfaces
- Interfaces define a contract that implementing classes must follow
- Before Java 8, interfaces could only contain abstract methods and constants
- Since Java 8, interfaces can have default and static methods with implementations
- Since Java 9, they can also have private methods

### Declaring an Interface
```java
public interface Movable {
    // Constants (implicitly public, static, and final)
    int MAX_SPEED = 100;
    
    // Abstract methods (implicitly public and abstract)
    void move(int distance);
    void stop();
    
    // Default method (Java 8+)
    default void turnRight() {
        System.out.println("Turning right...");
    }
    
    // Static method (Java 8+)
    static boolean isMoving(Movable object) {
        // Implementation
        return true;
    }
    
    // Private method (Java 9+)
    private void helperMethod() {
        // Implementation
    }
}
```

### Implementing an Interface
```java
public class Car implements Movable {
    private int currentSpeed;
    
    @Override
    public void move(int distance) {
        System.out.println("Car is moving " + distance + " meters");
    }
    
    @Override
    public void stop() {
        currentSpeed = 0;
        System.out.println("Car has stopped");
    }
    
    // Can override default methods if needed
    @Override
    public void turnRight() {
        System.out.println("Car turning right");
    }
}
```

### Multiple Interface Implementation
- Unlike classes, a class can implement multiple interfaces
- This provides a form of multiple inheritance in Java

```java
public class Car implements Movable, Drawable, Serializable {
    // Must implement all methods from all interfaces
}
```

### Interface Inheritance
- Interfaces can extend one or more other interfaces
- This creates a hierarchy of interfaces

```java
public interface Vehicle extends Movable, Drawable {
    void startEngine();
}
```

### Default Methods
- Introduced in Java 8
- Allow adding methods to interfaces without breaking existing implementations
- Implementing classes can override default methods

```java
default void turnLeft() {
    System.out.println("Default implementation for turning left");
}
```

### Static Methods in Interfaces
- Also introduced in Java 8
- Associated with the interface rather than instances of implementing classes
- Cannot be overridden by implementing classes

```java
static double convertToMiles(double kilometers) {
    return kilometers * 0.621371;
}
```

### Functional Interfaces
- An interface with exactly one abstract method
- Can be implemented using lambda expressions
- Often annotated with `@FunctionalInterface`

```java
@FunctionalInterface
public interface Runnable {
    void run();
}

// Using lambda expression
Runnable r = () -> System.out.println("Running...");
```

### Common Built-in Interfaces
1. **Comparable**
   - Used for natural ordering of objects
   - Has a single method: `compareTo()`

2. **Comparator**
   - Used for custom comparison logic
   - Has a primary method: `compare()`

3. **Iterable**
   - Allows objects to be targets of the "for-each loop"
   - Has a method: `iterator()`

4. **Collection**
   - Base interface for collections framework
   - Extends Iterable

5. **Serializable**
   - Marker interface (no methods)
   - Marks classes whose objects can be converted to byte streams

### Best Practices for Interfaces
1. Use interfaces to define types that permit multiple implementations
2. Keep interfaces focused and cohesive (single responsibility)
3. Avoid interface pollution (too many methods)
4. Document interface methods thoroughly
5. Consider providing skeletal implementations (abstract classes) for complex interfaces
6. Use default methods sparingly and mainly for backward compatibility

### Interfaces vs. Abstract Classes
| Feature | Interface | Abstract Class |
|---------|-----------|----------------|
| Multiple inheritance | Supported | Not supported |
| State | No instance fields (except constants) | Can have instance fields |
| Constructor | Cannot have constructors | Can have constructors |
| Method implementation | Only default, static, and private methods | Any methods |
| Access modifiers | Methods implicitly public | Any access level |
| Purpose | Define a contract | Provide a base implementation |

### Summary
- Interfaces define contracts that classes must fulfill
- They enable multiple inheritance of behavior
- Java 8+ interfaces can provide default and static implementations
- Functional interfaces enable lambda expressions
- Well-designed interfaces create flexible, maintainable, and extensible code 

## Final Summary and Best Practices

### Key Takeaways
- **Object.equals()**: The foundation of object comparison in Java, requiring careful implementation to maintain the contract.
- **Interfaces**: The backbone of abstraction in Java, enabling polymorphism and providing flexible design structures.

### Best Practices for Java Development
1. **Follow the equals() and hashCode() contract rigorously**
   - Always override both methods together
   - Test your implementations thoroughly with different scenarios

2. **Design interfaces with care**
   - Keep them focused on a single responsibility
   - Use interface segregation principle: better to have many small, specific interfaces than one large interface

3. **Leverage Java 8+ features in interfaces**
   - Use default methods to add functionality without breaking backward compatibility
   - Utilize static methods for utility functions related to the interface

4. **Be mindful of inheritance hierarchies**
   - Consider the Liskov Substitution Principle when designing class hierarchies
   - Prefer composition over inheritance when appropriate

5. **Use built-in interfaces**
   - Leverage the rich ecosystem of Java interfaces like Comparable, Comparator, etc.
   - Implement standard interfaces to make your classes work seamlessly with Java collections and utilities

6. **Document your code**
   - Clearly document the behavior of equals() and hashCode()
   - Provide clear Javadoc for interface methods specifying their contract

### When to Use What
- **Interface**: When you want to define a contract that multiple classes will implement
- **Abstract Class**: When you want to share code among closely related classes
- **equals() override**: When objects need to be compared based on their state rather than identity
- **hashCode() override**: Whenever equals() is overridden, to maintain the contract for hash-based collections

### Common Pitfalls to Avoid
- Violating the equals() contract in subclasses
- Creating interfaces with too many methods
- Forgetting to override hashCode() when overriding equals()
- Using mutable fields in equals() and hashCode() implementations
- Creating implementation dependencies in interfaces

By mastering these core Java concepts, you'll be able to create more robust, maintainable, and flexible applications. 