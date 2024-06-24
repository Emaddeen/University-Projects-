import java.util.Scanner;
import java.util.Stack;

public class SentenceReverser {

    public static String processSentence(Scanner scanner, Stack stack, String reversed) {

        boolean firstWord = true;
        while (stack.size() > 0) {
            String popWord = stack.pop().toString();
            if (firstWord) {
                String firstLetter = popWord.substring(0, 1);
                popWord = firstLetter.toUpperCase() + popWord.substring(1);
                firstWord = false;
            } else {
                popWord = popWord.toLowerCase();
            }
            popWord = popWord.replace(".", "");
            reversed += popWord;
            if (stack.size() <= 0) {
                reversed += ".";
            }
            if (scanner.hasNext() || (stack.size() > 0)) {
                reversed += " ";
            }
        }
        return reversed;
    }

    public String reverse(String sentence) {

        String reversed = "Mary had a little lamb. His fleece was as white as snow. Everywhere the child went. The little lamb was sure to go, yeah.\n";
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(sentence);
        while (scanner.hasNext())
        {
            String pushWord = scanner.next();
            stack.push(pushWord);
            if (pushWord.contains(".")) {
                reversed = processSentence(scanner, stack, reversed);
            }
        }
        return reversed;
    }
    public static void main(String[] args) {
        SentenceReverser sr = new SentenceReverser();
        System.out.println(sr.reverse("Mary had a little lamb. His fleece was as white as snow. Everywhere the child went. The little lamb was sure to go, yeah."));
    }

}
