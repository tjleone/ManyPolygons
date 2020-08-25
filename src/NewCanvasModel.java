import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

public class NewCanvasModel extends CanvasModel {

	public NewCanvasModel() {
		this(0,0,0,0,null);
	}

	public NewCanvasModel(double x, double y, double width, double height, ModelParameters parameters) {
		super(x, y, width, height, parameters);
	}

	public NewCanvasModel(double width, double height, ModelParameters parameters) {
		super(width, height, parameters);
	}

	public NewCanvasModel(GDimension size, ModelParameters parameters) {
		super(size, parameters);
	}

	public NewCanvasModel(GPoint pt, GDimension size, ModelParameters parameters) {
		super(pt, size, parameters);
	}

	public NewCanvasModel(GPoint pt, ModelParameters parameters) {
		super(pt, parameters);
	}

	public NewCanvasModel(GRectangle r, ModelParameters parameters) {
		super(r, parameters);
	}

}
