package Main;

import BinarySearch.BinarySearchTree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Circular Linked List ===");
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAt(10, 1);
        cll.insertAt(20, 2);
        cll.insertAt(30, 3);
        System.out.print("List after inserts: ");
        cll.display();
        cll.modifyNode(20, 25);
        System.out.print("List after modifying 20 to 25: ");
        cll.display();
        cll.deleteNode(10);
        System.out.print("List after deleting 10: ");
        cll.display();


        System.out.println("\n=== Circular Queue ===");
        CircularQueue<Integer> cq = new CircularQueue<>(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        System.out.print("Queue after enqueues: ");
        cq.display();
        cq.dequeue();
        System.out.print("Queue after one dequeue: ");
        cq.display();

        System.out.println("\n=== Quick Sort Strings ===");
        String[] arr = { "banana", "apple", "mango", "cherry" };
        QuickSortStrings sorter = new QuickSortStrings();
        sorter.quickSort(arr, 0, arr.length - 1);
        System.out.print("Sorted strings: ");
        for (String s : arr) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("\n=== Binary Search Tree ===");
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(50);
        bst.add(30);
        bst.add(70);
        bst.add(20);
        bst.add(40);
        bst.add(60);
        bst.add(80);

        System.out.print("Inorder traversal: ");
        bst.inorder();

        System.out.print("Preorder traversal: ");
        bst.preorder();

        System.out.print("Postorder traversal: ");
        bst.postorder();

        bst.remove(70);
        System.out.print("Inorder after deleting 70: ");
        bst.inorder();

        sc.close();
    }
}
