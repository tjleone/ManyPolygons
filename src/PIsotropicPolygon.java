import java.awt.Dimension;

import acm.graphics.GTurtle;

@SuppressWarnings({ "ucd", "serial" })
public class PIsotropicPolygon extends PIsotropicRectangle {
	
	protected PPolygon polygon = null;
	@SuppressWarnings("ucd")
	private PSpiral spiral = null;

	@SuppressWarnings("ucd")
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
	
	@SuppressWarnings("ucd")
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
