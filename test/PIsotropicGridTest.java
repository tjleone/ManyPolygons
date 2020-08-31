import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PIsotropicGridTest {

	static ArrayList<PIsotropicGrid> grids = new ArrayList<>();

	static List<ExpectedGrid> expectedValues = List.of(
			/* n = 4ExpectedGrid */
// 	public Expected(int n, int rows, int cols, double width, double height, double aspect) {

			new ExpectedGrid(4, 1, 1, 150, 150, 1.0)
			);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 0; i < 8; i++) {
			grids.add(new PIsotropicGrid(0,0, expectedValues.get(i).getWidth(), expectedValues.get(i).getHeight(), 0.9, expectedValues.get(i).getAspect(), expectedValues.get(i).getRows(), expectedValues.get(i).getCols()));
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
	final void test() {
		fail("Not yet implemented");
	}

}

class ExpectedGrid {

	int numSides;
	int rows;
	int cols;
	double width;
	double height;
	double aspect;
	double cellWidth;
	double cellHeight;

	public ExpectedGrid(int n, int rows, int cols, double width, double height, double aspect) {
		this.numSides = n;
		this.rows = rows;
		this.cols = cols;
		this.width = width;
		this.height = height;
		this.aspect = aspect;
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

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}

	public double getCellWidth() {
		return cellWidth;
	}

	public double getCellHeight() {
		return cellHeight;
	}

}
