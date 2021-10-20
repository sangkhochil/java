# Common

### HashCode
The hashcode of a Java Object is simply a number, it is 32-bit signed int, that allows an object to be managed by a hash-based data structure.
We know that hash code is an unique id number allocated to an object by JVM. ...
If two objects are equals then these two objects should return same hash code.

### Imutable class
Immutable class is class whose state can not be changed once created.
String is best example for immutable class. Once you create a String, you can not change it.
Immutable class is very simple to understand, it has only one state. Immutable class is carefully instantiated by the constructor. 
Immutable classes are thread safe. This is biggest advantage of immutable class, you don’t need to apply synchronization for immutable objects.

#### Steps for creating a immutable class
* Make your class final
* Declare all instance variable with private and final
* Say no to setter methods 
* Initialize all variables in constructor
* Perform cloning of mutable objects while returning from getter method

# Control Statements

## switch Vs else-if
switch more faster than else-if. In switch every condition/case is same type but for else-if there are multiple type's. if condition more than five, switch statement is always better than else-if.
switch statement create a “jump table” that it will use for selecting the path of execution depending on the value of the expression.
If a switch contains more than five items, it’s implemented using a lookup table or a hash list.

# Object Oriented

## Why main method declear as public static?
Java main() method is always static, so that compiler can call it without the creation of an object or before the creation of an object of the class.

* In any Java program, the main() method is the starting point from where compiler starts program execution. So, the compiler needs to call the main() method.
* If the main() is allowed to be non-static, then while calling the main() method JVM has to instantiate its class.
* While instantiating it has to call the constructor of that class, There will be ambiguity if the constructor of that class takes an argument.
* Static method of a class can be called by using the class name only without creating an object of a class.
* The main() method in Java must be declared public, static and void. If any of these are missing, the Java program will compile but a runtime error will be thrown.
## Abstraction 
Abstraction is a concept of exposing only essential details and hiding implementation details. 
It is one of the essential OOPs concept apart from encapsulation, inheritance and polymorphism. Abstraction retains only information which is most relevant for the specific purpose.

* For example:
ArrayList stores objects in sequential manner as list and you can use add() method to add elements to ArrayList, remove() method to remove elements from it, and get() method to retrieve element from the ArrayList.
That’s all you need to know to use ArrayList. That’s abstraction in java.

If you want to use ArrayList, you don’t need to understand how ArrayList works internally.
ArrayList uses abstraction by implementing List interface and List interface provides all necessary methods to use ArrayList.

Another real life example.
When you search for any text on google, you just type text in text area and click on search button. What happens behind the scenes, how google search algorithm works, you might not be aware of that.

* Ways to achieve abstraction
We can achieve abstraction using two ways in java.

1. Abstract class(0 to 100% abstraction)
2. Interface (100% abstraction)

### Abstraction vs Encapsulation
Encapsulation is process of binding related data(variables and methods) into a class.We can achieve encapsulation using access modifers such as public, private, protected.

Encapsulation is implementation of desired abstraction.
Abstraction is more of design level concept and helps you to provide only essential details and hiding implementation details. We can achieve abstraction by abstract class and interface.

## Interface 
Abstract class in java which provides partial abstraction. Interface is one of the core part of java and is used to achieve full abstraction.

Interface is generally used to provide contract for class to implement. Interface do not have implementation of any method.A class implements an interface, thereby inheriting the abstract methods of the interface. 
So it is kind of signing a contract, you agree that if you implement this interface, then you have to use its methods.It is just a pattern, it can not do anything itself.

All the methods in the interface are by default public and abstract and all variables are public static final.

## Abstract class
An abstract class is the class which is declared abstract and can have abstract or non abstract methods. 
An abstract class can not be instantiated. It can be extended by subclass to implement abstract methods and either use or override concrete methods.

* When do you need abstract class in java?
Let’s understand it with the help of the example. we have Shape class and it has some methods such as draw(), calcualteArea() etc. Drawing a shape is common for all the shapes but calculateArea() is different for each shape.

## Difference between Abstract Class and Interface
Parameter | Abstract class | Interface
--------- | -------------- | ---------
Default method Implementation | It can have default method implementation | Interfaces are pure abstraction.It can not have implementation at all but in java 8, you can have default methods in interface.
Implementation | Subclasses use extends keyword to extend an abstract class | subclasses use implements keyword to implement interfaces
Constructor | Abstract class can have constructor | Interface  can not have constructor
Different from normal java class | Abstract classes are almost same as java classes except you can not instantiate it. | Interfaces are altogether different type
Access Modifier | Abstract class methods can have public ,protected,private and default modifier | Interface methods are by default public. you can not use any other access modifier with it
Main() method | Abstract classes can have main method so we can run it | Interface do not have main method so we can not run it.
Multiple inheritance | Abstract class can extends one other class and can implement one or more interface. | Interface can extends to one or more interfaces only
Speed | It is faster than interface | Interface is somewhat slower as it takes some time to find implemented method in class
Adding new method | If you add new method to abstract class, you can provide default implementation of it. So you don’t need to change your current code | If you add new method to interface, you have to change the classes which are implementing that interface

### When to use Abstract class and interface
* If we have lot of methods and want default implementation for some of them, then go with abstract class
* If we want to implement multiple inheritance then we have to use interface. As java does not support multiple inheritance, subclass can not extend more than one class but we can implement multiple interface so we can use interface for that.
* If our base contract keeps on changing then we should use an abstract class. Because if our base contract keeps on changing and we still use an interface, we would have to change all the classes which implements that interface every time the contract changes.

## Polymorphism 
Polymorphism in java is one of core Object oriented programming concepts with Abstraction, encapsulation, and inheritance.
Polymorphism means one name many forms. In Java, polymorphism can be achieved by method overloading and method overriding.

Polymorphism in java with example
* Compile time polymorphism.
* Run time polymorphism.

### Compile time Polymorphism
Compile time Polymorphism is nothing but method overloading in java

### Runtime Polymorphism
Runtime Polymorphism is nothing but method overriding in java
If subclass is having same method as base class then it is known as method overriding Or in another word, 
If subclass provides specific implementation to any method which is present in its one of parents classes then it is known as method overriding

## Encapsulation
Encapsulation in java is the process of binding related data(variables) and functionality(methods) into a single unit called class. 
Encapsulation can be achieved by using access modifier such as public, private, protected or default, so our class will be safe from unauthorized access by others and will be simple to maintain.

* We can create fully encapsulated class by
Making variables private
Providing getters and setters methods for the accessing the variables.

* Encapsulation is also termed as data hiding because you are making variables private and variables can be only excessed through public getters and setters.

### Advantages of Encapsulation in java:
* It provides control over data. For example: If we want to check if age of employee is greater than 18 in setter method(setAge(int age)). we can easily do it in setter method without breaking any code. 
* Increase reusability.
* Makes class easy to use for other clients.
* It helps the developer to write code more flexible and maintainable by binding them into a single unit and use appropriate access modifier to access the code as per need.

### Difference between abstraction and encapsulation
* Encapsulation means data hiding using getter and setters. Abstraction means hiding implementation details using abstract class and interface.
* Abstraction is more of design level concept and Encapsulation is more of implementation level concept.

# Java Collections

## Default java collections capacity
* ArrayList-10
* Vector-10
* HashSet-16
* HashMap-16
* HashTable-11

## HashMap
* HashMap implements Map an interface that maps a key to value.
* It is not synchronized and is not thread-safe.
* Duplicate keys are not allowed
* One null key and multiple null values are allowed
* t is the unordered collection and does not give a guarantee for any specific order of elements.

## LinkedHashMap
* LinkedHashMap implements Map interface and extends HashMap class.
* LinkedHashMap maintains insertion order, so when you will be able to access elements in the order they were inserted like ArrayList.
* LinkedHashMap maintains doubly Linked list to maintain insertion order.
* It is not synchronized and is not thread-safe.
* Duplicate keys are not allowed
* One null key and multiple null values are allowed

## HashMap Vs LinkedHashMap
  LinkedHashMap ordered list and maintains doubly Linked list to maintain insertion order
  
## TreeMap
* TreeMap implements Map interface and extends HashMap class.
* TreeMap is implemented using Red black tree based NavigableMap.
* TreeMap is ordered collection and store its elements in natural ordering of keys.
* Key which you would like to put in TreeMap must implement Comaparable interface or you can use Comparator for custom sorting

## HashSet
* It can contain only unique element.
* It is not synchronized and is not thread-safe.
* Not allowed dublicate entity, Definition of duplicate can be quite tricky (custom defined objects)

## TreeSet
* It can contain only unique element.
* It stores objects in ascending order by default,
* It implements NavigableSet interface which extends SortedSet.
* When you put objects in TreeSet, it must implement Comparable interface.

## LinkedHashSet
* LinkedHashSet implements Set interface and extends HashSet class.
* LinkedHashSet maintains insertion order, so when you will be able to access elements in the order they were inserted like ArrayList.

## ArrayList

### Why to choose ArrayList vs Array:
* Array is fixed length data structure If array is full , you can not add element to it, where as ArrayList in java can dynamically grow and shrink as per our need.
* we can use generics with ArrayList but not with Array
* ArrayList have predefined methods which can be used to perform operations.

### Some important points about ArrayList in java are:
* ArrayList is implementation of list interface.
* ArrayList is not synchonized(so not thread safe)
* ArrayList is implemented using array as internal data structure.It can be dynamically resized .
* ArrayList increases half of its size when its size is increased.

***ArrayList default size.

When you create an object of ArrayList in Java without specifying a capacity, it is created with a default capacity which is 10. 
Since ArrayList is a growable array, it automatically resizes when the size (number of elements in array list) grows beyond a threshold.

Technically, it's 10, not zero, if you admit for a lazy initialisation of the backing array. See:

```java
public boolean add(E e) {
    ensureCapacityInternal(size + 1);
    elementData[size++] = e;
    return true;
}
```

```java
private void ensureCapacityInternal(int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    ensureExplicitCapacity(minCapacity);
}
```

## Hashtable Vs HashMap

Parameter | Hashtable | HashMap
--------- | --------- | --------
ThreadSafe | Yes | No
Synchronized | Yes | No
Performance | Due to theadSafe and Synchronized,it is often slower than HashMap | In single threaded environment, it is much faster than Hashtable.So if you do not work in multi thread environment ,then hashMap is recommended
Null key | Do not allow | Allows null key as well as values
Fail fast | enumeration in hashtable is not fail fast | Iterator in hashMap is fail fast
Extends | It extends Dictionary class which is quite old | It extends AbstractMap class
Alternative | No alternative | we can use ConcurrentHashMap for multi thread environment

### Some important points need to be discussed.

- Synchronized means only one thread can modify one table at one point of time. When any thread performs update operation on hashtable then it acquires lock on it and other threads have to wait for lock to be released.
- Fail-fast iterator means if one thread is iterating over hashmap and other thread trying to modify hashmap structurally it will throw ConcurrentModification Exception and fail immediately. Structurally modification means inserting or deleting elements that can change the structure of map.

### Can we synchronize HashMap?
Yes, We can synchronized a HashMap also with the help of Collections.synchonizedMap(hashmap) so HashMap can be synchronized by
```java
 Map map=Collections.synchonizedMap(hashmap)
```

## HashMap vs HashSet
One main thing about HashSet is objects which we are going to add in HashSet must implement Hashcode() and equals() method so that we can check for duplicate values.
If we are adding custom objects to HashSet then we must override() Hashcode() and equals() method according to our need.
If we do not override then object will take default implementation which may not desirable.

Parameter | HashMap | HashSet
--------- | ------- | -------
Interface | This is core difference among them.HashMap implements Map interface | HashSet implement Set interface
Method for storing data | It stores data in a form of (key value) pair.So it uses put(key,value) method for storing data | It uses add(value) method for storing data
Duplicates | HashMap allows duplicate value but not duplicate keys | HashSet does not allow duplicate values.
Performance | It is faster than hashset as values are stored with unique keys | It is slower than HashMap
HashCode Calculation | In hash map hashcode value is calculated using key object | In this,hashcode is calculated on the basis of value object.Hashcode can be same for two value object so we have to implement equals() method.If equals() method return false then two objects are different.

## Arrays.sort() Vs Collections.sort()

Collections.sort() Operates on List Whereas Arrays.sort() Operates on an Array.

Arrays.sort() uses Dual-Pivot Quicksort for Primitive Arrays and MergeSort for sorting array of Objects.

## Comparable interface:
Class whose objects to be sorted must implement this interface.In this,we have to implement compareTo(Object) method.
For example:
```java
	public class Country implements Comparable{
		   @Override
		public int compareTo(Country country) {
			return (this.countryId < country.countryId ) ? -1: (this.countryId > country.countryId ) ? 1:0 ;
	}}
```

* If any class implements comparable inteface then collection of that object can be sorted automatically using Collection.sort() or Arrays.sort().Object will be sort on the basis of compareTo method in that class.

## Comparator:
When you want to sort the list of objects of a class,you can use Comparator interface. we don’t need to implement Comparator on the class whose objects need to be sorted. we can create a separate class and implement a Comparator interface as below.
```java
	import java.util.Comparator;
	 
	public class EmployeeSortByIdComparator implements Comparator{
	 
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getEmpId()-e2.getEmpId();
		}
	}
```
### Anonymous Comparator:
One of advantage of Comparator over comparable is you can create anonymous comparator i.e you don’t need to implement Comparable interface to class whose objects need to be sorted.
```java
	Collections.sort(listofEmployees,new Comparator<Employee>() {	 
		@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getName().compareTo(o2.getName());
		}
	});
```

## Comparator vs Comparable
Main difference is sorting algorithm implement in same class for comparable but comparator implement in different class or anonymously, Sorting will be diffirent if anyone want.

# Multithreading

## Thread
Thread can be called as light weight process. Java supports multithreading , so it allows your application to perform two or more task concurrently. 
Multithreading can be of advantage specially when now a days, machine has multiple CPUs, so multiple tasks can be executed concurrently.

#### Thread can be created in two ways.
1 By extending Thread class
2 By implementing Runnable interface

```java
	public class FirstThread extends Thread {	 
	 public void run(){
		System.out.println("Thread is running");
	 }	 
	}
```
```java
	public class FirstThread implements Runnable {	 
	 public void run() {
		System.out.println("Thread is running");
	 } 
	}	 
```

### Thread vs Runnable which is better?
* Implementing Runnable interface is considered to be better approach than Extending Thread due to following reasons.
* Java does not support multiple inheritance so if you extend Thread class and you can not extend any other class which is needed in most of the cases.
* Runnable interface represents a task and this can be executed with help of Thread class or Executors.
* When you use inheritance, it is because you want to extend some properties of parent, modify or improve class behavior. But if you are extending thread class just to create thread, so it may not be recommended behavior for Object Oriented Programming.

### Process vs Thread:
1. The process can be referred as program in execution whereas thread is part of process.
2. Process has its own address space whereas multiple threads share same address space of process. Each thread has its own stack.
3. Process can have multiple threads but thread is the smallest unit which can execute concurrently with other threads.
4. Process are quite heavyweight and have more overhead whereas thread is light weight and have less overhead.
5. Process do not depend on each other whereas threads are not independent as they share address space.
6. we do not require synchronization in case of process. Threads require synchronization to avoid unexpected scenarios.
7. Processes can communicate to each other using inter-process communication only where as thread can communicate directly as thread share same address space.
8. we can easily create new threads by calling thread’s start method but you need to copy resources of parent process to create a new child process.

### Priority of a Thread

Each thread have a priority. Priorities are represented by a number between 1 and 10. In most cases, thread schedular schedules the threads according to their priority (known as preemptive scheduling).
But it is not guaranteed because it depends on JVM specification that which scheduling it chooses.
```java
	public static int MIN_PRIORITY
	public static int NORM_PRIORITY
	public static int MAX_PRIORITY
```
* Default priority of a thread is 5 (NORM_PRIORITY). The value of MIN_PRIORITY is 1 and the value of MAX_PRIORITY is 10.

### Join
```java
join() // main thread wait until clild thread back
join(milisecond) // main thread wait until milisecond clild thread back
join(milisecond, nanosecond) // main thread wait until milisecond plus nanosecond clild thread back
```
### Daemon thread
* Daemon threads are low priority background threads which provide services to user threads and It’s life depends on user threads.
* If no user thread is running then JVM can exit even if daemon threads are running, JVM do not wait for daemon threads to finish.
* Daemon threads perform background tasks such as garbage collection, finalizer  etc.
* The only purpose of daemon thread is to serve user thread.

```java
	Public void setDaemon(boolean status) //set true it's daemon thread
	Public boolean isDaemon() // This method can be used to check if thread is daemon or not.
```
can not convert user thread to daemon thread once it is started otherwise it will throw IllegalThreadStateException. 
Once started a thread, it can not be started again. If try to start thread again , it will throw IllegalThreadStateException.
inter thread communication by wait, notify and notifyAll

### wait(), notify(), and notifyAll()
Java provide benefits of avoiding thread pooling using inter-thread communication. The wait(), notify(), and notifyAll() methods of Object class are used for this purpose.
These method are implemented as final methods in Object, so that all classes have them. All the three method can be called only from within a synchronized context

* wait() Causes the current thread to wait until another thread invokes the notify()
* notify() Wakes up a single thread that is waiting on same object's monitor.
* notifyAll() Wakes up all the threads that called wait( ) on the same object.

wait() | sleep()
------ | -------
called from synchronised block | no such requirement
monitor is released |monitor is not released
gets awake when notify() or notifyAll() method is called | does not get awake when notify() or notifyAll() method is called
not a static method | static method
wait() is generaly used on condition | sleep() method is simply used to put your thread on sleep.

Callable | Runnable
-------- | --------
It is mandatory to define call() method if we are dealing with the Callable interface. | It is mandatory to define the run() method if we are dealing with the Runnable interface.
The return type of the call() method of the interface is an Object. Hence, the call() method returns an Object. | The return type of the run() method of the interface is void. Hence, the run() method returns void.
The call() method can throw an exception. | The run() method cannot throw an exception.
A thread cannot be created using the Callable interface. | A thread can be created using the Runnable interface.

## Executor Framework
Java 5 has introduced new concurrent API called Executor frameworks, design and development of multi-thread applications. 
It consists of mainly Executor, ExecutorService interface and ThreadPoolExecutor class which implements both interfaces i.e. Executor and ExecutorService. 
ThreadPoolExecutor class provide the implementation of thread pool.
When we create a simple multithreading application, we create Runnable objects and construct Thread object using Runnable, We need to create, execute and manage thread.
It may be difficult for us to do that. Executor Framework does it for us. It is responsible for creating, executing and managing the thread and not only this, it improves the performance of the application too.

```java
	public interface Executor {
	 void execute(Runnable command);
	}
```

There is another interface called ExecutorService which extends Executor interface. It can be termed as Executor that provides methods that can control termination and methods that can produce a 
Future for tracking the progress of one or more asynchronous tasks. It has method such as submit, shutdown, shutdownNow etc.

ThreadPoolExecutor is actual implementation of ThreadPool. It extends AbstractThreadPoolExecutor which implements ExecutorService interface.
we can create ThreadPoolExecutor from factory methods of Executor class. It is recommended a way to get an instance of ThreadPoolExecutor.
There are 4 factory methods in Executors class which can be used to get an instance of ThreadPoolExecutor.

* Here are four factory method present in Executors class.
newFixedThreadPool: This method returns thread pool executor whose maximum size(let’s say n threads) is fixed.If all n threads are busy performing the task and additional tasks are submitted, then they will have to be in the queue until thread is available.
newCachedThreadPool: this method returns an unbounded thread pool. It doesn’t have maximum size but if it has less number of tasks, then it will tear down unused thread. If thread has been unused for 1 mins(keepAliveTime), then it will tear it down.
newSingleThreadedExecutor: this method returns an executor which is guaranteed to use the single thread. 
newScheduledThreadPool: this method returns a fixed size thread pool that can schedule commands to run after a given delay, or to execute periodically.

We should not hardcode size of thread pool. It should be provided by configuration or calculated from Runtime.availableProcessors()

* Executor’s newCachedThreadPool  factory method :
This method returns an unbounded thread pool. It sets maximum pool size to Integer.Max and it will create new threads depending on demand. 
If demand decreases, it will tear down threads if threads are idle for more than 1 min.

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/executor-framework-java.png?raw=true)

1) SingleThreadExecutor
The SingleThreadExecutor is a special type of executor that has only a single thread. It is used when we need to execute tasks in sequential order. In case when a thread dies due to some error or exception at the time of executing a task, a new thread is created, and all the subsequent tasks execute in that new one.

```java
	ExecutorService executor = Executors.newSingleThreadExecutor() 
```

2) FixedThreadPool(n)
As the name indicates, it is a thread pool of a fixed number of threads. The tasks submitted to the executor are executed by the n threads and if there is more task they are stored on a LinkedBlockingQueue. It uses Blocking Queue.

```java
	ExecutorService executor = Executors.newFixedThreadPool(4); 
```

3) CachedThreadPool
Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. Calls to execute will reuse previously constructed threads if available. If no existing thread is available, a new thread will be created and added to the pool. It uses a SynchronousQueue queue.

```java
ExecutorService executor = Executors.newCachedThreadPool();  
```

4) ScheduledExecutor
The ScheduledExecutor is another special type of executor which we use to run a certain task at regular intervals. It is also used when we need to delay a certain task.

```java
	ScheduledExecutorService scheduledExecService = Executors.newScheduledThreadPool(1);  
```

The scheduleAtFixedRate and scheduleWithFixedDelay are the two methods that are used to schedule the task in ScheduledExecutor.

## FutureTask

FutureTask class has been introduced in JDK 5 with Executor Framework. FutureTask class is the concrete implementation of the Future object and provides methods for start and cancel the task.
It also provides method to see if the computation is done or not. We can query FutureTask object and get the result of computation.
If we call get method on FutureTask object, it is blocking call and returns once the computation is done.

FutureTask is normally used to wrap Runnable or Callable objects and submit them to ExecutorService for asynchronous execution.

### Callable vs Runnable

* For implementing Runnable, the run() method needs to be implemented which does not return anything, while for a Callable, the call() method needs to be implemented which returns a result on completion. Note that a thread can’t be created with a Callable, it can only be created with a Runnable.
* Another difference is that the call() method can throw an exception whereas run() cannot.

## Concurant Utils

### AtomicInteger 
The AtomicInteger class protects an underlying int value by providing methods that perform atomic operations on the value. It shall not be used as a replacement for an Integer class.
```java
	//Initial value is 0
	AtomicInteger atomicInteger = new AtomicInteger();  
	 
	//Initial value is 100
	AtomicInteger atomicInteger = new AtomicInteger(100);	 
	int currentValue = atomicInteger.get();         //100	 
	atomicInteger.set(1234);                        //Now value is 1234
```
### AtomicInteger Opeartion
* Processor can simultaneously read a location and write it in the same bus operation.

* Benefits of using Concurrency classes for atomic operation is that we don’t need to worry about synchronization. This improves code readability and chance of errors are reduced. Also atomic operation concurrency classes are assumed to be more efficient that synchronization which involves locking resources.

### When to use AtomicInteger in Java
In real life uses, we will need AtomicInteger in two cases:

* As an atomic counter which is being used by multiple threads concurrently.
* In compare-and-swap operations to implement non-blocking algorithms.

### There are 3 parameters for a CAS(Compare and Swap) operation:

1. A memory location V where value has to be replaced
2. Old value A which was read by thread last time
3. New value B which should be written over V

Java Compare and Swap Example
Assume V is a memory location where value “10” is stored. There are multiple threads who want to increment this value and use the incremented value for other operations, a very practical scenario.
Let’s break the whole CAS operation in steps:

1) Thread 1 and 2 want to increment it, they both read the value and increment it to 11.

V = 10, A = 0, B = 0

2) Now thread 1 comes first and compare V with it’s last read value:

V = 10, A = 10, B = 11
```java
	if A = V
	   V = B
	 else
	   operation failed
	   return V
```

Clearly the value of V will be overwritten as 11, i.e. operation was successful.

3) Thread 2 comes and try the same operation as thread 1

V = 11, A = 10, B = 11
```java
	if A = V
	   V = B
	 else
	   operation failed
	   return V
```

4) In this case, V is not equal to A, so value is not replaced and current value of V i.e. 11 is returned. Now thread 2, again retry this operation with values:

V = 11, A = 11, B = 12

And this time, condition is met and incremented value 12 is returned to thread 2.

### ConcurrentHashMap 
* ConcurrentHashMap introduced in Java 5 with other concurrency utils such as CountDownLatch, CyclicBarrier and BlockingQueue.
* ConcurrentHashMap is very similar to HashTable but it provides better concurrency level.
* we can synchonize HashMap using Collections.synchronizedMap(Map)
* difference between ConcurrentHashMap and Collections.synchronizedMap(Map)In case of Collections.synchronizedMap(Map), it locks whole HashTable object but in ConcurrentHashMap, it locks only part of it. we will understand it in later part.
* ConcurrentHashMap class has a inner class called Segment
* ConcurrentHashMap locks only part of it.It actually locks a Segment

### BlockingQueue 
It is thread safe queue to put and take elements from it. BlockingQueue is special type of queue which is used when one thread produces object and another thread consumes it.
Producer thread will keep inserting objects to queue until it reaches upper limit. Once this queue size has reached that limit then producer thread will get blocked and won’t able to put objects into queue until consumer thread starts consuming it.
Similarly consumer thread keep taking objects from queue until queue becomes empty. Once queue becomes empty, consumer thread get blocked and waits for producer threads for inserting objects into the queue.

### CountDownLatch
CountDownLatch is synchronisation aid that allow one or more threads to wait until set of operations being performed in other threads completes.
CountDownLatch is initialized with count. Any thread generally main threads calls latch.awaits() method, so it will wait for either count becomes zero or it’s interrupted by another thread and all other thread need to call latch.countDown() once they complete some operation.
So count is reduced by 1 whenever latch.countDown() method get called, so  if count is n that means count can be used as n threads have to complete some action or some action have to be completed n times.

One of disadvantage of CountDownLatch is you can not reuse it once count is zero. For that ,you need to use CyclicBarrier.

###CyclicBarrier
CyclicBarrier is synchronized aid which allows set of threads to wait for each other at common barrier points.It is called cyclic because it can be reused once waiting threads are released.
* The major difference between CyclicBarrier and CoundDownLatch is that CyclicBarrier can be reused.

### Semaphore 
Semaphore basically maintains a set of permits, so there are two methods which are mainly used for semaphore.
* acquire
* release

#### Real time examples:
* Semaphores can be used to restrict number of database connections at a time
* Semaphores can also be used to bound any collection.

### Exchanger
Exchanger class is used to exchange object between two threads. Exchanger simply waits until two separate threads calls exchange method, when it happens,
it exchanges data supplied by threads.Two threads can pair and swap objects between them. Exchanger class may be useful in genetic algorithms or pipeline design.

## Serialization
Serialization in Java allows us to convert an Object to stream that we can send over the network or save it as file or store in DB for later usage. 
Deserialization is the process of converting Object stream to actual Java Object to be used in our program

### serialVersionUID
The serialVersionUID is a universal version identifier for a Serializable class.
Deserialization uses this number to ensure that a loaded class corresponds exactly to a serialized object. If no match is found, then an InvalidClassException is thrown.
serialVersionUID must be Static and final.we can assign any number to it.
If serialVersionUID is not specified in class, JVM will calculate the value according to the JVM specification.

* Externalizable
It uses custom written mechanism to perform marshalling and unmarshalling of objects.Externalizable interface extends Serializable interface

When object is reconstructed and it is externalizable , an instance is created using no args constructor and readExternal is called.
If serialized class does not exsit no args constructor jvm will through exception( no valid constructor). In every class has default constructor with no argument, if explicite parameters constructor decleared
default or no args contructor will have to decleare.

* transient keyword
Transient variable is variable whose value is dose not serialized during serialization. Will get default value for these variable when deserialize it.

Parameter | Serializable | Externalizable
--------- | ------------ | --------------
Marker interface | It is marker interface. we don’t have to provide implementation of any method. | Externalizable is not marker interface, you have to override writeExternal and readExternal method.
Control | Serializable interface has less control over serialization process and it is optional to override readObject and writeObject. | Externalizable interface has more control over serialization process and it is mandatory to override writeExternal and readExternal.
Performance | JVM uses reflection to perform serialization in the case of Serializable interface which is quite slow. | Programmer have to implement readExternal and writeExternal methods but it relatively results in better performance
Constructor called during Deserialization | Default constructor is not called during Deserialization process. | Default constructor is called during Deserialization process.

## Exception
“An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program’s instructions.”
Every Exception will be thrown at runtime.

There are mainly two types of exceptions: checked and unchecked. Here, an error is considered as the unchecked exception. According to Oracle, there are three types of exceptions:

1. Checked Exception (CompilerTime Exception)
2. Unchecked Exception (RuntimeException)
3. Error (Also called RuntimeException)

1) Checked(CompilerTime Exception): are the exceptions that are checked at compile time. 
   IOException, FileNotFoundException, SQLException, ClassNotFoundException

2) Unchecked(RuntimeException): are the exceptions that are not checked at compiled time.
   Java exceptions under Error and RuntimeException classes are unchecked exceptions
   ArithmeticException, NullPointerException, NumberFormatException, IndexOutOfBoundsException, ArrayIndexOutOfBoundsException, StringIndexOutOfBoundsException, etc
   
3) Error: is irrecoverable e.g. StackOverFlowException, OutOfMemoryError, VirtualMachineError, AssertionError etc.

throw:
throw keyword is used to throw any custom exception or predefine exception.

throws:
throws keyword is used to declare list of all exception which method might throw. It delegates responsibility of handling exception to calling method.

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/exception1.png?raw=true)

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/exception2.png?raw=true)

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/exception3.png?raw=true)

# Lambda Expressions
Java 8 has introduced a new feature called Lambda expressions. It is considered to be a major change in java. As this change bring functional programming into Java.
A lambda expression is a short block of code which takes in parameters and returns a value. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

Syntax
The simplest lambda expression contains a single parameter and an expression:

parameter -> expression

To use more than one parameter, wrap them in parentheses:

(parameter1, parameter2) -> expression

Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as if or for. In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, then the code block should have a return statement.

(parameter1, parameter2) -> { code block }

## Functional Interfaces
Functional interfaces are those interfaces which have only one abstract method, it can have default methods, static methods and it can also override java.lang.Object class method.
There are many functional interfaces already present.

implement functional interfaces using lambda expressions.

```java
	@FunctionalInterface
	public interface Decorable {
	
		 // one abstract method
		 void decorateWithCurtains();
		 
		 // default method
		 default void decorateWithPaints() {
			System.out.println("Decorating using paints");
		 }
		 
		 // Overriding method of java.lang.Object
		 @Override
		 public int hashCode() {	 
		}
	}
```

Some popular Functional Interfaces are:
```java
	java.lang.Runnable
	java.util.concurrent.Callable
	java.awt.event.ActionListener
	java.util.Comparator
	java.lang.Comparable
```

### Anonymous function
An anonymous function is a function that declared without any named identifier to refer to it. As such, an anonymous function is usually not accessible after its initial creation

Lambda expression represents an anonymous function. It comprises of a set of parameters, a lambda operator (->) and a function body . We can call it function without name.
Lambda expression can be applied for the abstract method of functional Interface which is being implemented or being instantiated anonymously.

* Structure of Lambda Expressions
(Argument List) ->{expression;} or
(Argument List) ->{statements;}

* Lambda expression to three parts:
1. Argument list or parameters
   1. Lambda expression can have zero or more arguments.
   ```java
	   ()->{System.out.println(“Hello”)}; //Without argument, will print hello
	   (int a)->{System.out.println(a)}; // One argument, will print value of a
	   (int a,int b)-> {a+b};//two argument, will return sum of these two integers
   ```
   2. we can choose to not declare the type of arguments as it can be inferred from context.
   ```java
		(a,b)->{a+b}; // two argument, will return sum of these two numbers
   ```
   3. you can not declare one argument’s type and do not declare type for other argument.
   ```java
		(int a,b)->{a+b}; // Compilation error
   ```
   4. When there is a single parameter, if its type is inferred, it is not mandatory to use parentheses
   ```java
		a->{System.out.println(a)}; // Will print value of number a
   ```
2. Array token (->)
3. Body
	1. Body can have expression or statements.
	2. If there is only one statement in body,curly brace is not needed and return type of the anonymous function is same as of body expression
	3. If there are more than one statements, then it should be in curly braces and return type of anonymous function is same as value return from code block, void if nothing is returned.

```java
	public class Sample {
	 
	 public static void main(String[] args) {
	  
	  // old way
	  new Thread(new Runnable() {	   
		   @Override
		   public void run() {
			System.out.println("Thread is started");
		   }
	  }).start();
	 
	  // using lambda Expression
	  new Thread(()->System.out.println("Thread is started")).start();
	 }
	 
	}
```

### Stream
Stream is a new abstract layer introduced in Java 8. Using stream, we can process data in a declarative way similar to SQL statements.
Stream represents a sequence of objects from a source, which supports aggregate operations.

* Sequence of elements − A stream provides a set of elements of specific type in a sequential manner. A stream gets/computes elements on demand. It never stores the elements.
* Source − Stream takes Collections, Arrays, or I/O resources as input source.
* Aggregate operations − Stream supports aggregate operations like filter, map, limit, reduce, find, match, and so on.
* Pipelining − Most of the stream operations return stream itself so that their result can be pipelined.
* Automatic iterations − Stream operations do the iterations internally over the source elements

### Why default methods
The oneliner for this could be “backward compatibility”.If JDK modifies an interface, then all classes which implements this interface will break.

For adding lambda expression in Java 8, JDK needs to add  methods(such as foreach) to List or collections Interface, but if we add this method to these interface, it will break millions lines of code as class which implements the interface, need to implement all its methods.

By adding default method in interface, you can provide default implementation of it without affecting implementing classes as it includes implementation of that method and any implementing class which needs that method can override it.

* Adding default implementation to the interface can give rise to ambiguity in multiple inheritance.
 to solve this compilation ambiguity error by overriding default method method in implemetation classes.
 
 Parameter | Abstract class | Interface with default methods
 --------- | -------------- | ------------------------------
State of objects | Abstract class can hold state of object | Interface with default methods can not hold state of objects
Access Modifier | Abstract class methods can have public ,protected,private and default modifier | Interface methods are by default public. you can not use any other access modifier with it
Constructor | Abstract class can have constructor | Interface  can not have constructor
Member variables | It can have member variables | No member variables

## Functional Interface
 java.util.function package in Java 8 contains many builtin functional interfaces like-
 *N.B: T must be reference type for all functional interface. String, Integer, Long, Boolean
 
### Supplier
Supplier is functional interface which does not take any argument and produces result of type T. The Supplier interface can also be thought of as a factory interface.

```java
	@FunctionalInterface
	public interface Supplier<T> {
		/**
		 * Gets a result.
		 *
		 * @return a result
		 */
		T get();
	}
```
```java
	Supplier<String> supplier= ()-> "Jahangir";
	System.out.println(supplier.get());
	
	Supplier<Integer> supplier1 = () -> new Integer((int) (Math.random() * 1000D));
	System.out.println(supplier1.get());
```

#### supplier in Stream’s generate method
```java
	public static<T> Stream<T> generate(Supplier<T> s)
```
### Consumer
Consumer is single argument(T type) functional interface like Predicate but it does not return any value. As Consumer is functional interface, so it can be used as assignment target for lambda expressions.
The Java Consumer interface is a functional interface that represents an function that consumes a value without returning any value.
A Java Consumer implementation could be printing out a value, or writing it to a file, or over the network etc

```java
	@FunctionalInterface
	public interface Consumer<T> {
	 
		/**
		 * Performs this operation on the given argument.
		 *
		 * @param t the input argument
		 */
		void accept(T t);
	 
		default Consumer<T> andThen(Consumer<? super T> after) {
			Objects.requireNonNull(after);
			return (T t) -> { accept(t); after.accept(t); };
		}
	}
```
```java
	Consumer<Integer> consumer = (value) -> System.out.println(value);
```
#### default andThen() method
Returns a composed Consumer that performs, in sequence, this operation followed by the after operation.
If performing either operation throws an exception, it is relayed to the caller of the composed operation.
If performing this operation throws an exception, the after operation will not be performed.

Two consumers and used andThen() method to create composite consumer.
When we called accept() method on composite consumer, both the consumers are called in sequence.

### Predicate
Predicate is single argument functional interface which returns boolean value. It takes one argument with type T and returns result in form of true or false.

```java
public interface Predicate {
	boolean test(T t);
}
```

``` java
	// Using anonymous class
	Predicate<Integer> predicate=new Predicate<Integer>() {

		@Override
		public boolean test(Integer i) {
			return i > 100;
		}
	};

	// Using lambda expression
	Predicate<Integer> predicate = i -> i > 100;
```

### UnaryOperator
The Java UnaryOperator interface is a functional interface that represents an operation which takes a single parameter and returns a parameter of the same type,

```java
	UnaryOperator<Person> unaryOperator = (person) -> { person.name = "New Name"; return person; };
```

The UnaryOperator interface can be used to represent an operation that takes a specific object as parameter, modifies that object, and returns it again

### BinaryOperator

The Java BinaryOperator interface is a functional interface that represents an operation which takes two parameters and returns a single value. Both parameters and the return type must be of the same type.
The Java BinaryOperator interface is useful when implementing functions that sum, subtract, divide, multiply etc.

```java
	BinaryOperator<MyValue> binaryOperator = (value1, value2) -> { value1.add(value2); return value1; };
```

### Function
The Java Function interface (java.util.function.Function) interface is one of the most central functional interfaces in Java. 
The Function interface represents a function (method) that takes a single parameter and returns a single value.

```java
	public interface Function<T,R> {
		public <R> apply(T parameter);
	}
```
```java
	public class AddThree implements Function<Long, Long> {

		@Override
		public Long apply(Long aLong) {
			return aLong + 3;
		}
	}
	
	Function<Long, Long> adder = new AddThree();
	Long result = adder.apply((long) 4);
	System.out.println("result = " + result);
```

The Function interface has also a default compose method that allows to combine several functions into one and execute them sequentially:

```java
	Function<Integer, String> intToString = Object::toString;
	Function<String, String> quote = s -> "'" + s + "'";
	 
	Function<Integer, String> quoteIntToString = quote.compose(intToString);
	 
	assertEquals("'5'", quoteIntToString.apply(5));
```
####  Primitive Function Specializations
Since a primitive type can’t be a generic type argument, there are versions of the Function interface for most used primitive types double, int, long, and their combinations in argument and return types:

* IntFunction, LongFunction, DoubleFunction: arguments are of specified type, return type is parameterized
* ToIntFunction, ToLongFunction, ToDoubleFunction: return type is of specified type, arguments are parameterized
* DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction, IntToLongFunction, LongToIntFunction, LongToDoubleFunction — having both argument and return type defined as primitive types, as specified by their names

There is no out-of-the-box functional interface for, say, a function that takes a short and returns a byte, but nothing stops you from writing your own:
```java
	@FunctionalInterface
	public interface ShortToByteFunction {	 
		byte applyAsByte(short s);	 
	}
```

#### Two-Arity Function Specializations
To define lambdas with two arguments, we have to use additional interfaces that contain “Bi” keyword in their names: BiFunction, ToDoubleBiFunction, ToIntBiFunction, and ToLongBiFunction.

BiFunction has both arguments and a return type generified, while ToDoubleBiFunction and others allow you to return a primitive value.

One of the typical examples of using this interface in the standard API is in the Map.replaceAll method, which allows replacing all values in a map with some computed value.
```java
	Map<String, Integer> salaries = new HashMap<>();
	salaries.put("John", 40000);
	salaries.put("Freddy", 30000);
	salaries.put("Samuel", 50000);
	 
	salaries.replaceAll((name, oldValue) -> 
	  name.equals("Freddy") ? oldValue : oldValue + 10000);

```

### Legacy Functional Interfaces
Not all functional interfaces appeared in Java 8. Many interfaces from previous versions of Java conform to the constraints of a FunctionalInterface and can be used as lambdas. 
A prominent example is the Runnable and Callable interfaces that are used in concurrency APIs. In Java 8 these interfaces are also marked with a @FunctionalInterface annotation. 
This allows us to greatly simplify concurrency code:

```java
	Thread thread = new Thread(() -> System.out.println("Hello From Another Thread"));
	thread.start();
```

## Collectors
Collectors is one of the utility class in JDK which contains a lot of utility functions. It is mostly used with Stream API as a final step. such as average, count, groupby, sort the list with the help of Collectors.

## Java 9
interface in Java is a concept which is used to achieve abstraction. an interface can contain only abstract methods and constants. Java 8 allows to add default and static methods as well.
Java 9, interface allows creating private and private static methods, so here is the java interface now

* Abstract methods
* Constant variables
* Default methods (added in Java 8)
* Static methods (added in Java 8)
* Private methods (added in Java 9)
* Private static methods (added in Java 9)

#### Interface Private Method
These methods can’t be accessible outside the interface and don’t inherit to the interface or implementing class.
The primary purpose behind to add private method was to share common code between non-abstract methods within the interface.

```java
	interface Workable{
		default void workTime() {
			done();
		}
		private void done() {
			System.out.println("work is done.");
		}
	}
```

#### Interface Private Static Methods
Like private instance methods, private methods can be static as well. 
A private static method can not be accessible from outside the interface and can only be accessible inside the default or static methods.

```java
	interface Workable{
		default void workTime() {
			done();
			tea();
		}
		private void done() {
			System.out.println("work is done");
		}
		private static void tea() {
			System.out.println("Let's have a Tea");
		}
	}
```

#### Key-points to remember
* Interface private methods must have implementation body; they can’t be declared as abstract methods.
* A static method can call only private static method, but a default method can call both the static and non-static(instance) private methods.
* The interface private methods support sharing common code between non-abstract methods(default, static and private).

### try with resources
It helps to close all the resources declared within try block. It automatically closes the resources after being used. A resource can be any file or a database connection.

* What type of resources can be handled automatically?
Java says, any object that implements java.lang.AutoCloseable interface and java.io.Closeable interface, can be used as a resource.

* Old feshion
```java
	try {
		FileOutputStream fileOutputStream =new FileOutputStream("info.txt");
		fileOutputStream.write("Java2blog is a technical blog".getBytes());
		System.out.println("File is written");
		fileOutputStream.close(); // closing resource
	}catch(Exception e) {
		System.out.println(e);
	}
```
* new feshion
```java
	try (FileOutputStream fileOutputStream = new FileOutputStream("info.txt")) {
		fileOutputStream.write("Java2blog is a technical blog".getBytes());
		System.out.println("File is written");
		// fileOutputStream.close(); No need to close manually 
	}catch(Exception e) {
		System.out.println(e);
	}
```

* Basic syntex
``` java
	try( // resources ){
		// body of try block
	}catch( // Exception ) {
		// handler code
	}
```

### Javadoc
The Javadoc is a tool like javac and a part of JDK. It is used to generate HTML documentation of Java source code.

### Underscore 
Underscore(_) is a symbol that is used to combine multi-words in a single identifier sometimes refers to a variable in a programming context.
In Java, to create a lengthy variable, we prefer to use underscore (_) such as employee_id, employee_name etc.

This code will work in Java 8 but will not work new java release.
```java
	int _ = 10; // valid till Java 8
	System.out.println(_);
```

Underscore as variable in Java 9, If we execute this example with Java 9 then it reports an error
```java
	int _a = 10; // valid
	System.out.println(_a);
	int a_ = 20; // valid
	System.out.println(a_);
	int a_b = 20; // valid
	System.out.println(a_b);
	int _ = 10; // invalid
	System.out.println(_);
```
But all are ok on Java 8

### Dimoand Operator
Type inference is a feature of Java that was introduced in Java 7. Now, Java compiler can infer type of a data automatically.
```java
	List<String> list = new ArrayList<String>(); // Before Java 7
	List<String> list = new ArrayList<>(); // From Java 7 and onward
```
We can see that Java 7 allows us to use empty diamond operator to avoid code redundancy.
But we can use this Java collection only, what about the anonymous class? If we do the same in Java 7 with anonymous class, means use empty diamond in an anonymous class then compiler reports an error.

See the example below:
```java
	abstract class CalculateAble<T>{
		abstract T add(T a, T b); 
	}	 
	public class Main {	 
		public static void main(String[] args) {
			CalculateAble<Integer> a = new CalculateAble<>() { // diamond operator is empty 
				public Integer add(Integer a, Integer b){  
					return a+b;   
				}  
			};
			int result = a.add(10, 20);
			System.out.println(result);
		}
	}
```
Output:
```java
	error: cannot infer type arguments for CalculateAble
	CalculateAble a = new CalculateAble() {
	^
	reason: cannot use ” with anonymous inner classes
```
Correction:
```java 
 DemoCalculator<Integer> a = new DemoCalculator<Integer>() { // diamond operator is not empty 
            Integer show(Integer a, Integer b){  
                return a+b;   
            }  
        };    
 
```

### Anonymous class: Java 9 Improvement
Java improved its type inference feature and allowed us to use (diamond) in the anonymous class too.
```java
	abstract class CalculateAble<T>{
		abstract T add(T a, T b);	 
	}	 
	public class Main {	 
		public static void main(String[] args) {
			CalculateAble<Integer> a = new CalculateAble<>() { // diamond operator is empty 
				public Integer add(Integer a, Integer b){  
					return a+b;   
				}  
			};
			int result = a.add(10, 20);
			System.out.println(result);
		}
	}
```

### @SafeVarargs Annotation
The @SafeVarargs is an annotation that is used to perform safe operations. When a method takes variable arguments, then it may cause to unsafe operation, 
so the @SafeVarargs annotation tells to the compiler to perform safe operations.
For example, if we don’t use the annotation the compiler reports warning:

We can use this annotation to final and static and private (from Java 9) methods only of a class

## Garbage Collection 
JVM Memory is divided into three parts

1. Young generation
2. Old generation
3. Metaspace (Permanent generation)

### Young Generation
As the name suggests, young generation is the area where newly created objects are allocated.

- When young generation fills up, it cause minor garbage collection aka Minor GC.
- When minor Gcs occurs, dead objects will be removed from young generation.
- If you have lot of dead objects in young generation, Minor GC will be perfomed faster.
- All minor GCs are “stop the world” events, so when minor GCs occurs, application threads will also stop.

Young generation is divided into 3 parts.

- Eden space
- Survivor space S0
- Survivor space S1

young and old generation piturial view
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/GC_1.png?raw=true)

* All newly created objects are allocated in eden space.
* When Eden space is completely filled with objects then minor GC will occur. All the objects which are not dead or unreferenced will be moved to one of the survivors spaces. In our case, let’s say all the objects are moved to S0.

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/GC_2.jpg?raw=true)
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/GC_3.jpg?raw=true)
* When Eden space is filled again, then all the live objects in Eden space andSurvivor space S0 will be moved to Survivor space S1.
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/GC_4.jpg?raw=true)
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/GC_5.jpg?raw=true)
* Once objects are survived multiple cycles of minor GC, they will be moved to old generation. we can control this threshold by MaxTenuringThreshold. The actual tenuring threshold is dynamically adjusted by JVM.

#### check memory allocation in Visual GC (A visualVM plugin) - tool for visualization of JVM memory

### Old generation
* It is used to hold old long surviving objects
* It is generally larger than the young generation.
* When tenured space is completely filled(or predefined threshold) with objects then Major GC will occur. It will reclaim the memory and free up space.
* Often, Major GCs are slower and less frequent than minor GC.

#### How can we use this information to optimize memory?
It depends on nature of application.
If we have lots of temporary objects then there will be lot of minor gc. we can provide arguments XX:NewRatio=1 to distribute 50% to young generation and 50% to old.
By default, NewRatio=2 hence young Generation is 1/3 of total heap.
Similarly, If we have too many long-lived objects, then we might need to increase size of tenure space by putting high value of NewRatio.

### Why two survivor spaces?
We have two survivor spaces(S0, S1) to avoid memory fragmentation. Each time we copy objects from eden to survivor and we get empty eden space and 1 empty survivor space.

## Garbage Collection Algorithms
JVM comes with several algorithms for young and old generation. There are 3 types of algorithms

### Serial collector
It uses single thread to perform all the garbage collection and is suitable for basic application with single processor machines.
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/SerialGC.jpg?raw=true)

### Parallel collector
It uses multiple CPUs to perform garbage collector. While serial collector uses 1 thread to perform GC, parallel GC uses several threads to perform GC and it is useful when there is enough memory and good number of cores.
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/parallelGC.jpg?raw=true)

### Concurrent collector
Concurrent collector performs garbage collection with application threads. It is useful for applications which have medium to large datasets and require quick response time.
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/concurrentGC.jpg?raw=true)
we can use different GC algorithms for young and old generations but we can pair only compatible algorithms.
For example: We can not pair Parallel Scavenge for young generation to Concurrent mark sweep for old as parallel scavenge does not provide synchronization which is required in CMS.
Young Collector | Old Collector | JVM options
--------------- | ------------- | ------------ 
Serial (DefNew) | Serial Mark-Sweep-Compact |-XX:+UseSerialGC	
Parallel scavenge (PSYoungGen) | Serial Mark-Sweep-Compact (PSOldGen) | -XX:+UseParallelGC	
Parallel scavenge (PSYoungGen) |Parallel Mark-Sweep-Compact (ParOldGen) | -XX:+UseParallelOldGC	
Serial (DefNew) | Concurrent Mark Sweep | -XX:+UseConcMarkSweepGC -XX:-UseParNewGC	
Parallel (ParNew) |	Concurrent Mark Sweep | -XX:+UseConcMarkSweepGC -XX:+UseParNewGC	
G1 |  |	-XX:+UseG1GC

### G1
The Garbage First Garbage Collector (G1 GC) is the low-pause, server-style generational garbage collector for Java HotSpot VM.
The G1 GC uses concurrent and parallel phases to achieve its target pause time and to maintain good throughput.
A garbage collector (GC) is a memory management tool. The G1 GC achieves automatic memory management through the following operations:

Allocating objects to a young generation and promoting aged objects into an old generation.
Finding live objects in the old generation through a concurrent (parallel) marking phase. The Java HotSpot VM triggers the marking phase when the total Java heap occupancy exceeds the default threshold.
Recovering free memory by compacting live objects through parallel copying.

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

  


