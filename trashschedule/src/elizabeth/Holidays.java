package elizabeth;

import java.util.Calendar;
import java.util.HashMap;

public class Holidays {
	private Calendar cal = Calendar.getInstance();
	private boolean isHoliday = false;
	private int month = cal.get(Calendar.MONTH) + 1;
	private int day = cal.get(Calendar.DAY_OF_MONTH);
	private int year = cal.get(Calendar.YEAR);
	private int number_day = cal.get(Calendar.DAY_OF_WEEK);
	private int week_of_month = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	
	public String getCalDate() {
		// Combined variable for date
		String date = ("Date: " + month + "/" + day + "/" + year);
		return date;
	}
	public String getDay() {
		//Hashmap that contains key value pair associating numbers with the days of the week
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
		// New Years Day (Good)
		if (month == 1 && day == 1) {
			System.out.println("New Years Eve");
			isHoliday = true;
		}
		// Memorial Day(Test This)
		else if (month == 5 && number_day == 2 && week_of_month == 4) {
			System.out.println("Memorial Day");
			isHoliday = true;
		}
		// 4th of July / Independence Day (Good)
		else if (month == 7 && day == 4) {
			System.out.println("Happy 4th of July! It is a Holiday! No Trash!");
			isHoliday = true;
		}
		// Labor day, month = september, number_day = monday, rando = week of month
		// (Test This)
		else if (month == 9 && number_day == 2 && week_of_month == 1) {
			System.out.println("Labor Day");
			isHoliday = true;
		}
		// Thanksgiving (Good)
		else if (month == 11 && number_day == 5 && week_of_month == 4) {
			System.out.println("Happy Thanksgiving");
			isHoliday = true;
		}
		// Christmas (Good)
		else if (month == 12 && day == 25) {
			System.out.println("Christmas");
			isHoliday = true;
		}
		
		return isHoliday;
	}
}
