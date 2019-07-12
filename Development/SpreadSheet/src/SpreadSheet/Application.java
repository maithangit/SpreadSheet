package SpreadSheet;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		List<Cell> listCells = new ArrayList<Cell>();;
		
		sheet.addCell(new Cell(1, 1, DataTypeFactory.getInstanceType("Airfare: ")));
		sheet.addCell(new Cell(1, 2, DataTypeFactory.getInstanceType("6885.15")));
		sheet.addCell(new Cell(1, 3, DataTypeFactory.getInstanceType("5")));
		sheet.addCell(new Cell(1, 4, DataTypeFactory.getInstanceType("What we pay to the airlines")));
		
		sheet.addCell(new Cell(2, 1, DataTypeFactory.getInstanceType("Taxi: ")));
		sheet.addCell(new Cell(2, 2, DataTypeFactory.getInstanceType("118")));
		sheet.addCell(new Cell(2, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(2, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(3, 1, DataTypeFactory.getInstanceType("Rental Car: ")));
		sheet.addCell(new Cell(3, 2, DataTypeFactory.getInstanceType("295.85")));
		sheet.addCell(new Cell(3, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(3, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(4, 1, DataTypeFactory.getInstanceType("Hotel: ")));
		sheet.addCell(new Cell(4, 2, DataTypeFactory.getInstanceType("432")));
		sheet.addCell(new Cell(4, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(4, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(5, 1, DataTypeFactory.getInstanceType("Meals: ")));
		sheet.addCell(new Cell(5, 2, DataTypeFactory.getInstanceType("150")));
		sheet.addCell(new Cell(5, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(5, 4, DataTypeFactory.getInstanceType("All meals combined")));
		
		sheet.addCell(new Cell(6, 1, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(6, 2, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(6, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(6, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(7, 1, DataTypeFactory.getInstanceType("Sub-total:")));
		sheet.addCell(new Cell(7, 2, DataTypeFactory.getInstanceType("[1,2] + [2,2] + [3,2] + [4,2] + [5,2]")));
		sheet.addCell(new Cell(7, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(7, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(8, 1, DataTypeFactory.getInstanceType("Discount:")));
		sheet.addCell(new Cell(8, 2, DataTypeFactory.getInstanceType("0.15")));
		sheet.addCell(new Cell(8, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(8, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(9, 1, DataTypeFactory.getInstanceType("Total:")));
		sheet.addCell(new Cell(9, 2, DataTypeFactory.getInstanceType("[7,2] - [7,2] * [8,2]")));
		sheet.addCell(new Cell(9, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(9, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(10, 1, DataTypeFactory.getInstanceType("Partners:")));
		sheet.addCell(new Cell(10, 2, DataTypeFactory.getInstanceType("4")));
		sheet.addCell(new Cell(10, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(10, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(11, 1, DataTypeFactory.getInstanceType("Months:")));
		sheet.addCell(new Cell(11, 2, DataTypeFactory.getInstanceType("12")));
		sheet.addCell(new Cell(11, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(11, 4, DataTypeFactory.getInstanceType("")));
		
		sheet.addCell(new Cell(12, 1, DataTypeFactory.getInstanceType("Installments:")));
		sheet.addCell(new Cell(12, 2, DataTypeFactory.getInstanceType("139.559375")));
		sheet.addCell(new Cell(12, 3, DataTypeFactory.getInstanceType("")));
		sheet.addCell(new Cell(12, 4, DataTypeFactory.getInstanceType("[9,2] / [10,2] / [11,2]")));


		//reference
//		sheet.modifyCell(6,1, "[1,1]");
//		sheet.modifyCell(6,2, "[1,2]");
//		sheet.modifyCell(6,3, "[1,3]");
//		sheet.modifyCell(6,4, "[1,4]");
//
		sheet.modifyCell(7,4, "2 + 3 - 4 + [1,3] + [1,3]");

		sheet.print();

		// examine spreadsheet.
		sheet.examine();
	}

}
