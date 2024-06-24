import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {



    int[] a = generate(500000);
        System.out.println("thg");

    print(a);

    long time = System.currentTimeMillis();
    int mid = (a.length - 1) / 2;
    SortThread left = new SortThread(a, 0, mid);
    SortThread right = SortThread(a, mid + 1, a.length - 1);
    left.start;
    right.start;
        try

    {
        left.join();
        right.join();
    }catch(Exception)

    time =System.currentTimeMillis()-time;
        System.out.println("elapsed time: ",+time);

    print(a);

    public class SortThread {

        int start;
        //int mid;
        int end;
        int[] a;

        public SortThread(int start, int end) {
            this.start = start;
            this.end = end;
            this.a = a;
        }
    }


}