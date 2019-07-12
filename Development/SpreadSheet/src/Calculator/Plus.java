package Calculator;

public class Plus extends Operator{
	@Override
	public double compute(double left, double right) {
		return left + right;
	}
}
