package SpreadSheet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
give input and return dedicated Type object

parse inputs:
â€œâ€?	        String, everything inside a double quote will be considered as a string

0-9	        Number, only contains numbers

[]	        Reference, only accept [x,y] x and y are numbers

+ - * /	    Operation, actually not a type but can operate on numbers or strings together

Number/String + Operation = Formula
*/
public class DataTypeFactory {
    private enum types {
        String, Number, Reference, Formula
    }

    public static DataType getInstanceType(String content) {
        if (isNumeric(content)) {
            Double val = Double.parseDouble(content);
            return new NumberType(val);
        } else if (isReference(content)) {
            Cell reference = parseReferenceContent(content);
            if (reference != null) return new Reference(parseReferenceContent(content));
        } else if (isFormula(content)) {
            return new Formula(content, parseReferenceInFormula(content));
        }
        return new StringType(content);
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

//    public static boolean isFormula(String content) {
//        Pattern pattern = Pattern.compile("((\\d*\\.\\d+)|(\\d+)|([\\+\\-\\*/\\(\\)]))");
//        Matcher m = pattern.matcher(content);
//        return m.lookingAt();
//    }
    
    public static boolean isFormula(String content) {
        //Pattern pattern = Pattern.compile("([+*/-])");
    	Pattern pattern = Pattern.compile("(([-+*\\/ ])*\\d+((\\.\\d+)?)|(\\[[\\d+][\\,\\ ]*[\\d+]\\]))");
        Matcher m = pattern.matcher(content);
        return m.find();
    }

    public static boolean isReference(String content) {
        Pattern pattern = Pattern.compile("(\\[\\d+,(\\s)?\\d+\\])");
        Matcher m = pattern.matcher(content);
        return m.matches();
    }

    private static String parseReferenceInFormula(String content){
        String result = content;
        Pattern pattern = Pattern.compile("(\\[\\d+,(\\s)?\\d+\\])");
        Matcher m = pattern.matcher(content);

        while(m.find()){
            String refStr = m.group();
            Cell c = parseReferenceContent(refStr);
            if(c != null){
                result = result.replace(refStr, c.getValue().toString());
            }
        }

        return result;
    }

    private static Cell parseReferenceContent(String content) {
        int start = content.indexOf("[");
        int end = content.indexOf("]");
        if (start < 0 || end < 0) return null;
        //parse the content to find r, c
        int r = content.charAt(start + 1) - '0', c = content.charAt(end - 1) - '0';
        //find in list cell
        return Sheet.getCell(r, c);
    }
}
