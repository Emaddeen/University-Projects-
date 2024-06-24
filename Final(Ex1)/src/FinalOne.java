import java.util.Scanner;

public class FinalOne {
    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Enter the number: ");

        int n = num.nextInt();
        evenOrOdd(n);

    }

    public static void evenOrOdd(int n) {
        if (n % 2 == 0) {
            System.out.println("Its is an even number");
        } else if (n % 2 != 0) {
            System.out.println("Its is an odd number");
        }
    }
}