import acm.graphics.*;
import acm.program.*;

import java.awt.Color;
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
public class OldMain extends GraphicsProgram {

	public GTurtle _turtle = new GTurtle();
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	public static GPoint CENTER;
	
	private static FileHandler _fileHandler;

	private CanvasModel _model;
	private NewCanvasModel _newModel;
	private CanvasComponent _component;
	private NewCanvasComponent _newComponent;
	private ModelParameters _parameters;

	public OldMain() throws CloneNotSupportedException {
		try {
			_fileHandler = Util.createFileHandler(LOGGER.getName());
			LOGGER.setLevel(Level.ALL);
//			LOGGER.setLevel(Level.SEVERE);
			LOGGER.addHandler(_fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	private void initParameters() {
		// int rows, int columns, int numPolySides, int polysInSpiral, double displacementPortion
		_parameters = new ModelParameters(2, 2, 7, 10, 0.2);
	}
	
	private GPoint getCenter() {
		return new GPoint(getWidth()/2, getHeight()/2);
	}
	
	private void initializeTurtle() {
		_turtle.hideTurtle();
		_turtle.setSpeed(1);
		add(_turtle);
	}

	// _model.resize(width, height) should be enough to fix size
	// and trigger a redraw
	@Override
	public void run() {
		CENTER = new GPoint();
		CENTER.setLocation(getWidth()/2, getHeight()/2);
		initParameters();
		_model = new CanvasModel(0, 0, getWidth(), getHeight(), _parameters);
		_newModel = new NewCanvasModel(0, 0, getWidth(), getHeight(), _parameters);
		_component = new CanvasComponent(_model);
		_newComponent = new NewCanvasComponent(_newModel, _parameters);
		LOGGER.log(Level.FINEST, "// run: screen size {0}", getSize());
		LOGGER.log(Level.FINEST, "// run: center ({0},{1})", 
				new Object[] { getWidth()/2, getHeight()/2 });
		initializeTurtle();
		update();
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				update();
			}
		});
		try {
			_fileHandler.close();
		} catch (SecurityException e1) {
			e1.printStackTrace();
		}
	}

	private void update() {
		CENTER.setLocation(getWidth()/2, getHeight()/2);
		_model.resize(getWidth(), getHeight());
		_newModel.resize(getWidth(), getHeight());
		assert _model.getSize().getWidth() == _newModel.getSize().getWidth();
		assert _model.getSize().getHeight() == _newModel.getSize().getHeight();
		// for now, pass a max size and max height that will work best for tracing/logging
		
		// TODO: make each model a subclass of AbstractModel and do this:
//		_model.resize(getBounds(), _parameters);
		
//		_turtle.setColor(Color.BLACK);
//		_component.update(_turtle);
		
		_turtle.setColor(Color.RED);
		_newComponent.update(_turtle);
		_turtle.setColor(Color.BLACK);
	}

	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		try {
			new OldMain().start(args);
		} catch (CloneNotSupportedException e) {
            Logger.getLogger(OldMain.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		/*
		try {
			new ManyPolygonsProgram().start(args);
		} catch (IOException e) {
            Logger.getLogger(ManyPolygonsProgram.class.getName()).log(Level.SEVERE, null, e);
		}
		*/
	}

}
