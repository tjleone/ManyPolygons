
public class PMath {

	public static double tanDegrees(double d) {
		return Math.tan(Math.toRadians(d));
	}

	public static double asinDegrees(double sine) {
		return Math.toDegrees(Math.asin(sine));
	}

	/**
	 * From
	 * https://guava.dev/releases/19.0/api/docs/src-html/com/google/common/math/DoubleMath.html
	 * 
	 * Returns {@code true} if {@code a} and {@code b} are within {@code tolerance}
	 * of each other.
	 *
	 * <p>
	 * Technically speaking, this is equivalent to
	 * {@code Math.abs(a - b) <= tolerance || Double.valueOf(a).equals(Double.valueOf(b))}.
	 *
	 * <p>
	 * Notable special cases include:
	 * <ul>
	 * <li>All NaNs are fuzzily equal.
	 * <li>If {@code a == b}, then {@code a} and {@code b} are always fuzzily equal.
	 * <li>Positive and negative zero are always fuzzily equal.
	 * <li>If {@code tolerance} is zero, and neither {@code a} nor {@code b} is NaN,
	 * then {@code a} and {@code b} are fuzzily equal if and only if {@code a == b}.
	 * <li>With {@link Double#POSITIVE_INFINITY} tolerance, all non-NaN values are
	 * fuzzily equal.
	 * <li>With finite tolerance, {@code Double.POSITIVE_INFINITY} and {@code
	* Double.NEGATIVE_INFINITY} are fuzzily equal only to themselves.</li>
	 *
	 * <p>
	 * This is reflexive and symmetric, but <em>not</em> transitive, so it is
	 * <em>not</em> an equivalence relation and <em>not</em> suitable for use in
	 * {@link Object#equals} implementations.
	 *
	 * @throws IllegalArgumentException if {@code tolerance} is {@code < 0} or NaN
	 * @since 13.0
	 */
	public static boolean fuzzyEquals(double a, double b, double tolerance) {
		assert tolerance >= 0;
		return Math.copySign(a - b, 1.0) <= tolerance
				// copySign(x, 1.0) is a branch-free version of abs(x), but with different NaN
				// semantics
				|| (a == b) // needed to ensure that infinities equal themselves
				|| (Double.isNaN(a) && Double.isNaN(b));
	}

	/**
	 * From
	 * https://guava.dev/releases/19.0/api/docs/src-html/com/google/common/math/DoubleMath.html
	 * 
	 * Compares {@code a} and {@code b} "fuzzily," with a tolerance for nearly-equal
	 * values.
	 *
	 * <p>
	 * This method is equivalent to
	 * {@code fuzzyEquals(a, b, tolerance) ? 0 : Double.compare(a, b)}. In
	 * particular, like {@link Double#compare(double, double)}, it treats all NaN
	 * values as equal and greater than all other values (including
	 * {@link Double#POSITIVE_INFINITY}).
	 *
	 * <p>
	 * This is <em>not</em> a total ordering and is <em>not</em> suitable for use in
	 * {@link Comparable#compareTo} implementations. In particular, it is not
	 * transitive.
	 *
	 * @throws IllegalArgumentException if {@code tolerance} is {@code < 0} or NaN
	 * @since 13.0
	 */
	public static int fuzzyCompare(double a, double b, double tolerance) {
		if (fuzzyEquals(a, b, tolerance)) {
			return 0;
		} else if (a < b) {
			return -1;
		} else if (a > b) {
			return 1;
		} else {
			return Boolean.compare(Double.isNaN(a), Double.isNaN(b));
		}
	}

	private PMath() {
	}

}
