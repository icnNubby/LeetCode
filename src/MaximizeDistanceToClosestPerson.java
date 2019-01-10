/**
 * <a href = "https://leetcode.com/problems/maximize-distance-to-closest-person/">Problem here.</a>
 */
public class MaximizeDistanceToClosestPerson {

    public static void main(String[] args) {
        MaximizeDistanceToClosestPerson test = new MaximizeDistanceToClosestPerson();
        int[] testArray = {1, 1, 1, 1, 0, 0, 0, 0, 0};
        System.out.println(test.maxDistToClosest(testArray));
    }

    public int maxDistToClosest(int[] seats) {
        int emptySeats = 0;
        int maxEmptySeats = 0;
        boolean start = true;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (start) emptySeats += 2;
                else emptySeats++;
                maxEmptySeats = Math.max(emptySeats, maxEmptySeats);
            }
            if (seats[i] == 1) {
                if (start) start = false;
                emptySeats = 0;
            }
        }
        if (seats[seats.length - 1] == 0) maxEmptySeats = Math.max(emptySeats * 2, maxEmptySeats);
        return (maxEmptySeats + 1) / 2;
    }
}
