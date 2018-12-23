/**
 * <a href = "https://leetcode.com/problems/rotate-string/"> Problem here. </a>
 * @author icnNubby
 *
 */
public class RotateString {
	
    public boolean rotateString(String A, String B) { //O(N*M) =(
    	if (A.length() != B.length()) return false;
    	StringBuilder sb = new StringBuilder(A);
    	for (int i = 0; i < A.length(); i++) {
    		char temp = sb.charAt(0);
    		sb.deleteCharAt(0);
    		sb.append(temp);
    		if (sb.toString().equals(B)) return true;
    	}
        return false;
    }

    public boolean rotateString2(String A, String B) { //O(N*M) =(
    	return (A + A).contains(B);
    }
    
    //TODO implement KMP method
    
    
    public static void main(String[] args) {
    	RotateString test = new RotateString();
    	System.out.println(test.rotateString2("abcdefg", "cdefgab"));
    	
    }
}
