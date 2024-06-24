import java.util.Scanner;

public class Qpractice {
    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        Qpractice num1 = new Qpractice();
        num1.setText("Who was the inventor of Java?");
        num1.setAnswer("James Gosling");
        num1.display();
        System.out.print("Your answer: ");
        String response = in1.nextLine();
        System.out.println(num1.checkAnswer(response));

        Scanner in2 = new Scanner(System.in);
        Qpractice num2 = new Qpractice();
        num2.setText("When was intellij created?");
        num2.setAnswer("January 2001");
        num2.display();
        System.out.print("Your answer: ");
        response = in2.nextLine();
        System.out.println(num2.checkAnswer(response));

        Scanner in3 = new Scanner(System.in);
        Qpractice num3 = new Qpractice();
        num3.setText("What coding language does IntelliJ use");
        num3.setAnswer("Java");
        num3.display();
        System.out.print("Your answer: ");
        response = in3.nextLine();
        System.out.println(num3.checkAnswer(response));
    }

    private String text;
    private String answer;

    public Qpractice() {
        text = "";
        answer = "";
    }

    public void setText(String questionText) {
        text = questionText;
    }

    public void setAnswer(String correctResponse) {
        answer = correctResponse;
    }

    public boolean checkAnswer(String response) {
        return response.equals(answer);
    }

    public void display() {
        System.out.println(text);
    }
}