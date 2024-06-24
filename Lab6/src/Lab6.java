import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lab6 {
    public static void main(String[] args) {
        Lab6 lab6 = new Lab6();
        lab6.testdriver();
    }

    public void testdriver() {
        int arr[] = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("unsorted array");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Arrays.sort(arr);
        System.out.println("sorted array");
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        ArrayList<Integer> sorted = new ArrayList<>();
        System.out.println("unsorted arraylist ");
        for (int i = 0; i < 20; i++) {
            sorted.add((int) ((Math.random() * 100)));
        }
        System.out.println(sorted);
        Collections.sort(sorted);
        System.out.println("sorted arraylist");
        System.out.println(sorted);

        String[] countries = {"Egypt", "Switzerland", "Argentina", "Spain", "Poland", "Luxembourg", "India", "China"};
        System.out.println("unsorted countries: ");
        for (String country : countries)
            System.out.print(country + " ");
        System.out.println();
        System.out.println("sorted countries: ");
        Arrays.sort(countries);
        for (String country : countries)
            System.out.print(country + " ");
        System.out.println();

        ArrayList<String> countriesArraylist = new ArrayList<>();
        Collections.addAll(countriesArraylist,countries);
        System.out.println("Sorted list of Contries: ");
        for (String country : countriesArraylist)
            System.out.print(country+" ");
        System.out.println();
        System.out.println(" Add two contries to the arraylist");
        countriesArraylist.add("Turkey");
        countriesArraylist.add("Canada");
        for (String country : countriesArraylist)
            System.out.print(country+" ");
        System.out.println();
        Collections.sort(countriesArraylist);
        System.out.println("Sorted Arraylist of Countries");
        for (String country : countriesArraylist)
            System.out.print(country+" ");
        System.out.println();

        System.out.println("Add three numbers to the Array of numbers");
        sorted.add((int)(Math.random()*100));
        System.out.println(sorted);
        Collections.sort(sorted);
        System.out.println("Array of sorted numbers");
        System.out.println(sorted);




    }
}

