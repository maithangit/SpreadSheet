package SpreadSheet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
give input and return dedicated Type object

parse inputs:
""	        String, everything inside a double quote will be considered as a string

0-9	        Number, only contains numbers

[]	        Reference, only accept [x,y] x and y are numbers

+ - * /	    Operation, actually not a type but can operate on numbers or strings together

Number/String + Operation = Formula
*/
public class DataTypeFactory {

    private Sheet sheet;

    public DataTypeFactory(Sheet sheet) {
        this.sheet = sheet;
    }

    public DataType getInstanceType(String content) {
        if (isNumeric(content)) {
            Double val = Double.parseDouble(content);
            return new NumberType(val);
        } else if (isFormula(content)) {
            return new Formula(content, parseReferenceInFormula(content));
        } else if (isReference(content)) {
            Cell reference = parseReferenceContent(content);
            if (reference != null)
                return new Reference(parseReferenceContent(content));
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
        Pattern pattern = Pattern.compile("(([-+*\\/ ])*\\d+((\\.\\d+)?)|(\\[[\\d+][\\,\\ ]*[\\d+]\\]))");
        Matcher m = pattern.matcher(content);
        return m.find();
    }

    public static boolean isReference(String content) {
        Pattern pattern = Pattern.compile("(\\[(\\d+),(\\s)?(\\d+)\\])");
        Matcher m = pattern.matcher(content);
        return m.matches();
    }

    private String parseReferenceInFormula(String content){
        String result = content;
        Pattern pattern = Pattern.compile("(\\[(\\d+),(\\s)?(\\d+)\\])");
        Matcher m = pattern.matcher(content);

        while (m.find()) {
            String refStr = m.group();
            Cell c = parseReferenceContent(refStr);
            if (c != null) {
                result = result.replace(refStr, c.getValue().toString());
            }
        }

        return result;
    }

    private Cell parseReferenceContent(String content) {
        Pattern pattern = Pattern.compile("(\\[(\\d+),(\\d+)\\])");
        Matcher m = pattern.matcher(content);
        if (m.matches()) {
            int row = Integer.valueOf(m.group(2));
            int col = Integer.valueOf(m.group(3));
            return sheet.getCell(row, col);
        }
        return null;
    }
}
