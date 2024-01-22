package challenges;

import java.util.Stack;

public class QueueWithStack {

    private Stack<Integer> enqueueStack = new Stack<>();
    private Stack<Integer> dequeueStack = new Stack<>();

    public static void main(String[] args) {
        QueueWithStack queue = new QueueWithStack();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        var first = queue.dequeue();
        System.out.println(first);
    }

    public void enqueue(int item) {
        enqueueStack.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveContents();

        return dequeueStack.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveContents();

        return dequeueStack.peek();
    }

    private void moveContents() {
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

}
