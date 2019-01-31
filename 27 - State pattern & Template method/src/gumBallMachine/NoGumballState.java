package gumBallMachine;

public class NoGumballState implements State {

	GumballMachine gumballMachine;

	public NoGumballState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("A quarter is inserted");
		System.out.println("A quarter is ejected");
		System.out.println("The machine has no gumballs left");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Nothing to eject");

	}

	@Override
	public void turnCrank() {
		System.out.println("Nothing happens");

	}

}
