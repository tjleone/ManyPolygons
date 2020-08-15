import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GridModelTests {

	private double _width = 400;
	private double _height = 300;
	private GridModel _model = new GridModel(_width, _height);
//	private CanvasModel _canvas = new CanvasModel(754, 469);
	
	@BeforeAll
	public static void setup() {
	}

	@AfterAll
	public static void tearDown() {
	}

	@Test
	void test() {
		assertEquals(_width, _model.getWidth());
		assertEquals(_height, _model.getHeight());
		assertEquals(_width / _height, _model.getAspectRatio(), 0.01, 
				"Expected: " + _width / _height + ", Got: " + _model.getAspectRatio());
	}

}
