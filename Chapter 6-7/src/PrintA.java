
public class PrintA implements Print {

	
	@Override
	public void print() {
		System.out.println("A");
		
	}

	public static void main(String[] args) {
		Print a = new PrintA();
		Print b = new PrintB();
		
		a.print();
		b.print();

	}

}
