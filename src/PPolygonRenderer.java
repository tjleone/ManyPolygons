import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GTurtle;

public class PPolygonRenderer extends PRenderer {

	@SuppressWarnings("ucd")
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PPolygonRenderer.class.getName());
	private PTurtleState turtleState;
	private PPolygon polygon;
	private PSpiral spiral;

	@SuppressWarnings("ucd")
	public PPolygonRenderer(GTurtle turtle, PIsotropicPolygon bounds) {
		super(turtle, bounds);
		this.turtleState = new PTurtleState();
		this.polygon = bounds.getPolygon();
		this.spiral = bounds.getSpiral();
	}
	
	public void drawPicture() {
		drawBounds();
		draw();
	}
	
	public void draw() {
		GTurtle t = getTurtle();
		LOGGER.log(Level.FINEST, "draw (on entry) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		LOGGER.log(Level.FINEST, "draw (on entry) polygon.getExternalAngle(): {0}", polygon.getExternalAngle());

		turtleState.saveState(t);
		t.penDown();
		drawBounds();
		t.forward(polygon.getDeltaX());

		double q = spiral.getParameters().getDisplacementPortion();
		drawSpiral(t, q, polygon.side(), spiral.getSpiralDepth());
		
		turtleState.restoreState(t);

		LOGGER.log(Level.FINEST, "draw (on exit) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on exit) t.getDirection(): {0}", t.getDirection() % 360);
	}
	
	@SuppressWarnings("ucd")
	public void drawSpiral(GTurtle t, double q, double sideLength, int spiralDepth) {
		LOGGER.log(Level.FINEST, "drawSpiral (on entry) sideLength={0}", sideLength);
		if (spiralDepth == 0) {
			return;
		}
		drawPolygon(t, sideLength);
		t.forward(spiral.calculateSpiralDisplacement(q, sideLength));
		t.left(spiral.getSpiralAngle());
		drawSpiral(t, q, spiral.calculateNextSideLength(sideLength), spiralDepth-1);
	}

	private void drawPolygon(GTurtle t, double sideLength) {
		LOGGER.log(Level.FINEST, "polygon.getNumSides()=" + polygon.getNumSides());
		LOGGER.log(Level.FINEST, "polygon.getExternalAngle()=" + polygon.getExternalAngle());
		LOGGER.log(Level.FINEST, "POddPolygon.side: sideLength=" + sideLength);
		for(int i=0; i < polygon.getNumSides(); i++) {
			t.forward(sideLength);
			t.left(polygon.getExternalAngle());
		}
	}

	public PTurtleState getTurtleState() {
		return turtleState;
	}

	public PPolygon getPolygon() {
		return polygon;
	}

	public PSpiral getSpiral() {
		return spiral;
	}

}
