import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		//Employee.myTest();
		//System.out.println(Exception3.exceptionTest());
		//System.out.println(new HelloTryCatch().Test());
		try {
			String str1="Hello";
			str1.concat("world");
			System.out.println(str1);
			System.out.println(new Exception3().exceptionTest());
			System.out.println(new Exception3().exceptionTest_001());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		try {
//			
//		} catch(Exception ex) {
//			ex.printStackTrace();
//		}		
	}
}

class HelloTryCatch {
	
	public int Test() {
		int a = 10;
		try {
			a = a/0;
			return a;
		} catch (Exception e) {
			return a+10;
		}
		finally {
			a = 11;
			return a;
		}
		//return a;
	}
	
	public int Test1() throws Exception {
		try {
			throw new Exception("Custom exception0");
			//return 10;
		} catch(Exception ex) {
			throw new Exception("Custom exception1");
		}
		finally {
			throw new Exception("Custom exception2");
		}		
	}
}
class Employee {
	public String name;

	@Override
	public int hashCode() {
		return 31;
	}

	public static void myTest() {
		Employee employeeOne = new Employee();
		Employee employeeTwo = new Employee();
		employeeOne.name = "John";
		employeeTwo.name = "John";
		HashSet employeeSet = new HashSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		System.out.println(employeeSet.size());
	}
}
class Exception3 {

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
	
	public static int exceptionTest_001() {
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
