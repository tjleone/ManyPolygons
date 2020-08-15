import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class CanvasModelTests {
	
	private CanvasModel _canvas = new CanvasModel(754, 469);
	private static double EPSILON = 0.1;

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/*
	@Test
	void testSetGridAspectRatio() {
		_canvas.setGridSize();
		assertEquals(625.33 * CanvasModel.GRID_SCALE_FACTOR, _canvas.getGrid().getWidth(), EPSILON);
		assertEquals(469 * CanvasModel.GRID_SCALE_FACTOR, _canvas.getGrid().getHeight(), EPSILON);
	}
	*/

}
