import java.util.Queue;
import java.util.LinkedList;
public class QueueDSA {
    public static void main(String[] args)
    {
        // Queue = FIFO data structure. First-In First-Out (ex. a line of people)
        //         A collection designed for holding elements prior to processing.
        //         Linear data structure.

        // Add    = enqueue - offer();
        // remove = dequeue - poll();
        // Check  = examine - peak();

        // Uses of Queues:
        // 1. Keyboard Buffer (letters should appear on the screen in the order they're pressed)
        // 2. Printer Queue (Print jobs should be completed in order)
        // 3. Any sort of line structure (Line at a store or line to check in somewhere)
        // 4. Used in LinkedLists, PriorityQueues, Breadth-first search.

        // Queue using LinkedList
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1); // add 1 to queue
        queue.offer(2); // add 2 to queue
        queue.offer(3); // add 3 to queue
        queue.offer(4); // add 4 to queue

        System.out.println("queue.peak(): " + queue.peek()); // print head of queue
        System.out.println("queue: " + queue); // print queue

        queue.poll(); // remove 1 from queue
        queue.poll(); // remove 2 from queue
        System.out.println("queue after calling poll twice: " + queue); // print queue

        queue.poll(); // remove 3 from queue
        queue.poll(); // remove 4 from queue
        System.out.println("queue after calling poll twice again: " + queue); // print queue - prints []

        // checks head of queue without exception. - Better method
        System.out.println("queue.peak() while queue is empty: " + queue.peek());
//        System.out.println(queue.element()); // checks head fo queue but throws exception since empty. - not as good

        System.out.println("queue.isEmpty(): " + queue.isEmpty()); // checks if queue is empty
        queue.offer(1); // add 1 to queue
        System.out.println("queue.isEmpty() after adding 1 to queue: " + queue.isEmpty()); // checks if queue is empty

        System.out.println("queue.size() " + queue.size()); // Returns size of queue.

        System.out.println("\nqueue: " + queue); // Prints queue
        System.out.println("queue.contains(0): " + queue.contains(0)); // Checks if queue contains 0.
        System.out.println("queue.contains(1): " + queue.contains(1)); // Checks if queue contains 1.




    }
}
