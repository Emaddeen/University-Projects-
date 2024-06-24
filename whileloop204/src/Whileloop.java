import java.util.Scanner;
class WhileLoop {
    public static void main(String[] args) {
        int a;
        int sum=0;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer");
        while ((a = keyboard.nextInt()) != 0) {
            sum= sum+ a;
        }
        System.out.println("Your total is "+sum);
        System.out.println("Out of loop");
    }
}