
public class QuadAspectCalculator extends EvenAspectCalculator {

	public QuadAspectCalculator(int numSidesInPolygon) {
		super(numSidesInPolygon);
		assert numSidesInPolygon % 4 == 0;
	}
	
	/**
	 * Polygons with n % 4 == 0 all fit in a square bounding box
	 * 
	 * @param n number of sides in polygon
	 */
	@Override
	public double aspectRatio() {
		return 1.0;
	}

}
