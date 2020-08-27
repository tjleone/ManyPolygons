
public class PAspectCalculatorFactory {

	public static PAspectCalculator calculator(int n) {
		if (n % 4 == 0) {
			return new PQuadAspectCalculator(n);
		}
		if (n % 2 == 0) {
			return new PEvenAspectCalculator(n);
		}
		
		return new POddAspectCalculator(n);
		
	}

}
