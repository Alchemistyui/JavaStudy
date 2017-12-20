package Chapter3.Array;

public class SortArray {

	public static void main(String[] args) {
		int SIZE = 6;
		int temp;
		int[] sim = {7,2,3,8,6,1};
		
		for (int i = 0; i < SIZE; i++) {
			for (int j =i+1; j < SIZE; j++ ) {
				if (sim[i] > sim[j]) {
					temp = sim[i];
					sim[i] = sim[j];
					sim[j] = temp;
				}
			}
		}
		
		for (int i = 0; i < SIZE; i++) {
			System.out.println(sim[i]);
		}
		
	}

}
