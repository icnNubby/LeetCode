public class LongestMountainInArray {

    public static void main(String[] args) {
        LongestMountainInArray test = new LongestMountainInArray();
        int[] testArray = {0, 2, 0, 2, 1, 2, 2, 0, 0, 1};
        System.out.println(test.longestMountain(testArray));

    }

    public int longestMountain(int[] A) {
        if (A.length < 3) return 0;
        boolean goingUp = A[0] < A[1];
        int maxLength = 0;
        int curLength = goingUp ? 1 : 0;
        for (int i = 1; i < A.length; i++) {
            if (goingUp) {
                if (A[i] > A[i - 1])
                    if (curLength == 0) curLength = 2;
                    else curLength++;
                if (A[i] < A[i - 1]) {
                    goingUp = false;
                    curLength++;
                }
                if (A[i] == A[i - 1])
                    curLength = 0;
            } else {
                if (A[i] < A[i - 1] && curLength >= 1) {
                    curLength++;
                }
                if (A[i] >= A[i - 1]) {
                    goingUp = true;
                    maxLength = (curLength > 2) ? Math.max(maxLength, curLength) : maxLength;
                    if (A[i] == A[i - 1]) curLength = 0;
                    else curLength = 2;
                }
            }
        }
        if (!goingUp && curLength > 2) maxLength = Math.max(maxLength, curLength);
        return maxLength;
    }
}
