import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Inner class representing a single question in the quiz
    public static class Question {
        private String text;
        private String[] options;
        private int correctAnswerIndex;

        public Question(String text, String[] options, int correctAnswerIndex) {
            this.text = text;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getText() {
            return text;
        }

        public String[] getOptions() {
            return options;
        }

        public boolean isCorrectAnswer(int index) {
            return index == correctAnswerIndex;
        }
    }

    // Inner class representing the quiz itself
    public static class Quiz {
        private List<Question> questions;

        public Quiz() {
            questions = new ArrayList<>();
        }

        public void addQuestion(Question question) {
            questions.add(question);
        }

        public void start() {
            Scanner scanner = new Scanner(System.in);
            int score = 0;

            for (int i = 0; i < questions.size(); i++) {
                Question question = questions.get(i);
                System.out.println("Question " + (i + 1) + ": " + question.getText());
                String[] options = question.getOptions();
                
                for (int j = 0; j < options.length; j++) {
                    System.out.println((j + 1) + ". " + options[j]);
                }

                int answer = -1;
                while (answer < 1 || answer > options.length) {
                    System.out.print("Your answer (1-" + options.length + "): ");
                    if (scanner.hasNextInt()) {
                        answer = scanner.nextInt();
                    } else {
                        scanner.next(); // clear invalid input
                    }
                }

                if (question.isCorrectAnswer(answer - 1)) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect!");
                }
            }

            System.out.println("Your final score is: " + score + "/" + questions.size());
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding questions to the quiz
        quiz.addQuestion(new Question("What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Rome"}, 2));
        quiz.addQuestion(new Question("What is 2 + 2?", new String[] {"3", "4", "5", "6"}, 1));
        quiz.addQuestion(new Question("Which is platform independent language?",new String[]{"c programming","HTML","java","data structure"},2));
        // Starting the quiz
        quiz.start();
    }
}
