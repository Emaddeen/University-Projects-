import java.util.Scanner;
public class midterm4 {

    public static void main(String[] args)
    {
        Scanner numb = new Scanner(System.in);
        System.out.println("Enter your first number: ");
        int x = numb.nextInt();
        System.out.println("Enter your second number: ");
        int y = numb.nextInt();
        System.out.println("The smaller number of the two you enterd is " + smallest(x, y));
        Integer objB = y;
        Integer objA= x;
        System.out.print("Are the integers equal? ("+objB.equals(objA)+")");
    }
    public static int smallest(int x, int y)
    {
        return Math.min(x, y);
    }
}