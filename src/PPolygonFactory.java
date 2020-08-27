
public class PPolygonFactory {

	public static PPolygon polygon(int n, double width, double height) {
		if (n % 4 == 0) {
			return new PQuadPolygon(n, width, height);
		}
		if (n % 2 == 0) {
			return new PEvenPolygon(n, width, height);
		}
		
		return new POddPolygon(n, width, height);
		
	}

	private PPolygonFactory() {
		
	}
}
