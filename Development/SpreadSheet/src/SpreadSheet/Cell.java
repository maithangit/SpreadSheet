package SpreadSheet;

import java.util.ArrayList;
import java.util.List;

public class Cell implements ISubject, IObserver {
    private int row;
    private int col;
    private DataType value;
    private Sheet sheet;
    //List of cells that observe this
    List<Cell> observerList;

    public Cell(int row, int col, DataType value) {
        this.row = row;
        this.col = col;
        this.value = value;
        //check observer
        if (value.getClass().getName().equals("Reference")) {
            ((Reference) value).getReference().addObserver(this);
        }
        observerList = new ArrayList<>();
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

    public void addObserver(Cell observer) {
        this.observerList.add(observer);
    }
    @Override
    public void notifyObservers() {
        for (Cell cell : observerList) cell.update();
    }

    @Override
    public void update() {
        //recalculate its value
        value.updateValue();
    }
}
