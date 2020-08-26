import acm.graphics.GMath;

/**
 * 
 */

/**
 * @author tj
 *
 */
public class EvenPolygon extends Polygon {

	/**
	 * For all calculations, we assume we are creating or working with
	 * a bounding box that is the width and height of a polygon that is
	 * resting on one of its sides.
	 * 
	 * @param n number of sides in polygon
	 */
	public EvenPolygon(int n) {
		super(n);
		assert n % 2 == 0;
	}

	/**
	 * For all calculations, we assume we are creating or working with
	 * a bounding box that is the width and height of a polygon that is
	 * resting on one of its sides.
	 * 
	 * @param n number of sides in polygon
	 * @param maxWidth max width allowed for bounding box
	 * @param maxHeight max height allowed for bounding box
	 */
	public EvenPolygon(int n, double maxWidth, double maxHeight) {
		super(n, maxWidth, maxHeight);
		assert n % 2 == 0;
	}

	@Override
	public AspectCalculator createAspectCalculator() {
		return new EvenAspectCalculator(getNumSides());
	}

	/**
	 * In a polygon with n % 2 == 0, n % 4 != 0, the width of the polygon
	 * is twice the radius and the height of the polygon is twice the 
	 * apothem.
	 * 
	 * So the ratio w/h is the same as the ratio radius/apothem.
	 * 
	 * In general, for a regular polygon, apothem = radius*cosDegrees(180/n)
	 * 
	 * So, w/h = radius/apothem = radius / (radius*cosDegrees(180/n))
	 * = 1 / cosDegrees(180/n)
	 * 
	 * @param n number of sides in the polygon
	 */
	@Override
	public double aspectRatio(int n) {
		assert n % 4 != 0;
		// n % 2 == 0, n % 4 != 0 -> h = 2a, w = 2r -> w/h = r/a
		return 1.0 / GMath.cosDegrees(180/n);
	}

	@Override
	public double radius(int n, double width, double height) {
		assert n % 4 != 0;
		return width / 2.0;
	}

	@Override
	public double apothem(int n, double width, double height) {
		return height / 2.0;
	}

	@Override
	public double side(int n, double width, double height) {
		return sideFromRadius(n, radius(n,width,height));
	}

}
