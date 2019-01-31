package stateTekken;

public class Fighter {

	String name;
	int health;
	Fighter opponent;
	boolean turn = false;

	FighterState ready;
	FighterState blocking;
	FighterState recovering;
	FighterState state;

	public Fighter(String name, int health) {
		this.name = name;
		this.health = health;
	}

	public void setOpponent(Fighter opponent) {
		this.opponent = opponent;
		ready = new Ready(this, opponent);
		blocking = new Blocking(this, opponent);
		recovering = new Recovering(this, opponent);
		state = ready;
	}

	void setState(FighterState newState) {
		this.state = newState;
	}

	public FighterState getState() {
		return state;
	}

	void block() {
		state.block();
	}

	void lightAttack() {
		state.lightAttack();
	}

	void heavyAttack() {
		state.heavyAttack();
	}

	void recover() {
		state.recover();
	}

	public void setTurn(boolean trueFalse) {
		this.turn = trueFalse;
	}

	public FighterState getReady() {
		return ready;
	}

	public FighterState getBlocking() {
		return blocking;
	}

	public FighterState getRecovering() {
		return recovering;
	}

	String getName() {
		return name;
	}

	String getHealth() {
		return "(" + health + ")";
	}

}
