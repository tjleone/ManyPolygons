import acm.graphics.GMath;

public abstract class Polygon {
	
	private int numSides = Integer.MIN_VALUE;
	private double aspectRatio = Double.MIN_VALUE;
	private double width = Double.MIN_VALUE;
	private double height = Double.MIN_VALUE;
	private double apothem = Double.MIN_VALUE;
	private double radius = Double.MIN_VALUE;
	private double side = Double.MIN_VALUE;
	
	/**
	 * For all calculations, we assume we are creating or working with
	 * a bounding box that is the width and height of a polygon that is
	 * resting on one of its sides.
	 * 
	 * @param n number of sides in polygon
	 * @param maxWidth max width allowed for bounding box
	 * @param maxHeight max height allowed for bounding box
	 */
	public Polygon(int n, double maxWidth, double maxHeight) {
		assert n > 2;
		setNumSides(n);
		setAspectRatio(aspectRatio(n));
		/*
		 *         self._numSides = n
        self._aspectRatio = self.aspectRatio(n)
        w, h = self.resizePolygonBounds(n, maxWidth, maxHeight)
        self._width, self._height = w, h
        self._apothem = self.apothem(n, w, h)
        self._radius = self.radius(n, w, h)
        self._side = self.side(n, w, h)

		 */
		
	}
	
	
	public int getNumSides() {
		assert numSides != Integer.MIN_VALUE;
		return numSides;
	}


	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}


	public double getAspectRatio() {
		assert aspectRatio != Double.MIN_VALUE;
		return aspectRatio;
	}


	public void setAspectRatio(double aspectRatio) {
		this.aspectRatio = aspectRatio;
	}


	public double getWidth() {
		assert width != Double.MIN_VALUE;
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		assert height != Double.MIN_VALUE;
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getApothem() {
		assert apothem != Double.MIN_VALUE;
		return apothem;
	}


	public void setApothem(double apothem) {
		this.apothem = apothem;
	}


	public double getRadius() {
		assert radius != Double.MIN_VALUE;
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	public double getSide() {
		assert side != Double.MIN_VALUE;
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	public abstract double aspectRatio(int n);
	
	public double apothemRadiusRatio(int n) {
		return GMath.cosDegrees(180/n);
	}
	
	public double radiusApothemRatio(int n) {
		return 1.0 / apothemRadiusRatio(n);
	}

	public void resizeBounds(int n, double maxWidth, double maxHeight) {
		double ar = aspectRatio(n);
		double h = 1;
		
		while (h*ar < maxWidth && h < maxHeight) {
			h++;
		}
		
		if (h*ar > maxWidth) {
			h--;
		}
		
		setWidth(h*ar);
		setHeight(h);
	}
	
	public abstract double radius(int n, double width, double height);
	
	public double radiusFromSide(int n, double side) {
		return side / (2*GMath.sinDegrees(180.0 / n));
	}
	
	public double radiusFromApothem(int n, double apothem) {
		return apothem / GMath.cosDegrees(180.0 / n);
	}
	
	public abstract double apothem(int n, double width, double height);
	
	public double apothemFromSide(int n, double side) {
		return side / (2*Util.tanDegrees(180.0 / n));
	}
	
	public double apothemFromRadius(int n, double radius) {
		return radius * GMath.cosDegrees(180.0 / n);
	}
	
	public abstract double side(int n, double width, double height);
	
	public double sideFromApothem(int n, double apothem) {
		return 2 * apothem * Util.tanDegrees(180.0 / n);
	}
	
	public double sideFromRadius(int n, double d) {
		return 2 * d * GMath.sinDegrees(180.0 / n);
	}
}
