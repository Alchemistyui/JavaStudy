
abstract public class Person {

	String name;
	char sex;
	int age;
	abstract void setData(String name, char sex, int age);
	abstract String getDetail();
	
	public static void main(String[] args) {

        Student s = new Student();
        s.setData("大彪",'女',18,220203031,"软件技术");
		System.out.print(s.getDetail());
		System.out.println();
		
		Person t = new Teacher();
		t.setData("陈老师", '男', 20);
		System.out.print(t.getDetail());
	}

}
