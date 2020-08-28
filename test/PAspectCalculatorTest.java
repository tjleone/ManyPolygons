import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PAspectCalculatorTest {

	static ArrayList<PAspectCalculator> calculators = new ArrayList<>();

	static List<Double> expectedValues = List.of(
				1.1547005383792515, // n = 3
				1.0, 				// n = 4
				1.0514622242382672, // n = 5
				1.1547005383792515, // n = 6
				1.025716863272554,  // n = 7
				1.0,				// n = 8
				1.015426611885745,	// n = 9
				1.0514622242382672  // n = 10
			);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		for (int i = 3; i < 11; i++) {
			calculators.add(PAspectCalculatorFactory.calculator(i));
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
		for (int i = 0; i < 8; i++) {
			assertEquals(calculators.get(i).aspectRatio(), expectedValues.get(i));
		}
	}

}
