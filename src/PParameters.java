/**
 *    <one line to give the program's name and a brief idea of what it does.>
 *    Copyright (C) <year>  <name of author>
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

@SuppressWarnings("ucd")
public class PParameters {
	private int rows;
	private int columns;
	private int numPolySides;
	private int spiralDepth;
	private double displacementPortion;
	private double scaleFactor;

	@SuppressWarnings("ucd")
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