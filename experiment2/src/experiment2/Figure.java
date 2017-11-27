package experiment2;

public abstract class Figure {

	int measure1, measure2;
	
	 int size() {
		 return measure1 * measure2;
	 }
}

class Rectangle extends Figure {

	Rectangle(int width, int height) {
		measure1 = width;
		measure2 = height;
	}
	
}
