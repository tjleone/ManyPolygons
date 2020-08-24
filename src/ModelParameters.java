
public class ModelParameters {
	private int rows;
	private int columns;
	private int numPolySides;
	private int polysInSpiral;
	private double displacementPortion;

	public ModelParameters(int rows, int columns, int numPolySides, int polysInSpiral, double displacementPortion) {
		this.rows = rows;
		this.columns = columns;
		this.numPolySides = numPolySides;
		this.polysInSpiral = polysInSpiral;
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

	public int getPolysInSpiral() {
		return polysInSpiral;
	}

	public void setPolysInSpiral(int polysInSpiral) {
		this.polysInSpiral = polysInSpiral;
	}

	public double getDisplacementPortion() {
		return displacementPortion;
	}

	public void setDisplacementPortion(double displacementPortion) {
		this.displacementPortion = displacementPortion;
	}
}