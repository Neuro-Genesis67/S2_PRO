package forsikring;

public class Bilforsikring {
	private double grundpræmie;
	
	public double getGrundPræmie() {
		return grundpræmie;
	}
	

	public  void setGrundpræmie(double grundPr) {
		if (grundPr <= 0) throw new RuntimeException("grundPr skal vaere positiv");
		grundpræmie = grundPr;
	}

	public double beregnPræmie(int alder, boolean isKvinde, int skadeFrieÅr) {
		double præmie = grundpræmie;
		if (præmie == 0) {
			throw new RuntimeException("GrundPræmie har ikke fået en værdi");
		}
		if (alder < 18) {
			throw new RuntimeException("Du er for ung til at tegne en forsikring");
		}
		if (alder-skadeFrieÅr < 18) {
			throw new RuntimeException("Du kan ikke have kørt skadefri så længe");
		}
		if (skadeFrieÅr < 0) {
			throw new RuntimeException("Antal skade frie år skal være positiv");
		}
		
		if (alder < 25) præmie = 1.25 * grundpræmie;
		
		if (isKvinde) præmie = præmie *0.95;
		
		if (skadeFrieÅr < 3);
		else if (skadeFrieÅr < 6) {
			præmie = præmie *0.85;
		}
		else if (skadeFrieÅr < 9) {
			præmie = præmie * 0.75;
		}
		else {
		    præmie = præmie * 0.65;
		}
		return præmie;
	}

}
