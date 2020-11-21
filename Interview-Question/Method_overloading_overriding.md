# Method overloading and overriding

### 1. What is method overloading?
If two or more methods have same name, but different argument then it is called method overloading.

### 2. What are rules of method overloading?
Rule | Description
---- | -----------
Number of Arguments	| Overloaded method can have different number of arguments
Date type | Overload method can have different data type for argument
Return type | Return type can be changed but either number of argument or data type of argument should also be changed.
Order of arguments | If we change sequence of arguments then it is also valid method overloading provided we have different data types arguments.
Constructor | Can be overloaded

### 3. Can we overload static methods in java?
Yes

### 4. Can we overload main method?
Yes, we can overload main method but only method with signature public static void main(String[] args) will be used when our class is invoked by JVM.

### 5. Can we change only return type while method overloading?
We can not.If we change only return type, it will become ambiguous for compiler to figure out which method to call. That is why we can not change only return type.

### 6. What is method overriding?
If subclass is having same method as base class then it is known as method overriding Or in another words, If subclass provides specific implementation to any method which is present in its one of parents classes then it is known as method overriding.

### 7. What are rules of method overriding?
Rule | Description
---- | -----------
Arguments | Must not change
Return type | Can’t change except for covariant (subtype) returns
Access Modifier | Must not be more restrictive. Can be less restrictive.
Exceptions | Can reduce or eliminate but must not throw new/broader checked exceptions
Contructor | Can not be overridden
Static method |	Can not be overridden
final method | Can not be overridden

### 8. Can we override static methods in java?
No

### 9. Can we override private methods in java?
No

### 10. Can we override final methods?
Because final methods are meant to be not overridden

### 11. What is static binding?
During compilation process, compiler bind method call to actual method. This is called static binding and method overloading binding happens at compile time.

### 12. What is dynamic binding?
Binding of overridden methods happen at runtime is known as dynamic binding.

### 13. What are Covariant return type in java?
Covariant return type means if subclass overrides any method, return type of this overriding method can be subclass of return type of base class method
```java
public class BaseClass {
 
 public A m1() {
 System.out.println("In BaseClass method");
 return new A();
 }
 
 public static void main(String args[])
 {
 BaseClass b=new SubClass();
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
### 14. What would be the output of below program:
```java
public class MethodOverloadingExample {
 
 public void methodTest(Object object)
 {
  System.out.println("Calling object method");
 }
 
 public void methodTest(String object)
 {
  System.out.println("Calling String method");
 }
 
 public static void main(String args[])
 {
  MethodOverloadingExample moe=new MethodOverloadingExample();
  moe.methodTest(null);
 }
}
```

Output:
```java
Calling String method
```

### 15. What would be the output of below program:
```java
public class MethodOverrdingTestMain { 
 public static void main(String[] args) {
  B b=new B();
  try {
   b.method();
  } catch (Exception e) {
   e.printStackTrace();
  }
 }
 
}
class A{
 
 public void method() throws IOException
 {
  
 }
}
class B extends A{
 
 public void method() throws Exception
 {
  
 }
}
```
Output:
```java 
compile time error
```
Explanation:
As exception thrown by overridden method can not be more restrictive, it will result in compile time error.
Override method can be less access modifier and less exception. No higher access modifier and exception.

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

