package opgave_3_Ackermann;

public class Ackermann {

	public static void main(String[] args) {
		Ackermann a = new Ackermann();
		System.out.println(a.AckermannMethod(1, 3));

	}

	public int AckermannMethod(int x, int y) {
		if (x == 0) {
			return y + 1;
		}
		if (y == 0) {
			return AckermannMethod(x - 1, 1);
		} else {
			return AckermannMethod(x - 1, AckermannMethod(x, y - 1));
		}
	}
}
