package Adapter_Example;

public class MainApp {

	public static void main(String[] args) {

		MallardDuck mDuck = new MallardDuck();
		VietnameseTurkey vTurkey = new VietnameseTurkey();
		DuckInterface TurkeyAdapter = new TurkeyAdapter(vTurkey);

		System.out.println("The vietnamese turkey says:");
		vTurkey.gobble();
		vTurkey.fly();

		System.out.println("\nThe mallard duck says:");
		mDuck.quack();
		mDuck.fly();
	}

	static void testDuck(DuckInterface duck) {
		duck.quack();
		duck.fly();
	}

}
