import acm.graphics.GDimension;
import acm.graphics.GTurtle;

public abstract class AbstractComponent {
	
	public abstract GDimension getSize();

	public void drawBounds(GTurtle t) {
		drawRectangle(t, getSize());
	}
	
	void drawRectangle(GTurtle t, GDimension size) {
		drawRectangle(t, size.getWidth(), size.getHeight());
	}
	
	void drawRectangle(GTurtle t, double width, double height) {
		for(int i=0; i < 2; i++) {
			t.penDown();
			t.forward(width);
			t.left(90);
			t.forward(height);
			t.left(90);
		}
	}

}
