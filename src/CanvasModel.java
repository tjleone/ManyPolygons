import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CanvasModel extends AbstractModel {

	public final  static double SCALE_FACTOR = 0.9;
	public final static double GRID_SCALE_FACTOR = 0.9;
	public final static int DEFAULT_SPIRAL_DEPTH = 10;
	public final static double DEFAULT_SPIRAL_DISPLACEMENT = 0.2;
	
	// using Logger.Logger.GLOBAL_LOGGER_NAME + "." before the class name makes
	// the global logger defined in Main into the parent logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CanvasModel.class.getName());
	private GridModel _grid;

	public CanvasModel() {
		this(0,0,0,0,null);
	}

	public CanvasModel(double x, double y, double width, double height, ModelParameters parameters) {
		super(x, y, width, height, parameters);
		_grid = new GridModel(0,0, width, height, parameters);
	}

	public CanvasModel(double width, double height, ModelParameters parameters) {
		this(0,0, width, height, parameters);
	}

	public CanvasModel(GDimension size, ModelParameters parameters) {
		this(0, 0, size.getWidth(), size.getHeight(), parameters);
	}

	public CanvasModel(GPoint pt, GDimension size, ModelParameters parameters) {
		this(pt.getX(), pt.getY(), size.getWidth(), size.getHeight(), parameters);
	}

	public CanvasModel(GPoint pt, ModelParameters parameters) {
		this(pt.getX(), pt.getY(), 0, 0, parameters);
	}

	public CanvasModel(GRectangle r, ModelParameters parameters) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), parameters);
	}
	
	public GRectangle getGridBounds() {
		return _grid.getBounds();
	}
	
	public GridModel getGrid() {
		return _grid;
	}
	
	public void resize(Rectangle maxBounds, ModelParameters parameters) {
		resize(maxBounds.getX(), maxBounds.getY(), maxBounds.getWidth(), maxBounds.getHeight(), parameters);
	}

	@Override
	public void resize(GRectangle maxBounds, ModelParameters parameters) {
		resize(maxBounds.getX(), maxBounds.getY(), maxBounds.getWidth(), maxBounds.getHeight(), parameters);
	}
	
	public void resize(double x, double y, double width, double height, ModelParameters parameters) {
		LOGGER.log(Level.FINEST, "// resize (entering): center = {0}", center());
		LOGGER.log(Level.FINEST, "// resize (entering): (centerX,centerY) = {0},{1})", 
				new Object[] { centerX(), centerY() });
		setSize(width*SCALE_FACTOR, height*SCALE_FACTOR);
		double deltaX = (width - getWidth()) / 2;
		double deltaY = (height - getHeight())/2;
		LOGGER.log(Level.FINEST, "// resize: (x,y) = {0},{1})", 
				new Object[] { x, y });
		LOGGER.log(Level.FINEST, "// resize (before translate): (getX(), getY()) = {0},{1})", 
				new Object[] { getX(), getY() });
		LOGGER.log(Level.FINEST, "// resize: (deltaX, deltaY) = {0},{1})", 
				new Object[] { deltaX, deltaY });
		translate(deltaX, deltaY);
		LOGGER.log(Level.FINEST, "// resize (after translate): (getX(), getY()) = {0},{1})", 
				new Object[] { getX(), getY() });
		LOGGER.log(Level.FINEST, "// resize (after translate): (getWidth(), getHeight()) = {0},{1})", 
				new Object[] { getX(), getY() });
		LOGGER.log(Level.FINEST, "// resize (calling _grid.resize): center = {0}", center());
		LOGGER.log(Level.FINEST, "// resize (calling _grid.resize): (centerX,centerY) = {0},{1})", 
				new Object[] { centerX(), centerY() });
		_grid.resize(getBounds(), parameters);
		LOGGER.log(Level.FINEST, "// resize (leaving): center = {0}", center());
		LOGGER.log(Level.FINEST, "// resize (leaving): (centerX,centerY) = {0},{1})", 
				new Object[] { centerX(), centerY() });
	}

//	public void resize(double width, double height) {
//		setSize(width, height); // set width and height of CanvasModel
////		setGridBounds();				// size and location of GridModel
//		setGridBounds(307.71505898176616, 300); // set grid size with maxWidth, maxHeight for testing
//		LOGGER.log(Level.FINEST, "CanvasModel dimensions: {0}", getSize());
//		LOGGER.log(Level.FINEST, "CanvasModel center: {0}", getCenter());
//		LOGGER.log(Level.FINEST, "CanvasModel grid dimensions: {0}", getGridSize());
//	}
//	
//	public void resize(GDimension size) {
//		resize(size.getWidth(), size.getHeight());
//	}
//	
//	public void setGridBounds() {
//		setGridSize();
//		setGridLocation();
//	}
//	
//	public void setGridBounds(double maxWidth, double maxHeight) {
//		setGridSize(maxWidth, maxHeight);
//		setGridLocation();
//	}
//
//	private GDimension getGridSize()
//	{
//		return _grid.getSize();
//	}
//	
//	public void setGridSize() {
//		double aspectRatio = _grid.getAspectRatio();
//		if (getWidth() / getHeight() > aspectRatio) {
//			_grid.setSize(getHeight() * aspectRatio * GRID_SCALE_FACTOR, getHeight() * GRID_SCALE_FACTOR);
//		} else  {
//			_grid.setSize(getWidth() * GRID_SCALE_FACTOR, getWidth() / aspectRatio * GRID_SCALE_FACTOR);
//		}
//	}
//	
//	public void setGridSize(double width, double height) {
//		_grid.setSize(width, height);
//	}
//	
//	public void setGridLocation() {
//		double leftMargin = (getWidth() - _grid.getWidth()) / 2;
//		double bottomMargin = (getHeight() - _grid.getHeight()) / 2;
//		_grid.setLocation(leftMargin, getHeight() - bottomMargin);
//	}

}
