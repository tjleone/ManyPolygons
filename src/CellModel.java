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

}
