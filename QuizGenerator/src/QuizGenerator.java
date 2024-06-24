import java.util.ArrayList;
import java.util.Collections;

public class QuizGenerator {
    enum QuestionType {Torf, Multiplicative}

    enum level {Easy, Medium, Hard}

    public static void main(String[] args) {
        //creatig Quiz Generator object
        QuizGenerator quizGenerator = new QuizGenerator();
        //
        User user = quizGenerator.createUser();
        ArrayList<Question> quizQuestions = quizGenerator.createQuizQuestions();
        ArrayList<Question> quizQuestionQuiz1 = quizGenerator.getQuestionsByQuiz(quizQuestions, "quiz1");
        ArrayList<Quiz> quizzes = new ArrayList<>();

        Quiz quiz1 = quizGenerator.createQuiz("quiz1","Absolutely random trivia : ) ","This Quiz involves a few multiple choice and true or false questions on completely random topics with little to no correlation." +"\n"+"This Quiz is worth 50 points.",50,true, user.getId(), quizQuestions);
        quizzes.add(quiz1);
        quizGenerator.printQuiz(quiz1, user);
        System.out.println("\n");
    }
    public Quiz createQuiz(String quizId,String title, String summary, int score, boolean isPublished, String HostId,ArrayList<Question> questions) {
        Quiz quiz = new Quiz(quizId,title,summary,score,isPublished,HostId,questions);
        return quiz;
    }

    public User createUser() {
        return new User("DCCC", "Emaddeen", "Amm", "eamm@mail.dccc.edu", "goodluck:)", true, "Hello Emaddeen Amm");
    }

    class User {
        public User(String id, String firstName, String lastName, String email, String password, boolean isHost, String intro) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.isHost = isHost;
            this.intro = intro;
        }
        private String id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private boolean isHost;
        private String intro;
        public String getId() {return id;}
        public String getFirstName() {return firstName;}
        public String getLastName() {return lastName;}
        public String getEmail() {return email;}
        public String getIntro() {return intro;}
        public boolean isHost() {return isHost;}
        public String getPassword(){return password;}
    }

    class Question {
        String quizId;
        QuestionType type;
        level level;
        int score;
        String questionText;
        ArrayList<Answer> answers;

        public Question(String quizId, QuestionType type, level level, int score, String questionText, ArrayList<Answer> answers) {
            this.quizId = quizId;
            this.type = type;
            this.level = level;
            this.score = score;
            this.questionText = questionText;
            this.answers = answers;
        }
        public String getQuizId() {return quizId;}
        public QuestionType getType() {return type;}
        public QuizGenerator.level getLevel() {return level;}
        public int getScore() {return score;}
        public String getQuestionText() {return questionText;}
        public String toString() {return "(" + score + " points):\n" + questionText;}
        public ArrayList<Answer> getAnswers() {return answers;}
    }
    public ArrayList<Question> getQuestionsByQuiz(ArrayList<Question> questions, String quizId) {
        ArrayList<Question> questionSubset = new ArrayList<>();
        for (Question q : questions){
            if (q.quizId.equals(quizId))
                questionSubset.add(q);
        }
        return questionSubset;
    }

    class Answer {
        public Answer(String id, String quizId, boolean isActive, boolean isCorrect, String answerText) {
            this.id = id;
            this.quizId = quizId;
            this.isActive = isActive;
            this.isCorrect = isCorrect;
            this.answerText = answerText;
        }

        String id;
        String quizId;
        String questionId;
        boolean isActive;
        boolean isCorrect;
        String answerText;
        public String getId() {return id;}
        public String getQuizId() {return quizId;}
        public String getQuestionId() {return questionId;}
        public boolean isActive() {return isActive;}
        public boolean isCorrect() {return isCorrect;}
        public String getAnswerText() {return answerText;}
        @Override
        public String toString() {
            return answerText;
        }
    }
    public ArrayList<Answer> getAnswerByQuestion(ArrayList<Answer> answers, String questionId) {
        ArrayList<Answer> answerSubset = new ArrayList<>();
        for (Answer ans : answers) {
            if (ans.questionId.equals(questionId))
                answerSubset.add(ans);
        }
        return answerSubset;
    }
    class Quiz {
        String id;
        String title;
        String summary;
        int score;
        boolean isPublished;
        String hostId;
        ArrayList<Question> questions;
        public String getId() {
            return id;
        }
        public String getTitle() {
            return title;
        }
        public String getSummary() {
            return summary;
        }
        public int getScore() {
            return score;
        }
        public boolean isPublished() {
            return isPublished;
        }
        public String getHostId() {
            return hostId;
        }
        public ArrayList<Question> getQuestions() {
            return questions;
        }

        @Override
        public String toString() {
            return "Quiz{" + "questions=" + questions + '}';
        }
        public Quiz(String id, String title, String summary, int score, boolean isPublished, String hostId, ArrayList<Question> questions) {
            this.id = id;
            this.title = title;
            this.summary = summary;
            this.score = score;
            this.isPublished = isPublished;
            this.hostId = hostId;
            this.questions = questions;
        }
    }


    public void printQuiz(Quiz quiz, User user) {

        ArrayList<String> abcd = new ArrayList<>();
        abcd.add("A");
        abcd.add("B");
        abcd.add("C");
        abcd.add("D");
        System.out.println("Host: " + quiz.getHostId());
        System.out.println(user.getFirstName() + " " + user.getLastName());
        System.out.println(user.getIntro());
        System.out.println("Email: " + user.getEmail());
        System.out.println();
        System.out.println(quiz.getTitle());
        System.out.println(quiz.getSummary());
        System.out.println();

        Collections.shuffle(quiz.questions);

        int i = 0;
        for (Question question : quiz.getQuestions()) {
            System.out.print(i + 1 + ") ");
            System.out.println(question);

            int h = 0;
            Collections.shuffle(question.answers);
            for (Answer answer : question.getAnswers()) {
                System.out.print(abcd.get(h) + ", ");
                System.out.println(answer);
                h++;
            }
            i++;
            System.out.println();
        }
        System.out.println("___________________");
        System.out.println(" INSTRUCTOR VERSION ");
        System.out.println("___________________");
        System.out.println("Host: " + quiz.getHostId());
        System.out.println(user.getFirstName() + " " + user.getLastName());
        System.out.println(user.getIntro());
        System.out.println("Email: " + user.getEmail());
        System.out.println();
        System.out.println(quiz.getTitle());
        System.out.println(quiz.getSummary());
        System.out.println();

        i = 0;
        for (Question question : quiz.getQuestions()) {
            System.out.print(i + 1 + ") ");
            System.out.println(question);

            int h = 0;
            for (Answer answer : question.getAnswers()) {
                System.out.print(abcd.get(h) + ", ");
                System.out.println(answer);
                h++;
            }
            i++;
            //System.out.println();
            for (Answer answer : question.getAnswers()) {
                if (answer.isCorrect) {
                    System.out.println(" Correct Answer: " + answer);
                    break;
                }
            }
        }
    }
    public ArrayList<Question> createQuizQuestions() {

        ArrayList<Answer> quizAnswers = new ArrayList<>();

        quizAnswers.add(new Answer("Quiz1", "quiz1q1",true,true, "Hola"));
        quizAnswers.add(new Answer("Quiz1","quiz1q1", true, false, "Taco"));
        quizAnswers.add(new Answer("Quiz1", "quiz1q1", true, false, "Hora"));
        quizAnswers.add(new Answer("Quiz1", "quiz1q1", true, false, "Hello"));


        ArrayList<Answer> quizAnswersQ2 = new ArrayList<>();
        quizAnswersQ2.add(new Answer("Quiz2", "quiz2q2", true, true, "True"));
        quizAnswersQ2.add(new Answer("Quiz2", "quiz2q2", true, false, "False"));

        ArrayList<Answer> quizAnswersQ3 = new ArrayList<>();
        quizAnswersQ3.add(new Answer("Quiz3", "quiz3q3", true, false, "'A' is the most common letter in the english language "));
        quizAnswersQ3.add(new Answer("Quiz3", "quiz3q3", true, false, "'A' is not the most common letter in the english language"));
        quizAnswersQ3.add(new Answer("Quiz3", "quiz3q3", true, true, "'A','T', and 'E' are the most commonly used letters in the english language"));
        quizAnswersQ3.add(new Answer("Quiz3", "quiz3q3", true, false, "'E' is the most commonly used letter in the english language"));

        ArrayList<Answer> quizAnswersQ4 = new ArrayList<>();
        quizAnswersQ4.add(new Answer("Quiz4", "quiz4q4", true, true, "True"));
        quizAnswersQ4.add(new Answer("Quiz4", "quiz4q4", true, false, "False"));

        ArrayList<Answer> quizAnswersQ5 = new ArrayList<>();
        quizAnswersQ5.add(new Answer("Quiz5", "quiz5q5", true, false, "Drexel, Marple Center, Harvord"));
        quizAnswersQ5.add(new Answer("Quiz5", "quiz5q5", true, false, "Maple Center, Widener, West Chester"));
        quizAnswersQ5.add(new Answer("Quiz5", "quiz5q5", true, true, "Marple Center, Upper Darby Center, Exton Center"));


        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("quiz1", QuestionType.Multiplicative, level.Easy, 5, "which one of these is how you say 'Hello' in Spanish?",quizAnswers));
        questions.add(new Question("quiz2", QuestionType.Torf, level.Medium, 10, " True or False? A cross between a horse and a zebra is called a 'Hobra'.",quizAnswersQ2));
        questions.add(new Question("quiz3", QuestionType.Multiplicative, level.Hard,15,"'A' is the most common letter used in the English language",quizAnswersQ3));
        questions.add(new Question("quiz4", QuestionType.Torf, level.Hard, 15, " The small intestine is about three-and-a-half times the length of your body.",quizAnswersQ4));
        questions.add(new Question("quiz5", QuestionType.Multiplicative, level.Easy, 5, "Name three campus locations for DCCC?",quizAnswersQ5));


        return questions;
    }


}
