import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author tj
 *
 */
class PolygonTests {

	static ArrayList<Polygon> polygons = new ArrayList<>();

	static List<Expected> expectedValues = List.of(
			new Expected(173.20508075688772, 150, 1.1547005383792515, 100, 50.000000000000014, 173.20508075688772), // n
																													// =
																													// 3
			new Expected(150, 150, 1, 106.06601717798212, 75.0, 149.99999999999997), // n = 4
			new Expected(157.71933363574007, 150, 1.0514622242382672, 82.91796067500631, 67.0820393249937,
					97.4759088698719), // n = 5
			new Expected(173.20508075688772, 150, 1.1547005383792515, 86.60254037844386, 75.0, 86.60254037844385), // n
																													// =
																													// 6
			new Expected(153.85752949088308, 150, 1.025716863272554, 78.90713127012653, 71.09286872987347,
					68.47304231704499), // n = 7
			new Expected(150, 150, 1, 81.17941502192954, 75.0, 62.13203435596426), // n = 8
			new Expected(152.31399178286173, 150, 1.015426611885745, 77.33184030943225, 72.66815969056775,
					52.89809421253949), // n = 9
			new Expected(157.71933363574007, 150, 1.0514622242382672, 78.85966681787004, 75.0, 48.73795443493594) // n =
																													// 10
	);

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 3; i < 11; i++) {
			polygons.add(PolygonBuilder.polygon(i, 800, 150));
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link Polygon#Polygon(int, double, double)}.
	 */
	@Test
	final void testPolygon() {
		for (int i = 0; i < 8; i++) {
			assertEquals(polygons.get(i).getWidth(), expectedValues.get(i).getWidth());
		}
	}

//	/**
//	 * Test method for {@link Polygon#getNumSides()}.
//	 */
//	@Test
//	final void testGetNumSides() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setNumSides(int)}.
//	 */
//	@Test
//	final void testSetNumSides() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#getAspectRatio()}.
//	 */
//	@Test
//	final void testGetAspectRatio() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setAspectRatio(double)}.
//	 */
//	@Test
//	final void testSetAspectRatio() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#getWidth()}.
//	 */
//	@Test
//	final void testGetWidth() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setWidth(double)}.
//	 */
//	@Test
//	final void testSetWidth() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#getHeight()}.
//	 */
//	@Test
//	final void testGetHeight() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setHeight(double)}.
//	 */
//	@Test
//	final void testSetHeight() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#getApothem()}.
//	 */
//	@Test
//	final void testGetApothem() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setApothem(double)}.
//	 */
//	@Test
//	final void testSetApothem() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#getRadius()}.
//	 */
//	@Test
//	final void testGetRadius() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setRadius(double)}.
//	 */
//	@Test
//	final void testSetRadius() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#getSide()}.
//	 */
//	@Test
//	final void testGetSide() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#setSide(double)}.
//	 */
//	@Test
//	final void testSetSide() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#aspectRatio(int)}.
//	 */
//	@Test
//	final void testAspectRatio() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#apothemRadiusRatio(int)}.
//	 */
//	@Test
//	final void testApothemRadiusRatio() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#radiusApothemRatio(int)}.
//	 */
//	@Test
//	final void testRadiusApothemRatio() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#resizeBounds(int, double, double)}.
//	 */
//	@Test
//	final void testResizeBounds() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#radius(int, double, double)}.
//	 */
//	@Test
//	final void testRadius() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#radiusFromSide(int, double)}.
//	 */
//	@Test
//	final void testRadiusFromSide() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#radiusFromApothem(int, double)}.
//	 */
//	@Test
//	final void testRadiusFromApothem() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#apothem(int, double, double)}.
//	 */
//	@Test
//	final void testApothem() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#apothemFromSide(int, double)}.
//	 */
//	@Test
//	final void testApothemFromSide() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#apothemFromRadius(int, double)}.
//	 */
//	@Test
//	final void testApothemFromRadius() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#side(int, double, double)}.
//	 */
//	@Test
//	final void testSide() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#sideFromApothem(int, double)}.
//	 */
//	@Test
//	final void testSideFromApothem() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test method for {@link Polygon#sideFromRadius(int, double)}.
//	 */
//	@Test
//	final void testSideFromRadius() {
//		fail("Not yet implemented");
//	}

}

class Expected {

	double width;
	double height;
	double aspect;
	double radius;
	double apothem;
	double side;

	public Expected(double width, double height, double aspect, double radius, double apothem, double side) {
		this.width = width;
		this.height = height;
		this.aspect = aspect;
		this.radius = radius;
		this.apothem = apothem;
		this.side = side;
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
