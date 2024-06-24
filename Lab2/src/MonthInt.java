import java.time.Month;
import java.util.Scanner;
public class MonthInt {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int MonthInt;
        System.out.println("enter the month (1-12) ");
        MonthInt = Integer.parseInt(in.nextLine());
        String Months = " Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec ";
        System.out.println(Months.substring(MonthInt * 4-3, MonthInt *4));
        
    }
}
