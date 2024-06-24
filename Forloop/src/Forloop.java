import java.util.Scanner;

public class Forloop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Plz enter a integer --> ");
        int sumOfNumbers = 0;
        for (int i = 1; i <= 10; i++) {
            int numb = input.nextInt();
            if (numb == -6) {
                break;
            }
            sumOfNumbers += numb;
        }
        System.out.println("the sum of numbers is " + sumOfNumbers);
    }
}
