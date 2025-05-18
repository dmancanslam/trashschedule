package elizabeth;

public class Parse {
	
	public static boolean compareIgnoringSpaces(String str1, String str2) {
        String cleanedStr1 = str1.replaceAll("\\s", ""); // strip space characters from both strings
        String cleanedStr2 = str2.replaceAll("\\s", "");

        return cleanedStr1.equalsIgnoreCase(cleanedStr2); // compare the cleaned strings (case-insensitive)
    }

	public static String[] cleanupInput(String UserAddressRaw) {
		String address_number;
		String address_name = "";
		String zip_code;
		String[] abbreviateFrom = {"street", "drive", "boulevard", "avenue", "road"};
		String[] abbreviateTo = {"st", "dr", "blvd", "ave", "rd"};
		String[] pieces = UserAddressRaw.split(" "); // explode user input to break apart raw input
		int count = 0;
		
		for (int i = 0; i < pieces.length; i++) {
			if (i != 0 && i != pieces.length - 1) { //only add stuff in the middle of the addr number (begining) and zip code (at the end of the input)
				for(String e : abbreviateFrom) {
					if(compareIgnoringSpaces(pieces[i],e)) {
						pieces[i] = abbreviateTo[count];
						count = 0;
						break;
					}
					count++;
				}
				count = 0;
				address_name += pieces[i]+ " "; //address can consist of varying lengths
				//To account for this, we add all of the pieces to a variable called address name
				//with the exception of address number and zip code associated with the address
			}
		}
		address_number = pieces[0];
		zip_code = pieces[pieces.length - 1];
		
		//Full address as a single string
		String[] prepped_addr = {address_number, address_name, zip_code};
		return prepped_addr;

	}

}
