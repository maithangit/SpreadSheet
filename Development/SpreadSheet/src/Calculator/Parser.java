package Calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Parser {
	public Expression Parse(String polish)
    {
        List<String> symbols =  new LinkedList<String>(Arrays.asList(polish.split(" ")));
        return ParseNextExpression(symbols);
    }
 
    public Expression ParseNextExpression(List<String> symbols)
    {
        int value;
        try {
        	value = Integer.parseInt(symbols.get(0));
        	symbols.remove(0);
            return new IntegerExpression(value);
        }
        catch (Exception ex) {
        	return ParseNonTerminalExpression(symbols);
        }
    }
 
    private Expression ParseNonTerminalExpression(List<String> symbols)
    {
        String symbol = symbols.get(0);
        symbols.remove(0);
 
        Expression expr1 = ParseNextExpression(symbols);
        Expression expr2 = ParseNextExpression(symbols);
 
        switch (symbol)
        {
            case "+":
                return new AdditionExpression(expr1, expr2);
            case "-":
                return new SubtractionExpression(expr1, expr2);
            default:
                String message = String.format("Invalid Symbol ({0})", symbol);
                //throw new InvalidOperationException(message);
                return null;
        }
    }
}
