import java.util.Scanner;
public class Vowels {
    public static void main(String[] args) {
        Vowels vowels = new Vowels();
        Scanner input = new Scanner(System.in);
        System.out.println("please enter the word or phrase you wish to check");
        // dont need to use Sring phrase if we use (countvowels(in.nextln)) in line 10
        String phrase = input.nextLine();
        // idk is just to not make to the class static
        System.out.println(vowels.countVowels(phrase));
    }
    // char is just to let us know what type the information is
    // c is just something to be able to reference
    public boolean isVowel(char c) {
        String vowels = "aeiou";
        if (vowels.contains((Character.toString(c).toLowerCase()))) {
            return true;
        }
        return false;
    }
    // String is just to let us know what type the information is
    // text is just something to be able to reference
    public int countVowels(String text) {

        int counter = 0;
        for (int i = 0; i < text.toCharArray().length; i++) {
            if (isVowel(text.toCharArray()[i])) {
                ++counter;
            }

        }
        return counter;
    }
}
