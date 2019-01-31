package stateTekken;

public class Recovering implements FighterState {

	Fighter fighter;
	Fighter opponent;

	public Recovering(Fighter fighter, Fighter opponent) {
		this.fighter = fighter;
		this.opponent = opponent;
	}

	@Override
	public void block() {
		System.out.println(fighter.getName() + " needs to recover first");
	}

	@Override
	public void lightAttack() {
		System.out.println(fighter.getName() + " needs to recover first");
	}

	@Override
	public void heavyAttack() {
		System.out.println(fighter.getName() + " needs to recover first");
	}

	@Override
	public void recover() {
		System.out.println("|" + fighter.getName() + " has now fully recovered" + "|" + "\n");
		fighter.setState(fighter.ready);
		fighter.setTurn(false);
		opponent.setTurn(true);
	}

}
