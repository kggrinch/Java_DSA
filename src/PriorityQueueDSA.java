import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDSA {
    public static void main(String[] args)
    {
        // Priority Queue - A FIFO data structure that serves elements with the highest priority first before
        //                  elements with lower priority.


        // Priority queue with gpa priority that prints from lowest to highest grade fist.
        Queue<Double> gpaQueue = new PriorityQueue<>();
        gpaQueue.offer(3.0);
        gpaQueue.offer(2.5);
        gpaQueue.offer(4.0);
        gpaQueue.offer(1.5);
        gpaQueue.offer(2.0);
        System.out.println("Priority Queue with lowest grade priority: ");
        while(!gpaQueue.isEmpty())
        {
            System.out.println(gpaQueue.poll());
        }


        // Priority queue with gpa priority continued.
        // If you want to print highest to the lowest grade then you have to add Collections.reverseOrder() method in
        // the constructor

        Queue<Double> gpaQueue2 = new PriorityQueue<>(Collections.reverseOrder());
        gpaQueue2.offer(3.0);
        gpaQueue2.offer(2.5);
        gpaQueue2.offer(4.0);
        gpaQueue2.offer(1.5);
        gpaQueue2.offer(2.0);
        System.out.println("\nPriority Queue with highest grade priority: ");
        while(!gpaQueue2.isEmpty())
        {
            System.out.println(gpaQueue2.poll());
        }

        // Priority Queue with letter Grade and highest grade priority
        Queue<String> letterGrade = new PriorityQueue<>();
        letterGrade.offer("C");
        letterGrade.offer("A");
        letterGrade.offer("F");
        letterGrade.offer("B");
        letterGrade.offer("D");
        System.out.println("\nPriority Queue with highest letter grade priority");
        while(!letterGrade.isEmpty())
        {
            System.out.println(letterGrade.poll());
        }

        // Priority Queue with letter grade and lowest grade priority
        Queue<String> letterGrade2 = new PriorityQueue<>(Collections.reverseOrder());
        letterGrade2.offer("C");
        letterGrade2.offer("A");
        letterGrade2.offer("F");
        letterGrade2.offer("B");
        letterGrade2.offer("D");
        System.out.println("\nPriority Queue with lowest letter grade priority");
        while(!letterGrade2.isEmpty())
        {
            System.out.println(letterGrade2.poll());
        }
    }
}
