class Point {
	int x, y;
	
	Point() {
		x = 0;
		y = 0;
	}
	
	void setX(int xx) {
		x = xx;
	}
	
	void setY (int yy) {
		y = yy;
	}
	
	void getPoint() {
		System.out.println("Point: (" + x + "," + y + ")");
	}
	
	void movePoint(int xx, int yy) {
		x += xx;
		y += yy;
	}
}

public class TestPoint {

	public static void main(String[] args) {
		Point p = new Point();
		
		p.getPoint();
		
		p.movePoint(10, 20);
		p.getPoint();

	}

}
