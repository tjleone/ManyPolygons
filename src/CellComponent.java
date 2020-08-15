import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GTurtle;

public class CellComponent {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CellComponent.class.getName());
	private CellModel _model;

	public CellComponent(CellModel _model) {
		super();
		this._model = _model;
	}
	
	public void draw(GTurtle t) {
		drawBounds(t);
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
