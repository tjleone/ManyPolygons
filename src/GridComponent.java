import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

public class GridComponent extends AbstractComponent {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + GridComponent.class.getName());
	private GridModel _model;
	private CellComponent _cellComponent;
	
	public GridComponent(GridModel model) {
		_model = model;
		assert _model != null;
		_cellComponent = new CellComponent(_model.getCellModel());
	}
	
	public void draw(GTurtle t) {
		LOGGER.log(Level.FINEST, "// draw: _model.getSize()={0}", _model.getSize());
		LOGGER.log(Level.FINEST, "// draw: turtle starts at {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		drawBounds(t);
		LOGGER.log(Level.FINEST, "// draw: turtle after drawBounds: {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		drawCells(t);
		LOGGER.log(Level.FINEST, "// draw: turtle after drawCells: {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
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
	
	public void displaceTurtle(GTurtle t, double deltaX, double deltaY) {
		boolean penState = t.isPenDown();
		t.penUp();
		t.forward(deltaX);
		t.left(90);
		t.forward(deltaY);
		t.right(90);
		if (penState) {
			t.penDown();
		}
	}

	public void drawCells(GTurtle t) {
		LOGGER.log(Level.FINEST, "// drawCells: cols={0}", _model.getColumns());
		LOGGER.log(Level.FINEST, "// drawCells: rows={0}", _model.getRows());
		for (int cols = 0; cols < _model.getColumns(); cols++) {
			for(int rows = 0; rows < _model.getRows(); rows++) {
				_cellComponent.draw(t);
				displaceTurtle(t, 0.0, _model.getCellModel().getHeight());
			}
			displaceTurtle(t, _model.getCellModel().getWidth(), -_model.getHeight());
		}
		displaceTurtle(t,-_model.getWidth(), 0.0);
	}

	@Override
	public GDimension getSize() {
		return _model.getSize();
	}

}
