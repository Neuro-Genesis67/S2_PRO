package opg_2;

public class HowSubStringWorksApp {

	public static void main(String[] args) {
		String test = "Testing";

		System.out.println(test.substring(1) + "  = First       letter    removed");
		System.out.println(test.substring(2) + "   = First two   letters   removed");
		System.out.println(test.substring(3) + "    = First three letters   removed");
		System.out.println(test.substring(0) + " = No          letters   removed");

	}

}
