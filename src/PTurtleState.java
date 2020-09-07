/**
 *    PTurtleState is part of the ManyPolygons project
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
import java.awt.Color;

import acm.graphics.GPoint;
import acm.graphics.GTurtle;

@SuppressWarnings("ucd")
public class PTurtleState {
	
	@SuppressWarnings("ucd")
	private GTurtle turtle;
	@SuppressWarnings("ucd")
	private Color color;
	@SuppressWarnings("ucd")
	private GPoint location;
	@SuppressWarnings("ucd")
	private double direction;
	@SuppressWarnings("ucd")
	private boolean penIsDown;
	@SuppressWarnings("ucd")
	private boolean turtleIsVisible;
	@SuppressWarnings("ucd")
	private double speed;
	@SuppressWarnings("ucd")
	private int size;
	
	@SuppressWarnings("ucd")
	public void saveState(GTurtle turtle) {
		assert turtle != null;
		this.turtle = turtle;
		this.color = turtle.getColor();
		this.location = new GPoint(turtle.getLocation());
		this.direction = turtle.getDirection();
		this.penIsDown = turtle.isPenDown();
		this.turtleIsVisible = turtle.isTurtleVisible();
		this.speed = turtle.getSpeed();
		this.size = turtle.getTurtleSize();
	}
	
	@SuppressWarnings("ucd")
	public void restoreState(GTurtle turtle) {
		assert turtle != null;
		turtle.setColor(color);
		turtle.setLocation(getLocation());
		turtle.setDirection(getDirection());
		if (penIsDown) {
			turtle.penDown();
		} else {
			turtle.penUp();
		}
		if (turtleIsVisible) {
			turtle.showTurtle();
		} else {
			turtle.hideTurtle();
		}
		turtle.setSpeed(getSpeed());
		turtle.setSize(getSize());
	}

	public GTurtle getTurtle() {
		return turtle;
	}

	public GPoint getLocation() {
		return location;
	}

	public double getDirection() {
		return direction;
	}

	public boolean isPenIsDown() {
		return penIsDown;
	}

	public boolean isTurtleIsVisible() {
		return turtleIsVisible;
	}

	public double getSpeed() {
		return speed;
	}

	public int getSize() {
		return size;
	}
}
