package SpreadSheet;

import Calculator.Calculator;

public class Formula implements DataType {
    private String content;
    private Object valueAfterCalculated;
    private String syntax;
    public Formula(String content, String parseContent){
        this.content = content;
        Calculator calculator = new Calculator();
        valueAfterCalculated = calculator.calculate(parseContent);
        this.syntax = calculator.getSyntax();
    }
    
    @Override
    public Object getValue() {
        return valueAfterCalculated;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getSyntax() {
        return this.syntax;
    }
}
