/**
 *    PEvenPolygon is part of the ManyPolygons project
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
@SuppressWarnings("ucd")
public class PEvenPolygon extends PPolygon {

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
	 * are not multiples of 4. The case where n % 4 == 0 is handles by the 
	 * PQuadPolygon subclass.
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	@SuppressWarnings("ucd")
	public PEvenPolygon(int n, double width, double height) {
		super(n, width, height);
		assert n % 2 == 0;
	}

	@Override
	public double radius() {
		assert getNumSides() % 4 != 0;
		return getWidth() / 2.0;
	}

	@Override
	public double apothem() {
		return getHeight() / 2.0;
	}

	@Override
	public double side() {
		return sideFromRadius(getNumSides(), radius());
	}

}
