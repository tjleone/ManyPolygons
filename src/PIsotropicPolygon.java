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
import java.awt.Dimension;

import acm.graphics.GTurtle;

@SuppressWarnings({ "ucd", "serial" })
public class PIsotropicPolygon extends PIsotropicRectangle {
	
	protected PPolygon polygon = null;
	@SuppressWarnings("ucd")
	private PSpiral spiral = null;

	@SuppressWarnings("ucd")
	public PIsotropicPolygon(Dimension size, PParameters parameters) {
		super(size, parameters);
		initPolygon(getWidth(), getHeight(), parameters);
		spiral = new PSpiral(parameters);
	}
	
	public PRenderer getRenderer(GTurtle turtle) {
		return new PPolygonRenderer(turtle, this);

	}
	
	@SuppressWarnings("ucd")
	public void initPolygon(Dimension size, PParameters parameters) {
		initPolygon(size.getWidth(), size.getHeight(), parameters);
	}
	
	public void initPolygon(double width, double height, PParameters parameters) {
		polygon = PPolygonFactory.polygon(parameters.getNumPolySides(), width, height);
	}

	public PPolygon getPolygon() {
		return polygon;
	}

	public PSpiral getSpiral() {
		return spiral;
	}

}
