import java.util.logging.Logger;

import acm.graphics.GTurtle;

public class PPolygonRenderer extends PRenderer {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PPolygonRenderer.class.getName());
	private PPolygon polygon;

	public PPolygonRenderer(GTurtle turtle, PIsotropicRectangle bounds, PPolygon polygon) {
		super(turtle, bounds);
	}
	
	public void drawPicture() {
		drawBounds();
	}

}
