package TreeDSA;

import java.util.Random;

public class BinarySearchTreeDSA {
    public static void main(String[] args) {

        // Binary Tree - A binary tree is a basic data structure where each node has at most two children,
        //               referred to as the left child and the right child. There are no additional constraints
        //               on how the nodes are organized. The binary tree structure is used for various purposes,
        //               including representing hierarchical data and implementing certain algorithms.

        // Binary Search Tree - A binary search tree is the same as a binary tree with the exception that the tree
        //                      has additional constraints where all the values are arranged in an order

        //                      Benefit: easy to locate a node when they are in this order

        //                      Time Complexity: best case O(log n)
        //                                       worst case O(n)

        //                      Space Complexity: O(n)

        // Order: 1. The parent node is greater than the left child node and less than the right child node
        //        2. The left child node is less than the parent node. The left most leaf child is the smallest value
        //        3. The right child node is greater than the parent node. The right most leaf child is the greatest value

        // Example:          4
        //                 /   \
        //                2     6
        //              /  \   /  \
        //             1    3 5    7

        // Notice - how 2(left child node) is less than 4(parent node) and 6(right child node) is greater than 4.
        //          In addition, notice how the parents keeps going even to the subtrees.

        // Note - The order in which you Insert nodes into a Binary Search Tree does matter if it's unbalanced. Our tree
        //        here is fairly lopsided. There is a way to balance binary trees and those are called avl trees.


        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(new Node(5));
        bst.insert(new Node(1));
        bst.insert(new Node(9));
        bst.insert(new Node(7));
        bst.insert(new Node(3));
        bst.insert(new Node(6));
        bst.insert(new Node(4));
        bst.insert(new Node(8));
        bst.insert(new Node(2));

        System.out.print("bst.displayInorder(): "); bst.displayInorder();
        System.out.print("\nbst.displayReverseInorder(): "); bst.displayReverseInorder();

        System.out.println("\nbst.search(0): " + bst.search(0));
        System.out.println("bst.search(3): " + bst.search(3));

        bst.remove(5);
        System.out.print("bst.remove(5): "); bst.displayInorder();


//--------------------------------Tree Traversal-------------------------------------------------------------------------
        System.out.println("\n\nTree Traversal");

        // Tree Traversal: In-order Traversal Time Complexity: O(n)
        //                 Reverse In-order Traversal Time Complexity: O(n)
        //                 Post-order Traversal Time Complexity: O(n)
        //                 Pre-order Traversal Time Complexity: O(n)

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Give for loop to add elements into tree.

        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(6));
        tree.insert(new Node(4));
        tree.insert(new Node(8));
        tree.insert(new Node(2));

        // In-order Traversal - Used to traverse a tree in order (least to greatest)
        System.out.print("tree.displayInorder(): "); tree.displayInorder();

        // Reverse In-order Traversal - Used to traverse a tree in backwards order (greatest to least)
        // (left -> root -> right)
        System.out.print("\ntree.displayReverseInorder(): "); tree.displayReverseInorder();

        // Post-order Traversal - Use to delete a tree from leaf to root. (left -> right -> root)
        System.out.print("\ntree.displayPostorder(): "); tree.displayPostorder();

        // Pre-order Traversal - Use to make a copy a tree. (root -> left -> right)
        System.out.print("\ntree.displayPreorder(): "); tree.displayPreorder();

//--------------------------------Search Algorithms-------------------------------------------------------------------------

        BinarySearchTree<Integer> searchingExampleTree = new BinarySearchTree<>();

        searchingExampleTree.insert(new Node(5));
        searchingExampleTree.insert(new Node(1));
        searchingExampleTree.insert(new Node(9));
        searchingExampleTree.insert(new Node(7));
        searchingExampleTree.insert(new Node(3));
        searchingExampleTree.insert(new Node(6));
        searchingExampleTree.insert(new Node(4));
        searchingExampleTree.insert(new Node(8));
        searchingExampleTree.insert(new Node(2));

        // Depth-First Search - A search algorithm that traverses a tree or a graph data structure.
        //                      1. It picks a route going in deep until it hits a dead end.
        //                      2. Backtrack to last node that has unlisted adjacent nodes
        //                      (nodes that are attached but are not visited)

        // Example:          A     DFS: D, B, E,
        //                  / \
        //                 B   C
        //                / \   \
        //               D   E   F













    }
}

class BinarySearchTree<T extends Comparable<T>>
{
    Node root;

    public void insert(Node node)
    {
        root = insertHelper(root, node);
    }

    private Node insertHelper(Node root, Node node) // Using helper methods since we are using recursion.
    {
        T data = (T)node.data;

        if(root == null)
        {
            root = node;
            return root;
        }
        else if(root.data.compareTo(data) > 0)  // root.data > data
        {
            root.left = insertHelper(root.left, node);

            // Returns  * -1 if this.data < otherData
            //          *  1 if this.data > otherData
            //          *  0  if this.data = otherData.
        }
        else // root.data < data
        {
            root.right = insertHelper(root.right, node);
            
        }
        return root;
    }

    // In-order Traversal (least to greatest) (left -> root -> right)
    public void displayInorder()
    {
        displayHelperInorder(root);

    }

    // Post-order Traversal (Used to delete a tree from leaf to root) (left -> right -> root)
    public void displayPostorder()
    {
        displayHelperPostorder(root);
    }

    // Pre-order Traversal (Used to create a copy of a tree) (root -> left -> right)
    public void displayPreorder()
    {
        displayHelperPreorder(root);
    }

    // Reverse In-order Traversal (greatest to least)
    public void displayReverseInorder()
    {
        displayHelperReverseInorder(root);
    }

    // In-order Traversal Helper
    private void displayHelperInorder(Node root)
    {
        // Inorder traversal - displayed in non-decreasing order lowest - greatest
        if(root != null)
        {
            displayHelperInorder(root.left);
            System.out.print(root.data + " ");
            displayHelperInorder(root.right);
        }
    }

    // Post-order Traversal Helper
    private void displayHelperPostorder(Node root)
    {
        if(root != null)
        {
            displayHelperPostorder(root.left);
            displayHelperPostorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Pre-order Traversal Helper
    private void displayHelperPreorder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data + " ");
            displayHelperPreorder(root.left);
            displayHelperPreorder(root.right);
        }
    }

    // Reverse In-order Traversal Helper
    private void displayHelperReverseInorder(Node root)
    {
        // Post-order traversal - displayed in decreasing order greatest - lowest
        if(root != null)
        {
            displayHelperReverseInorder(root.right);
            System.out.print(root.data + " ");
            displayHelperReverseInorder(root.left);
        }
    }




    public boolean search(T data)
    {
        return searchHelper(root, data);
    }
    private boolean searchHelper(Node root, T data)
    {
        if(root == null)
        {
            return false;
        }
        else if(root.data == data)
        {
            return true;
        }
        else if(root.data.compareTo(data) > 0) // root.data > data
        {
            return searchHelper(root.left, data);
        }
        else // root.data < data
        {
            return searchHelper(root.right, data);
        }
    }

    public void remove(T data)
    {
        if(search(data))
        {
            removeHelper(root, data);
        }
        else
        {
            System.out.println(data + " does not exist");
        }

    }
    private Node removeHelper(Node root, T data)
    {
        if(root == null) // Checks if root is null
        {
            return root;
        }
        else if(root.data.compareTo(data) > 0) // root.data > data
        {
            root.left = removeHelper(root.left, data);
        }
        else if(root.data.compareTo(data) < 0)
        {
            root.right = removeHelper(root.right, data);
        }
        else // node found
        {
            // Check if it's a leaf node.
           if(root.left == null && root.right == null)
           {
               root = null;
           }
           // If root has a right child we need to find a successor(the least value) to replace this node.
           else if(root.right != null)
           {
               // This makes the node to be removed be replaced with the successor node which is the least leaf node
               // on the right side of the node to be removed.
               root.data = successor(root);

               // Once the node to be removed is replaced with the successor we now have to remove the old node
               // successor node, so we don't have duplicates.
               root.right = removeHelper(root.right, (T)root.data);
           }
           // If root has a left child we need to find a predecessor(the greatest value) to replace this node.
           else
           {
               // This makes the node to be removed be replaced with the predecessor node which is the greatest leaf node
               // on the left side of the node to be removed.
               root.data = predecessor(root);

               // Once the node to be removed is replaced with the predecessor we now have to remove the old node
               // predecessor, so we don't have duplicates.
               root.left = removeHelper(root.left, (T)root.data);
           }
        }
        return root;
    }

    // Find the least value below the right child of this root node.
    private T successor(Node root)
    {
        root = root.right;
        while(root.left != null)
        {
            root = root.left;
        }
        return (T)root.data;
    }
    // Find the greatest value below the left child of this root node.
    private T predecessor(Node root)
    {
        root = root.left;
        while(root.right != null)
        {
            root = root.right;
        }
        return (T)root.data;
    }
}
