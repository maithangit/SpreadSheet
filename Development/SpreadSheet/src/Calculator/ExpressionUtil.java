package Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static List<Token> parseToken(String expression) {
        expression = expression.replace(" ", "").trim();
        List<Token> tokens = new ArrayList<>();
		String[] parts = expression.split("(?=[-+*/()])|(?<=[^-+*/][-+*/])|(?<=[()])");
        for (int i = 0; i < parts.length; i++) {
			tokens.add(new Token(parts[i]));
        }
//        Pattern pattern = Pattern.compile("((\\d+\\.\\d+)|(\\d+)|([*/+-])|([\\(\\)]))");
//        Matcher m = pattern.matcher(expression);
//        if (m.lookingAt()) {
//            while (m.find()) {
//                String item = m.group();
//                tokens.add(new Token(item));
//            }
//        }
        return tokens;
    }
}
