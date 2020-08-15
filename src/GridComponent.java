import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

public class GridComponent {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + GridModel.class.getName());
	private GridModel _model;
	
	public GridComponent(GridModel model) {
		_model = model;
	}

	public void drawBounds(GTurtle t) {
		drawRectangle(t, _model);
	}
	
	private void drawRectangle(GTurtle t, GRectangle bounds) {
		LOGGER.log(Level.FINEST, "// drawRectangle: turtle starts at {0}", bounds.getLocation());
		t.penUp();
		t.setLocation(bounds.getLocation());
		for(int i=0; i < 2; i++) {
			t.penDown();
			t.forward(bounds.getWidth());
			t.left(90);
			t.forward(bounds.getHeight());
			t.left(90);
		}
	}

}
