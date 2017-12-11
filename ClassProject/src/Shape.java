
public abstract class Shape {
	int dimention1;
	int dimention2;

	static void aaa() {

	}

	public int getDimention1() {
		return dimention1;
	}

	public void setDimention1(int dimention1) {
		this.dimention1 = dimention1;
	}

	public int getDimention2() {
		return dimention2;
	}

	public void setDimention2(int dimention2) {
		this.dimention2 = dimention2;
	}

	public static void main(String args[]) {
		Moveable m = new Rectangle(4, 5);
		m.move();
	}

}
