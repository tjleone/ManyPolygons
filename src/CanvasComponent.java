import java.util.logging.Logger;

import acm.graphics.GDimension;
import acm.graphics.GTurtle;

public class CanvasComponent extends AbstractComponent {
	
	CanvasModel _model;
	GridComponent _gridComponent;
	
	// using Logger.Logger.GLOBAL_LOGGER_NAME + "." before the class name makes
	// the global logger defined in Main into the parent logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + CanvasComponent.class.getName());
	
	public CanvasComponent(CanvasModel model) {
		this(model, null);
	}
	
	public CanvasComponent(CanvasModel model, ModelParameters parameters) {
		_model = model;
		_gridComponent = new GridComponent(_model.getGrid());
	}

	public void update(GTurtle t) {
		t.erasePath();
		_gridComponent.draw(t);
	}

	@Override
	public GDimension getSize() {
		return _model.getSize();
	}
	
	public CanvasModel getModel() {
		return _model;
	}

}
