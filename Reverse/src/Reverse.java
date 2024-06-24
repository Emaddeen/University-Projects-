import java.util.Scanner;
public class Reverse{

    public static String reverse(String text){
        if (text.length()==1){
            return text;
        }
        else{
            return reverse(text.substring(1)) + text.charAt(0);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String str = sc.nextLine();
        System.out.println("The reversed string is: " + reverse(str));
    }
}