/**
 * <a href = "https://leetcode.com/problems/string-without-aaa-or-bbb/submissions/">Problem here.</a>
 * Stupidest problem ive ever solved
 * Created by NubbY
 */
public class StringWithoutAAAorBBB {
    public static void main(String[] args) {
        StringWithoutAAAorBBB test = new StringWithoutAAAorBBB();
        System.out.println(test.strWithout3a3b(14, 10));
    }

    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        char prev = '0';
        int a = A;
        int b = B;
        while (a > 0 || b > 0) {
            if (prev == '0') {
                if (a > b) {
                    if (a >= 2) {
                        sb.append("aa");
                        a -= 2;
                        prev = 'a';
                    } else {
                        sb.append("a");
                        break;
                    }
                } else if (b > a) {
                    if (b >= 2) {
                        sb.append("bb");
                        b -= 2;
                        prev = 'b';
                    } else {
                        sb.append("b");
                        break;
                    }
                } else {
                    sb.append("a");
                    a--;
                    prev = 'a';
                }
            } else if (prev == 'a') {
                if (b >= 2 && b >= a) {
                    sb.append("bb");
                    b -= 2;
                } else {
                    sb.append("b");
                    b--;
                }
                prev = 'b';
            } else {
                if (a >= 2 && a >= b) {
                    sb.append("aa");
                    a -= 2;
                } else {
                    sb.append("a");
                    a--;
                }
                prev = 'a';
            }
        }
        return sb.toString();
    }
}