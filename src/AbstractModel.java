import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

public abstract class AbstractModel extends GRectangle {
	
	private GRectangle _maxBounds;

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
