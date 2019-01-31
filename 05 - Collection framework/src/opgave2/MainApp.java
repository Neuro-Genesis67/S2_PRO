package opgave2;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		Skole skole = new Skole("Katedralskolen");

		List<Integer> karakter = new ArrayList<>();
		karakter.add(03);
		karakter.add(10);
		karakter.add(4);
		karakter.add(7);
		karakter.add(7);
		karakter.add(12);

		Studerende s1 = new Studerende(1, "Ling Xiaoyu", karakter);
		Studerende s2 = new Studerende(2, "Lei Wulong", karakter);
		Studerende s3 = new Studerende(3, "Nina Williams", karakter);
		Studerende s4 = new Studerende(4, "Josie Rizal", karakter);

		skole.addStuderende(s1);
		skole.addStuderende(s2);
		skole.addStuderende(s3);
		skole.addStuderende(s4);

		System.out.println(skole.toString());
	}

}
