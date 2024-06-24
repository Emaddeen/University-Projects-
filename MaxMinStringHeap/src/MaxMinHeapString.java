import java.util.Comparator;
import java.util.PriorityQueue;


class MinHeapsString {

    static PriorityQueue minHeapString = new PriorityQueue();

    public static void view() {
        for (Object x : minHeapString) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // using "add" operation to insert elements
        minHeapString.add("Jupiter");
        System.out.print("minHeap.add(Jupiter) = ");
        view();
        minHeapString.add("Saturn");
        minHeapString.add("Pluto");
        minHeapString.add("Earth");
        minHeapString.add("Venus");
        minHeapString.add("Mars");
        minHeapString.add("Neptune");
        minHeapString.add("Moon");
        minHeapString.add("Mercury");
        minHeapString.add("Ceres");
        minHeapString.add("Europa");


        // printing Min-Heap
        System.out.print("minHeap.view() = ");
        view();

        // using "peek" method to view the head
        System.out.println("minHeap.peek() = " + minHeapString.peek());

        // using "poll" method to remove and retrieve the head
        minHeapString.poll();
        System.out.print("minHeap.poll() = ");
        view();

        // using "remove" method to remove specified element
        minHeapString.remove("Europa");
        System.out.print("minHeap.remove(Europa) = ");
        view();

        // Check if an element is present using contains()
        boolean elementFound = minHeapString.contains("IO");
        System.out.println("minHeap.contains(IO) = " + elementFound);
        elementFound = minHeapString.contains("Earth");
        System.out.println("minHeap.contains(Earth) = " + elementFound);
    }
}

class MaxHeapsString{
    static PriorityQueue<String> maxHeapString = new PriorityQueue<String>(new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return b.compareTo(a);
        }
    });
    public static void main(String args[]) {
        // using "add" operation to insert elements
        maxHeapString.add("Jupiter");
        System.out.print("minHeap.add(Jupiter) = ");
        view();
        maxHeapString.add("Saturn");
        maxHeapString.add("Pluto");
        maxHeapString.add("Earth");
        maxHeapString.add("Venus");
        maxHeapString.add("Mars");
        maxHeapString.add("Neptune");
        maxHeapString.add("Moon");
        maxHeapString.add("Mercury");
        maxHeapString.add("Ceres");
        maxHeapString.add("Europa");


        // printing Min-Heap
        System.out.print("maxHeap.view() = ");
        view();

        // using "peek" method to view the head
        System.out.println("minHeap.peek() = " + args.peek());

        // using "poll" method to remove and retrieve the head
        args.poll();
        System.out.print("minHeap.poll() = ");
        view();

        // using "remove" method to remove specified element
        args.remove("Europa");
        System.out.print("minHeapString.remove(Europa) = ");
        view();

        // Check if an element is present using contains()
        boolean elementFound = args.contains("IO");
        System.out.println("minHeap.contains(IO) = " + elementFound);
        elementFound = args.contains("Earth");
        System.out.println("minHeap.contains(Earth) = " + elementFound);
    }
}
