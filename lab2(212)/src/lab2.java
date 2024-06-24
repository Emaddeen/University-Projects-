import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public class lab2 {
    static int[] array = new int[20];
    static ArrayList<Integer> numArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Random ran = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(99);
            numArrayList.add(ran.nextInt(99));

        }
        System.out.print("Array generated random numbers ");
        System.out.print(Arrays.toString(array));

        System.out.println();
        System.out.print("Random numbers sorted ");
        Arrays.sort(array);
        System.out.print(Arrays.toString(array));

        System.out.println();
        System.out.print("Array numbers in ascending order ");
        System.out.print(String.format("%s", Arrays.toString(array)));

        System.out.println();
        System.out.print("Array numbers unsorted ");
        System.out.print(Arrays.toString(numArrayList.toArray()));
    }
}
