# Java Core
### 1. What do we mean by Platform independence of java?
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

### 9. Can we give some good examples of immutable classes?
String, Integer, Long, Double, Character, Boolean etc and much more. Date is not an immutable class.
	
### 10. Why String is declared final or immutable in java?
```java
	String str1="Hello";
	str1.concat("world"); //String does not change because of immutable class, concat method return the concatation value ex. "Helloworld"
	System.out.println(str1);
	System.out.println(str1.concat("world"));
	  
	// Output will be 
	Hello
	Helloworld
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

### 11. What are access modifier available in java?
Private : Accessible only to the class.
Default : Accessible in the package.
Protected : Accessible in the packages and its subclasses.
Public : Accessible everywhere

### 12. What is difference between Abstract class and interface?

Both are using for abstraction. abstract class is pertial abstraction but interface is fully abstraction. 
If we have lot of methods and want default implementation for some of them, then go with abstract class. If we want to implement multiple inheritance then we have to use interface. As java does not support multiple inheritance
If our base contract keeps on changing then we should use an abstract class. Because if our base contract keeps on changing and we still use an interface, we would have to change all the classes which implements that interface every time the contract changes.
	
### 13. Can one interface implement another interface in java?
No, It can extend it using extends keyword.
	
### 14. What is marker interface?
Marker interfaces  are interfaces which have no method but it is used to indicate JVM to behave specially when any class implement these interfaces.
For example : If we implement cloneable interface and then call .clone method of object, it will clone wer object. If we do not implement cloneable interface, it will throw cloneNotSupported exception.
		
### 15. What is method overloading and method overriding in java?
Method overloading : Method overloading is concept that allows a class to have same method name but diferent method arguments. Method overloading is also known as compile time polymorphism.
Method overriding : If child class contain same method as parent class with same method signature. This is called method overriding. Method overriding is also known as dynamic polymorphism.

### 17. What is method hiding in Java and how to use it?
When super class and sub class contains same method including parameters and if they are static. The method in the super class will be hidden by the one that is in the sub class. This mechanism is known as method hiding.
```java
	public class Animal {
		public static void foo() {
			System.out.println("Animal");
		}
	}

	public class Cat extends Animal {
		public static void foo() {  // hides Animal.foo()
			System.out.println("Cat");
		}
	}
```
### 18. Can we override static methods in Java?
No, We can create same method in child class but it won’t be dynamic polymorphism. It will be method hiding. Static methods belong at class level not at object level hence we can not override static method.
	
### 19. Can we override private methods in Java?
No, Private methods are not visible to subclass.
	
### 20. Difference between path and classpath in java?
Parameter | Path | classpath
--------- | ---- | ---------
Locate | It allows operating system to locate executable such as javac, java | It allows classloader to locate all .class file used by program
Overriding | we can not override path variable with java setting | we can override classpath by using -cp with java,javac or class-path in manifest file.
Inclusion | we need to include bin folder of jdk (For example jdk1.7.1/bin) | we need to include all the classes which is required by program
Used by | Operating system | java classloaders

### 21. What is difference between StringBuffer and StringBuilder in java?
Both are mutable.

Parameter | StringBuffer | StringBuilder
--------  | -----------  | -------------
Thread-safe | StringBuffer is thread safe synchronized . Two threads can call methods of StringBuffer simultaneously. | StringBuilder is not thread safe, so two threads can not call methods of StringBuilder simultaneously.
Performance | It is less performance efficient as it is thread-safe	| It is more performance efficient as it is not thread-safe.

### 22. What are methods we should override when we put an object as key in HashMap?
Need to implement hashcode() and equals() method if we put key as object in HashMap.

### 23. Can we explain internal working of HashMap in java?
There is an Entry[]  array called table which has size 16.
This table stores Entry class’s object. HashMap class has a inner class called Entry.This Entry have key value as instance variable.
```java
	static class Entry implements Map.Entry
	{
			final K key;
			V value;
			Entry next;
			final int hash;
			...//More code goes here
	}
```

### 24. Why java uses another hash function internally to calculate hash value apart from hashcode method which we have implemented?
Avoid large number of collisions due to bad hashcode method written by developers.

### 25. What if we don’t override hashcode method while putting custom objects as key in HashMap?
If did not implement hashcode method, each object will have different hashcode(memory address) by default, so even if we have implemented equals method correctly, it won’t work as expected.

### 26. Can we explain internal working of HashSet in java?
HashSet internally uses HashMap to store elements in HashSet. It uses PRESENT as dummy object as value in that HashMap. HashSet uses HashMap to check duplicates in the HashSet.

### 27. What are differences between HashMap and HashSet in java?
Parameter | HashMap | HashSet
--------- | ------- | -------
Interface | This is core difference among them.HashMap implements Map interface | HashSet implement Set interface
Method for storing data | It stores data in a form of key->value pair.So it uses put(key,value) method for storing data | It uses add(value) method for storing data
Duplicates | HashMap allows duplicate value but not duplicate keys | HashSet does not allow duplicate values.
Performance | It is faster than hashset as values are stored with unique keys | It is slower than HashMap
HashCode Calculation | In hash map hashcode value is calculated using key object | In this,hashcode is calculated on the basis of value object. Hashcode can be same for two value object so we have to implement equals() method.If equals() method return false then two objects are different.

### 28. Can we explain internal working of ConcurrentHashMap in java?
ConcurrentHashMap uses concept of Segments to store elements. Each Segment logically contains a HashMap. ConcurrentHashMap does not lock whole object , it just lock part of it i.e. Segment.

### 29. Do we have lock while getting value from ConcurrentHashMap?
There is no lock while getting values from ConcurrentHashMap.Segments are only for write operation.In case of read operation, it allows full concurrency and provides most recently updated value using volatile variables.

### volatile variables
Volatile variables have the visibility features of synchronized but not the atomicity features. The values of volatile variable will never be cached and all writes and reads will be done to and from the main memory.

Volatile keyword is used to modify the value of a variable by different threads. It is also used to make classes thread safe. It means that multiple threads can use a method and instance of the classes at the same time without any problem. The volatile keyword can be used either with primitive type or objects.

The volatile keyword does not cache the value of the variable and always read the variable from the main memory. The volatile keyword cannot be used with classes or methods. However, it is used with variables. It also guarantees visibility and ordering. It prevents the compiler from the reordering of code.

The contents of the particular device register could change at any time, so you need the volatile keyword to ensure that such accesses are not optimized away by the compiler.

```java
	class Test  
	{  
	static int var=5;  
	}  
```
In the above example, assume that two threads are working on the same class. Both threads run on different processors where each thread has its local copy of var. If any thread modifies its value, the change will not reflect in the original one in the main memory. It leads to data inconsistency because the other thread is not aware of the modified value.

```java
	class Test  
	{  
	static volatile int var =5;  
	}  
```
In the above example, static variables are class members that are shared among all objects. There is only one copy in the main memory. The value of a volatile variable will never be stored in the cache. All read and write will be done from and to the main memory.

Volatile Keyword | Synchronization Keyword
---------------- | ---------------------
Volatile keyword is a field modifier. | Synchronized keyword modifies code blocks and methods.
The thread cannot be blocked for waiting in case of volatile. |	 Threads can be blocked for waiting in case of synchronized.
It improves thread performance. | Synchronized methods degrade the thread performance.
It synchronizes the value of one variable at a time between thread memory and main memory. | It synchronizes the value of all variables between thread memory and main memory.
Volatile fields are not subject to compiler optimization. | Synchronize is subject to compiler optimization.

### 30. How do we sort Collection of custom objects in java?
Implement the comparable interface to custom object class(Let’s say Country) and then implement compareTo(Object o) method which will be used for sorting. It will provides default way of sorting custom objects.
If we want to sort custom object (Lets say country) on different attributes such as name, population etc. We can implement Comparator interface and can be used for sorting.

###  31. What are differences between ArrayList and LinkedList in java?
Parameter | ArrayList | LinkedList
--------- | --------- | ----------
Internal data structure | It uses dynamic array to store elements internally | It uses doubly Linked List to store elements internally
Manipulation | If  We need to insert or delete element in ArrayList, it may take O(n) | If  We need to insert or delete element in LinkedList, it will take O(1), as it internally uses doubly LinkedList
Search | Search is faster in ArrayList as uses array internally which is index based. So here time complexity is O(1) | Search is slower in LinkedList as uses doubly Linked List internally So here time complexity is O(n)
Interfaces | ArrayList implements List interface only, So it can be used as List only | LinkedList implements List,Deque interfaces, so it can be used as List,Stack or Queue

### 32. What is Enum in java?
Java Enum is special data type which represents list of constants values. It is a special type of java class. It can contain constant, methods and constructors etc.

### 33. How do we create custom exception in java?
Need to extend Exception class to create custom exception. If we want to create Unchecked exception, then we need extend Runtime Exception.

### 34.What is difference between Checked Exception and Unchecked Exception?
Checked Exception: Checked exceptions are those exceptions which are checked at compile. If we do not handle them , we will get compilation error.
For example: IOException

Unchecked Exception : Unchecked exceptions are those exceptions which are not checked at compile time check at runtime. Java won’t complain if we do not handle the exception.
For example: NullPointerException, ArrayIndexOutOfBoundsException
Any type Error also known as Unchecked/runtime exception.

### 35. Can we have try without catch block in java ?
Yes, we can have try without catch block by using finally block. We can use try with finally. As we know finally block always executes even if we have exception or return statement in try block except in case of System.exit(). 

### 36. What are ways to create a thread in java ?
There are two ways to create a thread in java
	* By extending thread class
	* By implementing the Runnable interface.
	
### 37. What are differences between Sleep and wait in java?
Parameter | wait | sleep
--------- | ---- | -----
Synchonized | wait should be called from synchronized context i.e. from block or method, If we do not call it using synchronized context, it will throw IllegalMonitorStateException | It need not be called from synchronized block or methods
Calls on | wait method operates on Object and defined in Object class | Sleep method operates on current thread and is in java.lang.Thread
Release of lock | wait release lock of object on which it is called and also other locks if it holds any | Sleep method does not release lock at all
Wake up condition | until call notify() or notifyAll() from Object class | Until time expires or calls interrupt()
static | wait is non static method | sleep is static method

### 38. Define states of thread in java?
There are 5 states of thread in java
- New : When we create a thread object and it is not alive yet.
- Runnable: When we call start method of thread, it goes into Runnable state. Whether it will execute immediately or execute after some times , depends on thread scheduler.
- Running : When thread is being executed, it goes to running state.
- Blocked : When thread waits for some resources or some other thread to complete (due to thread’s join), it goes to blocked state.
- Dead: When thread’s run method returns, thread goes to dead state.

### 39. Can we call run method directly to start a thread?
No.

### 40. Can we start a thread twice in java?
No, Once we have started a thread, it can not be started again. If we try to start thread again , it will throw IllegalThreadStateException.

### 41. What is CountDownLatch in java?
CountDownLatch is synchronisation aid that allow one or more threads to wait until set of operations being performed in other threads completes. CountDownLatch waits for other threads to complete set of operations.
CountDownLatch is initialized with count. Any thread generally main threads calls latch.awaits() method, so it will wait for either count becomes zero or it’s interrupted by another thread and all other thread need to call latch.countDown() once they complete some operation.
So count is reduced by 1 whenever latch.countDown() method get called.

### 42. What is difference between CountDownLatch and CyclicBarrier?
Parameter | CountDownLatch | CyclicBarrier
--------- | -------------- | -------------
Reuse | It can not be reused once count reaches 0 | It can be reinitialized once parties reaches to 0, so it can reused
Method | It calls countDown() method to reduce the counter | It calls await() method to reduce the counter.
Common Event | It can not trigger common event when count reaches 0 | It can trigger common event (Runnable) once reaches to a barrier point. Constructor :CyclicBarrier(int parties, Runnable barrierAction)
Constructor | CountDownLatch(int count)	| CyclicBarrier(int parties)

### 43. Why wait, notify and nofiyAll method belong to object class ?
We put locks on shared objects not on thread, every object has mutex(lock), it make sense to put wait, notify and notifyAll methods in object class.

### 44. Can you call wait, notify and notifyAll from non synchronized context?
No

### 45. What is the difference between creating String as new() and literal?
If we create a String using new operator, it is not interned. It will create new object in heap memory even if String object already exists with same content.
```java
    String str1=new String("hello");
    String str2=new String("hello");
    System.out.println(str1==str2);
	
	It will return false as str1 and str2 will point to different object
```
If we create a String using assignment operator, it goes to the String constant pool and it is interned. If we create another String with same content, both will reference to same object in String constant pool.
```java
	String str1="helloworld";
	String str2="helloworld";
	System.out.println(str1==str2);
	
	It will return true as str1 and str2 will point to the same object in String constant pool.
``` 

### 46. What is Covariant return type in java?
Covariant return type means if subclass overrides any method, return type of this overriding method can be subclass of return type of base class method.
```java
	public class BaseClass {

		public A m1() {
			System.out.println("In BaseClass method");
			return new A();		}
		public static void main(String args[]) {
			BaseClass b = new SubClass();
			b.m1();
		}
	}

	class SubClass extends BaseClass {
		public B m1() {
			System.out.println("In SubClass method");
			return new B();
		}
	}

	class A {	
	}

	class B extends A {
	}
```

### 47. What is garbage Collection?
Garbage Collection is a process of looking at heap memory and deleting unused object present in heap memory. Garbage Collection is done by JVM.

### 48. What is System.gc()?
This method is used to invoke garbage collection for clean up unreachable object but it is not guaranteed that when you invoke System.gc() , garbage collection will definitely trigger.

### 49. What is use of finalize() method in object class?
Finalize method get called when object is being collected by Garbage Collector. This method can be used to write clean code before object is collected by Garbage Collector

### 50.What is difference between final, finally and finalize in Java?
final : Final is a keyword which is used with class to avoid being extended, with instance variable so they can not reassigned, with methods so that they can not be overridden.
finally : Finally is a keyword used with try, catch and finally blocks. Finally block executes even if there is an exception. It is generally used to do some clean up work.
finalize : Finalize is a method is used to invoke garbage collection for clean up unreachable object but it is not guaranteed that when you invoke System.gc(), garbage collection will definitely trigger.

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

