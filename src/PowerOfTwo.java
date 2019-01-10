public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo test = new PowerOfTwo();
        System.out.println(test.isPowerOfTwo(10));
        System.out.println(test.isPowerOfTwo(16));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        if (n == 1) return true;
        return (n & (n - 1)) == 0;
    }
}
