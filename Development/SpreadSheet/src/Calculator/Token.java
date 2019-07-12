package Calculator;

public class Token {
	private TokenType tokenType;
	private double value;
	//private char operator;
	private int precedence;
	private Operator operator;
	   
	public Token() {
		tokenType = TokenType.UNKNOWN;
	}
	   
	public Token(String contents) {
       switch(contents) {
           case "+":
               tokenType = TokenType.OPERATOR;
               //operator = contents.charAt(0);
               operator = new Plus();
               precedence = 1;
               break;
           case "-":
        	   tokenType = TokenType.OPERATOR;
               //operator = contents.charAt(0);
        	   operator = new Substract();
               precedence = 1;
               break;
           case "x":
               tokenType = TokenType.OPERATOR;
               //operator = contents.charAt(0);
               operator = new Multiply();
               precedence = 2;
               break;
           case "/":
        	   tokenType = TokenType.OPERATOR;
               //operator = contents.charAt(0);
        	   operator = new Divide();
               precedence = 2;
               break;
           case "(":
        	   tokenType = TokenType.OPEN_PARENTHESIS;
               break;
           case ")":
        	   tokenType = TokenType.CLOSE_PARENTHESIS;
               break;
           default:
               tokenType = TokenType.NUMBER;
               try {
                   value = Double.parseDouble(contents);
               } catch (Exception ex) {
            	   tokenType = TokenType.UNKNOWN;
               }
       }
   }
	   
   public Token(double x) {
	   tokenType = TokenType.NUMBER;
       value = x;
   }
   
   public TokenType getType() 
   { 
	   return tokenType; 
   }
   
   public double getValue() 
   { 
	   return value; 
   }
   
   public int getPrecedence() 
   { 
	   return precedence; 
   }
   
   public Operator getOperator() {
	   return operator;
   }
   
//   Token execute(double a,double b) {
//       double result = 0;
//       switch(operator) {
//           case '+':
//               result = a + b;
//               break;
//           case '-':
//               result = a - b;
//               break;
//           case 'x':
//               result = a * b;
//               break;
//           case '/':
//               result = a / b;
//               break;
//       }
//       return new Token(result);
//   }
}
