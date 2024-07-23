package elizabeth;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner; 

public class Display {
	
	public static void writeTable(int UserAddress) {
		Holidays holiday = new Holidays(); // create object to call functions
		boolean isHoliday = holiday.holidayCheck();
		String[][] table = createEmptyTable();
		int paperCheck = weeksPassed();
		String today = holiday.getDay();
		if (UserAddress <4) { // this if-else marks the garbage row for correct days according to ward
			if(isHoliday && today == "MON") { //if-statement to check if holiday
				table[3][4] = "H"; // MON column 
			}
			else {
				table[3][4] = "X";
			}
			//if-statement to check if holiday
			if(isHoliday && today == "THURS") { //if-statement to check if holiday
				table[3][10] = "H"; // THURS column 
			}
			else {
				table[3][10] = "X";
			}
		}
		else if (UserAddress >3){
			if(isHoliday && today == "TUE") {
				table[3][6] = "H"; // TUE column
			}
			else {
				table[3][6] = "X";
			}
			//if-statement to check if holiday
			if(isHoliday && today == "FRI") { 
				table[3][12] = "H"; // FRI column
			}
			else {
				table[3][12] = "X";
			}
		}
		// below if-statement checks for an even or odd week. 2024 calendar says odd weeks are metal/plastic
		if (paperCheck%2==0) { 
			if(isHoliday) { //if-statement to check if holiday
				table[1][8] = "H";; // WED column 
			}
			else {
				table[1][8] = "X";;
			} 
							   //odd weeks are paper even weeks are metals/plastic next week (1/1/2024) should be week 1 and should X on metal
		}
		else {
			if(isHoliday) { //if-statement to check if holiday
				table[2][8] = "H";; // WED column 
			}
			else {
				table[2][8] = "X";;
			}  
		}

		printTable(table); // end alterations
	}
	public static String[][] createEmptyTable() {
		String[][] table = new String[4][16];
		String[] weekdays = {"SUN","MON","TUE","WED","THURS","FRI","SAT"};
		for (int i=0; i<1; i++) {
			int k=0;
			for (int j=1; j<table[i].length; j++) {
				if (j%2==0) {
					table[i][j] = weekdays[k];
					k++;
				}
				else {
					table[i][j] = "|";
				}
			}
		}
		for (int i=1; i<4; i++) {
			for (int j=1; j<table[i].length; j++) {
				if (j%2==0) {
					table[i][j] = "-";
				}
				else {
					table[i][j] = "|";
				}
			}
		}
		table[0][0] = "_";
		table[1][0] = "Paper";
		table[2][0] = "Metal";
		table[3][0] = "Garbage";
		return table;
	}
	private static void printTable(String[][] table) { // might be removed when web development starts. 
		for (int i=0; i<table.length; i++) { // print table
			for (int j=0; j<table[i].length; j++) {
				if (table [i][j] == table [0][0]) {
					System.out.print("______");
				}
				if (table [i][j] == "-"|| table [i][j] =="X" || table [i][j] =="H") {
					if (i > 0 && j == 10) {
						System.out.print("  " + table [i][j] + "  ");
					}
					else {
						System.out.print(" " + table [i][j] + " ");
					}
				}
				else {
					System.out.print(table[i][j]);
				}
				if (table [i][j] == table [1][0] || table [i][j] == table [2][0]) {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}
	private static int weeksPassed() { // get weeks # to check later if it's paper or metal/plastic
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Define the week fields and get the week number
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        int weekNumber = currentDate.get(weekFields.weekOfWeekBasedYear());
        // System.out.println("Number of weeks passed in the current year: " + weekNumber);
        return weekNumber;
    }
	
}