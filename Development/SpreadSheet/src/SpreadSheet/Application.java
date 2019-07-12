package SpreadSheet;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		List<Cell> listCells = new ArrayList<Cell>() {
			private static final long serialVersionUID = 3270448845643882994L;
		
			{
				add(new Cell(1, 1, DataTypeFactory.getInstanceType("Airfare: ")));
				add(new Cell(1, 2, DataTypeFactory.getInstanceType("$6885.15")));
				add(new Cell(1, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(1, 4, DataTypeFactory.getInstanceType("What we pay to the airlines")));
				
				add(new Cell(2, 1, DataTypeFactory.getInstanceType("Taxi: ")));
				add(new Cell(2, 2, DataTypeFactory.getInstanceType("$118")));
				add(new Cell(2, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(2, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(3, 1, DataTypeFactory.getInstanceType("Rental Car: ")));
				add(new Cell(3, 2, DataTypeFactory.getInstanceType("$295.85")));
				add(new Cell(3, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(3, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(4, 1, DataTypeFactory.getInstanceType("Hotel: ")));
				add(new Cell(4, 2, DataTypeFactory.getInstanceType("$432")));
				add(new Cell(4, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(4, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(5, 1, DataTypeFactory.getInstanceType("Meals: ")));
				add(new Cell(5, 2, DataTypeFactory.getInstanceType("$150")));
				add(new Cell(5, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(5, 4, DataTypeFactory.getInstanceType("All meals combined")));
				
				add(new Cell(6, 1, DataTypeFactory.getInstanceType("")));
				add(new Cell(6, 2, DataTypeFactory.getInstanceType("")));
				add(new Cell(6, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(6, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(7, 1, DataTypeFactory.getInstanceType("Sub-total:")));
				add(new Cell(7, 2, DataTypeFactory.getInstanceType("$7881")));
				add(new Cell(7, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(7, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(8, 1, DataTypeFactory.getInstanceType("Discount:")));
				add(new Cell(8, 2, DataTypeFactory.getInstanceType("%0.15")));
				add(new Cell(8, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(8, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(9, 1, DataTypeFactory.getInstanceType("Total:")));
				add(new Cell(9, 2, DataTypeFactory.getInstanceType("$6698.85")));
				add(new Cell(9, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(9, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(10, 1, DataTypeFactory.getInstanceType("Partners:")));
				add(new Cell(10, 2, DataTypeFactory.getInstanceType("4")));
				add(new Cell(10, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(10, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(11, 1, DataTypeFactory.getInstanceType("Months:")));
				add(new Cell(11, 2, DataTypeFactory.getInstanceType("12")));
				add(new Cell(11, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(11, 4, DataTypeFactory.getInstanceType("")));
				
				add(new Cell(12, 1, DataTypeFactory.getInstanceType("Installments:")));
				add(new Cell(12, 2, DataTypeFactory.getInstanceType("$139.559375")));
				add(new Cell(12, 3, DataTypeFactory.getInstanceType("")));
				add(new Cell(12, 4, DataTypeFactory.getInstanceType("")));
				
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
