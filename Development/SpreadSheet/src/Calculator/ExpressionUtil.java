package Calculator;

public class ExpressionUtil {
	public static String formatExpression(String expression) {
		String reString = expression.trim();
		reString = reString.replace("(", " ( ");
		reString = reString.replace(")", " ) ");
		reString = reString.replace("+", " + ");
		reString = reString.replace("-", " - ");
		reString = reString.replace("  ", " ");
		
		return reString;
	}
	
	public static Token[] parseToken(String expression) {
		String[] parts = expression.split(" ");
        Token[] tokens = new Token[parts.length];
        for (int n = 0; n < parts.length; n++) {
            tokens[n] = new Token(parts[n]);
        }
        return tokens;
	}
}
