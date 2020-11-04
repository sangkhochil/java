
public class CustomFunctonalInterface {
	public void Example1() {
		HelloWorld hello = ()->{System.out.println("Hello World");};
		HelloWorld1 hello1 = str->System.out.println("Hello World " + str);
		hello.sayHelloWorld();
		hello1.sayHelloWorld("Ahnaf");
		
		HelloWorld2 hello2 = (a, b)->{return a + b;};
		int sum = hello2.getSum(2, 3);
		System.out.println("Sum (2 , 3) is " + sum);
		
		HelloWorld3 hello3 = a -> {return a*a;};
		int square = hello3.getSquare(3);
		System.out.println("Square of 3 is " + square);
	}
}

@FunctionalInterface	// optional
interface HelloWorld {
	void sayHelloWorld();
}

interface HelloWorld1 {
	void sayHelloWorld(String str);
}

interface HelloWorld2{
	int getSum(int a, int b);
}

interface HelloWorld3{
	int getSquare(int a);
}
