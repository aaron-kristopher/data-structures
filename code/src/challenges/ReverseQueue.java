package challenges;

import java.util.ArrayDeque;
import java.util.Queue;

import dataStructures.Stack;

public class ReverseQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<Integer>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println(queue);
        System.out.println(reverseQueue(queue));

    }

    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack stack = new Stack(5);

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

}
