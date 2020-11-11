# Java Core
### 1. What do you mean by Platform independence of java?
	We can write and compile program in one operation system and run another operation system.

### 2. What is difference between JVM, JRE and JDK ?
	JVM: Stands for Java Virtual Machine, it's virtual machine which is actually execute the byte code.
	JRE: Stands for Java RunTime Environment, It's include JVM, libraries such as rt.jar
	JDK: Stands for Java Development Kit, It' super set of JRE including imports libraries, compilation and debugging tools such as (javac, java)  

### 3. What are memory areas allocated in JVM?
	1. Heap area
	2. Method areas
	3. JVM language stacks
	4. Programm counter(PC) register
	5. Native method stacks

### 4. What are some core concepts of OOPS in Java ?
	1. Abstraction (abstraction is exposing necessary things hiding implementation details, abstraction can be achived by abstract class and interface. abstraction is design level concept.)
	2. Encapsulation (encapsulation is binding data and methods in a single unit(class). encalsulation can be achived by access modifier private, protected and public. encapsulation is implemetation of desire abstraction.)
	3. Inheritance (Inheritance in Java is a mechanism in which one object acquires all the properties(data/variable) and behaviors(method) of a parent object. The aim of inheritance is to provide the reusability of code)
	4. Polimorphism (Polymorphism means one name many forms. polymorphism can be achieved by method overloading and method overriding. There are two types of polymorphism in java ( Compile time polymorphism , Run time polymorphism)

### 5. What is constructor in java?
	Constructor is like others method. it used to initialize the objects. Constructor should same name as class. Constructor has no return types
	
### 6. Can we declare constructor as final?
	No, it will get compile time error.
	
### 7. What is immutable object in java?
	Immutable object is object whose state can not be changed once created. Example String , Integer are immutable once it creared. 

### 8 Why immutable objects are considered to be good keys for HashMap?
	Immutable object’s hashcode won’t change, so it makes key retrieval faster as we can cache different hashcode for different keys. 
	In case of mutable object, hashcode may be dependent on mutable fields, if any value for these field changes, it might change hashcode, so we might not able to find our key in HashMap as hashcode is different.

### 9 Can you give some good examples of immutable classes?
	String, Integer, Long, Double, Character, Boolean etc and much more. Date is not an immutable class.
	
### 10. Why String is declared final or immutable in java?
```java
	String str1="Hello";
	str1.concat("world");
	System.out.println(str1);
	  
	// Output will be 
	Hello
```
	* String pool
		If we simply assign a Value to String using double quotes, it is stored in area called string literal pool and one string can be referenced by many reference variables and if String Is mutable,  
		then it will affect all reference variables.
	* Thread Safe
		Immutable objects are by default thread safe, so we don’t need to put synchronisation for it and String instance can be safely shared among multiple threads.
	* Security
		If String is not immutable then it may cause multiple security issue. example, while connecting to database,  we provide username, password, Port and host name etc as String,  
		if String is mutable, any hacker can change the reference value and cause security threats to application.
	* Class Loading
		When we use String as key in HashMap or HashSet or any other collection, we can cache it’s hash value. As String is immutable in nature, we don’t need to calculate each time as it will be constant.
		It greatly improve performance for this hash based collections.
	* Cache hash value
		String is used as class loading mechanism. It is passed as a parameter. If String is mutable, it is a security threat as any hacker could have changed it.

### 11 What are access modifier available in java?
	Private : Accessible only to the class.
	Default : Accessible in the package.
	Protected : Accessible in the packages and its subclasses.
	Public : Accessible everywhere

### 12 What is difference between Abstract class and interface?

	Both are using for abstraction. abstract class is pertial abstraction but interface is fully abstraction. 
	If we have lot of methods and want default implementation for some of them, then go with abstract class. If we want to implement multiple inheritance then you have to use interface. As java does not support multiple inheritance
	If our base contract keeps on changing then we should use an abstract class. Because if our base contract keeps on changing and we still use an interface, we would have to change all the classes which implements that interface every time the contract changes.
	
### 13 Can one interface implement another interface in java?
	No, It can extend it using extends keyword.
	
### 14 What is marker interface?
	Marker interfaces  are interfaces which have no method but it is used to indicate JVM to behave specially when any class implement these interfaces.
	For example : If we implement cloneable interface and then call .clone method of object, it will clone your object. If you do not implement cloneable interface, it will throw cloneNotSupported exception.
		
### 15. What is method overloading and method overriding in java?
	Method overloading : Method overloading is concept that allows a class to have same method name but diferent method arguments. Method overloading is also known as compile time polymorphism.
	Method overriding : If child class contain same method as parent class with same method signature. This is called method overriding. Method overriding is also known as dynamic polymorphism.