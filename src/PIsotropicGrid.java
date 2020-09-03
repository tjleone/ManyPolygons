import java.awt.Dimension;

import acm.graphics.GDimension;
import acm.graphics.GTurtle;

public class PIsotropicGrid extends PIsotropicPolygon {

	public PIsotropicGrid(Dimension size, PParameters parameters) {
		super(size, parameters);
	}
	
	public void initPolygon(double width, double height, PParameters parameters) {
		polygon = PPolygonFactory.polygon(parameters.getNumPolySides(), width/parameters.getColumns(), height/parameters.getRows());
	}
	
	public void update() {
		super.update();
		fitFrame(getWidth(), getHeight());
		getPolygon().setSize(getWidth(), getHeight());
	}

	public GDimension recalculateSize(double sf, double ar) {

		double h = 1;
		double cols = getParameters().getColumns();
		double rows = getParameters().getRows();

		while (h * ar * cols < getWidth() && h * rows < getHeight()) {
			h++;
		}

		if (h * ar * cols > getWidth()) {
			h--;
		}

		setNewSize(sf * h * ar * cols, sf * h * rows);

		return getNewSize();
	}
	
	public PRenderer getRenderer(GTurtle turtle) {
		return new PGridRenderer(turtle, this);

	}

}
