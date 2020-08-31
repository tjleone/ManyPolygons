import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class PIsotropicRectangle extends GRectangle {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PIsotropicRectangle.class.getName());

	private double scaleFactor;
	private double aspectRatio;
	private GPoint bottomLeft = new GPoint();
	private GDimension newSize = new GDimension();

	public PIsotropicRectangle() {
		this(0,0,0,0,1,1);
	}

	public PIsotropicRectangle(GPoint pt) {
		this(pt.getX(), pt.getY(), 0, 0, 1, 1);
	}

	public PIsotropicRectangle(GDimension size) {
		this(0, 0, size.getWidth(), size.getHeight(), 1, 1);
	}

	public PIsotropicRectangle(GRectangle r) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), 1, 1);
	}

	public PIsotropicRectangle(double width, double height) {
		this(0, 0, width, height, 1, 1);
	}

	public PIsotropicRectangle(GPoint pt, GDimension size) {
		this(pt.getX(), pt.getY(), size.getWidth(), size.getHeight(), 1, 1);
	}

	public PIsotropicRectangle(double x, double y, double width, double height) {
		this(x, y, width, height, 1, 1);
	}

	public PIsotropicRectangle(GRectangle r, double scaleFactor, double aspectRatio) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), scaleFactor, aspectRatio);
	}
	
	public PIsotropicRectangle(double x, double y, 
			double width, double height, double scaleFactor, double aspectRatio) {
		super(x, y, width, height);
		assert x == 0 && y == 0;
		assert scaleFactor <= 1.0;
		this.scaleFactor = scaleFactor;
		this.aspectRatio = aspectRatio;
		init(scaleFactor, aspectRatio);
		LOGGER.log(Level.FINEST, "ctor: getLocation()={0}", getLocation());
		LOGGER.log(Level.FINEST, "ctor: getSize()={0}", getSize());
	}

	private void init(double sf, double ar) {
		resize(recalculateSize(sf, ar));
	}

	public GDimension recalculateSize(double sf, double ar) {
		
		double h = 1;
		
		while (h*ar < getWidth() && h < getHeight()) {
			h++;
		}
		
		if (h*ar > getWidth()) {
			h--;
		}
		
		newSize.setSize(sf*h*ar, sf*h);
		
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
		setLocation(0,0);
		setSize(width, height);
		init(scaleFactor, aspectRatio);
	}
	
	public GPoint getBottomLeft() {
		bottomLeft.setLocation(getX(), getY()+getHeight());
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

}
