package opg_1;

public class P12_1_Rectangle {

	int x;
	int y;

	public P12_1_Rectangle(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getArea() {

		if (x <= 0)
			return 0;

		if (x == 1)
			return y;

		else {
			P12_1_Rectangle smallerRect = new P12_1_Rectangle(x - 1, y);
			int area = smallerRect.getArea();
			return area + y;
		}

	}

}
