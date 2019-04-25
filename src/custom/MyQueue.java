package custom;

/**
 * Created by NubbY
 */
public class MyQueue<T> {

    private Node top = null;
    private Node tail = null;

    public void put(T value) {
        Node newNode = new Node(value);
        if (top == null) {
            tail = newNode;
            top = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T pop() {
        if (top != null) {
            Node store = top;
            top = top.next;
            if (top == null) {
                tail = null;
            }
            return store.getValue();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return (top == null);
    }

    private class Node {
        Node next;
        T value;

        Node(T val) {
            value = val;
        }

        T getValue() {
            return value;
        }
    }
}
