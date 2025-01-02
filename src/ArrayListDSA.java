import java.util.ArrayList;
public class ArrayListDSA {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(4);
        arrayList.add(10);
        arrayList.remove(9);

        // Sorting Algorithms
        System.out.println("Sorting Algorithms");
        System.out.println("Unsorted: " + arrayList.toString());

        selectionSort(arrayList);
        System.out.println("Selection Sort: " + arrayList.toString());

        insertionSort(arrayList);
        System.out.println("Insertion Sort: " + arrayList.toString());

        bubbleSort(arrayList);
        System.out.println("Bubble Sort: " + arrayList.toString());

        mergeSort(arrayList);
        System.out.println("Merge Sort: " + arrayList.toString());

        quickSort(arrayList, 0, arrayList.size()-1);
        System.out.println("Quick Sort: " + arrayList.toString());





        // Searching Algorithms
        System.out.println("\nSearching Algorithms");
        int target = 2;
        int index = binarySearch(arrayList, target);
        System.out.println("binarySearch(arrayList, target): " + index);

        int indexL = linearSearch(arrayList, target);
        System.out.println("linearSearch(arrayList, target): " + indexL);





        // Implemented ArrayList
        System.out.println("\nImplemented ArrayList: ");


        ArrayListImplementation arrayListImplemented = new ArrayListImplementation();
        System.out.println("arrayList: " + arrayListImplemented);
        System.out.println("isEmpty(): " + arrayListImplemented.isEmpty());
        arrayListImplemented.add("A");
        arrayListImplemented.add("B");
        arrayListImplemented.add("C");
        System.out.println("arrayList after adding A, B, C: " + arrayListImplemented);
        System.out.println("isEmpty(): " + arrayListImplemented.isEmpty());
        System.out.println("Size: " + arrayListImplemented.size);
        System.out.println("Capacity: " + arrayListImplemented.capacity);
        arrayListImplemented.insert(0, "X");
        System.out.println("arrayList after .insert(0, \"X\"): " + arrayListImplemented);
        System.out.println("Size: " + arrayListImplemented.size);
        arrayListImplemented.remove("X");
        System.out.println(".remove(\"X\"): " + arrayListImplemented);
        System.out.println(".indexOf(\"B\"): " + arrayListImplemented.indexOf("B"));

        arrayListImplemented.add("D");
        arrayListImplemented.add("E");
        arrayListImplemented.add("F");
        System.out.println("Testing grow(): " + arrayListImplemented);

        arrayListImplemented.remove("F");
        arrayListImplemented.remove("E");
        arrayListImplemented.remove("D");
        System.out.println("Testing shrink(): " + arrayListImplemented); // Usually null values would not be seen
        // refer to toString() method.

        arrayListImplemented.insert(2, "F");
        System.out.println(arrayListImplemented);









    }

    /** Sorting Algorithms */

    // [Insertion Sort]
    // Run Time: Quadratic time O(n^2)
    // Space Time: O(1) Constant space
    // Small data set = decent
    // Large data set = bad
    // selectionSort < insertionSort
    public static void insertionSort(ArrayList<Integer> arrayList)
    {
        for(int i = 1; i < arrayList.size(); i++)
        {
            int temp = arrayList.get(i);
            int j = i-1;
            while(j >= 0 && arrayList.get(j) > temp)
            {
                arrayList.set(j+1, arrayList.get(j));
                j--;
            }
            arrayList.set(j+1, temp);
        }
    }

    // [Selection Sort]
    // Run Time: Quadratic time O(n^2)
    // Space Time: O(1) Constant space
    // Small data set = decent
    // large data set = bad
    // bubbleSort < selectionSort < insertionSort
    public static void selectionSort(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(min) > arrayList.get(j)) {
                    min = j;
                }
            }
            int temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(min));
            arrayList.set(min, temp);
        }
    }

    // [Bubble Sort]
    // Run Time: Quadratic time O(n^2)
    // Space Time: O(1) Constant space
    // Small data set = decent
    // Large data set = bad
    // bubbleSort < selectionSort
    public static void bubbleSort(ArrayList<Integer> arrayList)
    {
        for(int i = 0; i < arrayList.size()-1; i++)
        {
            for(int j = 0; j < arrayList.size()-i-1; j++)
            {
                if(arrayList.get(j) > arrayList.get(j+1))
                {
                    int temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j+1));
                    arrayList.set(j+1, temp);
                }
            }
        }
    }

    // [Merge Sort]
    // Run Time: O(n log n) Quasilinear time
    // Space Time: O(n) Linear space
    // Small data set =
    // Large data set = good
    public static void mergeSort(ArrayList<Integer> arrayList)
    {
        int length = arrayList.size();
        if(length <= 1) // Base case
            return;

        int middle = length / 2;
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();

        for(int i = 0; i<length; i++)
        {
            if(i < middle)
            {
                leftArray.add(arrayList.get(i));
            }
            else
            {
                rightArray.add(arrayList.get(i));
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, arrayList);
    }
    public static void merge(ArrayList<Integer> leftArray, ArrayList<Integer> rightArray, ArrayList<Integer> arrayList)
    {
        int leftSize = arrayList.size() / 2;
        int rightSize = arrayList.size() - leftSize;
        int i = 0, l = 0, r = 0;

        // Check conditions for merging
        while(l < leftSize && r < rightSize)
        {
            if(leftArray.get(l) < rightArray.get(r))
            {
                arrayList.set(i, leftArray.get(l));
                i++;
                l++;
            }
            else
            {
                arrayList.set(i, rightArray.get(r));
                i++;
                r++;
            }
        }
        while (l < leftSize)
        {
            arrayList.set(i, leftArray.get(l));
            i++;
            l++;
        }
        while(r < rightSize)
        {
            arrayList.set(i, rightArray.get(r));
            i++;
            r++;
        }
    }

    // [Quick Sort]
    // Run Time = Best case:    O(n log(n))
    //            Average case: O(n log(n))
    //            Worst case:   O(n^2)
    // Space Time = O(log(n))
    // Small data set =
    // Large data set =
    public static void quickSort(ArrayList<Integer> arrayList, int start, int end)
    {
        // Base case
        if(end <= start)
            return;
        int pivot = partition(arrayList, start, end);
        quickSort(arrayList, start, pivot-1);
        quickSort(arrayList, pivot+1, end);
    }
    public static int partition(ArrayList<Integer> arrayList, int start, int end)
    {
        int pivot = arrayList.get(end);
        int i = start - 1;
        for(int j = start; j <= end; j++)
        {
            if(arrayList.get(j) < pivot)
            {
                i++;
                int temp = arrayList.get(i);
                arrayList.set(i, arrayList.get(j));
                arrayList.set(j, temp);
            }
        }
        i++;
        int temp = arrayList.get(i);
        arrayList.set(i, arrayList.get(end));
        arrayList.set(end, temp);

        return i;
    }

    // [Heap Sort]
    // Run Time = Best case:    O(n log(n))
    //            Average case: O(n log(n))
    //            Worst case:   O(n log(n))
    // Space Time = O(1)
    // Small data set = good
    // Large data set = good
    // Disadvantage - More code to implement since you need to implement the heap binary tree.


    /** Searching Algorithms */

    // Linear Search | Time Complexity: O(n)
    public static int linearSearch(ArrayList<Integer> array, Integer target)
    {
        for(Integer i : array)
        {
            if (i.equals(target))
                return i-1; // -1 due to it being an arrayList and first index being 0.
        }
        return -1;
    }

    // Binary Search | Time Complexity: O(logn)
    public static int binarySearch(ArrayList<Integer> array, Integer target)
    {
        Integer low = 0;
        Integer high = array.size();
        while(low <= high)
        {
            Integer mid = low + (high - low)/2;
            array.get(mid);
            Integer midValue = array.get(mid);
            if(midValue < target)
                low = midValue+1;
            else if(midValue > target)
                high = midValue-1;
            else
                return midValue-1;
        }
        return -1;
    }





}

/** ArrayList Implementation */
class ArrayListImplementation {
    int capacity = 5;
    int size;
    Object[] array;

    public ArrayListImplementation()
    {
        this.array = new Object[capacity];
    }
    public ArrayListImplementation(int capacity)
    {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    // Time Complexity: O(1).
    public void add(Object data)
    {
        if(size >= capacity)
        {
            grow();
        }
        array[size] = data;
        size++;
    }

    // Time Complexity: O(n)
    public void insert(int index, Object data)
    {
        if(size >= capacity)
        {
            grow();
        }
        for(int i = size; i > index; i--)
        {
            array[i] = array[i-1];
        }
        array[index] = data;
        size++;
    }

    // Time Complexity: O(n)
    public void remove(Object data)
    {
        for(int i = 0; i < size; i++)
        {
            if(array[i] == data)
            {
                for(int j = 0; j < (size-i-1); j++) // The i is used to work with the index that
                                                    // is found when array[i] = data
                {
                    array[i + j] = array[i + j + 1];
                }
                array[size - 1] = null;
                size--;
                if(size <= capacity/3) {
                    shrink();
                }
                break;
            }
        }
    }

    // Time Complexity: O(n)
    public int indexOf(Object data)
    {
        for(int i = 0; i < size; i++)
        {
            if(array[i] == data)
            {
                return i;
            }
        }
        return -1;
    }

    // Time Complexity: O(n)
    private void grow()
    {
        int newCapacity = capacity*2;
        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    // Time Complexity: O(n)
    private void shrink()
    {
        int newCapacity = capacity/2;
        Object[] newArray = new Object[newCapacity];
        for(int i = 0; i < size; i++)
        {
            newArray[i] = array[i];
        }
        capacity = newCapacity;
        array = newArray;
    }

    // Time Complexity: O(1)
    public boolean isEmpty()
    {
        return size == 0;
    }

    // Time Complexity: O(n)
    public String toString()
    {
        String arrayString = "";
        for(int i = 0; i < capacity; i++) // If you put i<size will only show all the elements in array. If you put
//                                      i<capacity it will show all the elements plus the empty space in array.
        {
            arrayString += array[i] + ",";
        }
        if(arrayString != "")
        {
            arrayString = "[" + arrayString.substring(0, arrayString.length() - 1) + "]";
        }
        else
        {
            arrayString = "[]";
        }
        return arrayString;
    }
}
