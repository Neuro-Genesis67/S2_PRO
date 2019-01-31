package opg4;

import java.util.Comparator;

public class NumberComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer c1, Customer c2) {
		return c1.getNumber() - c2.getNumber();
	}

}
