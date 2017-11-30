package experiment3;

public class GradeTest {

	public static void main(String[] args) {
		Grade myGrade = new Grade("大彪", "2016220203031", "陈老师", "001", "Java程序设计", 99);

		myGrade.showGrade();
	}

}

class Student {
	String stuName;
	String stuID;

	Student(String name, String id) {
		stuName = name;
		stuID = id;
	}
}

class Teacher {
	String tchrName;
	String tchrID;

	Teacher(String name, String id) {
		tchrName = name;
		tchrID = id;
	}
}

class Course {
	String courseName;

	Course(String name) {
		courseName = name;
	}
}

class Grade {
	Student stu;
	Teacher tchr;
	Course course;
	int grade;

	Grade(String stuName, String stuID, String tchrName, String tchrID, String courseName, int grade) {
		stu = new Student(stuName, stuID);
		tchr = new Teacher(tchrName, tchrID);
		course = new Course(courseName);
		this.grade = grade;

	}

	void showGrade() {
		System.out.println("student name: " + stu.stuName + " student ID: " + stu.stuID + " teacher name: "
				+ tchr.tchrName + " teacher ID: " + tchr.tchrID + " course: " + course.courseName + " grade: " + grade);
	}
}
