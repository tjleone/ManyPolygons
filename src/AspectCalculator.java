
public abstract class AspectCalculator {
	
	private int numPolygonSides; // number of sides in polygon

	public AspectCalculator(int numSidesInPolygon) {
		this.numPolygonSides = numSidesInPolygon;
	}

	public abstract double aspectRatio();

	public int getNumPolygonSides() {
		return numPolygonSides;
	}

	public void setNumPolygonSides(int numPolygonSides) {
		this.numPolygonSides = numPolygonSides;
	}

}
