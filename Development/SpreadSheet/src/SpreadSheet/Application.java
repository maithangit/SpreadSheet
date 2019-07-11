package SpreadSheet;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		List<Cell> listCells = new ArrayList<Cell>() {
			private static final long serialVersionUID = 3270448845643882994L;
		
			{
				add(new Cell(1, 1, TypeFactory.getInstanceType("Airfare: ")));
				add(new Cell(1, 2, TypeFactory.getInstanceType("$6885.15")));
				add(new Cell(1, 3, TypeFactory.getInstanceType("")));
				add(new Cell(1, 4, TypeFactory.getInstanceType("What we pay to the airlines")));
				
				add(new Cell(2, 1, TypeFactory.getInstanceType("Taxi: ")));
				add(new Cell(2, 2, TypeFactory.getInstanceType("$118")));
				add(new Cell(2, 3, TypeFactory.getInstanceType("")));
				add(new Cell(2, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(3, 1, TypeFactory.getInstanceType("Rental Car: ")));
				add(new Cell(3, 2, TypeFactory.getInstanceType("$295.85")));
				add(new Cell(3, 3, TypeFactory.getInstanceType("")));
				add(new Cell(3, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(4, 1, TypeFactory.getInstanceType("Hotel: ")));
				add(new Cell(4, 2, TypeFactory.getInstanceType("$432")));
				add(new Cell(4, 3, TypeFactory.getInstanceType("")));
				add(new Cell(4, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(5, 1, TypeFactory.getInstanceType("Meals: ")));
				add(new Cell(5, 2, TypeFactory.getInstanceType("$150")));
				add(new Cell(5, 3, TypeFactory.getInstanceType("")));
				add(new Cell(5, 4, TypeFactory.getInstanceType("All meals combined")));
				
				add(new Cell(6, 1, TypeFactory.getInstanceType("")));
				add(new Cell(6, 2, TypeFactory.getInstanceType("")));
				add(new Cell(6, 3, TypeFactory.getInstanceType("")));
				add(new Cell(6, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(7, 1, TypeFactory.getInstanceType("Sub-total:")));
				add(new Cell(7, 2, TypeFactory.getInstanceType("$7881")));
				add(new Cell(7, 3, TypeFactory.getInstanceType("")));
				add(new Cell(7, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(8, 1, TypeFactory.getInstanceType("Discount:")));
				add(new Cell(8, 2, TypeFactory.getInstanceType("%0.15")));
				add(new Cell(8, 3, TypeFactory.getInstanceType("")));
				add(new Cell(8, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(9, 1, TypeFactory.getInstanceType("Total:")));
				add(new Cell(9, 2, TypeFactory.getInstanceType("$6698.85")));
				add(new Cell(9, 3, TypeFactory.getInstanceType("")));
				add(new Cell(9, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(10, 1, TypeFactory.getInstanceType("Partners:")));
				add(new Cell(10, 2, TypeFactory.getInstanceType("4")));
				add(new Cell(10, 3, TypeFactory.getInstanceType("")));
				add(new Cell(10, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(11, 1, TypeFactory.getInstanceType("Months:")));
				add(new Cell(11, 2, TypeFactory.getInstanceType("12")));
				add(new Cell(11, 3, TypeFactory.getInstanceType("")));
				add(new Cell(11, 4, TypeFactory.getInstanceType("")));
				
				add(new Cell(12, 1, TypeFactory.getInstanceType("Installments:")));
				add(new Cell(12, 2, TypeFactory.getInstanceType("$139.559375")));
				add(new Cell(12, 3, TypeFactory.getInstanceType("")));
				add(new Cell(12, 4, TypeFactory.getInstanceType("")));
				
			}
		};
		
		sheet.addCells(listCells);


		//reference
		sheet.modifyCell(6,1, "[1,1]");
		sheet.modifyCell(6,2, "[1,2]");
		sheet.modifyCell(6,3, "[1,3]");
		sheet.modifyCell(6,4, "[1,4]");

		sheet.print();
	}

}
