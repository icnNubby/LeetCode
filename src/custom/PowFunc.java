package custom;

/**
 * Created by NubbY
 */
public class PowFunc {
    public static void main(String[] ags) {
        PowFunc test = new PowFunc();
        System.out.println("  1 = " + test.pow(1, 100));
        System.out.println("100 = " + test.pow(10, 2));
        System.out.println("  0 = " + test.pow(0, 100));
        System.out.println("0.5 = " + test.pow(2, -1));
        System.out.println("  0 = " + test.pow(0, 100));
        System.out.println("0.00625 = " + test.pow(2, -4));
        System.out.println("1024 = " + test.pow(2, 10));
    }

    public float pow(int number, int power) {
        if (number == 0 || power == 0) return 1;
        if (power == 1) return number;
        if (power == -1) return (float) 1 / number;
        float square = pow(number, power / 2);
        if (power % 2 == 0) {
            return square * square;
        } else {
            return square * square * number;
        }
    }
}
