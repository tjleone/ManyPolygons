import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GMath;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CellModel extends AbstractModel {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CellModel.class.getName());
	
	public CellModel() {
		this(0, 0, 0, 0, null);
	}

	public CellModel(ModelParameters parameters) {
		this(0, 0, 0, 0, parameters);
	}

	public CellModel(double x, double y, double width, double height, ModelParameters parameters) {
		super(x, y, width, height, parameters);
	}

	public CellModel(GDimension size, ModelParameters parameters) {
		super(size, parameters);
	}

	public CellModel(GPoint pt, GDimension size, ModelParameters parameters) {
		super(pt, size, parameters);
	}

	public CellModel(GPoint pt, ModelParameters parameters) {
		super(pt, parameters);
	}

	public CellModel(GRectangle r, ModelParameters parameters) {
		super(r, parameters);
	}

	public CellModel(double width, double height, ModelParameters parameters) {
		this(0, 0, width, height, parameters);
		LOGGER.setLevel(Level.ALL);
		LOGGER.log(Level.FINEST, "Cell Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Cell Height: {0}", getHeight());
	}

	public void resize(GRectangle maxBounds, ModelParameters parameters) {
		assert parameters != null : "null parameters";
		assert parameters.getNumPolySides() >= 3 : "number of sides < 3";
	}

	// Must be called after every resize and before getting other
	// values owned by CellModel.
	// Calculate aspect ratio, width and height of bounding box,
	// radius, apothem, side length and deltaX along bottom of
	// bounding box to position to start drawing polygon
	// and reset fields accordingly
	public void resizePolygonBounds(double maxCellWidth, double maxCellHeight) {
//		maxCellWidth = 153.88;
		maxCellHeight = 150.0;
		
		double ar = aspectRatio();
		int height = 1;

		while(height*ar < maxCellWidth && height < maxCellHeight) {
			height++;
		}
		
		if (height*ar > maxCellWidth) {
			height--;
		}
		
		double width = height*ar;
		System.out.println("calculated width=" + width);
		System.out.println("calculated height=" + height);

		setSize(width, height);
	}

	public int getNumPolySides() {
		return getParameters().getNumPolySides();
	}

	public double getStartX() {
//		return _startX;
		return 42.69224358691905;
	}

	public double getStartSideLength() {
		return 68.47304231704497;
	}
	
	public double sideLengthFromRadius(double radius) {
		return 68.47304231704497;
	}

	public double radiusFromSideLength(double sideLength) {
		return sideLength / (2 * GMath.sinDegrees(180 / getParameters().getNumPolySides()));
	}

	public double getExternalAngle() {
		return 360.0 / 7.0;
	}

	public double calculateSpiralDisplacement(double sideLength) {
		return CanvasModel.DEFAULT_SPIRAL_DISPLACEMENT * sideLength;
	}

	public double calculateNextSideLength(double sideLength) {
		return sideLength * getSpiralSideLengthFactor();
	}

	public int getSpiralDepth() {
		return CanvasModel.DEFAULT_SPIRAL_DEPTH;
	}

	public double getSpiralAngle() {
		return 9.597912330850274;
	}

	public double getSpiralSideLengthFactor() {
		return 0.9378255363311423;
	}
	
	/*
to widthOfOdd :numSides :height
	op 2 * sin(360/n * int :numSides / 4)
end
	 */
	private double aspectRatio() {
		int n = getParameters().getNumPolySides();
		double innerAngle = 360.0 / n;
		int spanningAngles = n / 2;
		double aspectRatio = 0; 
		if (n % 4 == 0) {
			aspectRatio = 1; // h = w = 2a
		} else if (n % 2 == 0) { // n % 2 == 0 -> h = 2a, w = 2r -> w/h = r/a
			aspectRatio = 1.0 / GMath.cosDegrees(180/n);
		} else  if (n % 2 == 1) { // h = a + r
			double w = 2 * GMath.sinDegrees(innerAngle * spanningAngles / 2.0);
			double h = 1 + GMath.cosDegrees(180.0 / n);
			aspectRatio = w / h;
		}
		System.out.println("calculated aspect ratio: " + aspectRatio);
		System.out.println("actual aspect ratio: " + 153.85752949088308 / 150.0);
		return aspectRatio;
	}

}
