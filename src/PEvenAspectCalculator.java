/**
 *    PEvenAspectCalculator is part of the ManyPolygons project
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
import acm.graphics.GMath;

@SuppressWarnings("ucd")
public class PEvenAspectCalculator extends PAspectCalculator {

	@SuppressWarnings("ucd")
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
