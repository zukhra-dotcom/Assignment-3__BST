package com.company;
import java.util.*;

class BST_class {
    class Node {
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }
    Node root;

    BST_class(){
        root = null;
    }

    int minValue(Node root)  {
        int minval = root.key;
        while (root.left != null)  {
            minval = root.left.key;
            root = root.left;
        }
        return minval;
    }

    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    Node insert_Recursive(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)
            root.right = insert_Recursive(root.right, key);
        return root;
    }

    void inorder() {
        inorder_Recursive(root);
    }

    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.key + " ");
            inorder_Recursive(root.right);
        }
    }
}
class Main{
    public static void main(String[] args)  {
        BST_class bst = new BST_class();
        /* BST tree example
              45
           /     \
          10      90
         /  \    /
        7   12  50   */
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        System.out.println("The BST Created with input data(Left-root-right):");
        bst.inorder();
    }
}