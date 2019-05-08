package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import immutable.Student;

public class Main {

	private final static Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		List<String> courses = new ArrayList<String>();
		courses.add("Math");
		courses.add("PE");
		Student student = new Student("Jon","Snow",new Date(),22,courses);
		
		logger.info(student.toString());
		Iterator<String> iter = student.getListOfCourses().iterator();
		while(iter.hasNext()) {
			logger.info(iter.next());
		}
	}

}
