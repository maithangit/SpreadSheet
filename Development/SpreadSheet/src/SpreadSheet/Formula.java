package SpreadSheet;

public class Formula implements DataType {
    private String content;
    private Object valueAfterCalculated;
    @Override
    public Object getValue() {
        return valueAfterCalculated;
    }

    @Override
    public String getContent() {
        return content;
    }
}
