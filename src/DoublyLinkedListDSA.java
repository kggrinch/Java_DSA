import java.util.NoSuchElementException;

public class DoublyLinkedListDSA {
    public static void main(String[] args) {
        // doubly linkedList - Similar to a singly linkedList, a double linkedList also contains a list of objects
        //                     called nodes.
        //
        //                     Each node contains a data and two reference variables. One reference variable refers
        //                     to the next node in the list. The other refers to the previous node in the list.

        //                                         Double Linked List
        //                 Node                           Node                           Node
        //      [address | data | address]  <->  [address | data | address]  <-> [address | data | address]

        doublyLinkedList<Integer> linkedList = new doublyLinkedList<>();
        linkedList.addToEnd(1);
        linkedList.addToEnd(2);
        linkedList.addToEnd(3);
        System.out.println("linkedList: " + linkedList);
        System.out.println("linkedList.size: " + linkedList.size);

        linkedList.addToStart(0);
        System.out.println("linkedList.addToStart(0): " + linkedList);

        linkedList.insert(4, 4);
        System.out.println("linkedList.insert(5, 3): " + linkedList);

        linkedList.deleteAtEnd();
        System.out.println("linkedList.deleteAtEnd(): " + linkedList);

        linkedList.deleteAtStart();
        System.out.println("linkedList.deleteAtStart(): " + linkedList);

        linkedList.delete(1);
        System.out.println("linkedList.delete(3): " + linkedList);
    }
}


// Doubly LinkedList Implemented
class doublyLinkedList<T>
{
    doublyNode head;
    int size;

    public doublyLinkedList()
    {
        this.head = null;
        this.size = 0;
    }
    public doublyLinkedList(doublyNode head)
    {
        this.head = head;
        this.size = 1;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void addToEnd(T data)
    {
        doublyNode newNode = new doublyNode(data);
        if (head == null)
        {
            head = newNode;
            size++;
        }
        else
        {
            doublyNode current = head;
            while(current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
            size++;
        }
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void addToStart(T data)
    {
        doublyNode newNode = new doublyNode<>(data);
        if (head == null)
        {
            head = newNode;
            size++;
        }
        else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void insert(T data, int index)
    {
        if(index < 0 | index > size + 1)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");

        doublyNode newNode = new doublyNode<>(data);
        int currentIndex = 1;
        if (index == 0)
        {
            addToStart(data);
        }
        else if(index == size)
        {
            addToEnd(data);
        }
        else {
            doublyNode current = head;
            while (current != null) {
                if (index == currentIndex) {
                    newNode.next = current.next;
                    current.next.prev = newNode;

                    newNode.prev = current;
                    current.next = newNode;
                    size++;
                }
                current = current.next;
                currentIndex++;
            }
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void deleteAtEnd()
    {
        doublyNode current = head;
        if(current == null || current.next == null)
        {
            head = null;
        }
        while(current != null)
        {
            if(current.next == null)
            {
                current.prev.next = null;
                size--;
                break;
            }
            current = current.next;
        }
    }

    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void deleteAtStart()
    {
        doublyNode current = head;
        if(current == null || current.next == null)
        {
            head = null;
        }
        else
        {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public void delete(T data)
    {
        doublyNode current = head;
        if(head == null || head.next == null)
        {
            head = null;
        }

        while(current != null)
        {
            if(current.data == data) {
                if (current.next == null) {
                    deleteAtEnd();
                    break;
                }
                else if(current.prev == null)
                {
                    deleteAtStart();
                    break;
                }
                else
                {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    size--;
                    break;
                }
            }
            else
            {
                current = current.next;
            }
        }
    }

    public int getSize()
    {
        doublyNode current = head;
        int currentSize = 0;
        while(current != null)
        {
            currentSize++;
            current = current.next;
        }
        return currentSize;
    }

    public String toString()
    {
        String linkedList = "";
        doublyNode current = head;
        while(current != null)
        {
            linkedList += current.data + ",";
            current = current.next;
        }
        if(linkedList != "")
        {
            linkedList = "[" + linkedList.substring(0, linkedList.length() - 1) + "]";
        }
        else
        {
            linkedList = "[]";
        }
        return linkedList;
    }
}



class doublyNode<T>
{
    T data;
    doublyNode next;
    doublyNode prev;

    doublyNode(T data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    doublyNode(T data, doublyNode next, doublyNode prev)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}