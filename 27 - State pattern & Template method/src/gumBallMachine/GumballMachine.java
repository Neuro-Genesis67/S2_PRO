package gumBallMachine;

public class GumballMachine implements State {

	State noGumballState;
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State state;
	int gumballs;

	public GumballMachine(int gumballsInMachine) {
		this.gumballs = gumballsInMachine;
		noGumballState = new NoGumballState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		state = noQuarterState;
		if (gumballs > 0) {
			state = noQuarterState;
		}
	}

	@Override
	public void insertQuarter() {
		state.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		state.turnCrank();
	}

	void setState(State state) {
		this.state = state;
	}

	void releaseGumBall() {
		System.out.println(
				"The machine releases a gumball. Enjoy your processed, temporary, unhealthy, tiny, rubbery piece of short lived, fleeting gratification");
		gumballs--;
	}

}
