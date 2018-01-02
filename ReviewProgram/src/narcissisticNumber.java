import java.util.Scanner;

public class narcissisticNumber {

	public static void main(String[] args) {
		System.out.println("inter a number");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int[] last = new int[10];
		int first = number;
		int i = 0;
		int sum = 0;
		 
		while(number/1 != 0) {
			last[i] = number%10;
			i++;
			number = number/10;
		}
		
		for(int j = 0;j<i;j++) {
			sum += last[j]*last[j]*last[j];
			
		}
		
		if (sum == first) {
			System.out.println("narcissisticNumber");
		}
		else {
			System.out.println("not a narcissisticNumber");
		}
	}
}
