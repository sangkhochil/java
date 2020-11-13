# OOP Concept
### 1. What are some core concepts of OOPS in java?
Core concepts of OOPs are :
- Polymorphism
- Abstraction
- Encapsulation
- Inheritance

### 2. What is Abstraction?
Abstraction is a concept of showing only important information and hiding its implementation details.
For example:
When we see a car, we know it is running but how it running internally, we we not aware of it.
This is Abstraction. We just expose required details.

### 3. What is encapsulation?
Encapsulation is process of wrapping data and function into single unit. We can use access modifier for variables, so other classes may not access it directly but it can be accessed only through public methods of the class.
We can create class fully encapsulated using private variables.

### 4. What is difference between Abstraction and Encapsulation?
Abstraction is a concept of showing only important information and hiding its implementation where as Encapsulation provides a barrier to access of data and methods.
Abstraction is more about design concept and Encapsulation is about implementation.

### 5. What is Polymorphism in java?
Polymorphism means single name many forms. By which we can perform same action in different ways.

### 6. What are types of Polymorphism in java?
There are two type of polymorphism in java.
- Compile time polymorphism
- Run time polymorphism

### 7. What are ways by which we can implement polymorphism in java?
We can implement polymorphism using
- Method overloading
- Method overriding

### 8. What is inheritance in java?
Inheritance allows use of properties and methods of another class (Parent class), so we can reuse all methods and properties.

### 9.What is multiple inheritance?
When child class can inherit from multiple parent classes. This mechanism is known as multiple inheritance.

### 10. What is diamond problem in case of multiple inheritance?
Class A has two child classes B and C.
Class D has two parent classes B and C.
methodCommon() of A is overriden by classes B and C.
When we call methodCommon() on instance of D, which method should get called(From class B or C)

### 11. Why java does not support multiple inheritance?
Java avoided multiple inheritance due to diamond problem and to make it less complex.

### 12. What is constructor in java?
A constructor is block of code which allows we to create instance of the object. It does not have return type.
It has two main points
- Constructor name should be same as class
- Constructor should not have any return type else it will be same as method.

### 13. Can we declare constructor as final?
No

### 14.What is Static Binding and Dynamic Binding?
Static binding is resolved at compile time. Method overloading is perfect example of static binding.
Dynamic binding is resolved at run time. Method overridng is perfect exmple of dynamic binding.

### 15. What is association?
Association is relationship between two objects. It defines multiplicities between two objects such as one to one, one to many, many to many.
For example: 
Student and Professor

### 16. What is aggregation?
Aggregation is the special form of association. It is also called as “has-a” relationship. If One object contains another object, it is considered as aggregation.
For example:
Car has a wheel.

### 17. What is composition?
Composition is special type of aggregation.We may consider it as “restricted aggregation” If object contains another object and contained object can not exist without container object then this relationship is known as composition.
Car has a engine. Engine can not exist without a car.


#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

