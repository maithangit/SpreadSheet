package SpreadSheet;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		
		sheet.addCell(new Cell(1, 1, "Airfare: "));
		sheet.addCell(new Cell(1, 2, "6885.15"));
		sheet.addCell(new Cell(1, 3, "5"));
		sheet.addCell(new Cell(1, 4, "What we pay to the airlines"));
		
		sheet.addCell(new Cell(2, 1, "Taxi: "));
		sheet.addCell(new Cell(2, 2, "118"));
		sheet.addCell(new Cell(2, 3, ""));
		sheet.addCell(new Cell(2, 4, ""));
		
		sheet.addCell(new Cell(3, 1, "Rental Car: "));
		sheet.addCell(new Cell(3, 2, "295.85"));
		sheet.addCell(new Cell(3, 3, ""));
		sheet.addCell(new Cell(3, 4, ""));
		
		sheet.addCell(new Cell(4, 1, "Hotel: "));
		sheet.addCell(new Cell(4, 2, "432"));
		sheet.addCell(new Cell(4, 3, ""));
		sheet.addCell(new Cell(4, 4, ""));
		
		sheet.addCell(new Cell(5, 1, "Meals: "));
		sheet.addCell(new Cell(5, 2, "150"));
		sheet.addCell(new Cell(5, 3, ""));
		sheet.addCell(new Cell(5, 4, "All meals combined"));
		
		sheet.addCell(new Cell(6, 1, ""));
		sheet.addCell(new Cell(6, 2, ""));
		sheet.addCell(new Cell(6, 3, ""));
		sheet.addCell(new Cell(6, 4, ""));
		
		sheet.addCell(new Cell(7, 1, "Sub-total:"));
		sheet.addCell(new Cell(7, 2, "[1,2] + [2,2] + [3,2] + [4,2] + [5,2]"));
		sheet.addCell(new Cell(7, 3, ""));
		sheet.addCell(new Cell(7, 4, ""));
		
		sheet.addCell(new Cell(8, 1, "Discount:"));
		sheet.addCell(new Cell(8, 2, "0.15"));
		sheet.addCell(new Cell(8, 3, ""));
		sheet.addCell(new Cell(8, 4, ""));
		
		sheet.addCell(new Cell(9, 1, "Total:"));
		sheet.addCell(new Cell(9, 2, "[7,2] - [7,2] * [8,2]"));
		sheet.addCell(new Cell(9, 3, ""));
		sheet.addCell(new Cell(9, 4, ""));
		
		sheet.addCell(new Cell(10, 1, "Partners:"));
		sheet.addCell(new Cell(10, 2, "4"));
		sheet.addCell(new Cell(10, 3, ""));
		sheet.addCell(new Cell(10, 4, ""));
		
		sheet.addCell(new Cell(11, 1, "Months:"));
		sheet.addCell(new Cell(11, 2, "12"));
		sheet.addCell(new Cell(11, 3, ""));
		sheet.addCell(new Cell(11, 4, ""));
		
		sheet.addCell(new Cell(12, 1, "Installments:"));
		sheet.addCell(new Cell(12, 2, "139.559375"));
		sheet.addCell(new Cell(12, 3, ""));
		sheet.addCell(new Cell(12, 4, "[9,2] / [10,2] / [11,2]"));


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
