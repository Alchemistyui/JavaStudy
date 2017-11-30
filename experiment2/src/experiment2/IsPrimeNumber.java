package experiment2;

import java.lang.Math;

public class IsPrimeNumber {

	int a[];
	int length;

	IsPrimeNumber(int n) {
		length = n;
		a = new int[length + 1];
	}

	public static void main(String[] args) {

		IsPrimeNumber num = new IsPrimeNumber(10);

		

		for (int i = 1; i <= num.length; i++) {
			int root = (int) Math.sqrt(i);
			for (int j = 2; j <= root; j++) {
				if (i % j == 0) {
					num.a[i] = 1;
					break;
				} else {
					num.a[i] = 0;
				}
			}
		}
		
		for (int i = 1; i <= num.length; i++) {
			System.out.print(num.a[i] + "\t");
		}

	}

}
