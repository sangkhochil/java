# Common

### HashCode
The hashcode of a Java Object is simply a number, it is 32-bit signed int, that allows an object to be managed by a hash-based data structure.
We know that hash code is an unique id number allocated to an object by JVM. ...
If two objects are equals then these two objects should return same hash code.

# Java Collections

## Default java collections capacity
* ArrayList-10
* Vector-10
* HashSet-16
* HashMap-16
* HashTable-11
* HashSet-16

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
* You can use generics with ArrayList but not with Array
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
Alternative | No alternative | You can use ConcurrentHashMap for multi thread environment

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
When you want to sort the list of objects of a class,you can use Comparator interface. You don’t need to implement Comparator on the class whose objects need to be sorted. You can create a separate class and implement a Comparator interface as below.
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
6. You do not require synchronization in case of process. Threads require synchronization to avoid unexpected scenarios.
7. Processes can communicate to each other using inter-process communication only where as thread can communicate directly as thread share same address space.
8. You can easily create new threads by calling thread’s start method but you need to copy resources of parent process to create a new child process.

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

## FutureTask

FutureTask class has been introduced in JDK 5 with Executor Framework. FutureTask class is the concrete implementation of the Future object and provides methods for start and cancel the task.
It also provides method to see if the computation is done or not. We can query FutureTask object and get the result of computation.
If we call get method on FutureTask object, it is blocking call and returns once the computation is done.

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
* difference between ConcurrentHashMap and Collections.synchronizedMap(Map)In case of Collections.synchronizedMap(Map), it locks whole HashTable object but in ConcurrentHashMap, it locks only part of it. You will understand it in later part.
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
serialVersionUID must be Static and final.You can assign any number to it.
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
Marker interface | It is marker interface. You don’t have to provide implementation of any method. | Externalizable is not marker interface, you have to override writeExternal and readExternal method.
Control | Serializable interface has less control over serialization process and it is optional to override readObject and writeObject. | Externalizable interface has more control over serialization process and it is mandatory to override writeExternal and readExternal.
Performance | JVM uses reflection to perform serialization in the case of Serializable interface which is quite slow. | Programmer have to implement readExternal and writeExternal methods but it relatively results in better performance
Constructor called during Deserialization | Default constructor is not called during Deserialization process. | Default constructor is called during Deserialization process.

#### Reference's ####
https://java2blog.com/
https://howtodoinjava.com
https://www.journaldev.com
https://www.geeksforgeeks.org/

  


