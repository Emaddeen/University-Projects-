import java.util.Comparator;
import java.util.PriorityQueue;

class MinHeaps {

    static PriorityQueue minHeap = new PriorityQueue();

    public static void view() {
        for (Object x : minHeap) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // using "add" operation to insert elements
        minHeap.add(29);
        System.out.print("minHeap.add(3) = ");
        view();
        minHeap.add(13);
        minHeap.add(7);
        minHeap.add(16);
        minHeap.add(21);
        minHeap.add(12);
        minHeap.add(9);
        minHeap.add(56);
        minHeap.add(67);
        minHeap.add(77);
        minHeap.add(31);


        // printing Min-Heap
        System.out.print("minHeap.view() = ");
        view();

        // using "peek" method to view the head
        System.out.println("minHeap.peek() = " + minHeap.peek());

        // using "poll" method to remove and retrieve the head
        minHeap.poll();
        System.out.print("minHeap.poll() = ");
        view();

        // using "remove" method to remove specified element
        minHeap.remove(31);
        System.out.print("minHeap.remove(7) = ");
        view();

        // Check if an element is present using contains()
        boolean elementFound = minHeap.contains(11);
        System.out.println("minHeap.contains(11) = " + elementFound);
        elementFound = minHeap.contains(16);
        System.out.println("minHeap.contains(16) = " + elementFound);
    }
}

     class MaxHeaps {

        public static void main(String args[]) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            // using "add" operation to insert elements
            maxHeap.add(29);
            System.out.print("maxHeap.add(3) = ");
            view();
            maxHeap.add(13);
            maxHeap.add(7);
            maxHeap.add(16);
            maxHeap.add(21);
            maxHeap.add(12);
            maxHeap.add(9);
            maxHeap.add(56);
            maxHeap.add(67);
            maxHeap.add(31);


            // printing Max-Heap
            System.out.print("maxHeap.view() = ");
            view();

            // using "peek" method to view the head
            System.out.println("maxHeap.peek() = " + maxHeap.peek());

            // using "poll" method to remove and retrieve the head
            maxHeap.poll();
            System.out.print("maxHeap.poll() = ");
            view();

            // using "remove" method to remove specified element
            maxHeap.remove(31);
            System.out.print("maxHeap.remove(7) = ");
            view();

            // Check if an element is present using contains()
            boolean elementFound = maxHeap.contains(11);
            System.out.println("maxHeap.contains(11) = " + elementFound);
            elementFound = maxHeap.contains(16);
            System.out.println("maxHeap.contains(16) = " + elementFound);
        }


     }
