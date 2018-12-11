/**
 * <a href = "https://leetcode.com/problems/long-pressed-name/"> Problem here. </a> 
 * 
 *  * @author Nubby 
 * */


public class LongPressedName {

	boolean isLongPressedName(String name, String typed) {

		if (name.length() > typed.length()) return false;
		int namedIndex = 0; int typedIndex = 0;
		while (namedIndex < name.length() && typedIndex < typed.length()) {
			if (name.charAt(namedIndex) != typed.charAt(typedIndex)) {
				
				if (namedIndex == 0) return false; 															//we are at beginning and we cant check previous symbol
				
				if (name.charAt(namedIndex - 1) == typed.charAt(typedIndex)) 								//previous symbol matches, we can go further on string typed
					typedIndex++;
				else 
					return false;																			//if symbols dont match - clearly false output
				
			} else 
				namedIndex++; typedIndex++;																	//symbols matches, we go further on both strings
			
		}
		
		if (typedIndex < typed.length() && namedIndex == name.length()) 									//we have unchecked tail of typed string, checking it
			while (typedIndex < typed.length() && typed.charAt(typedIndex) == name.charAt(namedIndex - 1)) 
				typedIndex++;
		
		return ((typedIndex == typed.length()) && (namedIndex == name.length())) ? true: false;
	}

	public static void main(String[] args) {

		LongPressedName test = new LongPressedName();
		System.out.println(test.isLongPressedName("abc","abc"));	

	}
}