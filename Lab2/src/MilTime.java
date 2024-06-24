import java.util.Scanner;

public class MilTime {
    public static void main(String[] args) {
        Scanner Miltime = new Scanner(System.in);
        int FirstT;
        int SecondT;

        System.out.println("enter first time");
        FirstT = Miltime.nextInt();
        System.out.println("enter second time");
        SecondT = Miltime.nextInt();

        int SecondTM = SecondT / 100*60 + SecondT % 100;
        int FirstTM = FirstT / 100*60 + FirstT % 100;
        int TimeD = SecondTM - FirstTM;
        int HourD = TimeD/60;
        int MinuteD = TimeD%60;
        System.out.println("time Difference: " + HourD + " Hours " +MinuteD + " Minutes");


    }
}
