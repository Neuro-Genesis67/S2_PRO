package opgave_3;

public class MainApp {

	public static void main(String[] args) {
		// ThreadQueueDequeue tqd = new ThreadQueueDequeue();
		// tqd.start();
		CircularArrayQueue<Person> caq = new CircularArrayQueue<>();
		Person p1 = new Person("Ling");
		Person p2 = new Person("Lei");
		Person p3 = new Person("Yammie");
		Person p4 = new Person("Nina");
		Person p5 = new Person("Anna");
		Person p6 = new Person("Negan");
		Person p7 = new Person("Lene");
		Person p8 = new Person("Smilla");
		Person p9 = new Person("Digital");
		Person p10 = new Person("Food");
		Person p11 = new Person("Extend");
		Person p12 = new Person("Chai");

		System.out.println("Engueueing 8 objects...");
		caq.enqueue(p1);
		caq.enqueue(p2);
		caq.enqueue(p3);
		caq.enqueue(p4);
		caq.enqueue(p5);
		caq.enqueue(p6);
		caq.enqueue(p7);
		caq.enqueue(p8);
		System.out.println(caq + "\n");

		caq.setRandomInListAsFirst();
		System.out.println("setRandomInListAsFirst: \n" + caq + "\n");

		System.out.println("Spiser personen 2 pladser fra start: " + caq.spisHam(2));
		System.out.println(caq + "\n");
		System.out.println("Spiser personen 2 pladser fra start: " + caq.spisHam(2));
		System.out.println(caq);
		System.out.println("Spiser personen 2 pladser fra start: " + caq.spisHam(2));
		System.out.println(caq);
		// System.out.println("Spiser personen 0 pladser fra start: " + caq.spisHam(0));
		// System.out.println(caq);
	}

}
