package Main;

import java.util.Scanner;

class CircularLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    private Node last;
    public void insertAt(int data, int position) {
        Node newNode = new Node(data);
        if (last == null) {
            newNode.next = newNode;
            last = newNode;
            return;
        }
        Node temp = last.next;
        if (position == 1) {
            newNode.next = temp;
            last.next = newNode;
            return;
        }
        for (int i = 1; i < position - 1 && temp != last; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == last) {
            last = newNode;
        }
    }
    public void deleteNode(int key) {
        if (last == null) return;
        Node temp = last.next, prev = last;
        do {
            if (temp.data == key) {
                if (temp == last && temp.next == last) {
                    last = null;
                } else {
                    prev.next = temp.next;
                    if (temp == last) last = prev;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != last.next);
    }

    // Modify
    public void modifyNode(int oldData, int newData) {
        if (last == null) return;

        Node temp = last.next;
        do {
            if (temp.data == oldData) {
                temp.data = newData;
                return;
            }
            temp = temp.next;
        } while (temp != last.next);
    }

    // Display
    public void display() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = last.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }
}
