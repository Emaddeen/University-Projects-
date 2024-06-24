import java.util.Scanner;
public class Invest {
   public static void main(String[] args) {
      System.out.println("Please answer the following questions.");
      Scanner Invest = new Scanner(System.in);
      double InAmount;
      double rate;

      System.out.println("What is your initials deposit amount");
      InAmount = Invest.nextDouble();
      System.out.println("What is the rate on your investment in decimal for, Ex: 6% as 0.06");
      rate = Invest.nextDouble();
      System.out.println("How long has it been since you deposited your investment");
      int NumMonths = Invest.nextInt();
      for (int month = 1; month <= NumMonths; month++) {
         double amt = InAmount * Math.pow(1 + rate / 12, month);
         System.out.printf("After month %d.  $%.2f%n",month,amt);
      }
   }
}