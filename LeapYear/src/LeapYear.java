import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {

        //make a scanner for input
        Scanner in = new Scanner(System.in);
        int Year;

        // now ask the user for a Year
        System.out.println("Please enter a year: ");
        Year = in.nextInt();

        //now do the if and math part to calculate the leap year
        if (Year % 4 == 0 && Year % 100 != 0 && Year > 1582 && Year % 400 ==0) {
            System.out.println("This is a leap year");
        }else{ System.out.println("This is not a leap year ");
        }
    }
}