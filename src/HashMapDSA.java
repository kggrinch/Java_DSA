import java.util.HashMap;

public class HashMapDSA {
    public static void main(String[] args)
    {
        // HashMap = HashMap is similar to ArrayList, but with key-value pairs.
        //           Stores objects, need to use wrapper class.
        //           HashMap implements the Map interface (need import)
        // Examples = (name, email), (userName, userID), (country, capital), (name, numberID)

        HashMap<Integer, String> clients = new HashMap();

        clients.put(1, "Jeff");
        clients.put(2, "Bob");
        clients.put(3, "Jerry");
        clients.put(4, "Larry");
        clients.put(5, "Clyde");
        System.out.println("clients: " + clients); // Prints HashMap default format.

        System.out.println("clients.get(3): " + clients.get(3)); // Returns the value in the given key.
        System.out.println("clients.size(): " + clients.size());

        clients.replace(1, "Josh"); // Replaces the value in the given key.
        System.out.println("After calling clients.replace(1, \"Josh\"): " + clients);

        System.out.println("clients.containsKey(6): " + clients.containsKey(6)); // Checks if hashmap contains key 6.
        // Checks if hashmap contains value "Clyde".
        System.out.println("clients.containsValue(\"Clyde\"): " + clients.containsValue("Clyde"));

        // A decent way of printing the whole hashMap.
        System.out.println("\nDisplaying hashMap in cleaner format: ");
        for(Integer i : clients.keySet())
        {
            // Formatting used to make it cleaner, but the main is i.
            System.out.print(i + "\t"+"= ");
            System.out.println(clients.get(i));
        }

      clients.remove(1); // Removes the element in the at the given key. Also removes element
      System.out.println("clients after calling clients.remove(1): " + clients);
      clients.clear(); // Clears the HashMap so its empty.
      System.out.println("clients after calling clients.clear(): " + clients);
    }
}
