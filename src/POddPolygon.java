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
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GMath;

/**
 * @author tj
 *
 */
@SuppressWarnings("ucd")
public class POddPolygon extends PPolygon {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PPolygonRenderer.class.getName());

	/**
	 * For all calculations, we assume we are creating or working with a bounding
	 * box that is the width and height of a polygon that is resting on one of its
	 * sides.
	 * 
	 * It should always be the case that width/height is the proper aspect ratio
	 * for the given number of sides. An aspect ratio calculator checks this in
	 * the constructor.
	 * 
	 * This constructor should only be called for odd values of n
	 * 
	 * @param n         number of sides in polygon
	 * @param width		width of bounding box
	 * @param height	height of bounding box
	 */
	@SuppressWarnings("ucd")
	public POddPolygon(int n, double width, double height) {
		super(n, width, height);
		assert n % 2 == 1;
	}
	
	/**
	 * For any polygon, we can connect two radii that touch the sides
	 * of its bounding box. For a polygon with an odd number of sides,
	 * there is a central angle formed by these radii that is less than 
	 * 180.
	 * 
	 * Here we will call that angle the width angle, since the ends of
	 * the corresponding radii span the width of the bounding box.
	 * 
	 * Half of this angle is useful in calculations because half of 
	 * e
	 * the width angle sits inside a right triangle with the radius as a
	 * hypotenuse and a leg that is one half the width of the bounding
	 * box.
	 * 
	 * @param n number of sides in the polygon
	 * @return half of width angle (central angle that spans width of polygon)
	 */
	private double halfWidthAngle(int n) {
		return (int)(n / 2) * 180.0 / n;
	}

	/**
	 * From aspectRatio, we see that
	 * 
	 * w/2 = r*sin(halfWidthAngle(n))
	 * 
	 * So, r = w / (2*sin(halfWidthAngle(n)))
	 * 
	 * @param n number of sides in the polygon
	 * @param width width of bounding box
	 * @param height height of bounding box
	 * @return radius of polygon with n sides that fits in the bounding box
	 */
	@Override
	public double radius() {
		LOGGER.log(Level.FINEST, "POddPolygon.radius: n=" + getNumSides() + ", width=" + getWidth() + ", height=" + getHeight());
		LOGGER.log(Level.FINEST, "POddPolygon.radius: width/height=" + getWidth()/getHeight());
		return getWidth() / (2 * GMath.sinDegrees(halfWidthAngle(getNumSides())));
	}

	@Override
	@SuppressWarnings("ucd")
	public double apothem() {
		return apothemFromRadius(getNumSides(), radius());
	}

	@Override
	public double side() {
		LOGGER.log(Level.FINEST, "POddPolygon.side: n=" + getNumSides() + ", width=" + getWidth() + ", height=" + getHeight());
		LOGGER.log(Level.FINEST, "POddPolygon.side: width/height=" + getWidth()/getHeight());
		double sideLength = sideFromRadius(getNumSides(), radius());
		LOGGER.log(Level.FINEST, "POddPolygon.side: radius()=" + radius());
		LOGGER.log(Level.FINEST, "POddPolygon.side: sideLength=" + sideLength);
		return sideFromRadius(getNumSides(), radius());
	}

}
