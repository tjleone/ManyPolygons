import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class PIsotropicRectangle extends GRectangle {
	
	private double scaleFactor;
	private double aspectRatio;
	private GPoint bottomLeft = new GPoint();

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
		System.out.println("ctor: getSize()=" + getSize());
		System.out.println("ctor: getLocation()=" + getLocation());
		System.out.println();
	}

	private void init(double sf, double ar) {
		double h = 1;
		
		while (h*ar < getWidth() && h < getHeight()) {
			h++;
		}
		
		if (h*ar > getWidth()) {
			h--;
		}
		
		resize(sf*h*ar, sf*h);
	}
	
	private void resize(double newWidth, double newHeight) {
		double dx = (newWidth - getWidth()) / 2;
		double dy = (newHeight - getHeight()) / 2;
		grow(dx, dy);
		System.out.println("resize: getSize()=" + getSize());
		System.out.println("resize: getLocation()=" + getLocation());
		System.out.println();
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

}
