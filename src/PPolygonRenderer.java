/**
 *    PPolygonRenderer is part of the ManyPolygons project
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

import acm.graphics.GTurtle;

public class PPolygonRenderer extends PRenderer {

	@SuppressWarnings("ucd")
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PPolygonRenderer.class.getName());
	private PTurtleState turtleState;
	private PPolygon polygon;
	private PSpiral spiral;

	@SuppressWarnings("ucd")
	public PPolygonRenderer(GTurtle turtle, PIsotropicPolygon bounds) {
		super(turtle, bounds);
		this.turtleState = new PTurtleState();
		this.polygon = bounds.getPolygon();
		this.spiral = bounds.getSpiral();
	}
	
	public void drawPicture() {
		drawBounds();
		draw();
	}
	
	public void draw() {
		GTurtle t = getTurtle();
		LOGGER.log(Level.FINEST, "draw (on entry) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on entry) t.getDirection(): {0}", t.getDirection() % 360);
		LOGGER.log(Level.FINEST, "draw (on entry) polygon.getExternalAngle(): {0}", polygon.getExternalAngle());

		turtleState.saveState(t);
		t.penDown();
		drawBounds();
		t.forward(polygon.getDeltaX());

		double q = spiral.getDisplacementFactor();
		drawSpiral(t, polygon.side(), spiral.getSpiralDepth());
		
		turtleState.restoreState(t);

		LOGGER.log(Level.FINEST, "draw (on exit) t.getLocation(): {0}", t.getLocation());
		LOGGER.log(Level.FINEST, "draw (on exit) t.getDirection(): {0}", t.getDirection() % 360);
	}
	
	@SuppressWarnings("ucd")
	public void drawSpiral(GTurtle t, double sideLength, int spiralDepth) {
		LOGGER.log(Level.FINEST, "drawSpiral (on entry) sideLength={0}", sideLength);
		if (spiralDepth == 0) {
			return;
		}
		drawPolygon(t, sideLength);
		t.forward(spiral.calculateSpiralDisplacement(sideLength));
		t.left(spiral.getSpiralAngle());
		drawSpiral(t, spiral.calculateNextSideLength(sideLength), spiralDepth-1);
	}

	private void drawPolygon(GTurtle t, double sideLength) {
		LOGGER.log(Level.FINEST, "polygon.getNumSides()=" + polygon.getNumSides());
		LOGGER.log(Level.FINEST, "polygon.getExternalAngle()=" + polygon.getExternalAngle());
		LOGGER.log(Level.FINEST, "POddPolygon.side: sideLength=" + sideLength);
		for(int i=0; i < polygon.getNumSides(); i++) {
			t.forward(sideLength);
			t.left(polygon.getExternalAngle());
		}
	}

	public PTurtleState getTurtleState() {
		return turtleState;
	}

	public PPolygon getPolygon() {
		return polygon;
	}

	public PSpiral getSpiral() {
		return spiral;
	}

}
