import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CanvasModel extends GDimension {

	public final static double GRID_SCALE_FACTOR = 0.9;
	
	// using Logger.Logger.GLOBAL_LOGGER_NAME + "." before the class name makes
	// the global logger defined in Main into the parent logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CanvasModel.class.getName());
	
	private CanvasComponent _component;
	private GridModel _grid;
	
	public CanvasModel() {
		this(0, 0);
	}

	public CanvasModel(Dimension size) {
		this(size.getWidth(), size.getHeight());
	}

	public CanvasModel(double width, double height) {
		super(width, height);
		// if log level is not set, LOGGER.getLevel() is null, 
		// which means that this LOGGER's effective level is the 
		// level of its parent
		// LOGGER.log(Level.FINEST, "Canvas Level: {0}", LOGGER.getLevel());
		LOGGER.log(Level.FINEST, "Canvas Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Canvas Height: {0}", getHeight());
		
		_grid = new GridModel();
	}

	public CanvasModel(GDimension size) {
		this(size.getWidth(), size.getHeight());
	}
	
	public GRectangle getGridBounds() {
		return _grid.getBounds();
	}

	public void resize(double width, double height) {
		setSize(width, height);
		setGrid();
	}
	
	public void resize(GDimension size) {
		resize(size.getWidth(), size.getHeight());
	}
	
	public void setGrid() {
		setGridSize();
		setGridLocation();
	}

	public void setGridSize() {
		double aspectRatio = _grid.getAspectRatio();
		if (getWidth() / getHeight() > aspectRatio) {
			_grid.setSize(getHeight() * aspectRatio * GRID_SCALE_FACTOR, getHeight() * GRID_SCALE_FACTOR);
		} else  {
			_grid.setSize(getWidth() * GRID_SCALE_FACTOR, getWidth() / aspectRatio * GRID_SCALE_FACTOR);
		}
	}
	
	public void setGridLocation() {
		double leftMargin = (getWidth() - _grid.getWidth()) / 2;
		double bottomMargin = (getHeight() - _grid.getHeight()) / 2;
		_grid.setLocation(leftMargin, getHeight() - bottomMargin);
	}
	
	public GRectangle getGrid() {
		return _grid;
	}

}
