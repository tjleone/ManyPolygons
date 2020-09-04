import acm.graphics.GTurtle;

@SuppressWarnings("ucd")
public class PRenderer {

	private GTurtle turtle;
	private PIsotropicRectangle bounds;
	
	@SuppressWarnings("ucd")
	public PRenderer(GTurtle turtle, PIsotropicRectangle bounds) {
		this.turtle = turtle;
		this.bounds = bounds;
	}
	
	@SuppressWarnings("ucd")
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
	
	@SuppressWarnings("ucd")
	public void drawBounds() {
		drawRectangle(bounds.getWidth(), bounds.getHeight());
	}
	
	@SuppressWarnings("ucd")
	public void drawRectangle(double width, double height) {
		for(int i=0; i < 2; i++) {
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
