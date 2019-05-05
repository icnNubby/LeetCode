package custom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NubbY
 */
public class MinHeap {
    List<Integer> store = new ArrayList<>();

    public MinHeap() {
        //blocking store[0] for better readability
        store.add(0);
    }

    public int pop() {
        if (store.size() == 1) {
            throw new IndexOutOfBoundsException("Heap size is less than 0");
        }
        int out = store.get(1);
        store.set(1, store.get(store.size() - 1));
        sink(1);
        return out;
    }


    public void put(int item) {
        store.add(item);
        swim(store.size() - 1);
    }

    private void swim(int index) {
        if (index == 1) return;
        if (store.get(index) < store.get(index / 2)) {
            int tmp = store.get(index);
            store.set(index, store.get(index / 2));
            store.set(index / 2, tmp);
            swim(index / 2);
        }
    }

    private void sink(int index) {
        int leftIndex = index * 2;
        int rightIndex = index * 2 + 1;
        int leftChild;
        int rightChild;

        if (store.size() <= leftIndex) {
            return;
        } else {
            leftChild = store.get(leftIndex);
        }
        if (store.size() <= rightIndex) {
            int tmp = store.get(index);
            store.set(index, store.get(leftIndex));
            store.set(leftIndex, tmp);
        } else {
            rightChild = store.get(rightIndex);
            if (rightChild > leftChild) {
                int tmp = store.get(index);
                store.set(index, store.get(leftIndex));
                store.set(leftIndex, tmp);
                sink(leftIndex);
            } else {
                int tmp = store.get(index);
                store.set(index, store.get(rightIndex));
                store.set(rightIndex, tmp);
                sink(rightIndex);
            }
        }
    }
}
