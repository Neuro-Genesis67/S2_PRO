package Adapter_Example;

public class TurkeyAdapter implements DuckInterface {

	VietnameseTurkey turkey;

	public TurkeyAdapter(VietnameseTurkey turkey) {
		this.turkey = turkey;
	}

	public void quack() {
		turkey.gobble();
	}

	@Override
	public void fly() {
		turkey.fly();
	}

}
