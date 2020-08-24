import acm.graphics.GMath;

/**
 * 
 */

/**
 * @author tj
 *
 */
public class QuadPolygon extends EvenPolygon {

	/**
	 * For all calculations, we assume we are creating or working with
	 * a bounding box that is the width and height of a polygon that is
	 * resting on one of its sides.
	 * 
	 * @param n number of sides in polygon
	 * @param maxWidth max width allowed for bounding box
	 * @param maxHeight max height allowed for bounding box
	 */
	public QuadPolygon(int n, double maxWidth, double maxHeight) {
		super(n, maxWidth, maxHeight);
		assert n % 4 == 0;
	}
	
	/**
	 * Polygons with n % 4 == 0 all fit in a square bounding box
	 * 
	 * @param n number of sides in polygon
	 */
	@Override
	public double aspectRatio(int n) {
		return 1.0;
	}

	/**
	 * For polygons with n % 4 == 0, the width and height of 
	 * the bounding box are both twice the apothem.
	 * 
	 * So we use the apothem method inherited from EvenPolygon
	 * and apply radiusFromApothem to that value to get the radius.
	 * 
	 * @param maxWidth max width allowed for bounding box
	 * @param maxHeight max height allowed for bounding box
	 * @param n number of sides in polygon
	 */
	@Override
	public double radius(int n, double width, double height) {
		return radiusFromApothem(n, apothem(n, width, height));
	}

}
