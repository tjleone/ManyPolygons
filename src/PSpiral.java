import java.util.logging.Level;
import java.util.logging.Logger;

import acm.graphics.GMath;

public class PSpiral {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME + "." + PSpiral.class.getName());

	private PParameters parameters;
	
	public PSpiral(PParameters parameters) {
		this.parameters = parameters;
	}
	
	public PParameters getParameters() {
		return parameters;
	}

	public void setParameters(PParameters parameters) {
		this.parameters = parameters;
	}

	public double getSpiralAngle() {
//		return 9.597912330850274;
		double q = getParameters().getDisplacementPortion();
	    double angle = PMath.asinDegrees(q*GMath.sinDegrees(getInternalAngle())/getScaleFactor());
	    if (getExternalAngle() > 90 && q > 0.5) {
	    	return 180 - angle;
	    }
	    return angle;
	}
	
	public double getExternalAngle() {
		return 360 / parameters.getNumPolySides();
	}
	
	public double getInternalAngle() {
		return 180 - getExternalAngle();
	}
	
	public double getScaleFactor() {
		double q = getParameters().getDisplacementPortion();
		double p = 1 - q;
		LOGGER.log(Level.FINEST, "q=" + q);
		LOGGER.log(Level.FINEST, "p=" + p);
		LOGGER.log(Level.FINEST, "internal angle = " + getInternalAngle());
		LOGGER.log(Level.FINEST, "GMath.cosDegrees(getInternalAngle()" + GMath.cosDegrees(getInternalAngle()));
		double result = Math.sqrt(p*p + q*q - 2*p*q*GMath.cosDegrees(getInternalAngle()));
		LOGGER.log(Level.FINEST, "getScaleFactor returns " + result);
		return Math.sqrt(p*p + q*q - 2*p*q*GMath.cosDegrees(getInternalAngle()));
	}
	
	public double calculateSpiralDisplacement(double sideLength) {
		return getParameters().getDisplacementPortion() * sideLength;
	}
	
	public double calculateNextSideLength(double sideLength) {
		return sideLength * getScaleFactor();
	}
	
	public int getSpiralDepth() {
		return getParameters().getSpiralDepth();
	}

}
