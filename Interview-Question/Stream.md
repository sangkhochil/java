# Stream

### 1. What Is Stream in Java?
A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result. 
The features of Java stream are – A stream is not a data structure instead it takes input from the Collections, Arrays or I/O channels.
Different Operations On Streams-
Intermediate Operations:

**map:** The map method is used to returns a stream consisting of the results of applying the given function to the elements of this stream.

List number = Arrays.asList(2,3,4,5);
List square = number.stream().map(x->x*x).collect(Collectors.toList());

**filter:** The filter method is used to select elements as per the Predicate passed as argument.

List names = Arrays.asList("Reflection","Collection","Stream");
List result = names.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());

**sorted:** The sorted method is used to sort the stream.

List names = Arrays.asList("Reflection","Collection","Stream");
List result = names.stream().sorted().collect(Collectors.toList());

**Terminal Operations:**

**collect:** The collect method is used to return the result of the intermediate operations performed on the stream.

List number = Arrays.asList(2,3,4,5,3);
Set square = number.stream().map(x->x*x).collect(Collectors.toSet());

**forEach:** The forEach method is used to iterate through every element of the stream.

List number = Arrays.asList(2,3,4,5);
number.stream().map(x->x*x).forEach(y->System.out.println(y));

**reduce:** The reduce method is used to reduce the elements of a stream to a single value.
The reduce method takes a BinaryOperator as a parameter.

List number = Arrays.asList(2,3,4,5);
int even = number.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);

Here ans variable is assigned 0 as the initial value and i is added to it .

### 2. What does the map() function do? why you use it?
The map() function perform map functional operation in Java. This means it can transform one type of object to others by applying a function.

For example, if you have a List of String and you want to convert that to a List of Integer, you can use map() to do so.

Just supply a function to convert String to Integer e.g., parseInt() to map() and it will apply that to all elements of List and give you a List of Integer. 
In other words, the map can convert one object to another.

### 3. What does the filter() method do? when you use it?
The filter method is used to filter elements that satisfy a certain condition that is specified using a Predicate function.

A predicate function is nothing but a function that takes an Object and returns a boolean. For example, if you have a List of Integer and you want a list of even integers.

### 4. What does the flatmap() function do? why you need it?
The flatmap function is an extension of the map function. Apart from transforming one object into another, it can also flatten it.

For example, if you have a list of the list but you want to combine all elements of lists into just one list. In this case, you can use flatMap() for flattening. 
At the same time, you can also transform an object like you do use map() function.

### 5. What is the difference between flatMap() and map() functions? (answer)
Even though both map() and flatMap() can be used to transform one object to another by applying a method to each element.

The main difference is that flatMap() can also flatten the Stream. For example, if you have a list of the list, then you can convert it to a big list by using the flatMap() function.

### 6. What is the difference between intermediate and terminal operations on Stream? (answer)
The intermediate Stream operation returns another Stream, which means you can further call other methods of Stream class to compose a pipeline.

For example after calling map() or flatMap() you can still call filter() method on Stream.

On the other hand, the terminal operation produces a result other than Streams like a value or a Collection.

Once a terminal method like forEach() or collect() is called, you cannot call any other method of Stream or reuse the Stream.

![alt text](https://github.com/sangkhochil/java/blob/main/Resources/Java_8_Stream.png?raw=true)

### 7. What does the peek() method do? When should you use it?
The peek() method of Stream class allows you to see through a Stream pipeline. You can peek through each step and print meaningful messages on the console. 
It's generally used for debugging issues related to lambda expression and Stream processing.

### 8. What do you mean by saying Stream is lazy?
When we say Stream is lazy, we mean that most of the methods are defined on Java .util.stream.Stream class is lazy i.e. they will not work by just including them on the Stream pipeline.

They only work when you call a terminal method on the Stream and finish as soon as they find the data they are looking for rather than scanning through the whole set of data.

### 9. What is a functional interface in Java 8? (answer)
A functional interface is an interface that represents a function. Technically, an interface with just one abstract method is called a functional interface.

You can also use @FunctionalInterface to annotated a functional interface. In that case, the compiler will verify if the interface actually contains just one abstract method or not.
It's like the @Override annotation, which prevents you from accidental errors.

Another useful thing to know is that If a method accepts a functional interface, then you can pass a lambda expression to it.

Some examples of the functional interface are Runnable, Callable, Comparator, and Comparable from old API and Supplier, Consumer, and Predicate, etc. from new function API.

### 10. What is the difference between a normal and functional interface in Java?
The normal interface in Java can contain any number of abstract methods, while the functional interface can only contain just one abstract method.

### 11. What is the difference between the findFirst() and findAny() method? (answer)
The findFirst() method will return the first element meeting the criterion i.e. Predicate, while the findAny() method will return any element meeting the criterion, 
very useful while working with a parallel stream.

### 12. What is a Predicate interface?
A Predicate is a functional interface that represents a function, which takes an Object and returns a boolean. It is used in several Stream methods like filter(), which uses Predicate to filter unwanted elements.

here is how a Predicate function looks like:

public boolean test(T object){
   return boolean; 
}

### 13. What are Supplier and Consumer Functional interface?
The Supplier is a functional interface that returns an object. It's similar to the factory method or new(), which returns an object.

The Supplier has get() functional method, which doesn't take any argument and return an object of type T. This means you can use it anytime you need an object.

Since it is a functional interface, you can also use it as the assignment target for a lambda expression or method reference.

A Consumer is also a functional interface in JDK 8, which represents an operation that accepts a single input argument and returns no result.

Unlike other functional interfaces, Consumer is expected to operate via side-effects. The functional method of Consumer is accept(T t), and because it's a functional interface

### 14. Can you convert an array to Stream? How? (answer)
Yes, you can convert an array to Stream in Java. The Stream class provides a factory method to create a Stream from an array, like Stream .of(T ...) which accepts a variable argument, that means you can also pass an array to it as shown in the following example:

String[] languages = {"Java", "Python", "JavaScript"};
Stream numbers = Stream.of(languages);
numbers.forEach(System.out::println);

Output:
Java
Python
JavaScript

### 15. What is Java Parallel Streams?
Java Parallel Streams is a feature of Java 8 and higher, meant for utilizing multiple cores of the processor. Normally any java code has one stream of processing, 
where it is executed sequentially. Whereas by using parallel streams, we can divide the code into multiple streams that are executed in parallel on separate cores and 
the final result is the combination of the individual outcomes. The order of execution, however, is not under our control.

Therefore, it is advisable to use parallel streams in cases where no matter what is the order of execution, the result is unaffected and the state of one element does not 
affect the other as well as the source of the data also remains unaffected.

Parallel streams divide the provided task into many and run them in different threads, utilizing multiple cores of the computer. On the other hand sequential streams work just like for-loop using a single core.

#### Reference's ####
01. https://www.java67.com/2018/10/java-8-stream-and-functional-programming-interview-questions-answers.html

