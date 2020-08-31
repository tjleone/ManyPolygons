import acm.graphics.GTurtle;

public class PGridRenderer extends PPolygonRenderer {

	public PGridRenderer(GTurtle turtle, PIsotropicGrid bounds) {
		super(turtle, bounds);
		bounds.getPolygon().setSize(bounds.getWidth()/bounds.getParameters().getColumns(),
				bounds.getHeight()/bounds.getParameters().getRows());
	}

}
