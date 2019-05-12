package immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {

	private final String name;
	private final String lastName;
	private final Date birthDay;
	private final int age;
	private final List<String> listOfCourses;
	
	public Student(String name, String lastName, Date birthDay, int age, List<String> listOfCourses) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.age = age;
		this.listOfCourses = listOfCourses;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDay() {
		return new Date(this.birthDay.getTime());
	}

	public int getAge() {
		return new Integer(this.age);
	}

	public List<String> getListOfCourses() {
		return new ArrayList<String>(this.listOfCourses);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", lastName=" + lastName + ", birthDay=" + birthDay + ", age=" + age
				+ ", listOfCourses=" + listOfCourses + "]";
	}	
}
