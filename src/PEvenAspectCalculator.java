import acm.graphics.GMath;

public class PEvenAspectCalculator extends PAspectCalculator {

	public PEvenAspectCalculator(int numSidesInPolygon) {
		super(numSidesInPolygon);
		assert numSidesInPolygon % 2 == 0;
	}

	/**
	 * In a polygon with n % 2 == 0, n % 4 != 0, the width of the polygon is twice
	 * the radius and the height of the polygon is twice the apothem.
	 * 
	 * So the ratio w/h is the same as the ratio radius/apothem.
	 * 
	 * In general, for a regular polygon, apothem = radius*cosDegrees(180/n)
	 * 
	 * So, w/h = radius/apothem = radius / (radius*cosDegrees(180/n)) = 1 /
	 * cosDegrees(180/n)
	 * 
	 * @param n number of sides in the polygon
	 */
	@Override
	public double aspectRatio() {
		assert getNumPolygonSides() % 4 != 0;
		// n % 2 == 0, n % 4 != 0 -> h = 2a, w = 2r -> w/h = r/a
		return 1.0 / GMath.cosDegrees(180 / getNumPolygonSides());
	}

}
