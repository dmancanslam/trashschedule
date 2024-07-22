package elizabeth;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { // main driver code to 
		Scanner input = new Scanner(System.in); // for java console
		System.out.print("Enter your address in this format: ### ADDRESS NAME ##### ");
			String UserAddressRaw = input.nextLine(); // Read user input

			int wardNum = Integer.parseInt(Wards.search(Parse.cleanupInput(UserAddressRaw)));

			Display.writeTable(wardNum); // static cast to java file located in same directory. Might need to change this to a 'display' object and call the method that way.
			
			if (wardNum <4 && wardNum>0){ // wards 1-3 have the same schedule
				System.out.println("This table shows an X when the trash will be picked up in the morning. \nKindly place your trash at the curb the previous day after 8:00pm.");
			}
			else if (wardNum >3 && wardNum<7){ // wards 4-6 have the same schedule
				System.out.println("This table shows an X when the trash will be picked up in the morning. \nKindly place your trash at the curb the previous day after 8:00pm.");
			}
			else {
				System.out.print("Error in IF statement for displaying additional info");
			}
	}

}
