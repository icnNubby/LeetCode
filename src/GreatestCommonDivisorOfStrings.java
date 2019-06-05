/**
 * Created by NubbY
 */
public class GreatestCommonDivisorOfStrings {

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings test = new GreatestCommonDivisorOfStrings();
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(test.gcdOfStrings(str1, str2));// ABC
        str1 = "ABABABAB";
        str2 = "ABAB";
        System.out.println(test.gcdOfStrings(str1, str2));// AB
        str1 = "LEET";
        str2 = "CODE";
        System.out.println(test.gcdOfStrings(str1, str2));// ""
    }

    boolean isDivisor(String strToCheck, String divisor) {
        if (strToCheck.length() % divisor.length() != 0) {
            return false;
        }
        int count = strToCheck.length() / divisor.length();
        StringBuilder checker = new StringBuilder();
        for (int i = 0; i < count; i++) {
            checker.append(divisor);
        }
        return checker.toString().equals(strToCheck);
    }

    public String gcdOfStrings(String str1, String str2) {

        //Ensure that str1 >= str2
        if (str1.length() < str2.length()) {
            String str = str1;
            str1 = str2;
            str2 = str;
        }
        String greatestDivisor = "";
        for (int i = 1; i < str2.length(); i++) {
            if (str2.length() % i != 0) {
                continue;
            }
            String currentDivisor;
            currentDivisor = str2.substring(0, str2.length() / i);
            if (isDivisor(str1, currentDivisor) && isDivisor(str2, currentDivisor)) {
                greatestDivisor = currentDivisor;
                break;
            }
        }

        return greatestDivisor;
    }
}
