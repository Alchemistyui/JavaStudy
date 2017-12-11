package duckduck;

//import duckduck.behavior.FlyBehavior;
import duckduck.behavior.QuackBehavior;
import duckduck.duck.MallardDuck;
import duckduck.duck.RedheadDuck;
import duckduck.duck.RubberDuck;
import duckduck.duck.WoodenDuck;

public abstract class Duck {

	protected duckduck.behavior.FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	private void swim() {
		System.out.println("游啊游 游啊游");
	}

	public abstract void display();

	void performFly() {
		flyBehavior.fly();
	}

	void performQuack() {
		quackBehavior.quack();
	}

	public static void main(String args[]) {
		Duck[] ducks = new Duck[20];
		for (int i = 0; i < ducks.length; i++) {
			if (i * 17 % 7 < 2) {
				ducks[i] = new RedheadDuck();
			} else if (i * 17 % 7 < 4) {
				ducks[i] = new MallardDuck();
			} else if (i * 17 % 7 < 6) {
				ducks[i] = new RubberDuck();
			} else {
				ducks[i] = new WoodenDuck();
			}
		}

		for (Duck duck : ducks) {
			duck.display();
			duck.performFly();
			duck.performQuack();
		}
	}

}
