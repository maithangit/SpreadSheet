package SpreadSheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sheet {
    private static List<Cell> cells;

    public static Cell getCell(int r, int c) {
        for (Cell cell : cells) {
            if (cell.getRow() == r && cell.getCol() == c) {
                return cell;
            }
        }
        return null;
    }

    public Cell getCellAt(int r, int c) {
        for (Cell cell : cells) {
            if (cell.getRow() == r && cell.getCol() == c) {
                return cell;
            }
        }
        return null;
    }

    public Sheet() {
        cells = new ArrayList<>();
    }

    public Sheet(List<Cell> cells) {
        this.cells = cells;
    }

    public void addCell(Cell c) {
        c.linkToSheet(this);
        cells.add(c);
    }

    public void addCell(int row, int column, Object content) {
    	Cell cell = getCell(row, column);
    	if (cell == null)
		{
			cell = new Cell(row, column);
			cells.add(cell);
		}
    	cell.setValue(DataTypeFactory.getInstanceType(content));
    		
    }

    public void addCells(List<Cell> listCells) {
        for (Cell cell : cells) {
            cell.linkToSheet(this);
        }
        cells.addAll(listCells);
    }

    public void OrganizeCell() {
        cells.stream().sorted(new Comparator<Cell>() {
            @Override
            public int compare(Cell x, Cell y) {
                if (x.getRow() != y.getRow()) {
                    return x.getRow() - y.getRow();
                } else {
                    return x.getCol() - y.getCol();
                }
            }
        });
    }

    public int getMaxCol() {
        IntSummaryStatistics statistics = cells.stream().collect(Collectors.summarizingInt(x -> x.getCol()));
        return statistics.getMax();
    }

    public int getMaxRow() {
        IntSummaryStatistics statistics = cells.stream().collect(Collectors.summarizingInt(x -> x.getRow()));
        return statistics.getMax();
    }

    public String[] getSheetColumns() {
        int cols = getMaxCol();
        String[] columns = new String[cols];
        for (Integer i = 1; i <= cols; i++) {
            columns[i - 1] = i.toString();
        }
        return columns;
    }

    public Object[][] getSheetData() {
        int cols = getMaxCol();
        int rows = getMaxRow();
        Object[][] data = new Object[rows][cols];

        for (Cell cell : cells) {
            data[cell.getRow() - 1][cell.getCol() - 1] = cell.getValue();
        }

        return data;
    }

    @Override
    public String toString() {
        OrganizeCell();
        int row = 0;
        String reString = "";
        //reString += "--------------------------------------------------------------------------------------------------------------------------------------------------------\n";

        for (int i = 0; i <= getMaxCol(); i++) {
            if (i > 1)
                reString += String.format("  %30s  ", i);
            else if (i == 0)
                reString += String.format("  %2s  ", "");
            else {
                reString += String.format("  %12s  ", 1);
            }
        }

        reString += "\n" + "     -------------------------------------------------------------------------------------------------------------------------------------------";


        for (Cell cell : cells) {
            if (cell.getRow() != row) {
                reString += "\n" + String.format("  %2s | %-20s |", cell.getRow(), cell.getValue());
                row = cell.getRow();
            } else {
                reString += "\t" + String.format("%30s |", cell.getValue());
            }
        }

        reString += "\n" + "     -------------------------------------------------------------------------------------------------------------------------------------------";

        return reString;
    }

    public void modifyCell(int r, int c, Object content) {
        Cell cell = getCell(r, c);
        cell.setValue(DataTypeFactory.getInstanceType(content));
    }

    public void reloadCell(int r, int c) {
        Cell cell = getCell(r, c);
        if (cell != null) {
        	cell.setValue(DataTypeFactory.getInstanceType(cell.getContent()));
        }
    }
    
    public void print() {
        System.out.println(toString());

    }

    public void examine() {
        StringBuilder examination = new StringBuilder();

        for (Cell cell : cells) {
            if (cell.getContent() != "") {
                examination.append(String.format("%6s = [%s] --> %s \n",
                        cell.toString(),
                        cell.getContent(),
                        cell.getSyntax()));
            }
        }

        System.out.println();
        System.out.println("==// Examine Spreadsheet //==");
        System.out.println("------------------------------------");
        System.out.println(examination.toString());
    }

    private void prepareSheet(int noRow, int noCol) {
    	for (int i = 0; i <= noRow; i++) {
			for (int j = 0; j <= noCol; j++) {
				this.addCell(i,j,"");
			}
		}
    }
    
    public void dummyData() {
    	prepareSheet(20,20);
    	this.addCell(1, 1, "Airfare:");
        this.addCell(1, 2, "6885.15");
        this.addCell(1, 3, "5");
        this.addCell(1, 4, "What we pay to the airlines");

        this.addCell(2, 1, "Taxi:");
        this.addCell(2, 2, "118");
        this.addCell(2, 3, "");
        this.addCell(2, 4, "");

        this.addCell(3, 1, "Rental Car:");
        this.addCell(3, 2, "295.85");
        this.addCell(3, 3, "");
        this.addCell(3, 4, "");

        this.addCell(4, 1, "Hotel:");
        this.addCell(4, 2, "432");
        this.addCell(4, 3, "");
        this.addCell(4, 4, "");

        this.addCell(5, 1, "Meals:");
        this.addCell(5, 2, "150");
        this.addCell(5, 3, "");
        this.addCell(5, 4, "All meals combined");

        this.addCell(6, 1, "");
        this.addCell(6, 2, "");
        this.addCell(6, 3, "");
        this.addCell(6, 4, "");

        this.addCell(7, 1, "Sub-total:");
        this.addCell(7, 2, "[1,2] + [2,2] + [3,2] + [4,2] + [5,2]");
        this.addCell(7, 3, "");
        this.addCell(7, 4, "");

        this.addCell(8, 1, "Discount:");
        this.addCell(8, 2, "0.15");
        this.addCell(8, 3, "");
        this.addCell(8, 4, "");

        this.addCell(9, 1, "Total:");
        this.modifyCell(9, 2, "[7,2] * (1.0 - [8,2])");
        this.addCell(9, 3, "");
        this.addCell(9, 4, "");

        this.addCell(10, 1, "Partners:");
        this.addCell(10, 2, "4");
        this.addCell(10, 3, "");
        this.addCell(10, 4, "");

        this.addCell(11, 1, "Months:");
        this.addCell(11, 2, "12");
        this.addCell(11, 3, "");
        this.addCell(11, 4, "");

        this.addCell(12, 1, "Installments:");
        this.addCell(12, 2, "[9,2] / [10,2] / [11,2]");
        this.addCell(12, 3, "");
        this.modifyCell(5, 2, "115 + 2 + 3 + 4 * 5 * 6 / 3 - 7 / 8");
        this.modifyCell(7, 2, "[1,2] + [2,2] + [3,2] + [4,2] + [5,2]");
        
    }
}
