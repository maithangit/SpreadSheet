package Calculator;

public class AdditionExpression extends Expression {
	Expression expr1;
    Expression expr2;
 
    public AdditionExpression(Expression expr1, Expression expr2)
    {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    
    @Override
    public int Evaluate()
    {
        int value1 = this.expr1.Evaluate();
        int value2 = this.expr1.Evaluate();
        return value1 + value2;
    }
 
    @Override
    public String toString()
    {
        return String.format("({0} + {1})", this.expr1, this.expr2);
    }
}
