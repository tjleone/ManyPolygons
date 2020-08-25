import acm.graphics.GTurtle;

public class NewCanvasComponent extends CanvasComponent {
	
	private PolygonComponent _polygonComponent;

	public NewCanvasComponent(CanvasModel model) {
		super(model);
	}

	public NewCanvasComponent(NewCanvasModel model) {
		this(model, null);
	}

	public NewCanvasComponent(NewCanvasModel model, ModelParameters parameters) {
		super(model);
		assert parameters != null;
		_polygonComponent = new PolygonComponent(PolygonBuilder.polygon(307.71506, 300.0, parameters));
	}

	public void update(GTurtle t) {
		t.erasePath();
		System.out.println("_model.getSize()=" + _model.getSize());
		System.out.println("t.getLocation()=" + t.getLocation());
		System.out.println("_model.getLocation()=" + _model.getLocation());
		System.out.println("_model.getCenter()=" + _model.getCenter());
 		draw(t, 307.71506, 300.0);
 		_polygonComponent.draw(t);
	}
	
	private void draw(GTurtle t, double width, double height) {
		System.out.println("Main.CENTER=" + Main.CENTER);
		t.penUp();
		t.setLocation(Main.CENTER);
		t.setDirection(0);
		t.forward(-width/2);
		t.right(90);
		t.forward(height/2);
		t.left(90);
		t.penDown();
		drawRectangle(t, width, height);
	}

}
