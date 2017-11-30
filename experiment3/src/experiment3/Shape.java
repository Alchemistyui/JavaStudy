package experiment3;

import java.lang.Math;

public abstract class Shape {

	int measure1, measure2;

	abstract int size();

	public static void main(String[] args) {
		Rectangle rect = new Rectangle(4, 5);
		Triangle tri = new Triangle(4, 5);
		Pillar pillar = new Pillar(2, 3);

		System.out.println("the area of rect is:" + rect.size());
		System.out.println("the area of tri is:" + tri.size());
		System.out.println("the pillar of tri is:" + pillar.size());
	}

}

class Rectangle extends Shape {

	Rectangle(int width, int height) {
		measure1 = width;
		measure2 = height;
	}

	@Override
	int size() {

		return measure1 * measure2;
	}

}

class Triangle extends Shape {

	Triangle(int bottom, int height) {
		measure1 = bottom;
		measure2 = height;
	}

	@Override
	int size() {

		return measure1 * measure2 / 2;
	}
}

class Pillar extends Shape {
	Pillar(int radius, int height) {
		measure1 = radius;
		measure2 = height;
	}

	@Override
	int size() {

		return (int) (measure1 * measure1 * Math.PI * measure2);
	}
}
