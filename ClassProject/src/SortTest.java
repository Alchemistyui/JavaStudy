import java.util.Arrays;
import java.util.Random;

public class SortTest {

	public static void main(String[] args) {
		SortTest sort = new SortTest();
		int[] array = new int[200000];
		Random rand = new Random();
		for (int i = 0; i < array.length; i++)
			array[i] = rand.nextInt(100);
		long startTime = System.currentTimeMillis();
		sort.mergeSort(array, 0, array.length);
		System.out.println("Sorting time:" + (System.currentTimeMillis() - startTime));
//		sort.print(array);
	}

	static int threshold = 1000;

	public void mergeSort(int[] array, int s, int e) {
		if ((e - s) < threshold) {
			sort(array, s, e);
		} else {
			Thread t1 = new Thread() {
				public void run() {
					mergeSort(array, s, s + (e - s) / 2);
				}
			};
			Thread t2 = new Thread() {
				public void run() {
					mergeSort(array, s + (e - s) / 2, e);
				}
			};
			t1.start();
			t2.start();
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			merge(array, s, s + (e - s) / 2, s + (e - s) / 2, e);
		}
	}

	public void merge(int[] array, int s1, int e1, int s2, int e2) {
		int[] array1 = Arrays.copyOfRange(array, s1, e1);
		int[] array2 = Arrays.copyOfRange(array, s2, e2);
		int i = 0;
		int j = 0;
		int k = s1;
		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				array[k++] = array1[i++];
			} else {
				array[k++] = array2[j++];
			}
		}
		while (i < array1.length)
			array[k++] = array1[i++];
		while (j < array2.length)
			array[k++] = array2[j++];
		// print(array1);
		// print(array2);
		// print(array, s1, e2);
	}

	public void sort(int[] array, int s, int e) {
		for (int i = s; i < e; i++)
			for (int j = i + 1; j < e; j++) {
				if (array[i] > array[j]) {
					array[i] = array[i] ^ array[j];
					array[j] = array[i] ^ array[j];
					array[i] = array[i] ^ array[j];
				}
			}
	}

	public void print(int[] array) {
		System.out.print("array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public void print(int[] array, int s, int e) {
		System.out.print("array: ");
		for (int i = s; i < e; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
