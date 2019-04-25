package custom;

/**
 * Created by NubbY
 */
public class MyStack<T> {

    private Node top = null;

    public void put(T value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (top != null) {
            Node store = top;
            top = top.next;
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
