package Calculator;

public class IntegerExpression extends Expression {
	private int value;
	 
    public IntegerExpression(int value)
    {
        this.value = value;
    }
 
    @Override
    public int Evaluate()
    {
        return value;
    }
 
    @Override
    public String toString()
    {
        return "" + value;
    }
}
