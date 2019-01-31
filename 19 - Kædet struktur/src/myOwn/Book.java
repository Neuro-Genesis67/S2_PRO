package myOwn;

public class Book {

	private String title;
	private int pages;

	Book(String title, int pages) {
		this.title = title;
		this.pages = pages;
	}

	@Override
	public String toString() {
		return "Titel: " + this.title + "\nPages: " + this.pages;
	}
}
