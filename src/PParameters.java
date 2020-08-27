
public class PParameters {
	private int rows;
	private int columns;
	private int numPolySides;
	private int spiralDepth;
	private double displacementPortion;

	public PParameters(int rows, int columns, int numPolySides, int spiralDepth, double displacementPortion) {
		this.rows = rows;
		this.columns = columns;
		this.numPolySides = numPolySides;
		this.spiralDepth = spiralDepth;
		this.displacementPortion = displacementPortion;
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
}