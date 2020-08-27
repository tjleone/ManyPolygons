import acm.graphics.GMath;

/**
 * @author tj
 *
 */
public class POddPolygon extends PPolygon {

	/**
	 * For all calculations, we assume we are creating or working with a bounding
	 * box that is the width and height of a polygon that is resting on one of its
	 * sides.
	 * 
	 * It should always be the case that width/height is the proper aspect ratio
	 * for the given number of sides. An aspect ratio calculator checks this in
	 * the constructor.
	 * 
	 * This constructor should only be called for odd values of n
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	public POddPolygon(int n, double width, double height) {
		super(n, width, height);
		assert n % 2 == 1;
	}
	
	/**
	 * For any polygon, we can connect two radii that touch the sides
	 * of its bounding box. For a polygon with an odd number of sides,
	 * there is a central angle formed by these radii that is less than 
	 * 180.
	 * 
	 * Here we will call that angle the width angle, since the ends of
	 * the corresponding radii span the width of the bounding box.
	 * 
	 * Half of this angle is useful in calculations because half of 
	 * the width angle sits inside a right triangle with the radius as a
	 * hypotenuse and a leg that is one half the width of the bounding
	 * box.
	 * 
	 * @param n number of sides in the polygon
	 * @return half of width angle (central angle that spans width of polygon)
	 */
	private double halfWidthAngle(int n) {
		return (int)(n / 2) * 180.0 / n;
	}

	/**
	 * From aspectRatio, we see that
	 * 
	 * w/2 = r*sin(halfWidthAngle(n))
	 * 
	 * So, r = w / (2*sin(halfWidthAngle(n)))
	 * 
	 * @param n number of sides in the polygon
	 * @param width width of bounding box
	 * @param height height of bounding box
	 * @return radius of polygon with n sides that fits in the bounding box
	 */
	@Override
	public double radius() {
		System.out.println("POddPolygon.radius: n=" + getNumSides() + ", width=" + getWidth() + ", height=" + getHeight());
		System.out.println("POddPolygon.radius: width/height=" + getWidth()/getHeight());
		return getWidth() / (2 * GMath.sinDegrees(halfWidthAngle(getNumSides())));
	}

	@Override
	public double apothem() {
		return apothemFromRadius(getNumSides(), radius());
	}

	@Override
	public double side() {
		System.out.println("POddPolygon.side: n=" + getNumSides() + ", width=" + getWidth() + ", height=" + getHeight());
		System.out.println("POddPolygon.side: width/height=" + getWidth()/getHeight());
		double sideLength = sideFromRadius(getNumSides(), radius());
		System.out.println("POddPolygon.side:sideLength=" + sideLength);
		System.out.println();
		return sideFromRadius(getNumSides(), radius());
	}

}
