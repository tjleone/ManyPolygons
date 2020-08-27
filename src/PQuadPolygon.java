
public class PQuadPolygon extends PEvenPolygon {

	/**
	 * For all calculations, we assume we are creating or working with a bounding
	 * box that is the width and height of a polygon that is resting on one of its
	 * sides.
	 * 
	 * It should always be the case that width/height is the proper aspect ratio
	 * for the given number of sides. An aspect ratio calculator checks this in
	 * the constructor.
	 * 
	 * This constructor should only be called directly for even values of n that 
	 * are multiples of 4.
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	public PQuadPolygon(int n, double width, double height) {
		super(n, width, height);
		assert n % 4 == 0;
	}

	/**
	 * For polygons with n % 4 == 0, the width and height of 
	 * the bounding box are both twice the apothem.
	 * 
	 * So we use the apothem method inherited from EvenPolygon
	 * and apply radiusFromApothem to that value to get the radius.
	 */
	@Override
	public double radius() {
		return radiusFromApothem(getNumSides(), apothem());
	}
}
