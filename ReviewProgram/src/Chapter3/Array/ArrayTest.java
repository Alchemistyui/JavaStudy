package Chapter3.Array;
import java.util.Scanner;

public class ArrayTest {
	
// method 1
//	public static void main(String[] args) {
//		int fib[] = new int[10];
//		fib[0] = 1;
//		fib[1] = 1;
//		for (int i = 2; i < 10; i++) {
//			fib[i] = fib[i-1] + fib[i-2];
//		}
//		
//		for (int i = 0; i < 10; i++) {
//			System.out.println(fib[i]);
//		}
//	}

	static int fibonacci(int i) {
		if (i <= 0) {
			System.out.println("wrong input!");
		}
		if (i==1 || i==2) {
			return 1;
		}
		else {
			return fibonacci(i-1) + fibonacci(i-2);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("input: ");
		Scanner sc = new Scanner(System.in);
		
		
		int max = sc.nextInt();
		for (int i = 0; i<max;i++) {
			System.out.println(fibonacci(i+1));
		}
		
		
	}
}
