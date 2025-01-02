public class NodeDSA {
    public static void main(String[] args)
    {
        // Initializing and connecting Nodes manually
        // This creates nodes with given values, but they are not connected.
        Node nodeA = new Node(6);
        Node nodeB = new Node(3);
        Node nodeC = new Node(4);
        Node nodeD = new Node(2);
        Node nodeE = new Node(1);

        // To connect the nodes we can write:
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        System.out.println("NodeCount: " + Node.countNodes(nodeA));

        // Node-Based Data Structures.
        Node x = new Node(2, null); // This would be the node after y.
        Node y = new Node(1, x); // This would be considered the head. It is kind of in a reversed order.
        System.out.println("y.getData(): " + y.getData());
        System.out.println("y.getNext().getData(): " + y.getNext().getData());
    }
}

// Singly
class Node{
    int data;
    Node next;
//    Node prev; // This will make the Node doubly (going in both directions)
    public Node(int data)
    {
        this.data = data;
    }
    public Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public int getData()
    {
        return data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    // Algorithm to calculate the amount of nodes in the linkedList.
    // Given the head of a linkedList figure out how many Nodes are in the linkedList.
    static int countNodes(Node head)
    {
        int nodeCount = 0;
        Node current = head;
        while(current!=null)
        {
            nodeCount++;
            current = current.next;
        }
        return nodeCount;
    }
}