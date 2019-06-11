package custom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Heap with maximum top element.
 * Supports repeating values.
 * <p>
 * Repeating values are stored as pairs (value + amount of repeats).
 * <p>
 * Created by NubbY
 */
public class MaxHeap implements Heap {
    private List<ValueWithAmount> store = new ArrayList<>();
    private Map<Integer, ValueWithAmount> presence = new HashMap<>();
    private int size;

    public MaxHeap() {
        //blocking store[0] for better readability
        store.add(new ValueWithAmount(0));
        size = 0;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap's size is less than 0");
        }
        ValueWithAmount topElement = store.get(1);
        if (topElement.getAmount() == 1) {
            serveHeap(topElement);
        } else {
            topElement.decreaseAmount();
        }
        printHeap();
        return topElement.getValue();
    }

    public void put(int item) {
        ValueWithAmount foundSameItem = presence.get(item);
        if (foundSameItem == null) {
            ValueWithAmount newElement = new ValueWithAmount(item);
            store.add(newElement);
            presence.put(item, newElement);
            size++;
            swim(size);
        } else {
            foundSameItem.increaseAmount();
        }
    }

    public void printHeap() {
        for (ValueWithAmount item : store) {
            System.out.print(item);
        }
        System.out.print("\n");
    }

    @Override
    public boolean isEmpty() {
        return store.size() == 1;
    }

    private void serveHeap(ValueWithAmount topElement) {
        int lastIndex = size;
        ValueWithAmount lastElement = store.get(lastIndex);
        store.set(1, lastElement);
        sink(1);
        presence.remove(topElement.getValue());
        store.remove(lastIndex);
        size--;
    }

    private void swim(int index) {
        while (index > 1 && less(index / 2, index)) {
            exchange(index, index / 2);
            index = index / 2;
        }
    }

    private void sink(int index) {
        while (2 * index <= size) {
            int sunkenIndex = 2 * index;
            if (sunkenIndex < size && less(sunkenIndex, sunkenIndex + 1)) {
                sunkenIndex++;
            }
            if (!less(index, sunkenIndex)) {
                break;
            }
            exchange(index, sunkenIndex);
            index = sunkenIndex;
        }
    }

    private boolean less(int i, int j) {
        return store.get(i).getValue() < store.get(j).getValue();
    }

    private void exchange(int i, int j) {
        ValueWithAmount swap = store.get(i);
        store.set(i, store.get(j));
        store.set(j, swap);
    }

    private class ValueWithAmount {
        int value;
        int amount;

        ValueWithAmount(int value) {
            this.value = value;
            this.amount = 1;
        }

        void increaseAmount() {
            amount++;
        }

        void decreaseAmount() {
            amount--;
        }

        int getAmount() {
            return amount;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "( " + value + " * " + amount + " )";
        }
    }
}
