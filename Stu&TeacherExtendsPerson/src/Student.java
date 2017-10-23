
public class Student extends Person {

	int sID;
	String speciality;
	
	void setData(String name, char sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		
	}
	
	void setData(String name, char sex, int age, int sID, String speciality) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sID = sID;
		this.speciality = speciality;
	}
	
	String getDetail() {
		return "name: " + name + " sex: " + sex + " age: " + age + "studentID: " + sID + " speciality: " + speciality; 
	}
}
