package custom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NubbY
 */
public class MinHeap implements Heap {
    private List<Integer> store = new ArrayList<>();

    public MinHeap() {
        //blocking store[0] for better readability
        store.add(0);
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap size is less than 0");
        }
        int out = store.get(1);
        store.set(1, store.get(store.size() - 1));
        sink(1);
        store.remove(store.size() - 1);
        return out;
    }


    public void put(int item) {
        store.add(item);
        swim(store.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return store.size() == 1;
    }

    private void swim(int index) {
        while (index > 1 && store.get(index) < store.get(index / 2)) {
            swap(index, index / 2);
            index = index / 2;
        }
    }

    private void sink(int index) {
        int n = store.size() - 1;
        while (2 * index <= n) {
            int j = 2 * index;
            if (j < n && store.get(j) > store.get(j + 1)) j++;
            if (!(store.get(index) <= store.get(j))) break;
            swap(index, j);
            index = j;
        }
    }

    private void swap(int index1, int index2) {
        int value1 = store.get(index1);
        int value2 = store.get(index2);

        store.set(index1, value2);
        store.set(index2, value1);
    }
}
