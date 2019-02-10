/**
 * <a href = "https://leetcode.com/problems/add-binary/">Problem here.</a>
 * Created by NubbY
 */
public class AddBinary {
    public static void main(String[] args) {
        String testStr1 = "101010101010101";
        String testStr2 = "101010101010101";
        System.out.println(new AddBinary().addBinary(testStr1, testStr2));
    }

    public String addBinary(String a, String b) {

        if (a.length() == 0 && b.length() == 0) return "";

        int aPos = a.length() - 1;
        int aChar = a.length() > 0 ? Character.getNumericValue(a.charAt(aPos)) : -1;

        int bPos = b.length() - 1;
        int bChar = b.length() > 0 ? Character.getNumericValue(b.charAt(bPos)) : -1;

        int rest = 0;

        StringBuilder sb = new StringBuilder();

        while (!(aChar == -1 && bChar == -1 && rest == 0)) {
            int sum = ((aChar != -1) ? aChar : 0) + ((bChar != -1) ? bChar : 0) + rest;
            if (sum == 0) {
                rest = 0;
                sb.append(0);
            } else if (sum == 1) {
                rest = 0;
                sb.append(1);
            } else if (sum == 2) {
                rest = 1;
                sb.append(0);
            } else {
                sb.append(1);
                rest = 1;
            }
            aPos--;
            bPos--;
            aChar = aPos >= 0 ? Character.getNumericValue(a.charAt(aPos)) : -1;
            bChar = bPos >= 0 ? Character.getNumericValue(b.charAt(bPos)) : -1;
        }
        return sb.reverse().toString();
    }
}