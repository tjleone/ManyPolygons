import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CanvasModel extends GDimension {

	public final static double GRID_SCALE_FACTOR = 0.9;
//	private final static Logger LOGGER = Logger.getLogger(CanvasModel.class.getName());
//	private static FileHandler _fileHandler;
	
	private GridModel _grid;
	
	public CanvasModel() {
		this(0, 0);
	}

	public CanvasModel(Dimension size) {
		this(size.getWidth(), size.getHeight());
	}

	public CanvasModel(double width, double height) {
		super(width, height);
//		try {
//			_fileHandler = Util.createFileHandler(LOGGER.getName());
//			LOGGER.setLevel(Level.ALL);
//			LOGGER.addHandler(_fileHandler);
//		} catch (IOException e) {
//			e.printStackTrace();
//		};
		
		_grid = new GridModel();
	}

	public CanvasModel(GDimension size) {
		this(size.getWidth(), size.getHeight());
	}
	
	public GRectangle getGridBounds() {
		return _grid.getBounds();
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
