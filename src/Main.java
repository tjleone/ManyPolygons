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
public class Main extends GraphicsProgram {

	public final static GTurtle TURTLE = new GTurtle();
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static FileHandler _fileHandler;

	private CanvasModel _model;

	public Main() {
		try {
			_fileHandler = Util.createFileHandler(LOGGER.getName());
			LOGGER.setLevel(Level.ALL);
			LOGGER.addHandler(_fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		};
		_model = new CanvasModel();
	}

	private void initModel() {
		_model.resize(getWidth(), getHeight());
//		_model.setSize(getWidth(), getHeight());
//		_model.setGrid();
	}
	
	private void drawRectangle(GRectangle bounds) {
		TURTLE.penUp();
		TURTLE.setLocation(bounds.getLocation());
		for(int i=0; i < 2; i++) {
			TURTLE.penDown();
			TURTLE.forward(bounds.getWidth());
			TURTLE.left(90);
			TURTLE.forward(bounds.getHeight());
			TURTLE.left(90);
		}
	}

	// _model.resize(width, height) should be enough to fix size
	// and trigger a redraw
	@Override
	public void run() {
		LOGGER.log(Level.FINEST, "Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Height: {0}", getHeight());
		TURTLE.hideTurtle();
		add(TURTLE);
		_model.resize(getWidth(), getHeight());
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
				TURTLE.erasePath();
				_model.resize(getWidth(), getHeight());
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
		new Main().start(args);
		/*
		try {
			new ManyPolygonsProgram().start(args);
		} catch (IOException e) {
            Logger.getLogger(ManyPolygonsProgram.class.getName()).log(Level.SEVERE, null, e);
		}
		*/
	}

}
