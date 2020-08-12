import java.io.IOException;
import java.util.logging.FileHandler;
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
public class GridModel extends GRectangle {

	// The aspect ratio will eventually be determined by
	// the aspect ratio of the cells and the number of
	// rows and columns
	public final static double DEFAULT_ASPECT_RATIO = 4.0 / 3.0;
//	private final static Logger LOGGER = Logger.getLogger(GridModel.class.getName());
//	private static FileHandler _fileHandler;
    
    public GridModel() {
		this(0, 0, 0, 0);
	}

	public GridModel(double x, double y, double width, double height) {
		super(x, y, width, height);
//		try {
//			_fileHandler = Util.createFileHandler(LOGGER.getName());
//			LOGGER.setLevel(Level.ALL);
//			LOGGER.addHandler(_fileHandler);
//		} catch (IOException e) {
//			e.printStackTrace();
//		};
//		setSize(width, height);
	}

	public GridModel(double width, double height) {
		this(0, 0, width, height);
	}

	public GridModel(GDimension size) {
		this(0, 0, size.getWidth(), size.getHeight());
	}

	public GridModel(GPoint pt, GDimension size) {
		this(pt.getX(), pt.getY(), size.getWidth(), size.getHeight());
	}

	public GridModel(GPoint pt) {
		this(pt.getX(), pt.getY(), 0, 0);
	}

	public GridModel(GRectangle r) {
		this(r.getX(), r.getY(), r.getWidth(), r.getHeight());
	}
	
	public void setSize(GDimension size) {
		setSize(size.getWidth(), size.getHeight());
	}
	public void setSize(double width, double height) {
		super.setSize(width, height);
	}

	// The aspect ratio will eventually be determined by
	// the aspect ratio of the cells and the number of
	// rows and columns
	public double getAspectRatio() {
//		if (getWidth() * getHeight() != 0) {
//			return getWidth() / getHeight();
//		}
		return DEFAULT_ASPECT_RATIO;
	}
}
