import java.util.Scanner;
public class Largerof {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter 3 numbers");
        int num1=0;
        int num2=0;
        int num3=0;
        num1 = in.nextInt();
        num2 = in.nextInt();
        num3 = in.nextInt();
        if ((num1 >= num2) && (num1 >= num3)) {
            System.out.println(num1 + " This is the largest number");
        }
        else if ((num2>=num1) && (num2>=num3)){
            System.out.println(num2+ " This is the largest number");
        }
        else System.out.println(num3+ " This is the largest number");
    }
}


