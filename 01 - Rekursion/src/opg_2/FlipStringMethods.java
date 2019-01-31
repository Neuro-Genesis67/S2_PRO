package opg_2;

public class FlipStringMethods {

	public String reverseOfficial(String text) {
		return reverseHelper(text, text.length() - 1);

	}

	public String reverseNoHelper(String string) {

		if (string.length() == 0) {
			return string;
		} else {
			return reverseNoHelper(string.substring(1)) + string.charAt(0);
		}

	}

	public String reverseHelper(String text, int index) {
		if (index < 0) {
			return "";
		} else {
			return text.charAt(index) + reverseHelper(text, index - 1);
		} // eksempel: o + l + l + e + H
	}
}
