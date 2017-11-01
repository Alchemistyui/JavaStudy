
public class TestArray {

	public static void main(String[] args) {
		
		int num = 5;
		//n仅用于初始化数组
		int n = 5;
		int[] a = new int[num];
		int temp = 0;
		
		
		for (int i = 0; i < num; i++) {
			a[i] = n--;
		}

		for(int i = 0; i < num -1; i++) {
			for (int j = 0; j < num - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
			
			System.out.println(a[i]);
		}
		
	}

}
