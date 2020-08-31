import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GRectangle;
import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;

@SuppressWarnings("serial")
public class PProgram extends GraphicsProgram {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private PParameters parameters;
	private GTurtle turtle;
	private GRectangle programRectangle = null;
	private PAspectCalculator aspectCalculator = null;
	private PIsotropicGrid renderingBounds = null;
	private PPolygon polygon = null;
	private PSpiral spiral = null;
	private PRenderer polygonRenderer = null;
	private PGridRenderer gridRenderer = null;

	public void init() {
		initLogging();
		LOGGER.log(Level.FINEST, "Logging initialized in Main");
		initParameters();
		initTurtle();
		initRenderingInfo();
		initListeners();
	}
	
	private void initLogging() {
		LogUtil.setupLogging(LOGGER.getName(), LOGGER, Level.ALL);
	}
	
	private void initParameters() {
		// int rows, int columns, int numPolySides, int polysInSpiral, double displacementPortion
//		parameters = new PParameters(2, 2, 3, 10, 0.2);
//		parameters = new PParameters(2, 2, 3, 10, 0.8);
		parameters = new PParameters(2, 2, 4, 10, 0.2);
//		parameters = new PParameters(2, 2, 7, 10, 0.2);
//		parameters = new PParameters(2, 2, 8, 10, 0.2);
		spiral = new PSpiral(parameters);
	}
	
	private void initRenderingInfo() {
		assert turtle != null;
		assert parameters != null;
		aspectCalculator = PAspectCalculatorFactory.calculator(parameters.getNumPolySides());
		programRectangle = new GRectangle(0,0,getWidth(), getHeight());
		renderingBounds =  new PIsotropicGrid(getProgramRectangle(), 0.9, aspectCalculator.aspectRatio(), 2, 2);
		polygon = PPolygonFactory.polygon(parameters.getNumPolySides(), renderingBounds.getWidth(), renderingBounds.getHeight());
		polygonRenderer = new PPolygonRenderer(turtle, renderingBounds, polygon, spiral);
		gridRenderer = new PGridRenderer(turtle, renderingBounds, polygonRenderer);
	}
	
	private void initTurtle() {
		turtle = new GTurtle();
		turtle.hideTurtle();
		turtle.setSpeed(1);
		add(turtle);
	}
	
	private void initListeners() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				update();
			}
		});
	}
	
	private GRectangle getProgramRectangle() {
		programRectangle.setLocation(0, 0);
		programRectangle.setSize(getWidth(), getHeight());
		return programRectangle;
	}
	
	private void update() {
		renderingBounds.fitFrame(getWidth(), getHeight());
		polygon.setSize(renderingBounds.getWidth(), renderingBounds.getHeight());
		polygonRenderer.render();
	}

	public void run() {
		
		finish();
	}
	
	private void finish() {
		LogUtil.tearDownLogging();
	}

/* Standard Java entry point */
/* This method can be eliminated in most Java environments */
	public static void main(String[] args) {
		new PProgram().start(args);
	}

}
