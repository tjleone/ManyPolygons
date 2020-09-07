package com.tjleone.polygons;

/**
 *    PRenderer is part of the ManyPolygons project
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
import acm.graphics.GTurtle;

public class PRenderer {

	private GTurtle turtle;
	private PIsotropicRectangle bounds;

	public PRenderer(GTurtle turtle, PIsotropicRectangle bounds) {
		this.turtle = turtle;
		this.bounds = bounds;
	}

	public void render() {
		turtle.erasePath();
		turtle.penUp();
		turtle.setLocation(bounds.getBottomLeft());
		turtle.penDown();
		drawPicture();
		turtle.penUp();
	}

	public void drawPicture() {
		drawBounds();
	}

	public void drawBounds() {
		drawRectangle(bounds.getWidth(), bounds.getHeight());
	}

	public void drawRectangle(double width, double height) {
		for (int i = 0; i < 2; i++) {
			turtle.forward(width);
			turtle.left(90);
			turtle.forward(height);
			turtle.left(90);
		}
	}

	public GTurtle getTurtle() {
		return turtle;
	}

	public void setTurtle(GTurtle turtle) {
		this.turtle = turtle;
	}

	public PIsotropicRectangle getBounds() {
		return bounds;
	}

	public void setBounds(PIsotropicRectangle bounds) {
		this.bounds = bounds;
	}
}
