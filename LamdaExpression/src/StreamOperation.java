import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperation {
	public void Example1() {
		List<Student> studentList = createStudentList();

		// Filter all male students
		List maleStudents = studentList.stream().filter(s -> s.getGender().equalsIgnoreCase("M"))
				.collect(Collectors.toList());
		
		System.out.println("Male students are :" + maleStudents);

		// Filter based on name
		Student student = (Student) studentList.stream().filter(s -> s.getName().equalsIgnoreCase("John")).findAny().orElse(null);
		System.out.println("Student with Name john :" + student);
		
		// Filter based on age
		Student student1 = (Student) studentList.stream().filter(s -> s.getAge() < 20).findFirst().orElse(null);
		System.out.println("Student with Name john :" + student1);
	}

	private List<Student> createStudentList() {
		List studentList = new ArrayList<Student>();
		Student s1 = new Student(1, "Jahangir", "M", 19);
		Student s2 = new Student(2, "John", "M", 17);
		Student s3 = new Student(3, "Monalisa", "F", 14);
		Student s4 = new Student(4, "Dav", "M", 21);
		Student s5 = new Student(5, "Ava", "F", 16);
		Student s6 = new Student(6, "King of London", "F", 20);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		return studentList;
	}
}
