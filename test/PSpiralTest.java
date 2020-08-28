import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PSpiralTest {

	static ArrayList<PPolygon> polygons = new ArrayList<>();

	static List<ExpectedSpiralValues> expectedValues = List.of();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	final void testGetSpiralAngle() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetInternalAngle() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetScaleFactor() {
		fail("Not yet implemented");
	}

	@Test
	final void testCalculateSpiralDisplacement() {
		fail("Not yet implemented");
	}

	@Test
	final void testCalculateNextSideLength() {
		fail("Not yet implemented");
	}

	@Test
	final void testGetSpiralDepth() {
		fail("Not yet implemented");
	}

}

class ExpectedSpiralValues {
	
	private double spiralAngle;
	private double internalAngle;
	private double scaleFactor;
	private double spiralDisplacement;
	private double nextSideLength;
	private double spiralDepth;
	
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
