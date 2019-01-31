package Adapter_Example;

public class VietnameseTurkey implements TurkeyInterface {

	@Override
	public void gobble() {
		System.out.println("Turkey Gobbles");
	}

	@Override
	public void fly() {
		System.out.println("Turkey flies a short distance");

	}

}
