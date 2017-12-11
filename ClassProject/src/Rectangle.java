
public class Rectangle extends Shape implements Printable,Moveable {

	Rectangle() {
		dimention1 = 5;
		dimention2 = 4;
	}

	public Rectangle(int length, int width) {
		this.dimention1 = length;
		this.dimention2 = width;
	}

	public void print() {
		for (int i = 0; i < dimention1; i++) {
			for (int j = 0; j < dimention2; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
