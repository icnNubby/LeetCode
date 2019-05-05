package custom;

import java.util.Random;

/**
 * Created by NubbY
 */
public class TestMinHeap {
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        Random rng = new Random();
        for (int i = 0; i < 100; i++) {
            heap.put(rng.nextInt());
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(heap.pop());
        }
    }
}
