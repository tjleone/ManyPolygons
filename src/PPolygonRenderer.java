import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GPoint;
import acm.graphics.GTurtle;

public class PPolygonRenderer extends PRenderer {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PPolygonRenderer.class.getName());
	private PPolygon polygon;

	public PPolygonRenderer(GTurtle turtle, PIsotropicRectangle bounds, PPolygon polygon) {
		super(turtle, bounds);
		this.polygon = polygon;
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
		GPoint pt = t.getLocation();
		double direction = t.getDirection();
		boolean penStateDown = t.isPenDown();
		
		t.setColor(Color.RED);
		t.penDown();
		drawBounds();
		t.forward(polygon.getDeltaX());

//		drawSpiral(t, polygon.getStartSideLength(), polygon.getSpiralDepth());
		drawPolygon(t, polygon.side());		
		t.penUp();

		t.setLocation(pt);
		t.setDirection(direction);
		
		
		if (penStateDown) {
			t.penDown();
		}
		t.setColor(Color.BLACK);
		LOGGER.log(Level.FINEST, "draw (on exit) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on exit) t.getDirection(): {0}", t.getDirection() % 360);
	}
	
	private void drawSpiral(GTurtle t, double sideLength, int spiralDepth) {
//		LOGGER.log(Level.FINEST, "drawSpiral (on entry) sideLength={0}", sideLength);
//		if (spiralDepth == 0) {
//			return;
//		}
//		drawPolygon(t, sideLength);
//		t.forward(polygon.calculateSpiralDisplacement(sideLength));
//		t.left(polygon.getSpiralAngle());
//		drawSpiral(t, polygon.calculateNextSideLength(sideLength), spiralDepth-1);
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

}
