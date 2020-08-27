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
		for(int i=0; i < 2; i++) {
			turtle.forward(bounds.getWidth());
			turtle.left(90);
			turtle.forward(bounds.getHeight());
			turtle.left(90);
		}
	}

}
