package TreeDSA;

public class Tree {
    public static void main(String[] args) {

        // Tree - a non-linear data structure where nodes are organized in a hierarchy.
        //        Ex: family tree, file explorer, databases, DNS, html dOC.

        //-------------------------------- Tree Example--------------------------------------

        //                                (Root Node)
        //                               /           \
        //                              /             \
        //                       (Branch Node)     (Branch Node)
        //                        /      \           /      \
        //                       /        \         /        \
        //              (Leaf Node) (Leaf Node)  (LeafNode) (Leaf Node)
        //-----------------------------------------------------------------------------------


        // Terminology - 1. Node = A node is a basic unit of a data structure that contains some sort of
        //                         data plus some other form of reference like to another node.

        //               2. Edge = A edge is the link between two nodes. Edges define how nodes are related and how
        //                         data flows or connects within a structure.

        //               3. Root Node = The top node of a tree is known as the root node. Does not have any
        //                              incoming edges only outgoing edges.

        //               2. Leaf Node = Nodes at the bottom of the tree are known as leaf nodes. Does not have outgoing
        //                              edges only incoming edges.

        //               3. Branch Node = Nodes in the middle of a tree are known as branch nodes. They have both
        //                                outgoing and incoming edges.

        //               4. Parent = Nodes with outgoing edges are known as parent nodes.
        //                           Nodes can be both child and parent simultaneously

        //               5. Child = Nodes with incoming edges are known as child nodes.
        //                          Nodes can be both child and parent simultaneously

        //               6. Sibling = Nodes that share the same parent are known as sibling nodes

        //               7. Subtree = A subtree is a smaller tree held within a larger tree
        //                            Example:          A         B  - subtree of A
        //                                             / \       / \
        //                                            B   C     D   E
        //                                           / \   \
        //                                          D   E   F

        //               8. Size = The size of a tree is equal to the number of nodes in the tree.

        //               9. Depth = The depth of a tree is equal to the number of edges below the root node.

        //               10. Height = The height of a tree is the number of edges above the furthest leaf node.
    }
}

class Node <T extends Comparable<T>>
{
    T data;
    Node left;
    Node right;

    public Node(T data)
    {
        this.data = data;
    }

    public int CompareTo(T otherData)
    {
        return this.data.compareTo(otherData);
        // Returns  * -1 if this.data < otherData
        //          *  1 if this.data > otherData
        //          *  0  if this.data = otherData.
    }
}