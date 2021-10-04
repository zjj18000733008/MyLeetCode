import java.util.Stack;

/**
 * @author JJ
 * @date 2020/8/1 - 9:33
 */
public class No232 {

}

class MyQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    Stack<Integer> stack3;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack3 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack3.push(stack2.pop());
        }
        while(!stack3.isEmpty()){
            stack1.push(stack3.pop());
        }
        Stack<Integer> temp=stack1;
        stack1=stack2;
        stack2=temp;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        return stack2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.pop();
        queue.pop();
        boolean empty = queue.empty();
    }
}