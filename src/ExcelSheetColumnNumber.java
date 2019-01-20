/**
 * <a href = "https://leetcode.com/problems/excel-sheet-column-number">Problem here.</a>
 * Created by NubbY
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
        System.out.println(test.titleToNumber("ZY")); //701
    }

    public int titleToNumber(String s) {
        int totalNumber = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            totalNumber += (c - 'A' + 1) * Math.pow(26, s.length() - i - 1);
        }
        return totalNumber;
    }
}
