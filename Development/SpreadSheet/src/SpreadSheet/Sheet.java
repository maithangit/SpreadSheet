package SpreadSheet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Sheet {
	private List<Cell> cells;

	public Sheet() {
		cells = new ArrayList<>();
	}
	
	public Sheet(List<Cell> cells) {
		this.cells = cells;
	}
	
	public void addCell(Cell c) {
		cells.add(c);
	}
	
	public void addCells(List<Cell> listCells) {
		cells.addAll(listCells);
	}
	
	public void OrganizeCell() {
		cells.stream().sorted(new Comparator<Cell>() {
			@Override
			public int compare(Cell x, Cell y) {
				if (x.getRow() != y.getRow()) {
					return x.getRow() - y.getRow();
				}
				else {
					return x.getCol() - y.getCol(); 
				}
			}
		});
	}
	
	public int getMaxCol() {
		IntSummaryStatistics statistics = cells.stream().collect(Collectors.summarizingInt(x->x.getCol()));
		return statistics.getMax();
	}
	
	@Override
	public String toString() {
		OrganizeCell();
		int row = 0;
		String reString = "";
		reString += "--------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		
		for (int i = 0; i <= getMaxCol(); i++) {
			if (i > 1)
				reString +=  String.format("  %35s  ", i);
			else if (i==0)
				reString +=  String.format("  %5s  ", "");
			else {
				reString +=  String.format("  %12s  ", 1);
			}
		}
		
		reString += "\n" + "--------------------------------------------------------------------------------------------------------------------------------------------------------";
		
		
		for (Cell cell : cells) {
			if (cell.getRow() != row) {
				reString += "\n" + String.format("| %5s | %-20s |", cell.getRow(), cell.getData().getValue());
				row = cell.getRow();
			}
			else {
				reString += "\t" + String.format("%30s |", cell.getData().getValue());
			}
		}
		
		reString += "\n" + "--------------------------------------------------------------------------------------------------------------------------------------------------------";
		
		return reString;
	}
	
	public void print() {
		System.out.println(toString());
		
	}
}
