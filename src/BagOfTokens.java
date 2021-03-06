import java.util.Arrays;
/**
 * <a href = "https://leetcode.com/problems/bag-of-tokens"> Problem here. </a>
 */

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int P) {

        if (tokens.length == 0) return 0;
    	if (tokens.length == 1 && tokens[0] < P) return 1;
    	
    	Arrays.sort(tokens);
    	boolean changed = false;
    	int points = 0;
    	int lowest = tokens[0];
    	if (P < lowest) return 0;
    	P -= lowest; points++;
        int hPointer = tokens.length - 1;
        int lPointer = 1;
		
 	
    	while(!changed){
            if (tokens[lPointer] > P && points == 0) break;
            if (tokens[lPointer] <= P) {
    			points++;
                P -= tokens[lPointer];
                lPointer++;
    			continue;
    		}
            if (tokens[lPointer] > P && points > 0 && hPointer - lPointer >= 2) {
                P += tokens[hPointer];
                hPointer--;
    			points--;
    			continue;
    		} 
    		changed = !changed;
    	}  
    	
        return points;
    }	
    
    public static void main(String[] args) {
    	int[]A = {42,10,26,22};
    	System.out.println(bagOfTokensScore(A, 	65));
    }
}
