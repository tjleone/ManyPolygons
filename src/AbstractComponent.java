import acm.graphics.GDimension;
import acm.graphics.GTurtle;

public abstract class AbstractComponent {
	
	public abstract GDimension getSize();

	public void drawBounds(GTurtle t) {
		drawRectangle(t, getSize());
	}
	
	void drawRectangle(GTurtle t, GDimension size) {
		for(int i=0; i < 2; i++) {
			t.penDown();
			t.forward(size.getWidth());
			t.left(90);
			t.forward(size.getHeight());
			t.left(90);
		}
	}

}
