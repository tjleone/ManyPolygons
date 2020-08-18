import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GPoint;
import acm.graphics.GRectangle;

@SuppressWarnings("serial")
public class CellModel extends AbstractModel {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CellModel.class.getName());
	private int _numPolySides;
	private double _startX;

	public CellModel()  {
		this(0,0,0,0, null);
	}

	public CellModel(double x, double y, double width, double height, ModelParameters parameters) {
		super(x, y, width, height, parameters);
	}

	public CellModel(GDimension size, ModelParameters parameters)  {
		super(size, parameters);
	}

	public CellModel(GPoint pt, GDimension size, ModelParameters parameters)  {
		super(pt, size, parameters);
	}

	public CellModel(GPoint pt, ModelParameters parameters)  {
		super(pt, parameters);
	}

	public CellModel(GRectangle r, ModelParameters parameters)  {
		super(r, parameters);
		// TODO Auto-generated constructor stub
	}

	public CellModel(double width, double height, ModelParameters parameters)  {
		this(0, 0, width, height, parameters);
		LOGGER.setLevel(Level.ALL);
		LOGGER.log(Level.FINEST, "Cell Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Cell Height: {0}", getHeight());
	}
	
	public void resize(GRectangle maxBounds, ModelParameters parameters) {
		assert parameters != null : "null parameters";
		assert parameters.getNumPolySides() >= 3 : "number of sides < 3";
		_numPolySides = parameters.getNumPolySides();
		_startX = 42.69224358691905;
		LOGGER.log(Level.FINEST, "_numPolySides = {0}", _numPolySides);
	}

	public int getNumPolySides() {
//		return _numPolySides;
		return 7;
	}
	
	public double getStartX() {
//		return _startX;
		return 42.69224358691905;
	}
	
	public double getStartSideLength() {
		return 68.47304231704497;
	}
	
	public double getExternalAngle() {
		return 360.0 / 7.0;
	}
	
	public double calculateSpiralDisplacement(double sideLength) {
		return CanvasModel.DEFAULT_SPIRAL_DISPLACEMENT * sideLength;
	}
	
	public double calculateNextSideLength(double sideLength) {
		return sideLength * getSpiralSideLengthFactor();
	}
	
	public int getSpiralDepth() {
		return CanvasModel.DEFAULT_SPIRAL_DEPTH;
	}
	
	public double getSpiralAngle() {
		return 9.597912330850274;
	}
	
	public double getSpiralSideLengthFactor() {
		return 0.9378255363311423;
	}

}
