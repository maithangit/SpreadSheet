package SpreadSheet;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		List<Cell> listCells = new ArrayList<Cell>() {
			private static final long serialVersionUID = 3270448845643882994L;
		
			{
				add(new Cell(1, 1, new CellData("Airfare: ")));
				add(new Cell(1, 2, new CellData("$6885.15")));
				add(new Cell(1, 3, new CellData("")));
				add(new Cell(1, 4, new CellData("What we pay to the airlines")));
				
				add(new Cell(2, 1, new CellData("Taxi: ")));
				add(new Cell(2, 2, new CellData("$118")));
				add(new Cell(2, 3, new CellData("")));
				add(new Cell(2, 4, new CellData("")));
				
				add(new Cell(3, 1, new CellData("Rental Car: ")));
				add(new Cell(3, 2, new CellData("$295.85")));
				add(new Cell(3, 3, new CellData("")));
				add(new Cell(3, 4, new CellData("")));
				
				add(new Cell(4, 1, new CellData("Hotel: ")));
				add(new Cell(4, 2, new CellData("$432")));
				add(new Cell(4, 3, new CellData("")));
				add(new Cell(4, 4, new CellData("")));
				
				add(new Cell(5, 1, new CellData("Meals: ")));
				add(new Cell(5, 2, new CellData("$150")));
				add(new Cell(5, 3, new CellData("")));
				add(new Cell(5, 4, new CellData("All meals combined")));
				
				add(new Cell(6, 1, new CellData(" ")));
				add(new Cell(6, 2, new CellData("")));
				add(new Cell(6, 3, new CellData("")));
				add(new Cell(6, 4, new CellData("")));
				
				add(new Cell(7, 1, new CellData("Sub-total:")));
				add(new Cell(7, 2, new CellData("$7881")));
				add(new Cell(7, 3, new CellData("")));
				add(new Cell(7, 4, new CellData("")));
				
				add(new Cell(8, 1, new CellData("Discount:")));
				add(new Cell(8, 2, new CellData("%0.15")));
				add(new Cell(8, 3, new CellData("")));
				add(new Cell(8, 4, new CellData("")));
				
				add(new Cell(9, 1, new CellData("Total:")));
				add(new Cell(9, 2, new CellData("$6698.85")));
				add(new Cell(9, 3, new CellData("")));
				add(new Cell(9, 4, new CellData("")));
				
				add(new Cell(10, 1, new CellData("Partners:")));
				add(new Cell(10, 2, new CellData("4")));
				add(new Cell(10, 3, new CellData("")));
				add(new Cell(10, 4, new CellData("")));
				
				add(new Cell(11, 1, new CellData("Months:")));
				add(new Cell(11, 2, new CellData("12")));
				add(new Cell(11, 3, new CellData("")));
				add(new Cell(11, 4, new CellData("")));
				
				add(new Cell(12, 1, new CellData("Installments:")));
				add(new Cell(12, 2, new CellData("$139.559375")));
				add(new Cell(12, 3, new CellData("")));
				add(new Cell(12, 4, new CellData("")));
				
			}
		};
		
		sheet.addCells(listCells);
		
		sheet.print();
	}

}
