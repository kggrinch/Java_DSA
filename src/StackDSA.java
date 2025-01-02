import java.util.Scanner;
import java.util.Stack;

public class StackDSA {
    public static void main(String[] args)
    {
        // Stack = LIFO data structure. Last-In First-Out
        //         store objects into a sort of vertical tower
        //         where push() is to add to the top
        //         and pop() is to remove from the top.

        // Uses of Stacks
        // 1. Undo/redo features in text editors
        // 2. Moving back/forward through browser history
        // 3. Backtracking algorithms (maze, file directories)
        // 4. Calling functions (call stack)

        // Space complexity: O(n)
        // Time complexity: peek() = O(1)
        //                  pop() = O(1)
        //                  push() = O(1)
        //                  push() implemented with fixed array = O(n) - worst case


        Stack<Integer> stack = new Stack<>();

        System.out.println("After creating stack: " + stack.empty()); // Checks if the stack is empty. Returns boolean

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("After pushing elements into stack: " + stack.empty()); // Checks if the stack is empty.
        System.out.println("Printing stack: " + stack);

        stack.pop(); // Removes top most object from stack
        System.out.println("After pop(): " + stack);
        stack.push(5);

        int elementAtTop = stack.pop(); // Removes top most object and assigns it to a variable
        System.out.println("element at top: " + elementAtTop);
        stack.push(5);

        System.out.println("After peak(): " + stack.peek()); // Returns the object at the top of stack without removing.

        System.out.println("Position of element 2 in the stack: " + stack.search(2)); // Returns position of element
        System.out.println("Position of element 10 in the stack: " + stack.search(10)); // Returns -1 since element DNE

        // Stack can run out of memory if too much data is added.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press x to overflow the stack or press any other key to skip");
        String userInput = scanner.nextLine();
        if(userInput.equals("x"))
        {
            // Pushes 1000000000 integers into the stack to overflow it.
            for(int i = 6; i < 1000000000; i++)
            {
                stack.push(i);
            }
        }




    }
}
