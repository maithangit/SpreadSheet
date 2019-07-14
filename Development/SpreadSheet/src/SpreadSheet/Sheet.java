package SpreadSheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

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

    public void modifyCell(int r, int c, String content) {
        Cell cell = getCell(r, c);
        cell.setValue(DataTypeFactory.getInstanceType(content));
    }

    public void print() {
        System.out.println(toString());

    }

    public void examine() {
        StringBuilder examination = new StringBuilder();

        for (Cell cell : cells) {
            if (cell.getContent() != "") {
                examination.append(String.format("%s = [%s] --> %s \n",
                        cell.toString(),
                        cell.getValue(),
                        cell.getContent()));
            }
        }

        System.out.println();
        System.out.println("==// Examine Spreadsheet //==");
        System.out.println("------------------------------------");
        System.out.println(examination.toString());
    }
}
