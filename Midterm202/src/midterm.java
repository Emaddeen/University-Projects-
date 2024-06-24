import java.util.Random;
import java.util.Scanner;

public class midterm {
    public static void main(String[] args) {
        midterm term = new midterm();
        midterm.testDriver();
    }

    public static void testDriver() {
        exOne();
        exTwo();
        exThree();
        exFour();
    }

    private static void exOne() {
        System.out.println("Exercise 1:\nCountdown");
        for (int i = 2; i >= 0; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            } else if (i >= 8) {
                break;
            }
        }
        System.out.println("WHO DO WE APPRECIATE");
        System.out.println("Exercise 1 end\n");
    }

    private static void exTwo() {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(6);
        System.out.println("Exercise 2:");
        switch (rand_int1) {
            case 0:
                System.out.println("Have a spectacular day.");
                break;
            //had my younger brother pick a message
            case 1:
                System.out.println("May your drip be icey, And your food be bussin.");
                break;
            case 2:
                System.out.println("I hope you experince no traffic on your way home.");
                break;
            case 3:
                System.out.println("You did awesome today.");
                break;
            case 4:
                System.out.println("There is nothing impossible to they who will try.");
                break;
            case 5:
                System.out.println("You made it through today, you can make through tomorrow.");
                break;
            case 6:
                System.out.println("I wish you good health.");
                break;
        }
        System.out.println("Exercise 2 end\n");

    }


    private static void exThree() {
        int a;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Exercise 3:\nInput an integer, when your are finished enter -3 to end program");
        while ((a = keyboard.nextInt()) != -3) {
            System.out.println("you entered " + a);
        }
        System.out.println("Out of loop\n" + "Exercise 3 end\n");
    }

    private static void exFour() {
        Scanner numb = new Scanner(System.in);
        System.out.println("Exercise 4:\nEnter your first number: ");
        int x = numb.nextInt();
        System.out.println("Enter your second number: ");
        int y = numb.nextInt();
        System.out.println("The smaller number of the two you enterd is " + smallest(x, y));
        Integer objB = y;
        Integer objA = x;
        System.out.println("Are the integers equal? (" + objB.equals(objA) + ")");
        System.out.println("Exercise 4 end\n");
    }
    public static int smallest(int x, int y) {
        return Math.min(x, y);
    }
}