package Chapter6.Interface;

public class PrintFlower implements Print{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Print flower = new PrintFlower();
		Print grass = new PrintGrass();
		flower.print();
		grass.print();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("flower");
	}

}

class PrintGrass implements Print {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("grass");
	}
	
}

interface Print {
	void print();
}
