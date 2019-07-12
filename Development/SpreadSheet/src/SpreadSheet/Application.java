package SpreadSheet;

import java.util.List;
import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		List<Cell> listCells = new ArrayList<Cell>() {
			private static final long serialVersionUID = 3270448845643882994L;
		
			{
				add(new Cell(1, 1, "Airfare: "));
				add(new Cell(1, 2, "$6885.15"));
				add(new Cell(1, 3, ""));
				add(new Cell(1, 4, "What we pay to the airlines"));
				
				add(new Cell(2, 1, "Taxi: "));
				add(new Cell(2, 2, "$118"));
				add(new Cell(2, 3, ""));
				add(new Cell(2, 4, ""));
				
				add(new Cell(3, 1, "Rental Car: "));
				add(new Cell(3, 2, "$295.85"));
				add(new Cell(3, 3, ""));
				add(new Cell(3, 4, ""));
				
				add(new Cell(4, 1, "Hotel: "));
				add(new Cell(4, 2, "$432"));
				add(new Cell(4, 3, ""));
				add(new Cell(4, 4, ""));
				
				add(new Cell(5, 1, "Meals: "));
				add(new Cell(5, 2, "$150"));
				add(new Cell(5, 3, ""));
				add(new Cell(5, 4, "All meals combined"));
				
				add(new Cell(6, 1, ""));
				add(new Cell(6, 2, ""));
				add(new Cell(6, 3, ""));
				add(new Cell(6, 4, ""));
				
				add(new Cell(7, 1, "Sub-total:"));
				add(new Cell(7, 2, "$7881"));
				add(new Cell(7, 3, ""));
				add(new Cell(7, 4, ""));
				
				add(new Cell(8, 1, "Discount:"));
				add(new Cell(8, 2, "%0.15"));
				add(new Cell(8, 3, ""));
				add(new Cell(8, 4, ""));
				
				add(new Cell(9, 1, "Total:"));
				add(new Cell(9, 2, "$6698.85"));
				add(new Cell(9, 3, ""));
				add(new Cell(9, 4, ""));
				
				add(new Cell(10, 1, "Partners:"));
				add(new Cell(10, 2, "4"));
				add(new Cell(10, 3, ""));
				add(new Cell(10, 4, ""));
				
				add(new Cell(11, 1, "Months:"));
				add(new Cell(11, 2, "12"));
				add(new Cell(11, 3, ""));
				add(new Cell(11, 4, ""));
				
				add(new Cell(12, 1, "Installments:"));
				add(new Cell(12, 2, "$139.559375"));
				add(new Cell(12, 3, ""));
				add(new Cell(12, 4, ""));
				
			}
		};
		
		sheet.addCells(listCells);


		//reference
		sheet.modifyCell(6,1, "[1,1]");
		sheet.modifyCell(6,2, "[1,2]");
		sheet.modifyCell(6,3, "[1,3]");
		sheet.modifyCell(6,4, "[1,4]");

		System.out.println(Sheet.getCell(6,1).getValue());
		System.out.println(Sheet.getCell(6,1).getContent());

		sheet.print();
	}

}
