package stateTekken;

public class Ready implements FighterState {

	Fighter fighter;
	Fighter opponent;

	public Ready(Fighter fighter, Fighter opponent) {
		this.fighter = fighter;
		this.opponent = opponent;

	}

	@Override
	public void block() {
		fighter.setState(fighter.blocking);
		System.out.println("|" + fighter.getName() + " is now blocking" + "|" + "\n");
		fighter.setTurn(false);
		opponent.setTurn(true);
	}

	@Override
	public void lightAttack() {
		System.out.println("|" + fighter.getName() + " used light attack" + "|");

		if (opponent.getState().equals(opponent.blocking)) {
			System.out.println("-" + opponent.getName() + " blocked the attack");
			opponent.setState(opponent.ready);

		} else {
			opponent.health -= 10;
			System.out.println("-" + opponent.getName() + " lost 10 health");
			opponent.setState(opponent.ready);
		}

		fighter.setState(fighter.ready);
		fighter.setTurn(false);
		opponent.setTurn(true);
	}

	@Override
	public void heavyAttack() {
		System.out.println("|" + fighter.getName() + " used heavy attack" + "|");

		if (opponent.getState().equals(opponent.blocking)) {
			System.out.println("-" + opponent.getName() + " blocked the attack");
			opponent.setState(opponent.ready);
			fighter.setState(fighter.recovering);
			System.out.println("-" + fighter.getName() + " is now recovering\n");
		} else {
			opponent.health -= 20;
			opponent.setState(opponent.recovering);
			System.out.println("-" + opponent.getName() + " lost 20 health");
			System.out.println("-" + opponent.getName() + " is now recovering\n");
			fighter.setState(fighter.ready);
		}

		fighter.setTurn(false);
		opponent.setTurn(true);
	}

	@Override
	public void recover() {

		System.out.println("|" + fighter.getName() + " is already fully recovered" + "|");

	}

}
