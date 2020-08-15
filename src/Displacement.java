import acm.graphics.GPoint;

public class Displacement {
	
	double _deltaX;
	double _deltaY;
	
	public Displacement() {
		this(0,0);
	}

	public Displacement(double _deltaX, double _deltaY) {
		this._deltaX = _deltaX;
		this._deltaY = _deltaY;
	}

	public double getDeltaX() {
		return _deltaX;
	}

	public void setDeltaX(double _deltaX) {
		this._deltaX = _deltaX;
	}

	public double getDeltaY() {
		return _deltaY;
	}

	public void setDeltaY(double _deltaY) {
		this._deltaY = _deltaY;
	}

	public void setDelta(GPoint pt, double x, double y) {
		setDeltaX(pt.getX() - x);
		setDeltaY(pt.getY() - x);
	}
	

}
