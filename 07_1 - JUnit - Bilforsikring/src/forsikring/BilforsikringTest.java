package forsikring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class BilforsikringTest {

	Bilforsikring object = new Bilforsikring();

	@Before
	public void SetUp() {
		object.setGrundpræmie(100);
		assertNotNull(object);
	}

	@Test(expected = RuntimeException.class)
	public void testBeregnPræmieUnder25() {

		// hvis der er tale om unge under 25 tillægges grundPræmien 25%
		double result = object.beregnPræmie(24, false, 1);
		assertEquals(object.getGrundPræmie() * 1.25, result, 0.001);

	}

	@Test(expected = RuntimeException.class)
	public void testBeregnPræmieKvinde() {

		// hvis der er tale om en kvinde reduceres præmien med 5%
		double result = object.beregnPræmie(25, true, 1);
		assertEquals(object.getGrundPræmie() * 0.95, result, 0.001);
	}

	@Test(expected = RuntimeException.class)
	public void testBeregnPræmieSkadefri02() {

		// hvis man har kørt skadefrit i:
		// 0 til 2 år reduceres præmien med 0%
		double result = object.beregnPræmie(25, false, 1);
		assertEquals(object.getGrundPræmie(), result, 0.001);
	}

	@Test(expected = RuntimeException.class)
	public void testBeregnPræmieSkadefri35() {

		// hvis man har kørt skadefrit i:
		// 3 til 5 år reduceres præmien med 15%
		double result = object.beregnPræmie(25, false, 4);
		assertEquals(object.getGrundPræmie() * 0.85, result, 0.001);

	}

	@Test(expected = RuntimeException.class)
	public void testBeregnPræmieSkadefri68() {

		// hvis man har kørt skadefrit i:
		// 6 til 8 år reduceres præmien med 25%
		double result = object.beregnPræmie(30, false, 7);
		assertEquals(object.getGrundPræmie() * 0.75, result, 0.001);

	}

	@Test(expected = RuntimeException.class)
	public void testBeregnPræmieSkadefriOver8() {

		// hvis man har kørt skadefrit i:
		// over 8 år reduceres præmien med 35%
		double result = object.beregnPræmie(40, false, 12);
		assertEquals(object.getGrundPræmie() * 0.65, result, 0.001);
	}

}
