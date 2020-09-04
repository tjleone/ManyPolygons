import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GTurtle;
import acm.program.GraphicsProgram;
import acm.program.ProgramMenuBar;

@SuppressWarnings("serial")
public class PProgram extends GraphicsProgram {
	
	@SuppressWarnings("ucd")
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private PParameters parameters;
	private GTurtle turtle;
	private PIsotropicGrid renderingBounds = null;
	
	protected ProgramMenuBar createMenuBar() {
		print("createMenuBar");
		return new PMenuBar(this);
	}
	
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
//		parameters = new PParameters(2, 2, 3, 10, 0.2, 0.9);
//		parameters = new PParameters(2, 2, 3, 10, 0.8, 0.9);
//		parameters = new PParameters(2, 2, 4, 10, 0.2, 0.9);
		parameters = new PParameters(8, 8, 4, 10, 0.2, 0.9);
//		parameters = new PParameters(2, 2, 8, 10, 0.2, 0.9);
	}
	
	@SuppressWarnings("ucd")
	public void updateRows(int rows) {
		parameters.setRows(rows);
		update();
	}
	
	@SuppressWarnings("ucd")
	public void updateColumns(int cols) {
		parameters.setColumns(cols);
		update();
	}
	
	@SuppressWarnings("ucd")
	public void updateShape(int numPolySides) {
		parameters.setNumPolySides(numPolySides);
		update();
	}
	
	private void initRenderingInfo() {
		assert turtle != null;
		assert parameters != null;
//		programRectangle = new GRectangle(0,0,getWidth(), getHeight());
		renderingBounds =  new PIsotropicGrid(getSize(), parameters);
		renderingBounds.getRenderer(turtle);
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
	
	private void update() {
		double scaleFactor = parameters.getScaleFactor();
		int numPolySides = parameters.getNumPolySides();
		double aspectRatio = PAspectCalculatorFactory.calculator(numPolySides).aspectRatio();
		renderingBounds.fitFrame(getWidth(), getHeight());
		GDimension newSize = renderingBounds.recalculateSize(scaleFactor, aspectRatio);
		renderingBounds.resize(newSize);
		renderingBounds.initPolygon(newSize.getWidth(), newSize.getHeight(), parameters);
		
		renderingBounds.getRenderer(turtle).render();
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
