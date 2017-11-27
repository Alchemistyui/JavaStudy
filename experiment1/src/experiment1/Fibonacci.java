package experiment1;

import java.util.Scanner;

public class Fibonacci {

	int num;

	Fibonacci(int number) {
		num = number;
	}

	 int countFibonacci(int n) {
		

		if (n == 1 || n == 2) {
			return 1;
		} else {
			return countFibonacci(n - 1) + countFibonacci(n - 2);
		}
		
	}
	
	void print(int number) {
		int n = number;
		
		for (int i = 1; i <= n; i++) {
			System.out.print(countFibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("请输入一个整数：");
		int number = scanner.nextInt();

		Fibonacci fib = new Fibonacci(number);
		fib.print(number);
	}

}
