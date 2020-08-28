import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GMath;

public abstract class PPolygon {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PPolygon.class.getName());

	private int numSides = Integer.MIN_VALUE;
	private double width = Double.MIN_VALUE;
	private double height = Double.MIN_VALUE;

	/**
	 * For all calculations, we assume we are creating or working with a bounding
	 * box that is the width and height of a polygon that is resting on one of its
	 * sides.
	 * 
	 * It should always be the case that width/height is the proper aspect ratio
	 * for the given number of sides. An aspect ratio calculator checks this in
	 * the constructor.
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	public PPolygon(int n, double width, double height) {
		assert n > 2;
		this.numSides = n;
		assert width != Double.MIN_VALUE && width != 0;
		assert height != Double.MIN_VALUE && height != 0;
		double aspectRatio = PAspectCalculatorFactory.calculator(n).aspectRatio();
		LOGGER.log(Level.FINEST, "POddPolygon.ctor: n=" + n);
		LOGGER.log(Level.FINEST, "POddPolygon.ctor: width=" + width);
		LOGGER.log(Level.FINEST, "POddPolygon.ctor: height=" + height);
		LOGGER.log(Level.FINEST, "POddPolygon.ctor: width/height=" + width/height);
		LOGGER.log(Level.FINEST, "POddPolygon.ctor: aspectRatio=" + aspectRatio);
		assert width/height == aspectRatio;
		this.width = width;
		this.height = height;
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}
	
	public void setSize(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public double getDeltaX() {
		return getWidth() / 2 - side() / 2;
	}

	public double getExternalAngle() {
		assert getNumSides() != 0;
		return 360.0 / getNumSides();
	}

	public abstract double radius();

	public double radiusFromSide(int n, double side) {
		return side / (2 * GMath.sinDegrees(180.0 / n));
	}

	public double radiusFromApothem(int n, double apothem) {
		return apothem / GMath.cosDegrees(180.0 / n);
	}

	public abstract double apothem();

	public double apothemFromSide(int n, double side) {
		return side / (2 * PMath.tanDegrees(180.0 / n));
	}

	public double apothemFromRadius(int n, double radius) {
		return radius * GMath.cosDegrees(180.0 / n);
	}

	public abstract double side();

	public double sideFromApothem(int n, double apothem) {
		return 2 * apothem * PMath.tanDegrees(180.0 / n);
	}

	public double sideFromRadius(int n, double d) {
		return 2 * d * GMath.sinDegrees(180.0 / n);
	}

}
