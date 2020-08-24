/**
 * 
 */

/**
 * @author tj
 *
 */
public class PolygonBuilder {

	public static Polygon polygon(int n, double maxWidth, double maxHeight) {
		if (n % 4 == 0) {
			return new QuadPolygon(n, maxWidth, maxHeight);
		}
		if (n % 2 == 0) {
			return new EvenPolygon(n, maxWidth, maxHeight);
		}
		
		return new OddPolygon(n, maxWidth, maxHeight);
		
	}

}
