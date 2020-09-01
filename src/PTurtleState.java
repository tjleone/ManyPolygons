import acm.graphics.GPoint;
import acm.graphics.GTurtle;

public class PTurtleState {
	
	GTurtle turtle;
	GPoint location;
	double direction;
	boolean penIsDown;
	boolean turtleIsVisible;
	double speed;
	int size;

	public PTurtleState(GTurtle turtle) {
		saveState(turtle);
	}
	
	public void saveState(GTurtle turtle) {
		this.turtle = turtle;
		this.location = new GPoint(turtle.getLocation());
		this.direction = turtle.getDirection();
		this.penIsDown = turtle.isPenDown();
		this.turtleIsVisible = turtle.isTurtleVisible();
		this.speed = turtle.getSpeed();
		this.size = turtle.getTurtleSize();
	}
	
	public void restoreState(GTurtle turtle) {
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
