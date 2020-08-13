import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

public class CanvasComponent {
	
	public void update(CanvasModel model) {
		Main.TURTLE.erasePath();
		drawRectangle(Main.TURTLE, model.getGrid());
	}
	
	private void drawRectangle(GTurtle t, GRectangle bounds) {
		t.penUp();
		t.setLocation(bounds.getLocation());
		for(int i=0; i < 2; i++) {
			t.penDown();
			t.forward(bounds.getWidth());
			t.left(90);
			t.forward(bounds.getHeight());
			t.left(90);
		}
	}

}
