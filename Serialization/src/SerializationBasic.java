import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationBasic {
	public void Serialize_1() {
		Employee emp = new Employee();
		emp.setEmployeeId(1001);
		emp.setEmployeeName("Ahnaf");
		emp.setDepartment("CSE");
		try {
			FileOutputStream fileOut = new FileOutputStream("employee.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void DeSerialize_1() {
		Employee emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employee) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getEmployeeName());
		System.out.println("Department: " + emp.getDepartment());
	}

	public void Serialize_2() {
		Employee2 emp = new Employee2();
		emp.setEmployeeId(1001);
		emp.setEmployeeName("Ahnaf");
		emp.setDepartment("CSE");

		// Serialize
		try {
			FileOutputStream fileOut = new FileOutputStream("employee2.ser");
			ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
			outStream.writeObject(emp);
			outStream.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}

		// Deserialize
		emp = null;
		try {
			FileInputStream fileIn = new FileInputStream("employee2.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employee2) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}
		System.out.println("Deserialized Employee...");
		System.out.println("Emp id: " + emp.getEmployeeId());
		System.out.println("Name: " + emp.getEmployeeName());
//		System.out.println("Department: " + emp.getDepartment());
	}
}
