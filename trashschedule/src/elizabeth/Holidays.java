package elizabeth;

import java.util.Calendar;
import java.util.HashMap;

public class Holidays {
	//Initiating calender variable used to produce all the
	//other date variables needed to produce a full date
	private Calendar cal = Calendar.getInstance();
	private boolean isHoliday = false;
	private int month = cal.get(Calendar.MONTH) + 1;
	private int day = cal.get(Calendar.DAY_OF_MONTH);
	private int year = cal.get(Calendar.YEAR);
	//these two particular variables are important when writing
	//the logic for detecting if it is a Holiday or not
	private int number_day = cal.get(Calendar.DAY_OF_WEEK);
	private int week_of_month = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	
	public String getCalDate() {
		// Combined variable for date
		String date = ("Date: " + month + "/" + day + "/" + year);
		return date;
	}
	public String getDay() {
		//Map that contains numbers mapped to the days of the week
		HashMap<Integer,String> dict = new HashMap<Integer,String>();
		dict.put(1, "SUN");
		dict.put(2, "MON");
		dict.put(3, "TUE");
		dict.put(4, "WED");
		dict.put(5, "THURS");
		dict.put(6, "FRI");
		dict.put(7, "SAT");
		String dayName = (dict.get(number_day));
		return dayName;
	}
	
	public boolean holidayCheck() {
		// Check if date is a Holiday
		// New Years Day 
		if (month == 1 && day == 1) {
			System.out.println("New Years Eve");
			isHoliday = true;
		}
		// Memorial Day
		else if (month == 5 && number_day == 2 && week_of_month == 4) {
			System.out.println("Memorial Day");
			isHoliday = true;
		}
		// 4th of July / Independence Day 
		else if (month == 7 && day == 4) {
			System.out.println("Happy 4th of July! It is a Holiday! No Trash!");
			isHoliday = true;
		}
		// Labor Day
		else if (month == 9 && number_day == 2 && week_of_month == 1) {
			System.out.println("Labor Day");
			isHoliday = true;
		}
		// Thanksgiving 
		else if (month == 11 && number_day == 5 && week_of_month == 4) {
			System.out.println("Happy Thanksgiving");
			isHoliday = true;
		}
		// Christmas 
		else if (month == 12 && day == 25) {
			System.out.println("Christmas");
			isHoliday = true;
		}
		
		return isHoliday;
	}
}
