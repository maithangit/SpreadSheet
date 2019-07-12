package Calculator;

import java.util.Stack;

public class Calculator {
	private Stack<Token> operatorStack;
    private Stack<Token> valueStack;
    private boolean valid;
    
    public Calculator() {
    	operatorStack = new Stack<Token>();
        valueStack = new Stack<Token>();
        valid = false;
    }

    private void execute(Token token) {
        Token left = null, right = null;
        if (valueStack.isEmpty()) {
            System.out.println("Expression error.");
            valid = true;
            return;
        } else {
            right = valueStack.peek();
            valueStack.pop();
        }
        if (valueStack.isEmpty()) {
            System.out.println("Expression error.");
            valid = true;
            return;
        } else {
            left = valueStack.peek();
            valueStack.pop();
        }
        
        Token res = new Token ( "" + token.getOperator()
										  .compute(left.getValue(), right.getValue()));
        
        valueStack.push(res);
    }
    
    public double calculate(String input) {
//    	String expression = ExpressionUtil.formatExpression(input); 
    	Token[] tokens = ExpressionUtil.parseToken(input);
    	
        //Process tokens
        for (int n = 0; n < tokens.length; n++) {
            Token nextToken = tokens[n];
            if (nextToken.getType() == TokenType.NUMBER) {
                valueStack.push(nextToken);
            } else if (nextToken.getType() == TokenType.OPERATOR) {
                if (operatorStack.isEmpty() || nextToken.getPrecedence() > operatorStack.peek().getPrecedence()) {
                    operatorStack.push(nextToken);
                } else {
                    while (!operatorStack.isEmpty() && nextToken.getPrecedence() <= operatorStack.peek().getPrecedence()) {
                        Token toProcess = operatorStack.peek();
                        operatorStack.pop();
                        execute(toProcess);
                    }
                    operatorStack.push(nextToken);
                }
            } else if (nextToken.getType() == TokenType.OPEN_PARENTHESIS) {
                operatorStack.push(nextToken);
            } else if (nextToken.getType() == TokenType.CLOSE_PARENTHESIS) {
                while (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.OPERATOR) {
                    Token toProcess = operatorStack.peek();
                    operatorStack.pop();
                    execute(toProcess);
                }
                if (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.OPEN_PARENTHESIS) {
                    operatorStack.pop();
                } else {
                    System.out.println("Error: missing open/close parenthesis.");
                    valid = true;
                }
            }

        }

        while (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.OPERATOR) {
            Token toProcess = operatorStack.peek();
            operatorStack.pop();
            execute(toProcess);
        }

        if(valid == false) {
            Token result = valueStack.peek();
            valueStack.pop();
            
            if (!operatorStack.isEmpty() || !valueStack.isEmpty()) {
                System.out.println("Invalid expresss");
                return Double.NaN;
            } else {
                //System.out.println("The result is " + result.getValue());
            	return result.getValue();
            }
        }
        
        return Double.NaN;
    }

}
