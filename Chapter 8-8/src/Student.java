
public class Student implements Person {
	String name;
	char sex;
	String birthday;
	String sID;
	String speciality;
	
	
	public void setData(String name, char sex, String birthday) {
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		
	}
	
	public String getData() {
		
		return " name: " + name + " sex: " + " birthday: " + birthday;
	}

	void setOwnData(String id, String spec) {
		sID = id;
		speciality = spec;
	}
	
	String getOwnData() {
		return " student ID: " + sID + " speciality: " + speciality;
	}
	
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setData("大彪", '女', "1999-03-11");
		stu.setOwnData("2016220203031", "软件技术");
		
		System.out.println(stu.getData());
		System.out.println(stu.getOwnData());
	}

}
