package opgave_4_QueueStack;

public class MainApp {

	public static void main(String[] args) {

		QueueStack<Person> qs = new QueueStack<>();
		Person p1 = new Person("One");
		Person p2 = new Person("Two");
		Person p3 = new Person("Three");
		Person p4 = new Person("Four");
		Person p5 = new Person("Five");
		Person p6 = new Person("Six");
		Person p7 = new Person("Seven");
		Person p8 = new Person("Eight");
		Person p9 = new Person("Nine");
		Person p10 = new Person("Ten");
		Person p11 = new Person("Eleven");
		Person p12 = new Person("Twelve");
		qs.enqueue(p1);
		qs.enqueue(p2);
		qs.enqueue(p3);
		qs.enqueue(p4);
		qs.enqueue(p5);
		qs.enqueue(p6);
		qs.enqueue(p7);
		qs.enqueue(p8);
		qs.enqueue(p9);
		qs.enqueue(p10);
		qs.enqueue(p11);
		qs.enqueue(p12);
		System.out.println(qs);
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs);
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs.dequeue());
		System.out.println(qs);

	}

}
