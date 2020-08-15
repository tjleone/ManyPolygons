import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GRectangle;
import acm.graphics.GTurtle;

public class CanvasComponent {
	
	CanvasModel _model;
	GridComponent _gridComponent;
	
	// using Logger.Logger.GLOBAL_LOGGER_NAME + "." before the class name makes
	// the global logger defined in Main into the parent logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CanvasComponent.class.getName());
	
	public CanvasComponent(CanvasModel model) {
		_model = model;
		_gridComponent = new GridComponent(_model.getGrid());
	}

	public void update(GTurtle t) {
		t.erasePath();
		_gridComponent.draw(t);
	}

}
