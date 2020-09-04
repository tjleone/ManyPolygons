
@SuppressWarnings("ucd")
public class PEvenPolygon extends PPolygon {

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
	 * are not multiples of 4. The case where n % 4 == 0 is handles by the 
	 * PQuadPolygon subclass.
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	@SuppressWarnings("ucd")
	public PEvenPolygon(int n, double width, double height) {
		super(n, width, height);
		assert n % 2 == 0;
	}

	@Override
	public double radius() {
		assert getNumSides() % 4 != 0;
		return getWidth() / 2.0;
	}

	@Override
	public double apothem() {
		return getHeight() / 2.0;
	}

	@Override
	public double side() {
		return sideFromRadius(getNumSides(), radius());
	}

}
