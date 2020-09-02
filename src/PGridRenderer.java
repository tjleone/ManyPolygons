import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GTurtle;

public class PGridRenderer extends PPolygonRenderer {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PGridRenderer.class.getName());

	public PGridRenderer(GTurtle turtle, PIsotropicGrid bounds) {
		super(turtle, bounds);
		bounds.getPolygon().setSize(bounds.getWidth()/bounds.getParameters().getColumns(),
				bounds.getHeight()/bounds.getParameters().getRows());
	}
	
	public void draw() {
		GTurtle t = getTurtle();
		LOGGER.log(Level.FINEST, "draw (on entry) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		LOGGER.log(Level.FINEST, "draw (on entry) polygon.getExternalAngle(): {0}", getPolygon().getExternalAngle());

		t.penUp();
		
		for (int col = 0; col < getColumns(); col++) {
			for (int row = 0; row < getRows(); row++) {
				getTurtleState().saveState(t);

				setUpForSpiral();
				drawSpiral(t, getPolygon().side(), getSpiral().getSpiralDepth());
				
				getTurtleState().restoreState(t);
				t.left(90);
				t.forward(getCellHeight());
				t.right(90);
			}
			t.forward(getCellWidth());
			t.right(90);
			t.forward(getRows()*getCellHeight());
			t.left(90);
		}
		t.forward(-getColumns()*getCellWidth());

		LOGGER.log(Level.FINEST, "draw (on exit) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on exit) t.getDirection(): {0}", t.getDirection() % 360);
	}
	
	private void setUpForSpiral() {
		getTurtle().penUp();
		getTurtle().forward(getPolygon().getDeltaX());
		getTurtle().penDown();
	}
	
	private int getRows() {
		return getBounds().getParameters().getRows();
	}
	
	private int getColumns() {
		return getBounds().getParameters().getColumns();
	}
	
	private double getCellWidth() {
		return getPolygon().getWidth();
	}
	
	private double getCellHeight() {
		return getPolygon().getHeight();
	}

}
