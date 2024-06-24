import java.util.Scanner;

public class FinalFour {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the numbers you wish to average");
        int num1= input.nextInt(), num2=input.nextInt(), num3=input.nextInt();
        double average = average(num1,num2,num3);
        System.out.println("Average of "+ num1 +" "+num2+" "+num3+" is "+average);
    }
    public static double average(int num1, int num2, int num3){
        return (num1 +num2+num3);
    }
}
