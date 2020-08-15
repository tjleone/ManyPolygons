import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CanvasModel extends GDimension {

	public final static double GRID_SCALE_FACTOR = 0.9;
	
	// using Logger.Logger.GLOBAL_LOGGER_NAME + "." before the class name makes
	// the global logger defined in Main into the parent logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CanvasModel.class.getName());
	private static Displacement _displacement = new Displacement();
	
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
		LOGGER.log(Level.FINEST, "CanvasModel dimensions: {0}", getSize());
		LOGGER.log(Level.FINEST, "CanvasModel center: {0}", getCenter());
		
		_grid = new GridModel();
	}

	public CanvasModel(GDimension size) {
		this(size.getWidth(), size.getHeight());
	}
	
	private GPoint getCenter() {
		return new GPoint(getWidth()/2, getHeight()/2);
	}
	
	// Offset of given location from center
	private Displacement getOffsetFromCenter(double x, double y) {
		_displacement.setDelta(getCenter(), x, y);
		return _displacement;
	}
	
	public GRectangle getGridBounds() {
		return _grid.getBounds();
	}

	public void resize(double width, double height) {
		setSize(width, height); // set width and height of CanvasModel
//		setGridBounds();				// size and location of GridModel
		setGridBounds(400,300); // set grid size with maxWidth, maxHeight for testing
		LOGGER.log(Level.FINEST, "CanvasModel dimensions: {0}", getSize());
		LOGGER.log(Level.FINEST, "CanvasModel center: {0}", getCenter());
		LOGGER.log(Level.FINEST, "CanvasModel grid dimensions: {0}", getGridSize());
	}
	
	public void resize(GDimension size) {
		resize(size.getWidth(), size.getHeight());
	}
	
	public void setGridBounds() {
		setGridSize();
		setGridLocation();
	}
	
	public void setGridBounds(double maxWidth, double maxHeight) {
		setGridSize(maxWidth, maxHeight);
		setGridLocation();
	}

	private GDimension getGridSize()
	{
		return _grid.getSize();
	}
	
	public void setGridSize() {
		double aspectRatio = _grid.getAspectRatio();
		if (getWidth() / getHeight() > aspectRatio) {
			_grid.setSize(getHeight() * aspectRatio * GRID_SCALE_FACTOR, getHeight() * GRID_SCALE_FACTOR);
		} else  {
			_grid.setSize(getWidth() * GRID_SCALE_FACTOR, getWidth() / aspectRatio * GRID_SCALE_FACTOR);
		}
	}
	
	public void setGridSize(double width, double height) {
		_grid.setSize(width, height);
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
