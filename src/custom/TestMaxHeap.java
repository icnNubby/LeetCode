package custom;

import java.util.Random;

/**
 * Created by NubbY
 */
public class TestMaxHeap {
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        Random rng = new Random();
        for (int i = 0; i < 200; i++) {
            heap.put(rng.nextInt(20));
        }
        int prev = 33;
        for (int i = 0; i < 200; i++) {
            int current = heap.pop();
            if (current > prev) {
                try {
                    throw new Exception("FAIL: " + current + " > " + prev);
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }
            } else {
                System.out.println(current);
            }
            prev = current;
        }
    }
}
