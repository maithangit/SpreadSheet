package SpreadSheet;

public class Cell {
	private int row;
	private int col;
	private Type value;
	private Sheet sheet;
	
	public Cell(int row, int col, String content) {
		this.row = row;
		this.col = col;
		this.value = TypeFactory.getInstanceType(content);
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

	public Type getData() {
		return value;
	}

	public void setValue(Type value) {
		this.value = value;
	}

	public Object getValue() {
		return value.getValue();
	}

	public String getContent() {
		return value.getContent();
	}

	@Override
	public String toString() {
		return "[" + row + "," + col + "]";
	}
}
