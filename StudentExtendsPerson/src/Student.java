
public class Student extends Person {

	int sID;
	int classNo;
	
	Student(String n, char s, int a, int id, int no) {
		name = n;
		sex = s;
		age = a;
		sID = id;
		classNo = no;
	}
	
	void setData(String n, char s, int a, int id, int no) {
		name = n;
		sex = s;
		age = a;
		sID = id;
		classNo = no;
	}
	
	String getData() {
		return "name: " + name + " sex: " + sex + " age: " + age + "studentID: " + sID + " class: " + classNo; 
	}
}
