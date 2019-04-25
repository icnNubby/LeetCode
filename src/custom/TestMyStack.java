package custom;

/**
 * Created by NubbY
 */
public class TestMyStack {

    public static void main(String[] args) {
        TestMyStack test = new TestMyStack();
        test.putOneElement();
        test.getOneElement();
        test.putTwoElements();
    }

    private void putOneElement() {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.put(1);

        if (!integerMyStack.isEmpty()) {
            System.out.println("putOneElement good");
        } else {
            System.out.println("putOneElement fail!");
        }
    }

    private void getOneElement() {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.put(1);
        int value = integerMyStack.pop();

        if (value == 1 && integerMyStack.isEmpty()) {
            System.out.println("getOneElement good");
        } else {
            System.out.println("getOneElement fail!");
        }
    }

    private void putTwoElements() {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.put(1);
        integerMyStack.put(2);
        int first = integerMyStack.pop();
        int second = integerMyStack.pop();

        if (first == 2 && second == 1 && integerMyStack.isEmpty()) {
            System.out.println("putTwoElements good");
        } else {
            System.out.println("putTwoElements fail!");
        }
    }

}
