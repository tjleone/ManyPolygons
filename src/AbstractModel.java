import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

public abstract class AbstractModel extends GRectangle implements Cloneable {

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
	}
	
	public AbstractModel clone() throws CloneNotSupportedException {
		AbstractModel clonedObj = (AbstractModel) super.clone();
		return clonedObj;
	}
	 
	// For now, I'm cloning the current model to keep from messing things up
	// when resizing. I can revisit this later when things are working to
	// see if I can avoid the cloning.
	public void resize(ModelParameters parameters) throws CloneNotSupportedException {
		resize(this.clone(), parameters);
	}
	
	public abstract void resize(GRectangle maxBounds, ModelParameters parameters);

}
