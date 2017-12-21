package Chapter6.Interface;

public class Student implements Person {
	String name;
	char sex;
	String birthday;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Person bigbiao = new Student();
		bigbiao.setData("bigbiao", '女', "1999-03-11");
		bigbiao.getData();
	}

	@Override
	public void setData(String name, char sex, String birthday) {
		// TODO Auto-generated method stub
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		
	}

	@Override
	public void getData() {
		// TODO Auto-generated method stub
		System.out.println(name+' '+sex+' '+birthday);
	}

}

interface Person {
	void setData( String name,char sex, String birthday);
	void getData();
}