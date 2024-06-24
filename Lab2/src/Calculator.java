import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        System.out.println("enter the first an second integer");
        Scanner in = new Scanner(System.in);
        double Numb1 = in.nextInt();
        double Numb2 = in.nextInt();
        System.out.println("first Number " + Numb1);
        System.out.println("second Number " + Numb2);
        System.out.println("Addition "+ (Numb1 + Numb2));
        System.out.println("Subtraction "+(Numb1 -Numb2));
        System.out.println("Multiplication " + (Numb1 * Numb2));
        System.out.println("Division " + (Numb1 / Numb2));
        System.out.println("Remainder " + (Numb1 % Numb2));
        System.out.println("Max "+(Math.max(Numb1,Numb2)));
        System.out.println("Min "+(Math.min(Numb1,Numb2)));
        System.out.println("Distance "+(Math.abs(-Numb1 - Numb2)));
    }
}
