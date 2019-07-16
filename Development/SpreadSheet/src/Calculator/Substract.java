package Calculator;

public class Substract extends Operator {
	@Override
	public double compute(double left, double right) {
		return left - right;
	}
    @Override
    public String toString() {
        return "-";
    }
}
