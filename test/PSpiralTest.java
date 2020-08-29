import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PSpiralTest {

	static final double EPSILON = 0.00000000000005; // doubles within EPSILON of each other are considered equal
	static final double SIDE_LENGTH = 173.20508075688767;
	static ArrayList<PSpiral> spirals0_2 = new ArrayList<>();
	static ArrayList<PSpiral> spirals0_8 = new ArrayList<>();

//	public ExpectedSpiralValues(
//	int numSides, 
//	double spiralAngle, 
//	double internalAngle, 
//	double scaleFactor, 
//	double spiralDisplacement,
//	double nextSideLength, 
//	double spiralDepth)
	static List<ExpectedSpiralValues> expectedValues0_2 = List.of(
			new ExpectedSpiralValues(3, 13.897886248013984, 59.99999999999999, 0.7211102550927979, 34.641016151377535,
					124.89995996796793, 2),
			new ExpectedSpiralValues(4, 14.036243467926477, 90.0, 0.8246211251235323, 30.0, 123.69316876852984, 2),
			new ExpectedSpiralValues(5, 12.44638431706523, 108.0, 0.8825448646952648, 19.495181773974373,
					86.02686280460902, 2),
			new ExpectedSpiralValues(6, 10.893394649130906, 119.99999999999999, 0.9165151389911681, 17.32050807568877,
					79.37253933193772, 2),
			new ExpectedSpiralValues(7, 9.597912330850274, 128.57142857142856, 0.9378255363311423, 13.694608463408995,
					64.2157676352077, 2),
			new ExpectedSpiralValues(8, 8.54315481489228, 135.0, 0.9519843328436112, 12.426406871192848,
					59.14872327457894, 2),
			new ExpectedSpiralValues(9, 7.681028558665159, 140.0, 0.961838979142597, 10.579618842507896,
					50.879448935977884, 2),
			new ExpectedSpiralValues(10, 6.968450533028629, 144.0, 0.9689610096386662, 9.7475908869872,
					47.22517753699889, 2));

	static List<ExpectedSpiralValues> expectedValues0_8 = List.of(
			new ExpectedSpiralValues(3, 106.10211375198602, 59.99999999999999, 0.7211102550927979, 138.56406460551014,
					124.89995996796793, 2),
			new ExpectedSpiralValues(4, 75.96375653207349, 90.0, 0.8246211251235323, 120.0, 123.69316876852984, 2),
			new ExpectedSpiralValues(5, 59.553615682934776, 108.0, 0.8825448646952648, 77.98072709589749,
					86.02686280460902, 2),
			new ExpectedSpiralValues(6, 49.1066053508691, 119.99999999999999, 0.9165151389911681, 69.28203230275508,
					79.37253933193772, 2),
			new ExpectedSpiralValues(7, 41.83065909772119, 128.57142857142856, 0.9378255363311423, 54.77843385363598,
					64.2157676352077, 2),
			new ExpectedSpiralValues(8, 36.45684518510773, 135.0, 0.9519843328436111, 49.70562748477139,
					59.148723274578934, 2),
			new ExpectedSpiralValues(9, 32.31897144133485, 140.0, 0.961838979142597, 42.318475370031585,
					50.879448935977884, 2),
			new ExpectedSpiralValues(10, 29.03154946697138, 144.0, 0.9689610096386662, 38.9903635479488,
					47.22517753699889, 2));

	static List<Double> sides = List.of(173.20508075688767, 149.99999999999997, 97.4759088698719, 86.60254037844385,
			68.47304231704499, 62.13203435596426, 52.89809421253949, 48.73795443493594);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < 8; i++) {
			spirals0_2.add(new PSpiral(new PParameters(1, 1, i + 3, 2, 0.2)));
			spirals0_8.add(new PSpiral(new PParameters(1, 1, i + 3, 2, 0.8)));
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

	@Test
	final void testGetNumSides() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(i + 3, expectedValues0_2.get(i).getNumSides());
		}
	}

	@Test
	final void testGetSpiralAngle() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getSpiralAngle(), spirals0_2.get(i).getSpiralAngle());
			assertEquals(expectedValues0_8.get(i).getSpiralAngle(), spirals0_8.get(i).getSpiralAngle());
		}
	}

	@Test
	final void testGetInternalAngle() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getInternalAngle(), spirals0_2.get(i).getInternalAngle(), EPSILON);
			assertEquals(expectedValues0_8.get(i).getInternalAngle(), spirals0_8.get(i).getInternalAngle(), EPSILON);
		}
	}

	@Test
	final void testGetScaleFactor() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getScaleFactor(), spirals0_2.get(i).getScaleFactor(), EPSILON);
			assertEquals(expectedValues0_8.get(i).getScaleFactor(), spirals0_8.get(i).getScaleFactor(), EPSILON);
		}
	}

	@Test
	final void testCalculateSpiralDisplacement() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getSpiralDisplacement(),
					spirals0_2.get(i).calculateSpiralDisplacement(sides.get(i)), EPSILON);
			assertEquals(expectedValues0_8.get(i).getSpiralDisplacement(),
					spirals0_8.get(i).calculateSpiralDisplacement(sides.get(i)), EPSILON);
		}
	}

	@Test
	final void testCalculateNextSideLength() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getNextSideLength(),
					spirals0_2.get(i).calculateNextSideLength(sides.get(i)), EPSILON);
			assertEquals(expectedValues0_8.get(i).getNextSideLength(),
					spirals0_8.get(i).calculateNextSideLength(sides.get(i)), EPSILON);
		}
	}

	@Test
	final void testGetSpiralDepth() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getSpiralDepth(), spirals0_2.get(i).getSpiralDepth(), EPSILON);
			assertEquals(expectedValues0_8.get(i).getSpiralDepth(), spirals0_8.get(i).getSpiralDepth(), EPSILON);
		}
	}

}

class ExpectedSpiralValues {

	private int numSides;
	private double spiralAngle;
	private double internalAngle;
	private double scaleFactor;
	private double spiralDisplacement;
	private double nextSideLength;
	private double spiralDepth;

	public ExpectedSpiralValues(int numSides, double spiralAngle, double internalAngle, double scaleFactor,
			double spiralDisplacement, double nextSideLength, double spiralDepth) {
		super();
		this.numSides = numSides;
		this.spiralAngle = spiralAngle;
		this.internalAngle = internalAngle;
		this.scaleFactor = scaleFactor;
		this.spiralDisplacement = spiralDisplacement;
		this.nextSideLength = nextSideLength;
		this.spiralDepth = spiralDepth;
	}

	public int getNumSides() {
		return numSides;
	}

	public double getSpiralAngle() {
		return spiralAngle;
	}

	public double getInternalAngle() {
		return internalAngle;
	}

	public double getScaleFactor() {
		return scaleFactor;
	}

	public double getSpiralDisplacement() {
		return spiralDisplacement;
	}

	public double getNextSideLength() {
		return nextSideLength;
	}

	public double getSpiralDepth() {
		return spiralDepth;
	}

}
