import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;

@SuppressWarnings("serial")
public class CellModel extends GDimension {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CellModel.class.getName());

	public CellModel() {
		this(0, 0);
	}

	public CellModel(Dimension size) {
		this(size.getWidth(), size.getHeight());
	}

	public CellModel(double width, double height) {
		super(width, height);
		LOGGER.setLevel(Level.ALL);
		LOGGER.log(Level.FINEST, "Cell Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Cell Height: {0}", getHeight());
	}

	public CellModel(GDimension size) {
		this(size.getWidth(), size.getHeight());
	}
	
	public int getNumSides() {
		return 7;
	}
	
	public double getStartX() {
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
