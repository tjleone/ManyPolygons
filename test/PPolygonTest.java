import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PPolygonTest {

	static ArrayList<PPolygon> polygons = new ArrayList<>();

	static List<Expected> expectedValues = List.of(
			/* n = 3 */
			new Expected(3, 173.20508075688772, 150, 1.1547005383792515, 100, 50.000000000000014, 173.20508075688772),
			/* n = 4 */
			new Expected(4, 150, 150, 1, 106.06601717798212, 75.0, 149.99999999999997),
			/* n = 5 */
			new Expected(5, 157.71933363574007, 150, 1.0514622242382672, 82.91796067500631, 67.0820393249937,
					97.4759088698719),
			/* n = 6 */
			new Expected(6, 173.20508075688772, 150, 1.1547005383792515, 86.60254037844386, 75.0, 86.60254037844385),
			/* n = 7 */
			new Expected(7,153.85752949088308, 150, 1.025716863272554, 78.90713127012653, 71.09286872987347,
					68.47304231704499),
			/* n = 8 */
			new Expected(8, 150, 150, 1, 81.17941502192954, 75.0, 62.13203435596426), // n = 8
			/* n = 9 */
			new Expected(9, 152.31399178286173, 150, 1.015426611885745, 77.33184030943225, 72.66815969056775,
					52.89809421253949), // n = 9
			/* n = 10 */
			new Expected(10, 157.71933363574007, 150, 1.0514622242382672, 78.85966681787004, 75.0, 48.73795443493594));

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < 8; i++) {
			polygons.add(PPolygonFactory.polygon(i+3, expectedValues.get(i).getWidth(), expectedValues.get(i).getHeight()));
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * Test method for {@link Polygon#getNumSides()}.
	 */
	@Test
	final void testGetNumSides() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).getNumSides(), expectedValues.get(i).getNumSides());
		}
	}

	@Test
	final void testGetWidth() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).getWidth(), expectedValues.get(i).getWidth());
		}
	}

	@Test
	final void testGetHeight() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).getHeight(), expectedValues.get(i).getHeight());
		}
	}

	@Test
	final void testAspect() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).getWidth()/polygons.get(i).getHeight(), expectedValues.get(i).getAspect());
		}
	}

	@Test
	final void testRadius() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).radius(), expectedValues.get(i).getRadius());
		}
	}

	@Test
	final void testApothem() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).apothem(), expectedValues.get(i).getApothem());
		}
	}

	@Test
	final void testSide() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).side(), expectedValues.get(i).getSide());
		}
	}

}

class Expected {

	int numSides;
	double width;
	double height;
	double aspect;
	double radius;
	double apothem;
	double side;

	public Expected(int n, double width, double height, double aspect, double radius, double apothem, double side) {
		this.numSides = n;
		this.width = width;
		this.height = height;
		this.aspect = aspect;
		this.radius = radius;
		this.apothem = apothem;
		this.side = side;
	}

	public double getNumSides() {
		return numSides;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getAspect() {
		return aspect;
	}

	public double getRadius() {
		return radius;
	}

	public double getApothem() {
		return apothem;
	}

	public double getSide() {
		return side;
	}

}
