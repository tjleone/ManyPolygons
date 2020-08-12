import acm.graphics.*;
import acm.program.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TJ Leone
 */
@SuppressWarnings("serial")
public class ManyPolygonsProgram extends GraphicsProgram {

	private final static Logger LOGGER = Logger.getLogger(ManyPolygonsProgram.class.getName());
	private static FileHandler _fileHandler;

	CanvasModel _model;
	GTurtle _turtle;

	public ManyPolygonsProgram() {
		try {
			_fileHandler = Util.createFileHandler(LOGGER.getName());
			LOGGER.setLevel(Level.ALL);
			LOGGER.addHandler(_fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		};
		_model = new CanvasModel();
		_turtle = new GTurtle();
	}

	private void initModel() {
		_model.setSize(getWidth(), getHeight());
		_model.setGrid();
	}
	
	private void drawRectangle(GRectangle bounds) {
		_turtle.penUp();
		_turtle.setLocation(bounds.getLocation());
		for(int i=0; i < 2; i++) {
			_turtle.penDown();
			_turtle.forward(bounds.getWidth());
			_turtle.left(90);
			_turtle.forward(bounds.getHeight());
			_turtle.left(90);
		}
	}

	@Override
	public void run() {
		LOGGER.log(Level.FINEST, "Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Height: {0}", getHeight());
		initModel();
		add(_turtle);
		GRectangle gridBounds = _model.getGrid();
		LOGGER.log(Level.FINEST, "Grid X: {0}", gridBounds.getX());
		LOGGER.log(Level.FINEST, "Grid Y: {0}", gridBounds.getY());
		LOGGER.log(Level.FINEST, "Grid Width: {0}", gridBounds.getWidth());
		LOGGER.log(Level.FINEST, "Grid Height: {0}", gridBounds.getHeight());
		drawRectangle(_model.getGridBounds());
		// addComponent is inherited from Component
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				_turtle.erasePath();
				initModel();
				GRectangle gridBounds = _model.getGrid();
				LOGGER.log(Level.FINEST, "Grid X: {0}", gridBounds.getX());
				LOGGER.log(Level.FINEST, "Grid Y: {0}", gridBounds.getY());
				LOGGER.log(Level.FINEST, "Grid Width: {0}", gridBounds.getWidth());
				LOGGER.log(Level.FINEST, "Grid Height: {0}", gridBounds.getHeight());
				drawRectangle(_model.getGridBounds());
			}
		});
		try {
			_fileHandler.close();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	}

	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new ManyPolygonsProgram().start(args);
		/*
		try {
			new ManyPolygonsProgram().start(args);
		} catch (IOException e) {
            Logger.getLogger(ManyPolygonsProgram.class.getName()).log(Level.SEVERE, null, e);
		}
		*/
	}

}
