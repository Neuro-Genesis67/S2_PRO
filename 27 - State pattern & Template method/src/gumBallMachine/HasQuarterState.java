package gumBallMachine;

public class HasQuarterState implements State {

	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("A quarter is already inserted");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("A quarter is ejected");
		gumballMachine.setState(gumballMachine.noQuarterState);
	}

	@Override
	public void turnCrank() {
		if (gumballMachine.gumballs > 0) {
			gumballMachine.releaseGumBall();
			gumballMachine.setState(gumballMachine.noQuarterState);
		} else {
			System.out.println(
					"The machine is out of gumballs, usually we'd just steal your quarter, but the programmer who made me is really smart I tells ya, here's your quarter back.");

			gumballMachine.setState(gumballMachine.noGumballState);
		}
	}

}
