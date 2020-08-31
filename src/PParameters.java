
public class PParameters {
	private int rows;
	private int columns;
	private int numPolySides;
	private int spiralDepth;
	private double displacementPortion;
	private double scaleFactor;

	public PParameters(int rows, int columns, int numPolySides, int spiralDepth, double displacementPortion, double scaleFactor) {
		this.rows = rows;
		this.columns = columns;
		this.numPolySides = numPolySides;
		this.spiralDepth = spiralDepth;
		this.displacementPortion = displacementPortion;
		this.scaleFactor = scaleFactor;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getNumPolySides() {
		return numPolySides;
	}

	public void setNumPolySides(int numPolySides) {
		this.numPolySides = numPolySides;
	}

	public int getSpiralDepth() {
		return spiralDepth;
	}

	public void setSpiralDepth(int spiralDepth) {
		this.spiralDepth = spiralDepth;
	}

	public double getDisplacementPortion() {
		return displacementPortion;
	}

	public void setDisplacementPortion(double displacementPortion) {
		this.displacementPortion = displacementPortion;
	}

	public double getScaleFactor() {
		return scaleFactor;
	}

	public void setScaleFactor(double scaleFactor) {
		this.scaleFactor = scaleFactor;
	}

}