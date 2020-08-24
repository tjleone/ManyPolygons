import acm.graphics.GMath;

/**
 * @author tj
 *
 */
public class OddPolygon extends Polygon {

	/**
	 * For all calculations, we assume we are creating or working with
	 * a bounding box that is the width and height of a polygon that is
	 * resting on one of its sides.
	 * 
	 * @param n number of sides in polygon
	 * @param maxWidth max width allowed for bounding box
	 * @param maxHeight max height allowed for bounding box
	 */
	public OddPolygon(int n, double maxWidth, double maxHeight) {
		super(n, maxWidth, maxHeight);
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
	 * In a polygon with an odd number of sides:
	 * 
	 *  w/2 = r*sin(halfWidthAngle(n)) // see comments for halfWidthAngle
	 *  -> w = 2*r*sin(halfWidthAngle(n)
	 *  h = r + a = r + r * cosDegrees(180.0 / n) // see Polygon.apothemFromRadius
	 *  -> h = r*(1 + cosDegrees(180.0 / n)
	 *  -> w/h = 2*sin(halfWidthAngle(n)) / (1 + cosDegrees(180.0 / n))
	 *  
	 *  The aspect ratio can be used to determine the largest bounding box
	 *  that fits inside a rectangle with a given maximum width and maximum height.
	 *  
	 *  For example, see Polygon.resizeBounds
	 * 
	 * @param n number of sides in the polygon
	 * @return apect ratio (width to height) of bounding box
	 */
	@Override
	public double aspectRatio(int n) {
		double w = 2 * GMath.sinDegrees(halfWidthAngle(n));
		double h = 1 + GMath.cosDegrees(180.0 / n);
		return w / h;
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
	public double radius(int n, double width, double height) {
		assert width / height == aspectRatio(n);
		return width / (2 * GMath.sinDegrees(halfWidthAngle(n)));
	}

	@Override
	public double apothem(int n, double width, double height) {
		return apothemFromRadius(n, radius(n,width,height));
	}

	@Override
	public double side(int n, double width, double height) {
		return sideFromRadius(n, radius(n,width,height));
	}

}
