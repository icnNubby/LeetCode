package custom;

/**
 * Created by NubbY
 */
public class TestMyQueue {

    public static void main(String[] args) {
        TestMyQueue test = new TestMyQueue();
        test.putOneElement();
        test.getOneElement();
        test.putTwoElements();
    }

    private void putOneElement() {
        MyQueue<Integer> integerMyQueue = new MyQueue<>();
        integerMyQueue.put(1);

        if (!integerMyQueue.isEmpty()) {
            System.out.println("putOneElement good");
        } else {
            System.out.println("putOneElement fail!");
        }
    }

    private void getOneElement() {
        MyQueue<Integer> integerMyQueue = new MyQueue<>();
        integerMyQueue.put(1);
        int value = integerMyQueue.pop();

        if (value == 1 && integerMyQueue.isEmpty()) {
            System.out.println("getOneElement good");
        } else {
            System.out.println("getOneElement fail!");
        }
    }

    private void putTwoElements() {
        MyQueue<Integer> integerMyQueue = new MyQueue<>();
        integerMyQueue.put(1);
        integerMyQueue.put(2);
        int first = integerMyQueue.pop();
        int second = integerMyQueue.pop();

        if (first == 1 && second == 2 && integerMyQueue.isEmpty()) {
            System.out.println("putTwoElements good");
        } else {
            System.out.println("putTwoElements fail!");
        }
    }

}
