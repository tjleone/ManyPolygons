import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

public class CanvasComponent {
	
	GTurtle _turtle;
	
	// using Logger.Logger.GLOBAL_LOGGER_NAME + "." before the class name makes
	// the global logger defined in Main into the parent logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CanvasComponent.class.getName());
	
	public CanvasComponent(GTurtle _turtle) {
		this._turtle = _turtle;
	}

	public void update(CanvasModel model) {
		_turtle.erasePath();
		drawRectangle(_turtle, model.getGrid());
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
