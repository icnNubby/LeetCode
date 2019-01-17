import java.util.ArrayList;

/**
 * <a href = "https://leetcode.com/problems/decoded-string-at-index/">Problem here.</a>
 * Created by NubbY
 */
public class DecodedStringAtIndex {

    public static void main(String[] args) {
        DecodedStringAtIndex test = new DecodedStringAtIndex();
        System.out.println(test.decodeAtIndex("abc3", 6)); // c
        System.out.println(test.decodeAtIndex("a23", 6)); // a
        System.out.println(test.decodeAtIndex("leet2code3", 10)); // o
        System.out.println(test.decodeAtIndex("ha22", 5)); // h
        System.out.println(test.decodeAtIndex("a2345678999999999999999", 1)); // a
    }

    private DecodedString decodeToLinkedList(String S) {
        ArrayList<DecodedString> decodedStrings = new ArrayList<>();
        DecodedString currentString = new DecodedString();
        currentString.addition = "";
        currentString.decodedStringBefore = null;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (!Character.isDigit(c)) {
                currentString.addition += c;
                currentString.length++;
            } else {
                currentString.multiplier = Character.getNumericValue(c);
                DecodedString newString = new DecodedString();
                newString.decodedStringBefore = currentString;
                newString.addition = "";
                newString.length = currentString.length * currentString.multiplier;
                currentString = newString;
            }
        }

        return currentString;
    }

    public String decodeAtIndex(String S, int K) {
        DecodedString head = decodeToLinkedList(S);
        while (head != null) {
            if (head.length - head.addition.length() > K) {
                if (head.decodedStringBefore != null) {
                    K = (int) (K % head.decodedStringBefore.length);
                    if (K == 0) K = (int) head.decodedStringBefore.length;
                }
                head = head.decodedStringBefore;
            } else if (head.length - head.addition.length() == K) {
                if (head.decodedStringBefore != null) {
                    K = K / head.decodedStringBefore.multiplier;
                    head = head.decodedStringBefore;
                } else {
                    return Character.toString(head.addition.charAt((int) (K - 1 - head.length + head.addition.length())));
                }
            } else {
                return Character.toString(head.addition.charAt((int) (K - 1 - head.length + head.addition.length())));
            }
        }
        return null;
    }

    private class DecodedString {
        public DecodedString decodedStringBefore;
        public String addition;
        public long length;
        public int multiplier;
    }
}
