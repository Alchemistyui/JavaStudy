
public abstract class Triangle extends Shape implements Printable,Moveable {

	Triangle() {
		dimention1 = 4;
		dimention2 = 3;
	}

	public Triangle(int base, int height) {
		super();
		this.dimention1 = base;
		this.dimention2 = height;
	}

	public void print() {
		for (int i = 0; i < dimention2; i++) {
			for (int j = 0; j < dimention1; j++) {
				System.out.print("*");
				if (j > (1 + dimention1) * i / dimention2) {
					break;
				}
			}
			System.out.println();
		}
	}
 
}
