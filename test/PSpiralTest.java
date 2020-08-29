import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PSpiralTest {

	static final double EPSILON = 0.00000000000001; // doubles within EPSILON of each other are considered equal
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
	static List<ExpectedSpiralValues> expectedValues0_2 = List.of(new ExpectedSpiralValues(3, 13.897886248013984,
			59.99999999999999, 0.7211102550927979, 34.641016151377535, 124.89995996796793, 2));
	static List<ExpectedSpiralValues> expectedValues0_8 = List.of(new ExpectedSpiralValues(3, 106.10211375198602,
			59.99999999999999, 0.7211102550927979, 138.56406460551014, 124.89995996796793, 2));

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
					spirals0_2.get(i).calculateSpiralDisplacement(SIDE_LENGTH), EPSILON);
			assertEquals(expectedValues0_8.get(i).getSpiralDisplacement(),
					spirals0_8.get(i).calculateSpiralDisplacement(SIDE_LENGTH), EPSILON);
		}
	}

	@Test
	final void testCalculateNextSideLength() {
		for (int i = 0; i < expectedValues0_2.size(); i++) {
			assertEquals(expectedValues0_2.get(i).getNextSideLength(),
					spirals0_2.get(i).calculateNextSideLength(SIDE_LENGTH), EPSILON);
			assertEquals(expectedValues0_8.get(i).getNextSideLength(),
					spirals0_8.get(i).calculateNextSideLength(SIDE_LENGTH), EPSILON);
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
