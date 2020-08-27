import acm.graphics.GMath;

public class POddAspectCalculator extends PAspectCalculator {

	public POddAspectCalculator(int numSidesInPolygon) {
		super(numSidesInPolygon);
		assert numSidesInPolygon % 2 == 1;
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
	public double aspectRatio() {
		double w = 2 * GMath.sinDegrees(halfWidthAngle());
		double h = 1 + GMath.cosDegrees(180.0 / getNumPolygonSides());
		return w / h;
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
	public double halfWidthAngle() {
		return (int)(getNumPolygonSides() / 2) * 180.0 / getNumPolygonSides();
	}

}
