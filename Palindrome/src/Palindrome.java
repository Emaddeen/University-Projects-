import java.util.Scanner;

public class Palindrome {


    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        palindrome.testPalindrome();
    }

    public String reverseString(String text) {
        if (text.isEmpty())
            return text;
        return reverseString(text.substring(1)) + text.charAt(0);
    }

    public boolean isPalindrome(String testString) {
        testString = testString.replaceAll("[^a-zA-Z]", "").toLowerCase();
        if (reverseString(testString).equals(testString))
            return true;
        else
            return false;
    }

    public void testPalindrome() {
        Scanner scanner = new Scanner(System.in);
        String text = "";
        while (!text.equals("q")) {
            System.out.println("Please enter a string to be reversed or (q) to quit: ");
            text = scanner.nextLine();
            // Don't bother to test for palindrome if user requests quit
            if (text.equals("q"))
                break;
            String reversed = reverseString(text);
            if (isPalindrome(text)) {
                System.out.println("'" + text + "'" + " is a palindrome.");
            } else if (isPalindromeWords(text)) {
                System.out.println("'" + text + "'" + " is a palindrome sentence.");
            } else {
                System.out.println("'" + text + "'" + " is not a palindrome.");
            }
        }
        System.out.println("Goodbye...");
    }

    //  recursively reverse words in a phrase or sentence
    public String reverseWords(String str) {
        int idx = str.indexOf(" ");
        //Base condition - when str has only one word
        if (idx == -1)
            return str;
        //return after concatenating in reverse order
        // idx + 1 is after the space
        return reverseWords(str.substring(idx + 1)) + " " + str.substring(0, idx);
    }

    public boolean isPalindromeWords(String testString) {
        // remove punctuation but not spaces
        testString = testString.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        //  A word palindrome must contain at least one space and be equal in both directions
        if (testString.contains(" ") && reverseWords(testString).equals(testString))
            return true;
        else
            return false;
    }
}