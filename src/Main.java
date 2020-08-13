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
//			LOGGER.setLevel(Level.ALL);
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.addHandler(_fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		};
		_model = new CanvasModel();
	}
	
	private void initializeTurtle() {
		TURTLE.hideTurtle();
		TURTLE.setSpeed(1);
		add(TURTLE);
	}

	// _model.resize(width, height) should be enough to fix size
	// and trigger a redraw
	@Override
	public void run() {
		LOGGER.log(Level.FINEST, "Width: {0}", getWidth());
		LOGGER.log(Level.FINEST, "Height: {0}", getHeight());
		initializeTurtle();
		_model.resize(getWidth(), getHeight());
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				_model.resize(getWidth(), getHeight());
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
