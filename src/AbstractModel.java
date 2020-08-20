import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public abstract class AbstractModel extends GRectangle {
	
	private GRectangle _maxBounds;
	private GPoint _center;

	public AbstractModel() {
		this(0, 0, 0, 0, null);
	}

	public AbstractModel(double width, double height, ModelParameters parameters)  {
		this(0, 0, width, height, parameters);
	}

	public AbstractModel(GDimension size, ModelParameters parameters)  {
		this(0, 0, size.getWidth(), size.getHeight(), parameters);
	}

	public AbstractModel(GPoint pt, GDimension size, ModelParameters parameters)  {
		this(pt.getX(), pt.getY(), size.getWidth(), size.getHeight(), parameters);
	}

	public AbstractModel(GPoint pt, ModelParameters parameters)  {
		this(pt.getX(), pt.getY(), 0, 0, parameters);
	}

	public AbstractModel(GRectangle r, ModelParameters parameters)  {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), parameters);
	}

	public AbstractModel(double x, double y, double width, double height, ModelParameters parameters)  {
		super(x, y, width, height);
		_maxBounds = new GRectangle(x, y, width, height);
		_center = center(new GPoint());
	}
	
	public double top() {
		return getY();
	}
	
	public double left() {
		return getX();
	}
	
	public double bottom() {
		return getY() + getHeight();
	}
	
	public double right() {
		return getX() + getWidth();
	}
	
	public double centerX() {
		return left() + getWidth() / 2;
	}
	
	public double centerY() {
		return top() + getHeight() / 2;
	}
	
	public GPoint center(GPoint pt) {
		pt.setLocation(centerX(), centerY());
		return pt;
	}
	
	public GPoint center() {
		assert _center != null;
		return _center;
	}
	
	// Resize the model based on the parameters
	public void resize(ModelParameters parameters) {
		resize(_maxBounds, parameters);
	}
	
	public GRectangle get_maxBounds() {
		return _maxBounds;
	}

	public void set_maxBounds(GRectangle _maxBounds) {
		this._maxBounds = _maxBounds;
	}

	public abstract void resize(GRectangle maxBounds, ModelParameters parameters);

}
