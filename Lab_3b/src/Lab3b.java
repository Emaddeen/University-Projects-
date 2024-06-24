import java.util.Scanner;
public class Lab3b {
    public static void main(String[] args) {
        Lab3b lab3 = new Lab3b();
        lab3.testDriver();
    }

    public void testDriver() {
        exOne();
        exTwo();
    }

    public void exOne() {

        Scanner InNum = new Scanner(System.in);
        System.out.println("chose a number corresponding to a month (1-12): ");
        int MonthNum = InNum.nextInt();
        System.out.println("Please chose which day you're picking: ");
        int DayNum = InNum.nextInt();
        String Season = "";

        if (MonthNum <= 3 && MonthNum >= 1) {
            Season = "The season is Winter";
            if (MonthNum % 3 == 0 && DayNum >= 21){
                Season ="The season is Spring";
            }
        }
        else if (MonthNum <= 6 && MonthNum >=3) {
            Season = "The season is Spring";
            if (MonthNum % 3 == 0 && DayNum >= 21){
                Season = "The season is Summer";
            }
        }
        else if (MonthNum <= 9 && MonthNum >=6) {
            Season = "The season is Summer";
            if  (MonthNum % 3 == 0 && DayNum >= 21){
                Season = "The season is Winter";
            }
        }
        else if (MonthNum <= 12 && MonthNum >=9) {
            Season ="The season is Fall";
            if (MonthNum % 3 == 0 && DayNum >= 21){
                Season = "The season is Winter";
            }
        }
    System.out.println(Season);
    }
        public void exTwo() {
            Scanner CM = new Scanner(System.in);
            // distances (in,cm,ft)
            double cm_to_in = 0.393701;
            double in_to_cm = 2.54;
            double cm_to_ft = 0.0328084;
            double ft_to_cm = 30.48;
            double ft_to_in = 12;
            double in_to_ft = 0.08333;
            // Volumes (gal,l,ml)
            double gal_to_l = 3.78541;
            double l_to_gal = 0.264172;
            double l_to_ml = 1000;
            double ml_to_l = 0.001;
            double gal_to_ml = 3785.41;
            double ml_to_gal = 0.000264172;

            //prompt the user to insert a value from the ones available
            System.out.println("Convert from (gal, l, ml, in, ft, cm): ");
            String convert_from = CM.next();
            System.out.println("Convert to (ml, l, gal, cm, in, ft): ");
            String convert_to = CM.next();
            System.out.println("Enter value: ");
            double value = CM.nextDouble();

            double c_factor = 0.0;

            //length conversion section
            //noinspection IfCanBeSwitch
            if (convert_from.equals("ft")) {
                if (convert_to.equals("cm")) {
                    c_factor = ft_to_cm;
                } else if (convert_to.equals("in")) {
                    c_factor = ft_to_in;
                }
            } else if (convert_from.equals("in")) {
                if (convert_to.equals("ft")) {
                    c_factor = in_to_ft;
                } else if (convert_to.equals("cm")) {
                    c_factor = in_to_cm;
                }
            } else if (convert_from.equals("cm")) {
                if (convert_to.equals("in")) {
                    c_factor = cm_to_in;
                } else if (convert_to.equals("ft")) {
                    c_factor = cm_to_ft;
                }
            }
            //volume conversion section
            else if (convert_from.equals("gal")) {
                if (convert_to.equals("ml")) {
                    c_factor = gal_to_ml;
                } else if (convert_to.equals("l")) {
                    c_factor = gal_to_l;
                }
            } else if (convert_from.equals("l")) {
                if (convert_to.equals("gal")) {
                    c_factor = l_to_gal;
                } else if (convert_to.equals("ml")) {
                    c_factor = l_to_ml;
                }
            } else if (convert_from.equals("ml")) {
                if (convert_to.equals("l")) {
                    c_factor = ml_to_l;
                } else if (convert_to.equals("gal")) {
                    c_factor = ml_to_gal;
                }
            }
            if (c_factor == 0.0) {
                System.out.println("this conversion is not supported");
            } else {
                double converted = c_factor * value;
                System.out.printf("%.4f %s = %.4f %s", converted, convert_to,value,convert_from);
            }
    }
}