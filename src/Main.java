import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GCanvas;
import acm.graphics.GRectangle;
import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

@SuppressWarnings("serial")
public class Main extends GraphicsProgram {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static FileHandler _fileHandler;

	private ModelParameters _parameters;
	private GRectangle frameRectangle = new GRectangle();
	private IsotropicRectangle canvas = null;
	private Polygon polygon = null;
	private PolygonComponent component = null;
	private GTurtle turtle = new GTurtle();

	public Main() {
		try {
			_fileHandler = Util.createFileHandler(LOGGER.getName());
			LOGGER.setLevel(Level.ALL);
//			LOGGER.setLevel(Level.SEVERE);
			LOGGER.addHandler(_fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public void init() {
		super.init();
		initParameters();
		initializeTurtle();
		polygon = PolygonBuilder.polygon(_parameters.getNumPolySides());
		component = new PolygonComponent(polygon);
		canvas = new IsotropicRectangle(getRectangle(), 0.9, polygon.getAspectRatio());
		update();
	}
	
	private void initParameters() {
		// int rows, int columns, int numPolySides, int polysInSpiral, double displacementPortion
		_parameters = new ModelParameters(2, 2, 7, 10, 0.2);
	}
	
	private void initializeTurtle() {
		turtle.hideTurtle();
		turtle.setSpeed(1);
		add(turtle);
	}
	
	private GRectangle getRectangle() {
		frameRectangle.setLocation(0, 0);
		frameRectangle.setSize(getWidth(), getHeight());
		return frameRectangle;
	}
	
	public void run() {
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
		canvas.fitFrame(getWidth(), getHeight());
		polygon.updateSize(canvas.getWidth(), canvas.getHeight());
		drawCanvas();
	}
	
	private void drawCanvas() {
		turtle.erasePath();
		turtle.penUp();
		turtle.setLocation(canvas.getBottomLeft());
		System.out.println("canvas.getBottomLeft()=" + canvas.getBottomLeft());
		turtle.penDown();
		drawRectangle(canvas.getWidth(), canvas.getHeight());
		component.draw(turtle);
		System.out.print("canvas location = [" + canvas.getX() + ", " + canvas.getY() + "]");
	}

	private void drawRectangle(double width, double height) {
		for(int i=0; i < 2; i++) {
			turtle.forward(width);
			turtle.left(90);
			turtle.forward(height);
			turtle.left(90);
		}
		
	}
	/* Standard Java entry point */
	/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new Main().start(args);
	}

}
