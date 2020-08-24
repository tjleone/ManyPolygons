import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GMath;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CellModel extends AbstractModel {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CellModel.class.getName());
	private Polygon _polygon;
	
	public CellModel() {
		this(0, 0, 0, 0, null);
	}

	public CellModel(ModelParameters parameters) {
		this(0, 0, 0, 0, parameters);
	}

	public CellModel(double x, double y, double width, double height, ModelParameters parameters) {
		super(x, y, width, height, parameters);
		LOGGER.setLevel(Level.ALL);
		LOGGER.log(Level.FINEST, "Cell Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Cell Height: {0}", getHeight());
		_polygon = PolygonBuilder.polygon(parameters.getNumPolySides(), width, height);
	}

	public CellModel(GDimension size, ModelParameters parameters) {
		this(0, 0, size.getWidth(), size.getHeight(), parameters);
	}

	public CellModel(GPoint pt, GDimension size, ModelParameters parameters) {
		this(pt.getX(), pt.getY(), size.getWidth(), size.getHeight(), parameters);
	}

	public CellModel(GPoint pt, ModelParameters parameters) {
		this(pt.getX(), pt.getY(), 0, 0, parameters);
	}

	public CellModel(GRectangle r, ModelParameters parameters) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), parameters);
	}

	public CellModel(double width, double height, ModelParameters parameters) {
		this(0, 0, width, height, parameters);
	}

	public void resize(GRectangle maxBounds, ModelParameters parameters) {
		assert parameters != null : "null parameters";
		assert parameters.getNumPolySides() >= 3 : "number of sides < 3";
		_polygon.resizeBounds(parameters.getNumPolySides(), maxBounds.getWidth(),
				maxBounds.getHeight());
	}

	// Must be called after every resize and before getting other
	// values owned by CellModel.
	// Calculate aspect ratio, width and height of bounding box,
	// radius, apothem, side length and deltaX along bottom of
	// bounding box to position to start drawing polygon
	// and reset fields accordingly
	public void resizePolygonBounds(double maxCellWidth, double maxCellHeight) {
		assert getNumPolySides() == _polygon.getNumSides();
		_polygon.resizeBounds(_polygon.getNumSides(), maxCellWidth, maxCellHeight);
		System.out.print("CellModel.resizePolygonBounds: setting size to ");
		System.out.println("(" + _polygon.getWidth() + ", " + _polygon.getHeight());
		setSize(_polygon.getWidth(), _polygon.getHeight());
	}

	public int getNumPolySides() {
		return getParameters().getNumPolySides();
	}

	public double getStartX() {
		return _polygon.getDeltaX();
//		return 42.69224358691905;
	}

	public double getStartSideLength() {
		return _polygon.getSide();
//		return 68.47304231704497;
	}
//	
//	public double sideLengthFromRadius(double radius) {
//		return 68.47304231704497;
//	}
//
//	public double radiusFromSideLength(double sideLength) {
//		return sideLength / (2 * GMath.sinDegrees(180 / getParameters().getNumPolySides()));
//	}

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
	
//	private double aspectRatio() {
//		return _polygon.aspectRatio(getParameters().getNumPolySides());
//	}
//
}
