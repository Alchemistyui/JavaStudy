
public class handleException {
	
	
	public static void main(String[] args) {
		try {
			System.out.println("ArithmeticException:");
			int i = 5 / 0;
		} catch (ArithmeticException a){
			System.out.println("Exception message: " + a.getMessage());
		}
		try {
			System.out.println("IndexOutOfBoundsException:");
			int a[] = new int[2];
			a[3] = 1;
		} catch (IndexOutOfBoundsException i){
			System.out.println("Exception message: " + i.getMessage());
		}
		try {
			System.out.println("NullPointerException:");
			int i[] = null;
			System.out.println(i.length);
		} catch (NullPointerException n){
			System.out.println("Exception message: " + n.getMessage());
		}

		

	}

}
