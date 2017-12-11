package duckduck.duck;

import duckduck.Duck;
import duckduck.behavior.FlyNoWay;
import duckduck.behavior.QuackNoWay;

public class WoodenDuck extends Duck {

	public WoodenDuck() {
		this.flyBehavior = new FlyNoWay();
		this.quackBehavior = new QuackNoWay();
	}

	@Override
	public void display() {
		System.out.println("这是一只不会飞的木头鸭子");
	}

}
