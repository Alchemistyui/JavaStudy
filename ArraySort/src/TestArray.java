
class ArraySort {
	
	int num = 5;
	int[] sim = new int[num];
	
	ArraySort (int[] n) {
		for (int i = 0; i < num; i++) {
			sim[i] = n[i];
			System.out.println(sim[i]);
		}
	}
	
	void setOrder() {
		int temp = 0;
			
		for(int i = 0; i < num -1; i++) {
			for (int j = 0; j < num - 1 - i; j++) {
				if (sim[j] > sim[j + 1]) {
					temp = sim[j];
					sim[j] = sim[j+1];
					sim[j+1] = temp;
				}
			}
		}
	}
}



public class TestArray {

	public static void main(String[] args) {
		int[] a = {5,4,3,2,1};
		
		ArraySort b = new ArraySort(a);

		System.out.println("sort---------");
		
		b.setOrder();
		for (int i = 0; i < b.num; i++) {
			System.out.println(b.sim[i]);
		}
	}

}
