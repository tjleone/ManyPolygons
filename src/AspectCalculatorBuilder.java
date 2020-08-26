
public class AspectCalculatorBuilder {

	public static AspectCalculator calculator(int n) {
		if (n % 4 == 0) {
			return new QuadAspectCalculator(n);
		}
		if (n % 2 == 0) {
			return new EvenAspectCalculator(n);
		}
		
		return new OddAspectCalculator(n);
		
	}

}
