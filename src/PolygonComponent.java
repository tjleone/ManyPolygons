import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GTurtle;

public class PolygonComponent extends AbstractComponent {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PolygonComponent.class.getName());
	private Polygon _polygon;

	public PolygonComponent() {
		this(null);
	}
	
	public PolygonComponent(Polygon polygon) {
		super();
		_polygon = polygon;
	}

	@Override
	public GDimension getSize() {
		return _polygon.getSize();
	}
	
	public void draw(GTurtle t) {
		LOGGER.log(Level.FINEST, "draw (on entry) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		LOGGER.log(Level.FINEST, "draw (on entry) _polygon.getExternalAngle(): {0}", _polygon.getExternalAngle());
		GPoint pt = t.getLocation();
		double direction = t.getDirection();
		boolean penStateDown = t.isPenDown();
		
		t.setColor(Color.RED);
		t.penDown();
		drawBounds(t);
		t.forward(_polygon.getDeltaX());

//		drawSpiral(t, _polygon.getStartSideLength(), _polygon.getSpiralDepth());
		
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
//		t.forward(_polygon.calculateSpiralDisplacement(sideLength));
//		t.left(_polygon.getSpiralAngle());
//		drawSpiral(t, _polygon.calculateNextSideLength(sideLength), spiralDepth-1);
	}

	private void drawPolygon(GTurtle t, double sideLength) {
		for(int i=0; i < _polygon.getNumSides(); i++) {
			t.forward(sideLength);
			t.left(_polygon.getExternalAngle());
		}
	}

}
