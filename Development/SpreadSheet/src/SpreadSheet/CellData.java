package SpreadSheet;

public class CellData {
	private StringType value;
	private StringType expression;
	
	public CellData(StringType value) {
		this.value = value;
		this.expression = value;
	}

	public CellData(StringType value, StringType expression) {
		this.value = value;
		this.expression = expression;
	}

	public StringType getValue() {
		return value;
	}

	public void setValue(StringType value) {
		this.value = value;
	}

	public StringType getExpression() {
		return expression;
	}

	public void setExpression(StringType expression) {
		this.expression = expression;
	}
}
