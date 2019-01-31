package gumBallMachine;

public class NoQuarterState implements State {

	GumballMachine gumballMachine;

	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("A quarter has been inserted");
		gumballMachine.setState(gumballMachine.hasQuarterState);
	}

	@Override
	public void ejectQuarter() {
		System.out.println("No quarters to eject");

	}

	@Override
	public void turnCrank() {
		System.out.println("Nothing comes out since there are no quarters in the machine");
	}

}
