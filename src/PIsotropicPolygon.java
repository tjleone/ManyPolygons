import java.awt.Dimension;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

public class PIsotropicPolygon extends PIsotropicRectangle {
	
	PPolygon polygon = null;
	PSpiral spiral = null;

	public PIsotropicPolygon(Dimension size, PParameters parameters) {
		super(size, parameters);
		initPolygon(getWidth(), getHeight(), parameters);
		spiral = new PSpiral(parameters);
	}
	
	public void update() {
		super.update();
		initPolygon(getWidth(), getHeight(), getParameters());
		spiral = new PSpiral(getParameters());
	}
	
	public PRenderer getRenderer(GTurtle turtle) {
		return new PPolygonRenderer(turtle, this);

	}
	
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
