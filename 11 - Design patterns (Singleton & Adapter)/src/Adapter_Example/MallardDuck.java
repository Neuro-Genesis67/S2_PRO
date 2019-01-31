package Adapter_Example;

public class MallardDuck implements DuckInterface {

	@Override
	public void quack() {
		System.out.println("MallardDuck quacks");

	}

	@Override
	public void fly() {
		System.out.println("MallardDuck flies");

	}

}
