import java.util.LinkedList;

public class LinkedListDSA {
    public static void main(String[] args) {
        // LinkedList - Stores Nodes in 2 parts (data + address pointing to next data).
        //              Nodes are in non-consecutive memory location (better memory usage bc doesn't store chunks in
        //              one spot).
        //              Elements are linked using pointers

        // Types of LinkedList:
        //                         Single Linked List
        //           Node                 Node                 Node
        //      [data | address] ->  [data | address] ->  [data | address]

        //                                         Double Linked List
        //                 Node                           Node                           Node
        //      [address | data | address]  <->  [address | data | address]  <-> [address | data | address]

        // Advantages:
        // 1) Dynamic Data Structure (allocates needed memory while running)
        // 2) Insertion and Deletion of Nodes is easy O(1).
        // 3) No/low memory waste

        // Disadvantages:
        // 1) Greater memory usage (additional pointers).
        // 2) No random access of elements (no index [i]).
        // 3) Accessing/searching elements is more time-consuming O(n).

        // Uses:
        // 1) implement Stacks/Queues.
        // 2) GPS navigation
        // 3) music playList.


        // Using Given LinkedList data Structure.
        LinkedList<String> linkedList = new LinkedList<>();

        // LinkedList as a Stack
        System.out.println("LinkedList as a Stack: ");
        linkedList.push("A");
        linkedList.push("B");
        linkedList.push("C");
        linkedList.push("D");
        linkedList.push("F");
        System.out.println("linkedList.push(): " + linkedList);
        linkedList.pop(); // Removes last element ("F") since stack
        System.out.println("linkedList.pop(): " + linkedList);

        // LinkedList as a Queue
        LinkedList<String> linkedList2 = new LinkedList<>();
        System.out.println("\nLinkedList as a Queue:");
        linkedList2.offer("A");
        linkedList2.offer("B");
        linkedList2.offer("C");
        linkedList2.offer("D");
        linkedList2.offer("F");
        System.out.println("linkedList.offer(): " + linkedList2);
        linkedList2.poll(); // Removes first element ("A") since queue
        System.out.println("linkedList.poll(): " + linkedList2);

        // Inserting and deleting elements in linkedList.
        System.out.println("\nInserting and deleting elements in linkedList.");
        linkedList2.add(0, "A"); // inserts the "A" string back in front of the linkedList
        System.out.println("linkedList2.add(0, \"A\"): " + linkedList2);
        linkedList2.remove("F"); // Removes the "F" string from the linkedList.
        System.out.println("linkedList2.remove(\"F\"): " + linkedList2);

        // Searching for elements in linkedList.
        System.out.println("\nSearching for elements in linkedList.");
        System.out.println("linkedList2.indexOf(\"C\"): " + linkedList2.indexOf("C")); // Prints the index of the string "C" in the linkedList

        // Important Methods.
        System.out.println("\nImportant Methods.");
        System.out.println("Current linkedList2: " + linkedList2);
        System.out.println("linkedList2.peekFirst(): " + linkedList2.peekFirst()); // Checks first element in linkedList
        System.out.println("linkedList2.peekLast(): " + linkedList2.peekLast()); // Checks last element in linkedList
        linkedList2.addFirst("0"); // Adds "0" into the first element of linkedList.
        System.out.println("linkedList2.addFirst(\"0\"): " + linkedList2);
        linkedList2.addLast("F"); // Add "0" into the last element of linkedList
        System.out.println("linkedList2.addLast(\"F\"): " + linkedList2);

        // Storing elements into a variable
        String first = linkedList2.removeFirst();// Remove first element from linkedList and stores into String variable
        String last = linkedList2.removeLast();// Remove last element from linkedList and stores into String variable

// ------------------------------------------------------------------------------------------------------------------------------//


        // Implemented LinkedList: HeadNode =  the first Node in the linkedList.
        //                         Node with null = the last Node in the linkedList.
        System.out.println("\nImplemented LinkedList");

        NodeIMP myNode = new NodeIMP(1);
        myNode.next = new NodeIMP(2);

        LinkedListIMP myLinkedList = new LinkedListIMP(myNode);
        System.out.println("myLinkedList: " + myLinkedList);

        myLinkedList.addToEnd(3);
        System.out.println("myLinkedList.add(3): " + myLinkedList);

        System.out.println("myLinkedList.search(2): " + myLinkedList.search(2));
        System.out.println("myLinkedList.search(3): " + myLinkedList.search(3));

        System.out.println("myLinkedList.size(): " + myLinkedList.size());

        myLinkedList.insert(0, 0);
        System.out.println("myLinkedList.insert(0, 0): " + myLinkedList);

        myLinkedList.remove(3);
        System.out.println("myLinkedList.remove(3): " + myLinkedList);

        myLinkedList.addToStart(0);
        System.out.println("myLinkedList.addToStart(0): " + myLinkedList);

        myLinkedList.removeAtEnd();
        System.out.println("myLinkedList.removeAtEnd(): " + myLinkedList);


        // Empty LinkedList Practice
        System.out.println("\nEmpty LinkedList Practice");
        LinkedListIMP emptyLinkedList = new LinkedListIMP();
        System.out.println("emptyLinkedList: " + emptyLinkedList);

        emptyLinkedList.addToEnd(1);
        System.out.println("emptyLinkedList.add(1): " + emptyLinkedList);
        emptyLinkedList.addToEnd(2);
        System.out.println("emptyLinkedList.add(2): " + emptyLinkedList);
    }
}

// Implementation of LinkedList
class LinkedListIMP {
    NodeIMP head;
    int size = size();

    public LinkedListIMP()
    {
        this.head = null;
        this.size = 0;
    }
    public LinkedListIMP(NodeIMP head)
    {
        this.head = head;
        this.size = 1;
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void addToEnd(int data)
    {
        // Create new Node with the data that needs to be added.
        NodeIMP newNode = new NodeIMP(data);

        // Check if the linkedList is empty by checking it head is null
        if(head == null)
        {
            head = newNode; // If linkedList is empty make the new Node the head.
        }
        else {
            // Create a current reference node to keep track of the current node while iterating the linkedList
            NodeIMP current = head;

            // Iterate through the linkedList until the Node after current is null. This means were at the last Node.
            while (current.next != null) {
                current = current.next; // If not at last node iterate to the next node.
                }
            current.next = newNode; // Once were at the last node make the node after become the new Node.
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void addToStart(int data)
    {
        NodeIMP newNode = new NodeIMP(data); // New node needed to be added.
        newNode.next = head; // Make the NewNodes.next be the head.
        head = newNode; // Update so that the NewNode becomes the head.
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void insert(int data, int index)
    {
        // If index is out of bounds of the size of the linkedList it throws out of bounds error.
        if(index >= size() | index < 0)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }

        NodeIMP newNode = new NodeIMP(data); // New node needed to be added.

        int currentIndex = 1; // Since 0 has its own case we start at index 1, and our current will be one index behind
        NodeIMP current = head;
        while(current != null)
        {
            if(index == 0)
            {
                newNode.next = head;
                head = newNode; // If index is 0 we place the newNode at the head.
                break;
            }

            if(currentIndex == index)
            {
                // If current indexes matches up our current will be behind the index, so we set the newNode's next
                // to the current.next since our current is behind the index.
                newNode.next = current.next;
                current.next = newNode; // Set the current.next equal to the newNode.
                break;
            }
            else {
                current = current.next; // Iterate through the linkedList.
                currentIndex++; // Update currentValue
            }
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void remove(int data)
    {
        NodeIMP current = head; // Create currentNode reference node
        while(current != null)
        {
            if(head.data == data)
            {
                head = current.next; // If data to remove is the head make head the node after head.
                break;
            }

            if(current.next.data == data)
            {
                current.next = current.next.next; // If data to remove is the node after current make
                                                  // current node point to the node after the node to remove.
                                                  // If its null the current.next will point to null.
                break;
            }
            current = current.next; // Iterate through the linkedList.
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void removeAtEnd()
    {
        NodeIMP current = head;

        // Check if the linkedList is null.
        if(current == null || current.next == null)
        {
            head = null;
        }

        // Keeps track of the Node after Current Node.
        NodeIMP nextNode = current.next;
        while (current.next != null)
        {
            if(nextNode.next == null)
            {
                current.next = null; // If the Node after nextNode which is after current Node is null which is the last Node.
                                     // we assign the node before the last node to point to null removing the last node
                                    // from the linkedList.
                break;
            }
            current = nextNode; // If nextNode.next is not null iterate through the linkedList by assigning current node to the NextNode
            nextNode = nextNode.next; // and the NextNode to the nextNode.next.
        }
    }

    // Time Complexity: O(n)
    // Space complexity: O(1)
    public int search(int data)
    {
        int index = 0;
        NodeIMP current = head;
        while(current != null)
        {
            if(current.data == data)
                return index;
            else
            {
                current = current.next;
                index++;

            }
        }
        return index;
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int size(){
        NodeIMP current = head;
        int size = 0;
        while(current != null)
        {
            size++;
            current = current.next;
        }
        return size;
    }

    // Time Complexity: O(n)
    // Space complexity: O(1)
    public String toString()
    {
        NodeIMP current = head;
        String linkedList = "";
        while(current != null)
        {
            linkedList += current.data + ",";
            current = current.next;
        }
        if(linkedList != "") {
            linkedList = "[" + linkedList.substring(0, linkedList.length() - 1) + "]";
        }
        else
        {
            linkedList = "[]";
        }
        return linkedList;
    }
}

class NodeIMP {
    int data;
    NodeIMP next;
    public NodeIMP(int data)
    {
        this.data = data;
        this.next = null;
    }
    public NodeIMP(int data, NodeIMP next)
    {
        this.data = data;
        this.next = next;
    }
}


