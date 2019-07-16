package SpreadSheet;

public class Application {

	public static void main(String[] args) {
		Sheet sheet = new Sheet();
		
		sheet.addCell(1, 1, "Airfare:");
		sheet.addCell(1, 2, "6885.15");
		sheet.addCell(1, 3, "");  // 5
		sheet.addCell(1, 4, "What we pay to the airlines");
		
		sheet.addCell(2, 1, "Taxi:");
		sheet.addCell(2, 2, "118");
		sheet.addCell(2, 3, "");
		sheet.addCell(2, 4, "");
		
		sheet.addCell(3, 1, "Rental Car:");
		sheet.addCell(3, 2, "295.85");
		sheet.addCell(3, 3, "");
		sheet.addCell(3, 4, "");
		
		sheet.addCell(4, 1, "Hotel:");
		sheet.addCell(4, 2, "431");
		sheet.addCell(4, 3, "");
		sheet.addCell(4, 4, "");
		
		sheet.addCell(5, 1, "Meals:");
		sheet.addCell(5, 2, "150");
		sheet.addCell(5, 3, "");
		sheet.addCell(5, 4, "All meals combined");
		
		sheet.addCell(6, 1, "");
		sheet.addCell(6, 2, "");
		sheet.addCell(6, 3, "");
		sheet.addCell(6, 4, "");
		
		sheet.addCell(7, 1, "Sub-total:");
		sheet.addCell(7, 2, "");
		sheet.addCell(7, 3, "");
		sheet.addCell(7, 4, "");
		
		sheet.addCell(8, 1, "Discount:");
		sheet.addCell(8, 2, "0.15");
		sheet.addCell(8, 3, "");
		sheet.addCell(8, 4, "");
		
		sheet.addCell(9, 1, "Total:");
		sheet.addCell(9, 2, "");
		sheet.addCell(9, 3, "");
		sheet.addCell(9, 4, "");
		
		sheet.addCell(10, 1, "Partners:");
		sheet.addCell(10, 2, "4");
		sheet.addCell(10, 3, "");
		sheet.addCell(10, 4, "");
		
		sheet.addCell(11, 1, "Months:");
		sheet.addCell(11, 2, "12");
		sheet.addCell(11, 3, "");
		sheet.addCell(11, 4, "");
		
		sheet.addCell(12, 1, "Installments:");
		sheet.addCell(12, 2, ""); //139.559375
		sheet.addCell(12, 3, "");
		sheet.addCell(12, 4, "");


		//reference
//		sheet.modifyCell(6,1, "[1,1]");
//		sheet.modifyCell(6,2, "[1,2]");
//		sheet.modifyCell(6,3, "[1,3]");
//		sheet.modifyCell(6,4, "[1,4]");
//
		sheet.modifyCell(7,2, "([1,2] + [2,2] + [3,2] + [4,2] + [5,2])");
		//sheet.modifyCell(7,4, "2 + 3 - 4 + [1,3] + [1,3]");
		sheet.modifyCell(9,2, "([7,2] * (1.0 - [8,2]))");
		sheet.modifyCell(12, 2, "([9,2] / [10,2] / [11,2])");

		sheet.print();

		// examine spreadsheet.
		sheet.examine();
	}

}
