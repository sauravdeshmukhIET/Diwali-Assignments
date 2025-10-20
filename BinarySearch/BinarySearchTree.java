package BinarySearch;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    private Node root;
    public void add(int data) {
        root = addRec(root, data);
    }
    private Node addRec(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = addRec(root.left, data);
        else root.right = addRec(root.right, data);
        return root;
    }
    public void remove(int data) {
        root = removeRec(root, data);
    }

    private Node removeRec(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = removeRec(root.left, key);
        } else if (key > root.data) {
            root.right = removeRec(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = minValue(root.right);
            root.right = removeRec(root.right, root.data);
        }

        return root;
    }
    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            root = root.left;
            min = root.data;
        }
        return min;
    }
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }
    private void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
}
