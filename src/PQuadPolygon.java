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
public class PQuadPolygon extends PEvenPolygon {

	/**
	 * For all calculations, we assume we are creating or working with a bounding
	 * box that is the width and height of a polygon that is resting on one of its
	 * sides.
	 * 
	 * It should always be the case that width/height is the proper aspect ratio
	 * for the given number of sides. An aspect ratio calculator checks this in
	 * the constructor.
	 * 
	 * This constructor should only be called directly for even values of n that 
	 * are multiples of 4.
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	@SuppressWarnings("ucd")
	public PQuadPolygon(int n, double width, double height) {
		super(n, width, height);
		assert n % 4 == 0;
	}

	/**
	 * For polygons with n % 4 == 0, the width and height of 
	 * the bounding box are both twice the apothem.
	 * 
	 * So we use the apothem method inherited from EvenPolygon
	 * and apply radiusFromApothem to that value to get the radius.
	 */
	@Override
	public double radius() {
		return radiusFromApothem(getNumSides(), apothem());
	}
}
