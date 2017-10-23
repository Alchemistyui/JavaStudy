
public class Person {

	String name;
	char sex;
	int age;
	
	Person() {
		
	}
	
	Person(String n, char s, int a) {
		name = n;
		sex = s;
		age = a;
	}
	
	void setData(String n, char s, int a) {
		name = n;
		sex = s;
		age = a;
	}
	
	String getData() {
		return "name: " + name + " sex: " + sex + " age: " + age; 
	}
	
	public static void main(String[] args) {
		Person p = new Student("大彪",'女',18,220203031,03);
		
		System.out.print(p.getData());

	}

}
