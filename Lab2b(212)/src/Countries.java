import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;


public class Countries {
    public void simpleCountries() {


        String[] count = {"Germany", "Brazial", "Japan", "China", "Nigeria"};
        System.out.println("Array: not alphabetical");
        for (
                String i : count)
            System.out.println(i + " ");
        System.out.println();
        System.out.println();
        Arrays.sort(count);
        System.out.println("Array: alphabetical");
        for (
                String a : count) {
            System.out.println(a + " ");
        }
        System.out.println();
        System.out.println();
    }

    public void listCountries() {
        ArrayList<String> countries = new ArrayList();
        countries.add("Germany");
        countries.add("Italy");
        countries.add("Spain");
        countries.add("Russian Federation");
        countries.add("South Korea");
        countries.add("United States");
        countries.add("France");
        countries.add("Sweden");
        countries.add("Poland");
        System.out.println("Array: not alphabetical");
        System.out.println(countries);
        System.out.println();
        System.out.println("Array: alphabetical");
        Collections.sort(countries);
        System.out.println(countries);
        System.out.println();
        countries.add("Nicaragua");
        System.out.println("");
        System.out.println(countries);
        System.out.println();
        System.out.println("");
        Collections.sort(countries);
        System.out.println(countries);
        System.out.println();


    }

    public static void main(String[] args) {
        Countries aS = new Countries();

        System.out.println("Simple Array listed countries ");
        aS.simpleCountries();

        System.out.println("Arraylist Countries");
        aS.listCountries();


    }
}