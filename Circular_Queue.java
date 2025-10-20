package Main;

import java.util.LinkedList;

class CircularQueue<T> {
    private LinkedList<T> list = new LinkedList<>();
    private int size;

    CircularQueue(int size) {
        this.size = size;
    }

    public void enqueue(T data) {
        if (list.size() == size) {
            System.out.println("Queue is full");
            return;
        }
        list.addLast(data);
    }

    public void dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        list.removeFirst();
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            for (T data : list) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}
