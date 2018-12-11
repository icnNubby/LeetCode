/**
 * <a href = "https://leetcode.com/problems/count-primes/" > Problem here. </a>
 * <p>
 * Straightforward approach;
 * @author Nubby
 *
 */
public class CountPrimes {
   	private boolean isPrimeNumber(int number) {
		if (number <= 3) return (number > 1);
		else if (number % 2 == 0 || number % 3 == 0) return false;
		int i = 5;
		while (i * i <= number) {
			if (number % i == 0) return false;
			i++;
		}
		return true;
	}

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) if (isPrimeNumber(i)) count++;
        return count;
    }
    
    
    public static void main(String[] args) {
    	CountPrimes test = new CountPrimes();
    	System.out.println(test.countPrimes(1000));
    }
}
