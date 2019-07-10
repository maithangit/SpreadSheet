package SpreadSheet;

public class Cell {
	private int row;
	private int col;
	private CellData data;
	
	public Cell(int row, int col, CellData data) {
		super();
		this.row = row;
		this.col = col;
		this.data = data;
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

	public CellData getData() {
		return data;
	}

	public void setData(CellData data) {
		this.data = data;
	}
}
