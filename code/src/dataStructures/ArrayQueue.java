package dataStructures;

import java.util.Arrays;

public class ArrayQueue {
    
    private int front;
    private int rear = 0;
    private int count = 0;
    private int[] array; 

    public ArrayQueue(int size) {
        array = new int[size];
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);

        System.out.println(queue);
    }
    
    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return count == array.length;
    }

    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();

        count++;
        array[rear++ % array.length] = item;
    }
        
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        int item = array[front];
        front = front++ % array.length;
        count--;
        return item; 
    }

    public int peek() {
        return array[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
