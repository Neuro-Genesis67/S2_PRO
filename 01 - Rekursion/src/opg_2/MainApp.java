package opg_2;

public class MainApp {

	public static void main(String[] args) {
		String s1 = "sataM";
		String s2 = "ssipnomeD";
		String s3 = "repsac em llac dna sllab ym kcil";
		FlipStringMethods fs = new FlipStringMethods();
		System.out.println(fs.reverseNoHelper(s1));
		System.out.println(fs.reverseOfficial(s2));
		System.out.println(fs.reverseHelper(s3, s3.length() - 1));

	}

}
