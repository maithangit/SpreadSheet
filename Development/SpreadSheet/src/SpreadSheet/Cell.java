package SpreadSheet;

public class Cell {
    private int row;
    private int col;
    private DataType value;
    private Sheet sheet;

    public Cell(int row, int col, String content) {
        this.row = row;
        this.col = col;
        this.value = DataTypeFactory.getInstanceType(content);
        this.sheet = sheet;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public DataType getData() {
        return value;
    }

    public void setValue(DataType value) {
        this.value = value;
    }

    public Object getValue() {
        return value.getValue();
    }

    public String getContent() {
        return value.getContent();
    }

    public void linkToSheet(Sheet sheet) {
        this.sheet = sheet;
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    @Override
    public String toString() {
        return "[" + row + "," + col + "]";
    }
}
