import acm.graphics.GDimension;

public class PolygonComponent extends AbstractComponent {
	
	private Polygon _polygon;

	public PolygonComponent() {
		this(null);
	}
	
	public PolygonComponent(Polygon polygon) {
		super();
		_polygon = polygon;
	}

	@Override
	public GDimension getSize() {
		return _polygon.getSize();
	}

}
