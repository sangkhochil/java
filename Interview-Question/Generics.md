# Generic

### 1. What is Generic?

is when a type can be used as a parameter in a class, method or interface declaration.

```java
	public interface Consumer<T> {
		public void consume(T parameter)
	}

	public class IntegerConsumer implements Consumer<Integer> {
		public void consume(Integer parameter)
	}
```

### 2. What Are Some Advantages of Using Generic Types?
One advantage of using generics is avoiding casts and provide type safety. This is particularly useful when working with collections

by using generics we have a compile type check which prevents ClassCastExceptions and removes the need for casting.

The other advantage is to avoid code duplication. Without generics, we have to copy and paste the same code but for different types. 
With generics, we do not have to do this. We can even implement algorithms that apply to generic types.

### 3. What Is Type Erasure?
It's important to realize that generic type information is only available to the compiler, not the JVM. In other words, type erasure means that generic type information is not available to the JVM at runtime, only compile time.

The reasoning behind major implementation choice is simple – preserving backward compatibility with older versions of Java. When a generic code is compiled into bytecode, it will be as if the generic type never existed. This means that the compilation will:

Replace generic types with objects
Replace bounded types (More on these in a later question) with the first bound class
Insert the equivalent of casts when retrieving generic objects.

### 4. If a Generic Type Is Omitted When Instantiating an Object, Will the Code Still Compile?
If we look at our list from question one, then we will see that we already have an example of omitting the generic type:

List list = new ArrayList();

Despite being able to compile, it's still likely that there will be a warning from the compiler. This is because we are losing the extra 
compile-time check that we get from using generics.

The point to remember is that while backward compatibility and type erasure make it possible to omit generic types, it is bad practice.

### 5. How Does a Generic Method Differ from a Generic Type?
A generic method is where a type parameter is introduced to a method, living within the scope of that method.
```java
	public static <T> T returnType(T argument) { 
		return argument; 
	}
```
We've used a static method but could have also used a non-static one if we wished. By leveraging type inference (covered in the next question), 
we can invoke this like any ordinary method, without having to specify any type arguments when we do so.

### 6. What Is Type Inference?
Type inference is the automatic deduction(সিদ্ধান্তগ্রহণ) of the data types of specific expressions in a programming language.
Type inference is when the compiler can look at the type of a method argument to infer a generic type. For example, if we passed in T to a method which returns T, 
then the compiler can figure out the return type. Let's try this out by invoking our generic method from the previous question:

```java
	Integer inferredInteger = returnType(1);
	String inferredString = returnType("String");
```

As we can see, there's no need for a cast, and no need to pass in any generic type argument. The argument type only infers the return type.2

### 7. What Is a Bounded Type Parameter?
When we use bounded parameters, we are restricting the types that can be used as generic type arguments.

As an example, let's say we want to force our generic type always to be a subclass of animal:
```java
	public abstract class Cage<T extends Animal> {
		abstract void addAnimal(T animal)
	}
```
By using extends, we are forcing T to be a subclass of animal. We could then have a cage of cats:

Cage<Cat> catCage;
But we could not have a cage of objects, as an object is not a subclass of an animal:
```java
	Cage<Object> objectCage; // Compilation error
```
One advantage of this is that all the methods of animal are available to the compiler. We know our type extends it, so we could write a generic algorithm which operates on any animal. This means we don't have to reproduce our method for different animal subclasses:
```java
	public void firstAnimalJump() {
		T animal = animals.get(0);
		animal.jump();
	}
```
### 8. Is It Possible to Declared a Multiple Bounded Type Parameter?
Declaring multiple bounds for our generic types is possible. In our previous example, we specified a single bound, but we could also specify more if we wish:
```java
	public abstract class Cage<T extends Animal & Comparable>
```
In our example, the animal is a class and comparable is an interface. Now, our type must respect both of these upper bounds. If our type were a subclass of animal but did not implement comparable, then the code would not compile. 
**It's also worth remembering that if one of the upper bounds is a class, it must be the first argument. **

### 9. What Is a Wildcard Type?
**A wildcard type represents an unknown type.** It's detonated with a question mark as follows:

> public static void consumeListOfWildcardType(List<?> list)

Here, we are specifying a list which could be of any type. We could pass a list of anything into this method.

### 10. What Is an Upper Bounded Wildcard?
**An upper bounded wildcard is when a wildcard type inherits from a concrete type. This is particularly useful when working with collections and inheritance.**

Let's try demonstrating this with a farm class which will store animals, first without the wildcard type:
```java
	public class Farm {
	  private List<Animal> animals;

	  public void addAnimals(Collection<Animal> newAnimals) {
		animals.addAll(newAnimals);
	  }
	}
```
If we had multiple subclasses of animal, such as cat and dog, we might make the incorrect assumption that we can add them all to our farm:

```java
	farm.addAnimals(cats); // Compilation error
	farm.addAnimals(dogs); // Compilation error
```

This is because the compiler expects a collection of the concrete type animal, not one it subclasses.

Now, let's introduce an upper bounded wildcard to our add animals method:

> public void addAnimals(Collection<? extends Animal> newAnimals)

Now if we try again, our code will compile. This is because we are now telling the compiler to accept a collection of any subtype of animal.

### 11. What Is an Unbounded Wildcard?
**An unbounded wildcard is a wildcard with no upper or lower bound, that can represent any type.**

It's also important to know that the wildcard type is not synonymous to object. This is because a wildcard can be any type whereas an object type is specifically 
an object (and cannot be a subclass of an object). Let's demonstrate this with an example:
```java
	List<?> wildcardList = new ArrayList<String>();
	List<Object> objectList = new ArrayList<String>(); // Compilation error
```

Again, the reason the second line does not compile is that a list of objects is required, not a list of strings. 
The first line compiles because a list of any unknown type is acceptable.

### 12. What Is a Lower Bounded Wildcard?
**A lower bounded wildcard is when instead of providing an upper bound, we provide a lower bound by using the super keyword.**
In other words, a lower bounded wildcard means we are forcing the type to be a superclass of our bounded type.

```java
import java.util.ArrayList;
import java.util.List;

	public class LowerBound {
		public void Test() {
			List<Animal> animalList = new ArrayList<Animal>();
			List<Cat> catList = new ArrayList<Cat>();
			List<RedCat> redCatList = new ArrayList<RedCat>();
			List<Dog> dogList = new ArrayList<Dog>();

			// add list of super class Animal of Cat class
			addCat(animalList);

			// add list of Cat class
			addCat(catList);

			// compile time error
			// can not add list of subclass RedCat of Cat class
			// addCat(redCatList);

			// compile time error
			// can not add list of subclass Dog of Superclass Animal of Cat class
			// addCat.addMethod(dogList);
		}

		private void addCat(List<? super Cat> catList) {
			catList.add(new RedCat());
			System.out.println("Cat Added");
		}

	}

	class Animal {
	}

	class Cat extends Animal {
	}

	class RedCat extends Cat {
	}

	class Dog extends Animal {
	}
```
### 13. When Would You Choose to Use a Lower Bounded Type vs. an Upper Bounded Type?
**When dealing with collections, a common rule for selecting between upper or lower bounded wildcards is PECS. PECS stands for producer extends, consumer super.**

This can be easily demonstrated through the use of some standard Java interfaces and classes.

Producer extends just means that if you are creating a producer of a generic type, then use the extends keyword. Let's try applying this principle to a collection, 
to see why it makes sense:
```java
	public static void makeLotsOfNoise(List<? extends Animal> animals) {
		animals.forEach(Animal::makeNoise);   
	}
```
Here, we want to call makeNoise() on each animal in our collection. This means our collection is a producer, as all we are doing with it is getting it to return animals for us to perform our operation on. If we got rid of extends, we wouldn't be able to pass in lists of cats, dogs or any other subclasses of animals. By applying the producer extends principle, we have the most flexibility possible.

Consumer super means the opposite to producer extends. All it means is that if we are dealing with something which consumes elements, then we should use the super keyword. We can demonstrate this by repeating our previous example:
```java
public static void addCats(List<? super Animal> animals) {
    animals.add(new Cat());   
}
```
We are only adding to our list of animals, so our list of animals is a consumer. This is why we use the super keyword. It means that we could pass in a list of any superclass of animal, but not a subclass. For example, if we tried passing in a list of dogs or cats then the code would not compile.

The final thing to consider is what to do if a collection is both a consumer and a producer. An example of this might be a collection where elements are both added and removed. In this case, an unbounded wildcard should be used.

### 14. Are There Any Situations Where Generic Type Information Is Available at Runtime?
There is one situation where a generic type is available at runtime. This is when a generic type is part of the class signature like so:

> public class CatCage implements Cage<Cat>

By using reflection, we get this type parameter:
```java
	(Class<T>) ((ParameterizedType) getClass()
	  .getGenericSuperclass()).getActualTypeArguments()[0];
```
This code is somewhat brittle. For example, it's dependant on the type parameter being defined on the immediate superclass. But, it demonstrates the JVM does have this type information.

### 15 Generics and Primitive Data Types
**One restriction of generics in Java is that the type parameter cannot be a primitive type.**

For example, the following doesn't compile:
```java
	List<int> list = new ArrayList<>();
	list.add(17);
```
To understand why primitive data types don't work, let's remember that generics are a compile-time feature, meaning the type parameter is erased and all generic types are implemented as type Object.

Let's look at the add method of a list:
```java
	List<Integer> list = new ArrayList<>();
	list.add(17);
```

### 16 Multiple Bounds
A type can also have multiple upper bounds:

> <T extends Number & Comparable>
If one of the types that are extended by T is a class (e.g. Number), we have to put it first in the list of bounds. Otherwise, it will cause a compile-time error.

#### Reference's ####
01. https://www.baeldung.com/java-generics-interview-questions

