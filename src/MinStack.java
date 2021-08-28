import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 */
public class MinStack {
    private Stack<Integer> valueStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        valueStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        valueStack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        valueStack.pop();
        minStack.pop();
    }

    public int top() {
        return valueStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
