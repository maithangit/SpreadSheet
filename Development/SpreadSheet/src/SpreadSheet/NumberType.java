package SpreadSheet;

public class NumberType extends Single {
    private Double content;

    public NumberType() {
    }

    public NumberType(Double content) {
        this.content = content;
    }

    @Override
    public Double getValue() {
        return content;
    }

    @Override
    public String getContent() {
        return content.toString();
    }
}
