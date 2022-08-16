package other;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
    }
    private Queue<Integer> queue = new LinkedList<>();
    private Queue<Integer> queue1 = new LinkedList<>();

    public StackWithQueue() {

    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        Integer poll = null;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            if(!queue.isEmpty()) {
                queue1.add(poll);
            }
        }
        queue = new LinkedList<>(queue1);
        queue1.clear();
        return poll;
    }

    public int top() {
        Integer poll = null;
        while(!queue.isEmpty()) {
            poll = queue.poll();
            queue1.add(poll);
        }
        queue = new LinkedList<>(queue1);
        queue1.clear();
        return poll;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
