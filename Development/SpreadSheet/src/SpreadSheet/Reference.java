package SpreadSheet;


//need put some constraint here for reference hell loop
public class Reference implements DataType {
    private Cell reference;

    public Reference(Cell reference) {
        this.reference = reference;
    }

    @Override
    public Object getValue() {
        return reference.getValue();
    }

    @Override
    public String getContent() {
        return reference.toString();
    }

    @Override
    public String getSyntax() {
        return null;
    }
}
