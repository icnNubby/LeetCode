/**
 * <a href = "https://leetcode.com/problems/valid-anagram/"> Problem here </a>
 * @author Nubby
 *
 */
public class ValidAnagram {
	
    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()) return false;
    	int[] counter = new int[26];
    	
    	for (char charsS: s.toLowerCase().toCharArray()) 
    		counter[(int)charsS - 97]++;
    	
    	for (char charsT: t.toLowerCase().toCharArray()) 
    		counter[(int)charsT - 97]--;
    	for (int checkCount: counter)
    		if (checkCount != 0) return false;
    	return true;
    }
    
    public static void main(String[] args) {
    	
    	String str1 = "abaa";
    	String str2 = "aabb";
    	
    	ValidAnagram test = new ValidAnagram();
    	System.out.println(test.isAnagram(str1, str2));
    	
    }
}
