import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GTurtle;

public class CellComponent {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CellComponent.class.getName());
	private CellModel _model;

	public CellComponent(CellModel _model) {
		super();
		this._model = _model;
	}
	
	public void draw(GTurtle t) {
		LOGGER.log(Level.FINEST, "draw (on entry) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		LOGGER.log(Level.FINEST, "draw (on entry) _model.getExternalAngle(): {0}", _model.getExternalAngle());
		boolean penStateDown = t.isPenDown();
		
		t.penDown();
		drawBounds(t);
		t.forward(_model.getStartX());
		for(int i=0; i < _model.getNumSides(); i++) {
			t.forward(_model.getStartSideLength());
			t.left(_model.getExternalAngle());
		}
		t.penUp();
		t.forward(- _model.getStartX());
		
		
		if (penStateDown) {
			t.penDown();
		}
		LOGGER.log(Level.FINEST, "draw (on exit) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on exit) t.getDirection(): {0}", t.getDirection() % 360);
	}

	public void drawBounds(GTurtle t) {
		drawRectangle(t, _model);
	}
	
	private void drawRectangle(GTurtle t, GDimension size) {
		LOGGER.log(Level.FINEST, "// drawRectangle: size {0}", size);
		for(int i=0; i < 2; i++) {
			t.penDown();
			t.forward(size.getWidth());
			t.left(90);
			t.forward(size.getHeight());
			t.left(90);
		}
	}

}
