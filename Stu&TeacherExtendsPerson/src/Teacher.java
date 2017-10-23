
public class Teacher extends Person{

	int tID;
	String department;
	
	void setData(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		
	}
	
	void setData(String name, char sex, int age, int sID, String department) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.tID = sID;
		this.department = department;
	}
	
	String getDetail() {
		return "name: " + name + " sex: " + sex + " age: " + age + "teacherID: " + tID + " department: " + department; 
	}
	
}
