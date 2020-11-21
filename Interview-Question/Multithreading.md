# Multithreading

### 1. What is thread in java?
Thread can be called as light weight process. It can be referred as smallest part of process which can be executed concurrently with other parts(threads) of process.

### 2. What is Multithreading?
Multithreading is execution of multiple threads concurrently. Java supports multithreading , so it allows your application to perform two or more task concurrently.

### 3. What are ways to create a thread in java?
There are two ways to create a thread in java
- By extending thread class
- By implementing Runnable interface.

### 4. Thread vs Runnable which is better approach to create a thread?
Implementing Runnable interface is considered to be better approach than Extending Thread due to following reasons.
- Java does not support multiple inheritance so if we extend Thread class and we can not extend any other class which is needed in most of the cases.
- Runnable interface represents a task and this can be executed with help of Thread class or Executors.
- When we use inheritance, it is because we want to extend some properties of parent, modify or improve class behavior. But if we are extending thread class just to create thread, so it may not be recommended behavior for Object Oriented Programming.

### 5. What are differences between thread and process?
Process vs Thread:
- The process can be referred as program in execution whereas thread is part of process.
- Process has its own address space whereas multiple threads share same address space of process. Each thread has its own stack.
- Process can have multiple threads but thread is the smallest unit which can execute concurrently with other threads.
- Process are quite heavyweight and have more overhead whereas thread is light weight and have less overhead.
- Process do not depend on each other whereas threads are not independent as they share address space.
- We do not require synchronization in case of process. Threads require synchronization to avoid unexpected scenarios.
- Processes can communicate to each other using inter-process communication only where as thread can communicate directly as thread share same address space.
- We can easily create new threads by calling thread’s start method but we need to copy resources of parent process to create a new child process.

### 6. What are differences between Sleep and wait in java?
Parameter | wait | sleep
--------- | ---- | -----
Synchonized | wait should be called from synchronized context i.e. from block or method, If we do not call it using synchronized context, it will throw IllegalMonitorStateException | It need not be called from synchronized block or methods
Calls on | wait method operates on Object and defined in Object class | Sleep method operates on current thread and is in java.lang.Thread
Release of lock | wait release lock of object on which it is called and also other locks if it holds any | Sleep method does not release lock at all
Wake up condition | until call notify() or notifyAll() from Object class | Until time expires or calls interrupt()
static | wait is non static method | sleep is static method

### 7. Define states of thread in java?
There are 5 states of thread in java
- New : When we create a thread object and it is not alive yet.
- Runnable:  When we call start method of thread, it goes into Runnable state. Whether it will execute immediately or execute after some times , depends on thread scheduler.
- Running : When thread is being executed, it goes to running state.
- Blocked : When thread waits for some resources or some other thread to complete (due to thread’s join), it goes to blocked state.
- Dead: When thread’s run method returns, thread goes to dead state.

### 8. Can we call run method directly to start a thread?
No

###9. Can we start a thread twice in java?
No, it will throw IllegalThreadStateException if call twice.

### 10. How to make a main thread wait until all other threads finished execution? 
Calling by join method to achieve above scenario.

### 11. What are daemon threads?
Daemon threads are low-priority background threads which provide services to user threads. Its life depends on user threads. 
If no user thread is running then JVM can exit even if daemon threads are running. JVM does not wait for daemon threads to finish.

### 12. How can we change user thread to daemon thread?
setDaemon method can be used to mark thread as user thread. If we put setDaemon(true), it makes thread as daemon.

### 13. What is Synchronization?
Synchronization is ability to restrict access to shared resource to only one thread.

### 14. What is need of Synchronization?
Say we want to count number of request we got for a particular URL. If we get two requests at the same time, then count may be inconsistent.

For example:
Thread T1 sees count as 20 and increment it to 21. At the same time, thread t2 also sees count as 20 and increment it to 21. This shows that count became inconsistent.

With Synchronization:
We can achieve Synchronization using two ways.
- synchronized method
- synchronized block

### 15. Can we explain about Object level locking and class level locking?
There are two types of locking in java.
- Object level locking
- Class level locking

#### Object level locking
Object level locking is mechanism when we want to synchronize a non-static method or non-static code block such that only one thread will be able to execute the code block on given instance of the class. 
This should always be done to make instance level data thread safe. 
This can be done as below :
```java
public class DemoClass 
{ 
  public synchronized void demoMethod(){} 
} 

or 

public class DemoClass 
{ 
  public void demoMethod(){ 
  synchronized (this) 
  { 
   //other thread safe code 
  } 
 } 
} 

or 

public class DemoClass 
{ 
  private final Object lock = new Object(); 
  public void demoMethod(){ 
  synchronized (lock) 
 { 
  //other thread safe code 
 } 
} 
```
#### Class level locking:
Class level locking prevents multiple threads to enter in synchronized block in any of all available instances on runtime. 
This means if in runtime there are 100 instances of DemoClass, then only one thread will be able to execute demoMethod() in any one of instance at a time, 
and all other instances will be locked for other threads. This should always be done to make static data thread safe.
```java
public class DemoClass 
{ 
  public synchronized static void demoMethod(){} 
} 

or 

public class DemoClass 
{ 
  public void demoMethod(){ 
  synchronized (DemoClass.class) 
  { 
   //other thread safe code 
  } 
 } 
} 

or 

public class DemoClass 
{ 
 private final static Object lock = new Object(); 
 public void demoMethod(){ 
 synchronized (lock) 
  { 
   //other thread safe code 
  } 
 } 
}
```

### 16. Can two threads execute static and non static methods concurrently?
Yes, Since two threads will acquire lock on different objects, they can be executed concurrently without any issues.

### 17. If one method of class is synchronized and other method of same class is not synchronized? Can they be executed concurrently by two threads?
Yes, because one thread will require lock to get into synchronized block but second thread which will execute non synchronized method that won’t require any lock, so it can be executed concurrently.

### 18. Is it safe to call a synchronized method from another synchronized method?
Yes

### 19. What is deadlock?
Deadlock is a situation where two or more threads are waiting for each other to release the resource.
Thread 1 have lock over object 1 and waiting to get lock on object 2. Thread 2 have lock over object 2 and waiting to get lock on object 1. In this scenario, both threads will wait for each other indefinitely.

### 20. What are differences between notify and notifyall?

notify(): When we call notify method on the object, it wakes one of thread waiting for that object. So if multiple threads are waiting for an object, it will wake of one of them. 
Now we must be wondering which one it will wake up. It actually depends on OS implementation.

notifyAll(): notifyAll will wake up all threads waiting on that object unlike notify which wakes up only one of them. Which one will wake up first depends on thread priority and OS implementation.

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/
