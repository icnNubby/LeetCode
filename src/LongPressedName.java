/**
 * <a href = "https://leetcode.com/problems/long-pressed-name/"> Problem here. </a> 
 * 
 *  * @author Nubby 
 * */


public class LongPressedName {

	public static void main(String[] args) {

		LongPressedName test = new LongPressedName();
		System.out.println(test.isLongPressedName("abc", "abc"));

	}

	boolean isLongPressedName(String name, String typed) {

		if (name.length() > typed.length()) return false;
		int namedIndex = 0; int typedIndex = 0;
		while (namedIndex < name.length() && typedIndex < typed.length()) {
			if (name.charAt(namedIndex) != typed.charAt(typedIndex)) {

				//we are at beginning and we cant check previous symbol
				if (namedIndex == 0) return false;

				//previous symbol matches, we can go further on string typed
				if (name.charAt(namedIndex - 1) == typed.charAt(typedIndex))
					typedIndex++;
				else
					//if symbols dont match - clearly false output
					return false;

			} else
				//symbols matches, we go further on both strings
				namedIndex++;
			typedIndex++;

		}

		//we have unchecked tail of typed string, checking it
		if (typedIndex < typed.length() && namedIndex == name.length())
			while (typedIndex < typed.length() && typed.charAt(typedIndex) == name.charAt(namedIndex - 1))
				typedIndex++;

		return (typedIndex == typed.length()) && (namedIndex == name.length());
	}
}
