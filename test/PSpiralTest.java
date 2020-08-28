import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PSpiralTest {

	static ArrayList<PSpiral> spirals = new ArrayList<>();

//	public ExpectedSpiralValues(
//	int numSides, 
//	double spiralAngle, 
//	double internalAngle, 
//	double scaleFactor, 
//	double spiralDisplacement,
//	double nextSideLength, 
//	double spiralDepth)
	static List<ExpectedSpiralValues> expectedValues = List.of(new ExpectedSpiralValues(3, 13.897886248013984,
			59.99999999999999, 41.3165741804195, 1984.7840235184508, 7156.2405675175, 114.59155902616465));

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < 8; i++) {
			spirals.add(new PSpiral(new PParameters(2, 2, i+3, 2, 0.2)));
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
		for (int i = 0; i < expectedValues.size(); i++) {
			assertEquals(i+3, expectedValues.get(i).getNumSides());
		}
	}
//
//	@Test
//	final void testGetSpiralAngle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	final void testGetInternalAngle() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	final void testGetScaleFactor() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	final void testCalculateSpiralDisplacement() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	final void testCalculateNextSideLength() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	final void testGetSpiralDepth() {
//		fail("Not yet implemented");
//	}

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
