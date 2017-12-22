package Chapter7.Exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			int a = 0;
			int b = 9 / a;
		}
		catch(ArithmeticException e) {
			System.out.println("Exception message: " + e.getMessage());
			System.out.println("Exception message: " + e.toString());
		}
		
		try {
			throwException();
		}
		catch (NumberOverTen e){
			System.out.println("catch NumberOverTen");
		}
		
	}

	static void throwException() throws NumberOverTen {
		throw new NumberOverTen();
	}
	
}


class NumberOverTen extends Throwable {
	NumberOverTen() {
		System.out.println("number should less than ten..");
	}
}
