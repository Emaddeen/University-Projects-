import java.util.Scanner;
public class Lab22 {
    public static void main(String[] args) {
        Lab22 lab2 = new Lab22();
        lab2.testDriver();
            }
            public  void testDriver() {
                exOne();
                exTwo();
                exThree();
            }

            public  void exOne() {
                Scanner Miltime = new Scanner(System.in);
                int FirstT;
                int SecondT;

                System.out.println("enter first time");
                FirstT = Miltime.nextInt();
                System.out.println("enter second time");
                SecondT = Miltime.nextInt();

                int SecondTM = SecondT / 100 * 60 + SecondT % 100;
                int FirstTM = FirstT / 100 * 60 + FirstT % 100;
                int TimeD = SecondTM - FirstTM;
                int HourD = TimeD / 60;
                int MinuteD = TimeD % 60;
                System.out.println("time Difference: " + HourD + " Hours " + MinuteD + " Minutes");
            }

            public void exTwo() {
                Scanner in = new Scanner(System.in);
                int MonthInt;
                System.out.println("enter the month (1-12) ");
                MonthInt = Integer.parseInt(in.nextLine());
                String Months = " Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec ";
                System.out.println(Months.substring(MonthInt * 4 - 3, MonthInt * 4));
            }

            public void exThree() {
                System.out.println("enter the first an second integer");
                Scanner in = new Scanner(System.in);
                double Numb1 = in.nextInt();
                double Numb2 = in.nextInt();
                System.out.println("first Number " + Numb1);
                System.out.println("second Number " + Numb2);
                System.out.println("Addition " + (Numb1 + Numb2));
                System.out.println("Subtraction " + (Numb1 - Numb2));
                System.out.println("Multiplication " + (Numb1 * Numb2));
                System.out.println("Division " + (Numb1 / Numb2));
                System.out.println("Remainder " + (Numb1 % Numb2));
                System.out.println("Max " + (Math.max(Numb1, Numb2)));
                System.out.println("Min " + (Math.min(Numb1, Numb2)));
                System.out.println("Distance " + (Math.abs(-Numb1 - Numb2)));
            }
        }