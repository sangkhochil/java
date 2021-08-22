# Java Exception

### 1. What is Exception ?
Java doc says “ An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program’s instructions.”
The term “exception” means “exceptional condition” and is an occurrence that changes the normal program flow.

### 2. How can you handle exception in java?
try-catch-finally blocks are used to handle exception in java.
try : This block has code which can throw exception.
catch : This block is used to handle appropriate exception.
finally : This block is used to write any clean up code irrespective of whether any exception occurred or not.

### 3. Explain the Exception hierarchy.
![alt text](https://github.com/sangkhochil/java/blob/main/Resources/exception1.png?raw=true)

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/exception2.png?raw=true)

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/exception3.png?raw=true)

### 4. Difference between checked exception, unchecked exceptionand and errors
Parameter | Checked Exception | Unchecked Exception | Error
--------- | ----------------- | ------------------- | -----
How to recognise | sub class of Exception class(Compile Time Exception) | sub class of RuntimeException class | sub class of Error class
Good to catch | Yes | Yes | No
Is Program required to handle or declared | Yes | No | No
Thrown by Programatically | JVM	 | JVM
Recoverable | Yes | Yes | No
Example | IOException, FileNotFoundException, etc | NullPointerException, ClassCastException, etc | StackOverFlowError, OutOfMemoryError, etc

### 5. Can we have try without catch block in java ?
Yes, we can have try without catch block by using finally block.

### 6. What is RunTime exception in java?
RunTime exception is the exception which is thrown at run time. These exceptions occur due to programmatic errors and need to be corrected. Compiler is not aware of any such exception.

### 7. What is checked exception or compile time exception?
Checked exceptions are those exceptions which are checked at compile. If we do not handle them , we will get compilation error.It forces we to handle this exception in try-catch block.

### 8. Can you put other statements between try,catch and finally block?
No

### 9. How do you create custom exception in java?
We just need to extend Exception class to create custom exception. If we want to create Unchecked Exception, we need to extend RuntimeException.

### 10. Is there any order in which catch block should be written?
Yes, most specific exception should be written first and then generic one.

```java
	public static int exceptionTest() { 
	   try {
		  File f=new File("/usr/abc.txt");
	   }
	   catch(Exception e) {
	   }
	   catch(IOException e) { // Compilation error 
	   }
	}
```

### 11. Difference between throw and throws keyword?
throw: throw keyword is used to throw any custom exception or predefine exception.
throws: throws keyword is used to declare list of all exception which method might throw. It delegates responsibility of handling exception to calling method.

### 12. What would be the output of below program:
```java
	public class Exception1 {
		public static void main(String[] args) {
			System.out.println(exceptionTest());
		}

		public static int exceptionTest() {
			int i = 6;
			try {
				return i;
			} catch (Exception e) {
				i = 10;
			} finally {
				System.out.println("In finally block");
			}
			return i;
		}
	}
```
Output:
```java 
	In finally block
	6
```
Explanation: 
If we notice we have return statement in try block, so before returning from exceptionTest() method, finally block will be executed. When we have return statement in try block, 
JVM will take note of value of i and this value will be returned by exceptionTest method.
### 13. What would be the output of below program:
```java
	public class Exception2 {
		public static void main(String[] args) {
			System.out.println(exceptionTest());
		}

		public static int exceptionTest() {
			int i = 6;
			try {
				throw new NullPointerException();
			} catch (Exception e) {
				i = 10;
				return i;
			} finally {
				i = 20;
				System.out.println("In finally block");
			}
		}
	}
```
Output:
```java
	In finally block
	10 
```
Explanation:
Value of variable i will be set to 6.
NullPointerException will be thrown from try block.
Flow will go to catch block and value of i will be set to 10. JVM will make note of value of i and this will be returned by exceptionTest method.
Before returning from exceptionTest method, finally block will be executed and “In finally block” will be printed on console.
In the end, return value of exceptionTest method will be 10.
### 14. What would be the output of below program:
```java
	public class Exception3 {
		public static void main(String[] args) {
			System.out.println(exceptionTest());
		}

		public static int exceptionTest() {
			int i = 6;
			try {
				throw new NullPointerException();
			} catch (NullPointerException e) {
				i = 10;
				throw e;
			} finally {
				i = 20;
				System.out.println("In finally block");
				return i;
			}
		}
	}
```
Output:
```java
	In finally block
	20
```
Explanation:
Value of variable i will be set to 6.
NullPointerException will be thrown from try block.
Flow will go to catch block and value of i will be set to 10. We are throwing NullPointerException from catch block.
finally will get excuted and value of i will be set to 20.”In finally block” will be printed on console.
In the end, return value of exceptionTest method will be 20.
If you notice here, return statement from finally block actually suppressed the NullPointerException.

```java
class Exception4 {
	
	public static int exceptionTest() {
		int i = 6;
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			i = 10;
			return i;
		} finally {
			i = 20;
			System.out.println("In finally block");
			throw new NullPointerException();
		}
	}
}
```

Output:
```java
	In finally block
	
	java.lang.NullPointerException
	at Exception3.exceptionTest(Main.java:97)
	at Main.main(Main.java:11)
```
Explanation:
Value of variable i will be set to 6.
NullPointerException will be thrown from try block.
Flow will go to catch block and value of i will be set to 10. We are throwing NullPointerException from catch block.
finally will get excuted and value of i will be set to 20.”In finally block” will be printed on console.
In the end, caller function does get any return value due to exception occured before.
If we notice here, NullPointerException actually suppressed the return statement of catch block.

### 15. What would be the output of below program:
```java
	public class Exception4 {
		public static void main(String[] args) {
			System.out.println(exceptionTest());
		}

		public static int exceptionTest() {
			int i = 6;
			try {
				i = 50;
				return i;
			} finally {
				i = 20;
				System.out.println("In finally block");
				return i;
			}

		}
	}
```
Output:
```java
	In finally block
	20
```

Explanation:
Value of variable i will be set to 6.
Value of variable i will be set to 50 and JVM will make note of return value of i as 50.
finally will get excuted and value of i will be set to 20.”In finally block” will be printed on console.
In the end, return value of exceptionTest method will be 20. It will override value returned by try block.

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

