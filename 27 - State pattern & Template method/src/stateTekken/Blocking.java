package stateTekken;

public class Blocking implements FighterState {

	Fighter fighter;
	Fighter opponent;

	public Blocking(Fighter fighter, Fighter opponent) {
		this.fighter = fighter;
		this.opponent = opponent;
	}

	@Override
	public void block() {
		System.out.println("|" + fighter.getName() + " is blocking" + "|" + "\n");
		fighter.setTurn(false);
		opponent.setTurn(true);
	}

	@Override
	public void lightAttack() {
		System.out.println("Don't think this part will be accessed...");

	}

	@Override
	public void heavyAttack() {
		System.out.println("Don't think this part will be accessed...");

	}

	@Override
	public void recover() {
		System.out.println("Don't think this part will be accessed...");

	}

}
