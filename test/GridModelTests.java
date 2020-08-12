import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GridModelTests {

	private GridModel _model = new GridModel(800, 600);
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals(800, _model.getWidth());
		assertEquals(600, _model.getHeight());
		assertEquals(800.0 / 600.0, _model.getAspectRatio(), 0.01, 
				"Expected: " + 800.0 / 600.0 + ", Got: " + _model.getAspectRatio());
	}

}
