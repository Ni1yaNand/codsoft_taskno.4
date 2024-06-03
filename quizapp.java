import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Quiz {
    private String question;
    private String[] options;
    private int correctAnswer;
    private int timeLimit;

    public Quiz(String question, String[] options, int correctAnswer, int timeLimit) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.timeLimit = timeLimit;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public int getTimeLimit() {
        return timeLimit;
    }
}

public class quizapp {
    public static void main(String[] args) {
        Quiz[] quizzes = new Quiz[] {
            new Quiz("Where is Taj Mahal situated?", new String[] {"Agra", "Kanpur", "Mumbai", "Chandigarh"}, 0, 10),
            new Quiz("How many states are there in India?", new String[] {"30", "24", "29", "26"}, 2, 10),
            new Quiz("What is the smallest country in the world?", new String[] {"Vatican City", "Monaco", "Cuba", "Sri Lanka"}, 0, 10),
        };

        int score = 0;
        for (Quiz quiz : quizzes) {
            System.out.println(quiz.getQuestion());
            for (int i = 0; i < quiz.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + quiz.getOptions()[i]);
            }

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                }
            }, quiz.getTimeLimit() * 1000);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your answer (1-" + quiz.getOptions().length + "): ");
            int answer = scanner.nextInt() - 1;

            if (answer == quiz.getCorrectAnswer()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + quiz.getOptions()[quiz.getCorrectAnswer()]);
            }

            timer.cancel();
        }

        System.out.println("Quiz complete! Your final score is " + score + " out of " + quizzes.length);
    }
}
