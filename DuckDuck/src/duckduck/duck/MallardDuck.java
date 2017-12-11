package duckduck.duck;

import duckduck.Duck;
import duckduck.behavior.FlyWithWings;
import duckduck.behavior.QuackGaga;

public class MallardDuck extends Duck {

	public MallardDuck() {
		this.flyBehavior = new FlyWithWings();
		this.quackBehavior = new QuackGaga();
	}

	@Override
	public void display() {
		System.out.println("这是一只绿头的野鸭...");
	}

}
