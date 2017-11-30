package experiment2;

public abstract class FigureArea {

	int measure1, measure2;
	
	 abstract int size();
	 
	 public static void main(String[] args) {
		 Rectangle rect = new Rectangle(4, 5);
		 Triangle tri = new Triangle(4, 5);
		 
		 System.out.println("the area of rect is:" + rect.size());
		 System.out.println("the area of tri is:" + tri.size());
	 }
}

class Rectangle extends FigureArea {

	Rectangle(int width, int height) {
		measure1 = width;
		measure2 = height;
	}

	@Override
	int size() {
		
		return measure1 * measure2;
	}
	
}

class Triangle extends FigureArea {
	
	Triangle(int bottom, int height) {
		measure1 = bottom;
		measure2 = height;
	}
	
	@Override
	int size() {
		
		return measure1 * measure2 / 2;
	}
}