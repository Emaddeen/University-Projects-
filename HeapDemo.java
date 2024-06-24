import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;

public class HeapDemo {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

  PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

      public void printHeap(PriorityQueue<Integer> queue) {
         for (Integer item: queue) {
             System.out.print(item + " ");
         }
        System.out.println();
    }

    public void doHeapDemo() {

        int[] ia = { 9, 10, 5, 3, 4, 7, 6, 1, 8 };
        for (int item : ia) {
            minHeap.add(item);
        }
        for (int item : ia) {
            maxHeap.add(item);
        }
        System.out.println("Min heap:");
        printHeap(minHeap);
        System.out.println("Min value is: " + minHeap.peek());

        System.out.println("Max heap:");
        printHeap(maxHeap);
        int max = maxHeap.peek();
        System.out.println("Max value is: " + max);
        System.out.println("Removing max: ");

        maxHeap.remove();
        System.out.println("Max heap:");
        printHeap(maxHeap);
        System.out.println("Add max back: " + max);
        maxHeap.add(max);
        System.out.println("Max heap:");
        printHeap(maxHeap);

    }

    public static void main(String[] args) {
        HeapDemo hd = new HeapDemo();
        hd.doHeapDemo();
    }

}
