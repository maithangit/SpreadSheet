package Calculator;

public class Divide extends Operator{
	@Override
	public double compute(double left, double right) {
		try {
				return left / right;
	        }
		catch (ArithmeticException ae) {
	        System.out.println("ArithmeticException occured!");
	        return Double.NaN;
	    }
	}
}
