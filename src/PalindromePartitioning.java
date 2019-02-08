import java.util.ArrayList;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/palindrome-partitioning/">Problem here.</a>
 * Created by NubbY
 */
public class PalindromePartitioning {

    private List<List<String>> partitions;
    private int initialStringLength;

    public static void main(String[] args) {
        String testString = "abba";
        PalindromePartitioning test = new PalindromePartitioning();
        List<List<String>> testPartitions = test.partition(testString);
        for (List<String> part : testPartitions) {
            for (String singlepoly : part) {
                System.out.print(singlepoly + ", ");
            }
            System.out.println();
        }
    }

    private boolean checkIfPalindrome(String strToCheck) {
        for (int i = 0; i < strToCheck.length() / 2; i++) {
            if (strToCheck.charAt(i) != strToCheck.charAt(strToCheck.length() - i - 1)) return false;
        }
        return true;
    }

    private void recursiveChecking(String strToCheck, int currPos, List<String> currPart) {
        if (currPos == initialStringLength) {
            partitions.add(new ArrayList<>(currPart));
            return;
        }
        for (int i = 0; i < strToCheck.length(); i++) {
            if (checkIfPalindrome(strToCheck.substring(0, i + 1))) {
                currPart.add(strToCheck.substring(0, i + 1));
                recursiveChecking(strToCheck.substring(i + 1), currPos + i + 1, currPart);
                currPart.remove(currPart.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        partitions = new ArrayList<>();
        initialStringLength = s.length();
        recursiveChecking(s, 0, new ArrayList<>());
        return partitions;
    }
}
