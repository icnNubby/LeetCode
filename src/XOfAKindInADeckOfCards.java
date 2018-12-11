import java.util.Hashtable;
import java.util.HashSet;
/**
 * <a href = "https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/"> Problem is here. </a>
 * <p>
 * Definitely not the optimal way
 * @author Nubby
 *
 */
public class XOfAKindInADeckOfCards {

	private boolean isPrimeNumber(int number) {
		if (number <= 3) return (number > 1);
		else if (number % 2 == 0 || number % 3 == 0) return false;
		int i = 5;
		while (i * i < number) {
			if (number % i == 0 || number % (i + 2) == 0 ) return false;
			i += 6;
		}
		return true;
	}

	private HashSet<Integer> getAllPrimeDenominators(int number) {
		HashSet<Integer> allPrimes = new HashSet<Integer>();
		int i = 2;
		while (number/i != 1) {
			if (isPrimeNumber(i)) {
				if (number % i == 0) {
					number /= i;
					allPrimes.add(i);
				}
				else i++;
			} else 
				i++;

		}
		if (number != 1) allPrimes.add(number);
		return allPrimes;
	}

	public boolean hasGroupsSizeX(int[] deck) {
		if (deck.length < 2) return false;

		Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
		int minCounter = Integer.MAX_VALUE; 

		for (int deckCard : deck)  table.put(deckCard, table.containsKey(deckCard) ? (table.get(deckCard) + 1) : 1); 

		for (int deckCounts: table.values()) minCounter = Math.min(deckCounts, minCounter);

		if (minCounter < 2) return false;

		HashSet<Integer> primesOfMinCounter = getAllPrimeDenominators(minCounter);

		for (int minPrimeDenominators: primesOfMinCounter) { 
			boolean found = true;
			for (int deckCounts: table.values()) { 
				if (deckCounts%minPrimeDenominators != 0) found = false;
			}
			if (found) return true;
		}

		return false;
	}

	public static void main (String[] args) {
		XOfAKindInADeckOfCards test = new XOfAKindInADeckOfCards();
		int[] testArray = {1,1,1,1,1,1,2,2,2,2,2,2};
		System.out.println(test.hasGroupsSizeX(testArray));
	}

}
