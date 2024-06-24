import java.util.Random;

public class midterm {
    public static void main(String[] args) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(6);
        switch ( rand_int1)
        {
            case 0: System.out.println("have a spectacular day");
                break;
                //had my younger brother pick a message
            case 1: System.out.println("May your drip be icey, And your food be bussin");
                break;
            case 2: System.out.println("I hope you experince no traffic on your way home");
                break;
            case 3: System.out.println("you did awesome today ");
                break;
            case 4: System.out.println("There is nothing impossible to they who will try.");
                break;
            case 5: System.out.println("you made it through today, you can make through tomorrow");
                break;
            case 6: System.out.println("i wish you good health");
                break;
        }
    }
}