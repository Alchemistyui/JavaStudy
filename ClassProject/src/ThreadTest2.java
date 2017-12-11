import java.util.Arrays;
import java.util.Random;

public class ThreadTest2 {
	public static void main(String args[]) {

		Random rand = new Random();
		int[] array = new int[10000000];
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(10000);
		System.out.println(System.currentTimeMillis());
		mergeSort(array);
//		print(array);
		System.out.println(System.currentTimeMillis());
	}

	public static int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
				}
			}
		}
		return array;
	}

	static int threshold = 100000;

	public static void mergeSort(int[] array) {
		if (array.length > threshold) {
			int[] arrayLeft = Arrays.copyOfRange(array, 0, array.length / 2 + 1);
			int[] arrayRight = Arrays.copyOfRange(array, array.length / 2 + 1, array.length);
			Thread t1=new Thread() {
				public void run() {
					mergeSort(arrayLeft);
				}
			};
			Thread t2=new Thread() {
				public void run() {
					mergeSort(arrayRight);
				}
			};
			t1.start();
			t2.start();
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			merge(arrayLeft, arrayRight, array);
		} else {
			sort(array);
		}
	}

	private static void merge(int[] arrayLeft, int[] arrayRight, int[] array) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arrayLeft.length && j < arrayRight.length) {
			if (arrayLeft[i] < arrayRight[j]) {
				array[k] = arrayLeft[i];
				k++;
				i++;
			} else {
				array[k] = arrayRight[j];
				k++;
				j++;
			}
		}
		while (i < arrayLeft.length) {
			array[k] = arrayLeft[i];
			k++;
			i++;
		}
		while (j < arrayRight.length) {
			array[k] = arrayRight[j];
			k++;
			j++;
		} 
	}

	public static void print(int[] array) {
		System.out.print("array:  ");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
