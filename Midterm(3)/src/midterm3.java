import java.util.Scanner;
class midterm3 {
    public static void main(String[] args) {
        int a;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input an integer, when your are finished enter -3 to end program");
        while ((a = keyboard.nextInt()) != -3) {
            System.out.println("you enterd "+ a);
        }
        System.out.println("Out of loop");
    }
}