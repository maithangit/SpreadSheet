package SpreadSheet;

/*
give input and return dedicated Type object

parse inputs:
“”	        String, everything inside a double quote will be considered as a string

0-9	        Number, only contains numbers

[]	        Reference, only accept [x,y] x and y are numbers

+ - * /	    Operation, actually not a type but can operate on numbers or strings together

Number/String + Operation = Formula
*/
public class TypeFactory {
    private enum types {
        String, Number, Reference, Formula
    }

    public static Type getInstanceType(String content) {
        if (isNumeric(content)) {
            Double val = Double.parseDouble(content);
            return new NumberType(val);
        }
        else {
            Cell reference = parseReferenceContent(content);
            if (reference != null) return new Reference(parseReferenceContent(content));
        }
        return  new StringType(content);
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
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
