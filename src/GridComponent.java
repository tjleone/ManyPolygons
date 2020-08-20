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
	
	public void setStartLocation(GTurtle t) {
		t.penUp();
		LOGGER.log(Level.FINEST, "// setStartLocation: center = {0}", Main.CENTER);
		LOGGER.log(Level.FINEST, "// setStartLocation: size = {0}", _model.getSize());
		LOGGER.log(Level.FINEST, "// setStartLocation: turtle starts at {0}", t.getLocation());
		t.setLocation(_model.left(), _model.bottom());
		LOGGER.log(Level.FINEST, "// setStartLocation: turtle moved to {0}", t.getLocation());
		t.setLocation(_model.getX(), _model.getY() + _model.getHeight());
		LOGGER.log(Level.FINEST, "// setStartLocation: turtle moved again to {0}", t.getLocation());
	}
	
	public void draw(GTurtle t) {
		setStartLocation(t);
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
		setStartLocation(t);
		drawRectangle(t, _model);
	}
	
	private void drawRectangle(GTurtle t, GRectangle bounds) {
		LOGGER.log(Level.FINEST, "// drawRectangle: turtle starts at {0}", bounds.getLocation());
		t.penDown();
		for(int i=0; i < 2; i++) {
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
			displaceTurtle(t, _model.getCellModel().getWidth(), -_model.getCellModel().getHeight()*_model.getRows());
		}
		displaceTurtle(t,-_model.getWidth(), 0.0);
	}

	@Override
	public GDimension getSize() {
		return _model.getSize();
	}

}
