package elizabeth;

import java.util.Scanner;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Wards {
	private static Scanner input;
	private static Scanner myReader;

	public static String search(String[] address) {
		String ward = "Ward not found. Input address parsed: "+address[1];
		boolean evenAddr = (Integer.parseInt(address[0]) % 2==0); // quick cast to int to check for E or O in csv file
		String EorO;
		if(evenAddr) {
			EorO = "E";
		}
		else {
			EorO = "O";
		}
		
		try {
			File myObj = new File("./countystreetlist04032017.csv");
			myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				String data[] = line.split(",");
				if (!(EorO.equals(data[3]))) { // skip csv read if not even or odd
					continue;					// reduces some time to iterate through csv
				}
				if (Parse.compareIgnoringSpaces(data[0], address[1])) {																	// below line checks lower and upper bounds
					if (Integer.parseInt(data[1]) <= Integer.parseInt(address[0]) && Integer.parseInt(data[2]) >= Integer.parseInt(address[0])) { // SUPER lazy way to parse ints. probably should make a function to make the nextline() thing into an array instead of leaving it as 1 big string per line.
						if (data[4].equals(address[2])) { // super strict way to check if input of zip code is identical to csv file's zip
							return data[5];
						}
					}
				}
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ward;
	}

	
}
