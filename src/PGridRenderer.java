import acm.graphics.GTurtle;

public class PGridRenderer extends PRenderer {
	
	private PIsotropicGrid grid;

	public PGridRenderer(GTurtle turtle, PIsotropicRectangle bounds) {
		super(turtle, bounds);
		assert PIsotropicGrid.class.isInstance(bounds);
		grid = (PIsotropicGrid)bounds;
	}

	public PGridRenderer(GTurtle turtle, PIsotropicRectangle bounds, PPolygonRenderer polygonRenderer) {
		super(turtle, bounds);
		assert PIsotropicGrid.class.isInstance(bounds);
		grid = (PIsotropicGrid)bounds;
	}
	
	public PGridRenderer(GTurtle turtle, PIsotropicGrid bounds, PRenderer polygonRenderer) {
		super(turtle, bounds);
		assert PIsotropicGrid.class.isInstance(bounds);
		grid = (PIsotropicGrid)bounds;
	}

	public void drawPicture() {
		drawGrid();
	}
	
	public void drawGrid() {
		for(int i=0; i < grid.getCols(); i++) {
			for(int j=0; j < grid.getRows(); j++) {
				drawRectangle(grid.getCellWidth(), grid.getCellHeight());
			}
		}
	}

}
