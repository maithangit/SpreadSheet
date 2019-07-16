package Calculator;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private Stack<Token> operatorStack;
    private Stack<Token> valueStack;
    private boolean valid;

    public String getSyntax() {
        return syntax;
    }

    private String syntax = "";

    @Override
    public String toString() {
        return syntax;
    }

    public Calculator() {
        operatorStack = new Stack<Token>();
        valueStack = new Stack<Token>();
        valid = false;
    }

    private void compute(Token token) {
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

        Token res = new Token("" + token.getOperator()
                .compute(left.getValue(), right.getValue()));

        syntax = "(" + (syntax == "" ? left.getValue() : syntax) + " " + token.getOperator() + " " + right.getValue() + ")";

        valueStack.push(res);

    }

    public double calculate(String input) {
        List<Token> tokens = ExpressionUtil.parseToken(input);

        //Process tokens
        for (Token token : tokens) {
            if (token.getType() == TokenType.NUMBER) {
                valueStack.push(token);
            } else if (token.getType() == TokenType.OPERATOR) {
                if (operatorStack.isEmpty() || token.getPrecedence() > operatorStack.peek().getPrecedence()) {
                    operatorStack.push(token);
                } else {
                    while (!operatorStack.isEmpty() && token.getPrecedence() <= operatorStack.peek().getPrecedence()) {
                        Token toProcess = operatorStack.peek();
                        operatorStack.pop();
                        compute(toProcess);
                    }
                    operatorStack.push(token);
                }
            } else if (token.getType() == TokenType.OPEN_PARENTHESIS) {
                operatorStack.push(token);
            } else if (token.getType() == TokenType.CLOSE_PARENTHESIS) {
                while (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.OPERATOR) {
                    Token toProcess = operatorStack.peek();
                    operatorStack.pop();
                    compute(toProcess);
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
            compute(toProcess);
        }



        if (valid == false) {
            Token result = valueStack.peek();
            valueStack.pop();

            if (!operatorStack.isEmpty() || !valueStack.isEmpty()) {
                System.out.println("Invalid expression.");
                return Double.NaN;
            } else {
                //System.out.println("The result is " + result.getValue());
                return result.getValue();
            }
        }

        return Double.NaN;
    }

}
