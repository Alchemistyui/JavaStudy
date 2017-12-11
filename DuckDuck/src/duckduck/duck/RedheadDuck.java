package duckduck.duck;
 

import duckduck.Duck;
import duckduck.behavior.FlyWithWings;
import duckduck.behavior.QuackWawa;
 
public class RedheadDuck extends Duck {

	public RedheadDuck() {
		this.flyBehavior = new FlyWithWings();
		this.quackBehavior = new QuackWawa();
	}

 	public void display() {
		System.out.println("这是一只红头鸭");
	}

}
