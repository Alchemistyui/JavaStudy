
public class Array {

	int[][] a = new int[2][3];
	int n = 1;
	
	void init() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = n++;
				System.out.println(a[i][j]);
			}
		}
	}
	
	
	public static void main(String[] args) {
		Array a = new Array();
		
		a.init();
		
	}

}
