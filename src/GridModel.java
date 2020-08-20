import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tj
 */
@SuppressWarnings("serial")
public class GridModel extends AbstractModel {

	// The aspect ratio will eventually be determined by
	// the aspect ratio of the cells and the number of
	// rows and columns
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + GridModel.class.getName());

	public final static double DEFAULT_ASPECT_RATIO = 4.0 / 3.0;
	private final static double DEFAULT_CELL_WIDTH = 153.85752949088308;
	private final static double DEFAULT_CELL_HEIGHT = 150;

	private int _rows; 
	private int _columns;

	private CellModel _cellModel;

	public GridModel() {
		this(0,0,0,0,null);
	}

	public GridModel(double x, double y, double width, double height, ModelParameters parameters) {
		super(x, y, width, height, parameters);
		assert parameters != null;
		_rows = parameters.getRows();
		_columns = parameters.getColumns();
		_cellModel = new CellModel(DEFAULT_CELL_WIDTH, DEFAULT_CELL_HEIGHT, parameters);
		LOGGER.log(Level.FINEST, "Grid X: {0}", getX());
		LOGGER.log(Level.FINEST, "Grid Y: {0}", getY());
		LOGGER.log(Level.FINEST, "Grid Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Grid Height: {0}", getHeight());
	}

	public GridModel(double width, double height, ModelParameters parameters) {
		this(0,0, width, height, parameters);
	}

	public GridModel(GDimension size, ModelParameters parameters) {
		this(0, 0, size.getWidth(), size.getHeight(), parameters);
	}

	public GridModel(GPoint pt, GDimension size, ModelParameters parameters) {
		this(pt.getX(), pt.getY(), size.getWidth(), size.getHeight(), parameters);
	}

	public GridModel(GPoint pt, ModelParameters parameters) {
		this(pt.getX(), pt.getY(), 0, 0, parameters);
	}

	public GridModel(GRectangle r, ModelParameters parameters) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight(), parameters);
	}

	// The aspect ratio will eventually be determined by
	// the aspect ratio of the cells and the number of
	// rows and columns
	//
	// This should be checked after every resize to make sure
	// it hasn't changed
	public double getAspectRatio() {
//		if (getWidth() * getHeight() != 0) {
//			return getWidth() / getHeight();
//		}
		return DEFAULT_ASPECT_RATIO;
	}

	public int getRows() {
		return _rows;
	}

	public void setRows(int _rows) {
		this._rows = _rows;
	}

	public int getColumns() {
		return _columns;
	}

	public void setColumns(int _columns) {
		this._columns = _columns;
	}
	
	public CellModel getCellModel() {
		return _cellModel;
	}

	public void setCellModel(CellModel cellModel) {
		this._cellModel = cellModel;
	}

	@Override
	public void resize(GRectangle maxBounds, ModelParameters parameters) {
//		setBounds(maxBounds);
		setBounds(maxBounds);
		double maxCellWidth = maxBounds.getWidth() / parameters.getRows();
		double maxCellHeight = maxBounds.getHeight() / parameters.getColumns();
		_cellModel.adjustBoundsToFitPolygon(maxCellWidth, maxCellHeight, parameters);
		double width = _cellModel.getWidth()*parameters.getRows();
		double height = _cellModel.getHeight()*parameters.getColumns();
		setSize(width, height);
		LOGGER.log(Level.FINEST, "// resize: size = {0}", getSize());
		LOGGER.log(Level.FINEST, "// resize: centerX() = {0}", centerX());
		LOGGER.log(Level.FINEST, "// resize: centerY() = {0}", centerY());
		setLocation(centerX() - width/2, centerY() - height/2);
	}
}
