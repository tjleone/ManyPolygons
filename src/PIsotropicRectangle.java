import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class PIsotropicRectangle extends GRectangle {

	private final static Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PIsotropicRectangle.class.getName());

	private double scaleFactor;
	private double aspectRatio;
	private GPoint bottomLeft = new GPoint();
	private GDimension newSize = new GDimension();
	private PParameters parameters = null;
	
	public PIsotropicRectangle(Dimension size, PParameters parameters) {
		super(0,0,size.getWidth(), size.getHeight());
		assert parameters != null;
		assert parameters.getScaleFactor() <= 1.0;
		this.parameters = parameters;
		this.scaleFactor = parameters.getScaleFactor();
		this.aspectRatio = PAspectCalculatorFactory.calculator(parameters.getNumPolySides()).aspectRatio();
		init(scaleFactor, aspectRatio);
		LOGGER.log(Level.FINEST, "ctor: getLocation()={0}", getLocation());
		LOGGER.log(Level.FINEST, "ctor: getSize()={0}", getSize());
	}

	private void init(double sf, double ar) {
		resize(recalculateSize(sf, ar));
	}

	public GDimension recalculateSize(double sf, double ar) {

		double h = 1;

		while (h * ar < getWidth() && h < getHeight()) {
			h++;
		}

		if (h * ar > getWidth()) {
			h--;
		}

		newSize.setSize(sf * h * ar, sf * h);

		return newSize;
	}

	public void resize(GDimension size) {
		resize(size.getWidth(), size.getHeight());
	}

	public void resize(double newWidth, double newHeight) {
		double dx = (newWidth - getWidth()) / 2;
		double dy = (newHeight - getHeight()) / 2;
		grow(dx, dy);
		LOGGER.log(Level.FINEST, "resize: getLocation()={0}", getLocation());
		LOGGER.log(Level.FINEST, "resize: getSize()={0}", getSize());
	}

	public void fitFrame(double width, double height) {
		setLocation(0, 0);
		setSize(width, height);
		init(scaleFactor, aspectRatio);
	}

	public GPoint getBottomLeft() {
		bottomLeft.setLocation(getX(), getY() + getHeight());
		return bottomLeft;
	}

	public double getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

	public double getAspectRatio() {
		return aspectRatio;
	}

	public void setAspectRatio(double aspectRatio) {
		this.aspectRatio = aspectRatio;
	}

	public void setBottomLeft(GPoint bottomLeft) {
		this.bottomLeft = bottomLeft;
	}
	
	public PRenderer getRenderer(GTurtle turtle) {
		return new PRenderer(turtle, this);

	}

	public GDimension getNewSize() {
		return newSize;
	}

	public void setNewSize(GDimension newSize) {
		this.newSize = newSize;
	}

	protected void setNewSize(double width, double height) {
		assert newSize != null;
		newSize.setSize(width, height);
	}

	public PParameters getParameters() {
		return parameters;
	}
	

}
