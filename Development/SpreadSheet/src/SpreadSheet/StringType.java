package SpreadSheet;

public class StringType extends Single  {
    private String content;

    public StringType() {
    }

    public StringType(String content) {
        this.content = content;
    }

    @Override
    public String getValue() {
        return content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void updateValue() {
        //do nothing
    }
}
