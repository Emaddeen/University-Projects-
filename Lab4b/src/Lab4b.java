import java.util.Scanner;
import java.awt.Graphics;
import javax.swing.*;

public class Lab4b {
    public static void main(String[] args) {
        Lab4b lab4 = new Lab4b();
        lab4.testDriver();
    }

    public void testDriver() {
        exOne();
        exTwo();
    }

    public void exOne() {
        for (int num = 1; num <= 10; num++) {
            for (int i = 1; i <= 10; i++) {
                System.out.print((num * i) + " ");
            }
            System.out.println();
        }
    }
    public void exTwo() {
        int sum = 0;
        for (int i = 0; i <= 101; i += 2)
            sum += i;
            System.out.println((int) sum);
        for (int i = 0; i <= 101; i++)
            sum += Math.sqrt(i);
            System.out.println(sum);
        for (int i =0; i <= 20; i++)
            sum += Math.pow(i, 2);
            System.out.println((int) sum);

        Scanner in= new Scanner(System.in);
        System.out.print("please enter your first number: ");
        int Anum = in.nextInt();
        System.out.print("please enter your Second number: ");
        int Bnum = in.nextInt();
        System .out.print("num is even");
        sum=0;
        for (int i= Anum;i <= Bnum; i++){
            if (i%2 != 0){
                sum += i;
            }
        }
        System.out.println("sum of odds = "+sum);
        sum=0;
        System.out.println("enter a five digit Number");
        int oddin = in.nextInt();
        int digit=0;
        while (oddin !=0){
            digit =oddin%10;
            if (digit%2 !=0){
                sum+=digit;
            }
            oddin/=10;
        }
        System.out.println("the total sum of odd digits = "+ sum);
    }
    }