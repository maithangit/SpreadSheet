package SpreadSheet;

public class Formula implements DataType {
    private String content;
    private Object valueAfterCalculated;
    public Formula(String content){
        this.content = content;
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
