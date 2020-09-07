package com.tjleone.polygons;
/**
 *    PAspectCalculator is part of the ManyPolygons project
 *    Copyright (C) 2020  TJ Leone
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

public abstract class PAspectCalculator {
	
	private int numPolygonSides; // number of sides in polygon
	
	public PAspectCalculator(int numSidesInPolygon) {
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
