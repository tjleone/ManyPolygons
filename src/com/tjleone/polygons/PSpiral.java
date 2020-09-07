package com.tjleone.polygons;

/**
 *    PSpiral is part of the ManyPolygons project
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
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GMath;

public class PSpiral {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PSpiral.class.getName());

	private PParameters parameters;
	private double displacementFactor;
	private int depth;

	public PSpiral(PParameters parameters) {
		this.parameters = parameters;
		displacementFactor = parameters.getDisplacementPortion();
		depth = parameters.getSpiralDepth();
	}

	public double getDisplacementFactor() {
		return displacementFactor;
	}

	public void setDisplacementFactor(double displacementFactor) {
		this.displacementFactor = displacementFactor;
	}

	/**
	 * We spiral a new polygon inside the current polygon as follows:
	 * 
	 * 1. Start on the left corner of the base of the polygon. 2. Let s be the side
	 * length of the current polygon. Move along the base of the current polygon a
	 * distant of s * q, where q is the portion of s that the turtle is displaced
	 * every time a new polygon is drawn. 3. Turn through an angle phi, which we
	 * will call the spiral angle. 4. Move forward a distance r * s until reaching a
	 * side of the current polygon. The distance r * s will be the side length of
	 * the new polygon. We will call r the scale factor, since it scales the size of
	 * the current polygon to give the side length for the new polygon. 5. Complete
	 * the new polygon by turning left through the external angle of the polygon and
	 * forward by the distance r * s.
	 * 
	 * To calculate the spiral angle phi, note that, by the Law of Sines,
	 * 
	 * sin(phi)/(q*s) = sin(theta)/(r*s)
	 * 
	 * where theta is the angle opposite the side of length r*s drawn in step 4
	 * above.
	 * 
	 * By drawing a picture of the current polygon and the first line r*s, we can
	 * see that theta is an internal angle of the polygon.
	 * 
	 * The scale factor r is determined int the getScaleFactor() method. The
	 * displacement portion q is given.
	 * 
	 * Multiplying the equation above by s gives
	 * 
	 * sin(phi)/q = sin(theta)/r -> sin(phi) = q*sin(theta)/r -> phi =
	 * arcsin(q*sin(theta)/r)
	 * 
	 * There is one exception case, when the polygon is a triangle and q > 0.5. In
	 * this case, the spiral angle will be greater than 90 degrees. The
	 * arcsinDegrees function only returns values between -90 and 90, and the
	 * required angle is greater than 90.
	 * 
	 * In this case, 180 - arcsin(q*sin(theta)/r).
	 * 
	 * To see why, drop a perpendicular from the point where r extends to the side
	 * of the current triangle. This forms a right triangle with an angle that is
	 * supplementary to the angle phi mentioned above. Let tau be this supplementary
	 * angle. Then q*sin(theta) = r*sin(tau). Dividing both sides by q*r gives
	 * sin(tau)/q = sin(theta)/r. Substituting sin(tau)/q for sin(phi)/q above gives
	 * 
	 * tau = arcsin(q*sin(theta/r)
	 * 
	 * Since tau is supplementary to phi, we have phi = 180 - tau, or phi = 180 -
	 * arcsin(q*sin(theta/r))
	 * 
	 * To better understand this last case, see
	 * 
	 * https://themathpage.com/aTrig/law-of-sines.htm https://youtu.be/iNCFx3XR-hw
	 * https://youtu.be/RCyjglaJo5w https://youtu.be/5dA4llotZ78
	 * 
	 * @return the spiral angle
	 */
	public double getSpiralAngle() {
		double angle = PMath.asinDegrees(displacementFactor * GMath.sinDegrees(getInternalAngle()) / getScaleFactor());
		if (getExternalAngle() > 90 && displacementFactor > 0.5) {
			return 180 - angle;
		}
		return angle;
	}

	public double getExternalAngle() {
		return 360.0 / parameters.getNumPolySides();
	}

	public double getInternalAngle() {
		return 180 - getExternalAngle();
	}

	/**
	 * We spiral a new polygon inside the current polygon as follows:
	 * 
	 * 1. Start on the left corner of the base of the polygon. 2. Let s be the side
	 * length of the current polygon. Move along the base of the current polygon a
	 * distant of s * q, where q is the portion of s that the turtle is displaced
	 * every time a new polygon is drawn. 3. Turn through an angle phi, which we
	 * will call the spiral angle. 4. Move forward a distance r * s until reaching a
	 * side of the current polygon. The distance r * s will be the side length of
	 * the new polygon. We will call r the scale factor, since it scales the size of
	 * the current polygon to give the side length for the new polygon. 5. Complete
	 * the new polygon by turning left through the external angle of the polygon and
	 * forward by the distance r * s.
	 * 
	 * To calculate r, note that, by the Law of Cosines,
	 * 
	 * (r*s)^2 = (p*s)^2 + (q*s)^2 - 2*p*s*q*s*cos(theta)
	 * 
	 * where theta is the angle opposite the side of length r*s drawn in step 4
	 * above, and p is 1 - q.
	 * 
	 * By drawing a picture of the current polygon and the first line r*s, we can
	 * see that theta is an internal angle of the polygon.
	 * 
	 * Now,
	 * 
	 * (r*s)^2 = (p*s)^2 + (q*s)^2 - 2*p*s*q*s*cos(theta) -> r^2*s^2 = p^2*s^2 +
	 * q^2*s^2-2*p*q*s^2*cos(theta) -> r^2 = p^2 + q^2 - 2*p*q*cos(theta) -> r =
	 * sqrt(p^2 + q^2 - 2*p*q*cos(theta)
	 * 
	 * @return the scale factor
	 */
	public double getScaleFactor() {
		double q = displacementFactor;
		double p = 1 - q;
		LOGGER.log(Level.FINEST, "q=" + q);
		LOGGER.log(Level.FINEST, "p=" + p);
		LOGGER.log(Level.FINEST, "internal angle = " + getInternalAngle());
		LOGGER.log(Level.FINEST, "GMath.cosDegrees(getInternalAngle()" + GMath.cosDegrees(getInternalAngle()));
		double result = Math.sqrt(p * p + q * q - 2 * p * q * GMath.cosDegrees(getInternalAngle()));
		LOGGER.log(Level.FINEST, "getScaleFactor returns " + result);
		return Math.sqrt(p * p + q * q - 2 * p * q * GMath.cosDegrees(getInternalAngle()));
	}

	public double calculateSpiralDisplacement(double sideLength) {
		return displacementFactor * sideLength;
	}

	public double calculateNextSideLength(double sideLength) {
		return sideLength * getScaleFactor();
	}

	public int getSpiralDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
