package SpreadSheet;

public class Cell {
	private int row;
	private int col;
	private DataType value;
	
	public Cell(int row, int col, DataType value) {
		this.row = row;
		this.col = col;
		this.value = value;
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

	@Override
	public String toString() {
		return "[" + row + "," + col + "]";
	}
}
