import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;

@SuppressWarnings("serial")
public class CellModel extends GDimension {

//	private final static Logger LOGGER = Logger.getLogger(CellModel.class.getName());
//	private static FileHandler _fileHandler;

	public CellModel() {
		this(0, 0);
	}

	public CellModel(Dimension size) {
		this(size.getWidth(), size.getHeight());
	}

	public CellModel(double width, double height) {
		super(width, height);
//		try {
//			if (_fileHandler == null) {
//				_fileHandler = Util.createFileHandler(LOGGER.getName());
//				LOGGER.setLevel(Level.ALL);
//				LOGGER.addHandler(_fileHandler);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}

	public CellModel(GDimension size) {
		this(size.getWidth(), size.getHeight());
	}

}
