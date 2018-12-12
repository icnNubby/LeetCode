import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href = "https://leetcode.com/problems/verifying-an-alien-dictionary/"> Problem here. </a>
 * @author Nubby
 *
 */
public class VerifyingAnAlienDictionary {
	class AlienComparator implements Comparator<String> {

		private ArrayList<Character> order;

		AlienComparator(String order) {
			Character[] orderBoxed = new Character[order.length()];
			for (int i = 0; i < order.length(); i++) orderBoxed[i] = Character.valueOf(order.charAt(i));
			this.order = new ArrayList<Character>(Arrays.asList(orderBoxed));
		}

		@Override
		public int compare(String o1, String o2) {
			if (o1.length() == 0 && o2.length() != 0) return 1; 
			if (o1.length() != 0 && o2.length() == 0) return -1;
			if (o1.length() == 0 && o2.length() == 0) return 0;

			int comparation = 0;
			int position = 0;

			while (comparation == 0) {
				comparation = (order.indexOf(o1.charAt(position)) < order.indexOf(o2.charAt(position))) ? 1 :
					(order.indexOf(o1.charAt(position)) == order.indexOf(o2.charAt(position))) ? 0: -1;
				position++;
				if (comparation == 0) {
					if (position > o1.length() - 1 && position <= o2.length() - 1) comparation = 1;
					if (position > o2.length() - 1 && position <= o1.length() - 1) comparation = -1;
					if (position == o1.length() && position == o2.length()) return comparation;
				}
			}
			return comparation;
		}

	}

	public boolean isAlienSorted(String[] words, String order) {
		if (order.length() != 26) return false;
		AlienComparator ac = new AlienComparator(order);
		if (words.length < 2) return true;
		for (int i = 0; i < words.length - 1; i++) {
			if (ac.compare(words[i], words[i+1]) < 0) return false;
		}
		return true;
	}

	public static void main (String[] args) {
		VerifyingAnAlienDictionary test = new VerifyingAnAlienDictionary();

		String[] testWords = {"word","world","row"};
		String testOrder = "worldabcefghijkmnpqstuvxyz";

		System.out.println(test.isAlienSorted(testWords, testOrder));
	}


}
