import java.util.LinkedList;

/**
 * @author JJ
 * @date 2020/8/1 - 8:30
 */
public class No225 {

}

class MyStack {

    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {

        queue1.offer(x);
        // 将2队列中元素全部转给1队列
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.pop());
        }
        // 交换1和2,使得1队列没有在push()的时候始终为空队列
        LinkedList<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue2.pop();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue2.isEmpty();
    }

    public static void main(String[] args) {
        MyStack sta = new MyStack();
        sta.push(1);
        sta.push(2);
        int top = sta.top();
        int pop = sta.pop();
    }
}