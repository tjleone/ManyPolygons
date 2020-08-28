import acm.graphics.GMath;

public class PSpiral {

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
	    return PMath.asinDegrees(q*GMath.sinDegrees(getInternalAngle())/getScaleFactor());
	}
	
	public double getInternalAngle() {
		return 180 - 360 / parameters.getNumPolySides();
	}
	
	public double getScaleFactor() {
		double q = getParameters().getDisplacementPortion();
		double p = 1 - q;
//		return 0.9378255363311423;
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
