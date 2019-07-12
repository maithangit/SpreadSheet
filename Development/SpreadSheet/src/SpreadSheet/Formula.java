package SpreadSheet;

import Calculator.Calculator;

public class Formula implements DataType {
    private String content;
    private Object valueAfterCalculated;
    public Formula(String content, String formatedContent){
        this.content = content;
        valueAfterCalculated = new Calculator().calculate(formatedContent);
    }
    
    @Override
    public Object getValue() {
        return valueAfterCalculated;
    }

    @Override
    public String getContent() {
        return content;
    }
}
