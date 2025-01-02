public class VectorDSA {
    public static void main(String[] args)
    {
        // Vector - the vector data structure is an older linear data structure that works exactly like an arrayList.
        //          The vector data structure was introduced before the arrayList and has since been replaced when the
        //          arrayList was introduced.

        // The arrayList data structure has better and faster operations than the vector data structure.

        // The vector data structure has thread safety, meaning that when running multiple threads the vector data
        // structure will not run into issue. Unlike the vector data structure, arrayList are not thread safety
        // and will run into issues while running multiple threads. However, arrayList could be made thread safety
        // by initializing the arrayList like this:

        // List<dataType> arrayList = Collection.synchronizedList(new ArrayList());

        // This creates a wrapper around your arrayList making all multithreaded operations on the arrayList be
        // synchronized just like a vector would.

        // In conclusion the vector data structure is an outdated data structure that has been replaced by the arrayList
        // and if you ever need to choose between vectors or arrayLists pick arrayLists since they
        // are faster in a single thread environment. And if you ever need to used multithreading, you should still
        // stick to the arrayList but use the synchronized method. arrayList > vector.

    }
}
