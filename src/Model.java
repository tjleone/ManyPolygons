import java.awt.Dimension;

import acm.graphics.GDimension;

public class Model {
	
	GDimension _maxSize;
	GDimension _adjustedSize;

	
	public Model() {
		this(0, 0);
	}

	public Model(Dimension size) {
		this(size.getWidth(), size.getHeight());
	}

	public Model(double width, double height) {
		_maxSize.setSize(width, height);
	}

	public GDimension getAdjustedSize() {
		return _adjustedSize;
	}

	public void setMaxSize(GDimension maxSize) {
		_maxSize = maxSize;
	}
	
	
}
