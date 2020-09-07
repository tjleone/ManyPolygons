package com.tjleone.polygons;
/**
 *    PIsotropicGrid is part of the ManyPolygons project
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
import java.awt.Dimension;

import acm.graphics.GDimension;
import acm.graphics.GTurtle;

@SuppressWarnings("serial")
public class PIsotropicGrid extends PIsotropicPolygon {

	
	public PIsotropicGrid(Dimension size, PParameters parameters) {
		super(size, parameters);
	}
	
	public void initPolygon(double width, double height, PParameters parameters) {
		polygon = PPolygonFactory.polygon(parameters.getNumPolySides(), width/parameters.getColumns(), height/parameters.getRows());
	}

	public GDimension recalculateSize(double sf, double ar) {

		double h = 1;
		double cols = getParameters().getColumns();
		double rows = getParameters().getRows();

		while (h * ar * cols < getWidth() && h * rows < getHeight()) {
			h++;
		}

		if (h * ar * cols > getWidth()) {
			h--;
		}

		setNewSize(sf * h * ar * cols, sf * h * rows);

		return getNewSize();
	}
	
	public PRenderer getRenderer(GTurtle turtle) {
		return new PGridRenderer(turtle, this);

	}

}
