package duckduck.duck;
import duckduck.Duck;
import duckduck.behavior.FlyNoWay;
import duckduck.behavior.QuackGaga;

public class RubberDuck extends Duck {

	public	RubberDuck() {
		this.flyBehavior = new FlyNoWay();
		this.quackBehavior = new QuackGaga();
	}

	@Override
	public void display() {
		System.out.println("这是一只不会飞的橡皮鸭子");
	}

}
