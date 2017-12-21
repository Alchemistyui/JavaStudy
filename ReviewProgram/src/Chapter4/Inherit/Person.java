package Chapter4.Inherit;

abstract public class Person {
	String name;
	char sex;
	int age;
	abstract void setData(String name, char sex, int age) ;
	abstract String getDetail();

	public static void main(String[] args) {

		Person stu = new Student();
		stu.setData("big biao", '女', 18);
		Person tech = new Teacher();
		tech.setData("emm", '女', 20);
		
		System.out.println(stu.getDetail());
		System.out.println(tech.getDetail());
	}
}


class Student extends Person {

	@Override
	void setData(String name, char sex, int age) {
		// TODO Auto-generated method stub
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	@Override
	String getDetail() {
		// TODO Auto-generated method stub
		return "Student name: "+ name + "sex: " + sex + "age: " + age;
	}
	
}


class Teacher extends Person {

	@Override
	void setData(String name, char sex, int age) {
		// TODO Auto-generated method stub
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	@Override
	String getDetail() {
		// TODO Auto-generated method stub
		return "Teacher name: "+ name + "sex: " + sex + "age: " + age;
	}
	
}


