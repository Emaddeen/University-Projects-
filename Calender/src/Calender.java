import java.time.LocalDate;
import java.util.Scanner;

public class Calender {

    public static final int WIDTH = 20;
    public static final int WEEK = 7;

    public static void main(String[] args) {
        Calender calender = new Calender();
        calender.printCalender();
    }

    public String spaces(int n) {
        StringBuilder blanks = new StringBuilder();
        String spaces = "";
        for (int i = 0; i < n; ++i)
                blanks.append(' ');
            return blanks.toString();
        }

        public void printHeader ( int mo, int yr){
            String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String month = months[mo];
            month = month + " " + yr;
            int leadSpaces = (WIDTH - month.length()) / 2;
            System.out.println("\n" + spaces(leadSpaces) + month);
            System.out.println("Su Mo Tu We Th Fr Sa");

        }

        public int printWeek ( int dayNum, int weekday, int dayinMon)
        {
            weekday = weekday % WEEK;
            System.out.print(spaces(weekday * 3));
            while (weekday <= 6 && dayNum <= dayinMon) {
                System.out.print(String.format("%2d ", dayNum));
                weekday++;
                dayNum++;
            }
            System.out.println();
            return dayNum;
        }
        public void printCalender () {
            Scanner in = new Scanner(System.in);
            System.out.print("enter the month on the calander(1-12): ");
            int month = in.nextInt();

            System.out.print("enter the year on the calander(YYYY): ");
            int year = in.nextInt();
            int day = 1;
            LocalDate date = LocalDate.of(year, month, day);
            int dayinMon = date.lengthOfMonth();

            printHeader(month-1, year);
            int weekday = java.time.LocalDate.of(year, month, 1).getDayOfWeek().getValue();
            int currentDay = 1;

            while (currentDay <= dayinMon) {
                currentDay = printWeek(currentDay, weekday, dayinMon);
                weekday = 0;
            }
        }
    }
