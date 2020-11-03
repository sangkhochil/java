import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Employee2 implements Externalizable {
	int employeeId;
	String employeeName;
	String department;
	String nationality;

	public Employee2() {

	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		employeeId = in.readInt();
		employeeName = (String) in.readObject();
		department = (String) in.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(employeeId);
		out.writeObject(employeeName);
		out.writeObject(department);
	}
}
