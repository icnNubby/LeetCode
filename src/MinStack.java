public class MinStack {

    private StackNode top;
    private int size;

    public MinStack() {
        top = null;
        size = 0;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public void push(int x) {
        if (top == null) {
            top = new StackNode(x);
            top.min = x;
        } else {
            StackNode temp = new StackNode(x);
            temp.min = Math.min(top.min, x);
            temp.next = top;
            top = temp;
        }
        size++;
    }

    public void pop() {
        if (size == 0) throw new IndexOutOfBoundsException("0 elements in the stack");
        top = top.next;
        size--;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.min;
    }

    private class StackNode {
        int val;
        int min;
        StackNode next;

        StackNode(int val) {
            this.val = val;
            next = null;
        }
    }
}