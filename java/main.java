package trashschedule;

import java.util.Scanner;

public class main {

	public static void main(String[] args) { // main driver code to 
		String address_number;
		String address_name = "";
		String zip_code;
		Scanner input = new Scanner(System.in); // for java console
		System.out.print("Enter your address in this format: ### ADDRESS NAME ##### ");
			String UserAddressRaw = input.nextLine(); // Read user input
			String[] pieces = UserAddressRaw.split(" "); // explode user input to break apart raw input
			for (int i = 0; i < pieces.length; i++) {
				if (i != 0 && i != pieces.length - 1) {

					address_name += pieces[i]+ " "; // add exploded street name sections together. i.e (vine st has a space in between, add 'vine' and 'st' together
														// need to implement a statement to convert 'street' to 'st' (and all others like boulevard to blvd) to search in csv.
				}
			}
			address_number = pieces[0];
			zip_code = pieces[pieces.length - 1];
			String[] prepped_addr = {address_number, address_name, zip_code};
			int wardNum = Integer.parseInt(wards.search(prepped_addr));
			
			display.writeTable(wardNum); // static cast to java file located in same directory. Might need to change this to a 'display' object and call the method that way.
			
			if (wardNum <4 && wardNum>0){
				System.out.println("This table shows an X when the trash will be picked up in the morning. \nKindly place your trash at the curb the previous day after 8:00pm.");
			}
			else if (wardNum >3 && wardNum<7){
				System.out.println("This table shows an X when the trash will be picked up in the morning. \nKindly place your trash at the curb the previous day after 8:00pm.");
			}
			else {
				System.out.print("Error in IF statement for displaying additional info");
			}
	}

}
