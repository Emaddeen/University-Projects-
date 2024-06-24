import java.util.Random;
import java.util.Scanner;

public class MagicBall{
    public static void main(String args[])
    {
        Random rand = new Random();

        String ask;
        int rand_int1 = rand.nextInt(20);
        Scanner in = new Scanner(System.in);
        System.out.println("Go on and ask your Greatest questions. \nP.S. it isn't our fault (the Magic8Ball Foundation [TM]) if your questions answer aren't legitimate, or even make sense for that matter.");
        ask = in.next();
        System.out.println("The Magic 8 Ball shall give you an answer");
        switch ( rand_int1)
        {
            case 0: System.out.println("Better not tell you now.");
                break;
            case 1: System.out.println("It is certain.");
                break;
            case 2: System.out.println("Don't count on it.");
                break;
            case 3: System.out.println("Reply hazy, try again.");
                break;
            case 4: System.out.println("Ask again later.");
                break;
            case 5: System.out.println("Very doubtful.");
                break;
            case 6: System.out.println("You may rely on it.");
                break;
            case 7: System.out.println("Outlook good.");
                break;
            case 8: System.out.println("Signs point to yes.");
                break;
            case 9: System.out.println("Yes.");
                break;
            case 10: System.out.println("Most likely.");
                break;
            case 11: System.out.println("As I see it, yes.");
                break;
            case 12: System.out.println("Cannot predict now.");
                break;
            case 13: System.out.println("Concentrate and ask again.");
                break;
            case 14: System.out.println("My sources say no.");
                break;
            case 15: System.out.println("Outlook not so good.");
                break;
            case 16: System.out.println("My reply is no.");
                break;
            case 17: System.out.println("Yes definitely.");
                break;
            case 18: System.out.println("Without a doubt.");
                break;
            case 19: System.out.println("It is decidedly so.");
                break;
            case 20: System.out.println("Without a doubt.");
                break;
        }
    }
}