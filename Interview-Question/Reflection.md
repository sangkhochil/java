# Reflection

### 1. What Is Reflection in Java?
Reflection is a very powerful mechanism in Java. Reflection is a mechanism of Java language which enables programmers to examine or modify the internal state of the program 
(properties, methods, classes etc.) at runtime. The java.lang.reflect package provides all required components for using reflection.

When using this feature, we can access all possible fields, methods, constructors that are included within a class definition. We can access them irrespective of their access
modifier. It means that for example, we are able to access private members. To do that, we don't have to know their names. All we have to do is to use some static methods of Class.

It's worth knowing that there is a possibility to restrict access via reflection. To do that we can use the Java security manager and the Java security policy file. They allow us 
to grant permissions to classes.

When working with modules since Java 9, we should know that by default, we aren't able to use reflection on classes imported from another module. To allow other classes to use 
reflection to access the private members of a package we have to grant the “Reflection” Permission.

Java Reflection is an API provided in Java programming language that makes it possible to inspect classes, methods, fields etc. at runtime; without knowing their names at compile 
time. In addition to inspecting classes and its members, it is also possible to instantiate objects, call methods and set field values using reflection.

### 2. Where is Java Reflection commonly used?
 
Java Reflection API is commonly used in the development of developer tools.

Visual Development Environments:Visual development environments use Java reflection to make the development process easier and more efficient by prompting the 
correct types and values to the developer
 
Class Browsers:Class browsers inspect class and its members

Debuggers and Testing Tools

### 3. What are the disadvantages of Reflection?
 
**Performance overhead:** Reflection works by dynamically resolving and inspecting classes and its members. with this flexibility comes its disadvantage - certain java virtual machine 
optimizations cannot be performed when types are resolved dynamically leading to slower performance as compared to normal class and method operations. When an operation can be 
performed non-reflective as well as reflective operation, always prefer the non-reflective operation. In performance sensitive applications, reflective operations must be avoided 
in loops and frequently called sections of code.

**Security Restrictions:** There are certain security impacts to using Reflection. Reflection needs a runtime permission which may not be available when running under a security 
manager, such as in an Applet.
 
**Exposure of Internals:** Java reflection enables us to perform certain operations which are illegal in non-reflective operations. For example - We can access the private members 
of a class which is illegal with non-reflective operations. This leads to dysfunctional and unportable code, and breaks the object oriented principle of abstraction and containment.

### 4. What is a Class object. How do you get a Class object via reflection?
 
Every type; including reference types, primitive types (int, char etc.) and arrays have an associated java.lang.Class object. To perform reflection operation on a class, we have to 
first get its associated class object. Following are the different ways to get a Class object, depending on what the code has access to - object, type, class or name of class.

**Class.forName():** If the code has access to a fully-qualified class name you can use 'Class.forName()' to get the class object of the fully-qualified class name.
 
**Object.getClass():** If the code has access to an instance object you can use 'Object.getClass()' syntax to get the class object for the object instance.

**Type.class:** If the code has access to the type of class, you can use 'Type.class' syntax to get the class object for the type.

### 5. How do you access the package of a class?
 
The package of a class can be accessed by calling the method getPackage() on the class object.
```java
Class myClass = Class.forName('java.lang.String');
Package package = myClass.getPackage();
```

### 6. How do you access the interfaces implemented by a class?
 
The interfaces of a class can be accessed by calling the method getInterfaces() on the class object.
```java
Class myClass = Class.forName('java.lang.String');
Package package = myClass.getInterfaces();
```

### 7. How do you access the parent class of a class?
 
The parent or super class of a class can be accessed by calling the method getSuperClass() on the class object.
```java
Class myClass = Class.forName('java.lang.String');
Package package = myClass.getSuperclass();
```

### 8. How do you retrieve class access modifiers reflection?
 
Class access modifiers are the access modifiers such as public, private etc. that a class is declared with. Class modifiers can be accessed calling the method getModifiers() on the class object.
```java
Class myClass = Class.forName('java.lang.String');
int modifier = myClass.getModifiers();
```

### 9. How do you access constructors defined in a class using reflection?
 
Constructors of a class can be accessed by calling the method getConstructors() on the class object.

### 10. How do you access fields defined in a class using reflection?
 
Fields of a class can be accessed by calling the method getFields() on the class object.
```java
Class myClass = Class.forName('java.lang.String');
Field[] fields = myClass.getFields();
```

### 11. How do you access annotations defined in a class using reflection?
 
Annotations of a class can be accessed by calling the method getAnnotations() on the class object.
```java
Class myClass = Class.forName('java.lang.String');
Annotation[] annotations = myClass.getAnnotations();
```

#### Reference's ####
01. https://www.baeldung.com/
02. https://www.interviewgrid.com/interview_questions/java/java_reflection
03. https://scrutinybykhimaanshu.blogspot.com/2016/04/java-reflection-api-interview-questions.html

