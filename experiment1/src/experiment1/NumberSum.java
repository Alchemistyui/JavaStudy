package experiment1;

import java.util.Scanner;

public class NumberSum {

	int integer;
	int sum;

	NumberSum(int integer) {
		this.integer = integer;
		sum = 0;
	}

	int addNumber() {
		for (; integer > 0; integer /= 10) {
			int number = integer % 10;
			sum += number;
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("请输入一个整数：");
		int integer = scanner.nextInt();
		NumberSum num = new NumberSum(integer);

		System.out.println("这个整数的各位数字之和为：" + num.addNumber());

	}

}
