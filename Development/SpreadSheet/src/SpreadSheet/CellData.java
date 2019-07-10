package SpreadSheet;

public class CellData {
	private String value;
	private String expression;
	
	public CellData(String value) {
		this.value = value;
		this.expression = value;
	}

	public CellData(String value, String expression) {
		this.value = value;
		this.expression = expression;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
}
