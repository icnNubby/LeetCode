import java.util.HashMap;

/**
 * <a href = "https://leetcode.com/problems/lru-cache/">Problem here.</a>
 */
public class LRUCache {

    private HashMap<Integer, Node> hashMap;
    private Node head;
    private Node tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        hashMap = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.put(2, 1);
        cache.get(2); // 2
        cache.put(3, 2);
        cache.get(2); // -1
        cache.get(3); // 3
    }

    private void push(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) head.prev = node;
        else tail = node;
        head = node;
        size++;
        if (size > capacity) {
            pop();
        }
    }

    private void pop() {
        if (size <= 1) {
            size = 0;
            hashMap.remove(tail.key);
            tail = null;
            head = null;
        } else {
            tail.prev.next = null;
            hashMap.remove(tail.key);
            tail = tail.prev;
            size--;
        }
    }

    private void moveToTop(Node node) {
        if (node != head) {
            node.prev.next = node.next;
        } else return;
        if (node != tail) {
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
        }
        size--;
        node.prev = null;
        push(node);
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            //System.out.println(-1);  //debug/testing
            return -1;
        } else {
            moveToTop(hashMap.get(key));
            //System.out.println(hashMap.get(key).getVal()); //debug/testing
            return hashMap.get(key).getVal();
        }
    }

    public void put(int key, int value) {
        if (!hashMap.containsKey(key)) {
            if (size == capacity) pop();
            Node newNode = new Node(key, value);
            push(newNode);
            hashMap.put(key, newNode);

        } else {
            hashMap.get(key).setVal(value);
            moveToTop(hashMap.get(key));
        }
    }

    private class Node {
        private Node next;
        private Node prev;
        private int key;
        private int val;


        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return key;
        }
    }

}
