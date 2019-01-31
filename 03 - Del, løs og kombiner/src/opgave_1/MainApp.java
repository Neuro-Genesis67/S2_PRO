package opgave_1;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ListMethods lm = new ListMethods();
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(8);
		list.add(10);
		list.add(2);
		list.add(10);
		list.add(20);
		list.add(25);
		list.add(15);
		System.out.println(lm.sumOfList(list));
	}

}
