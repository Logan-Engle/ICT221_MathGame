package au.edu.usc.mathgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * A simple console-based maths quiz for primary school children.
 *
 * @author Logan Engle
 */
public class Main {
    private int score = 0;
    HighScores highscore = new HighScores();
    Random rand = new Random();
    
    public static void main(String[] args) {
        Main main = new Main();
        main.playMultipleGames();
    }
    
    private String getOperator(Random rand, int value1, int value2) {
        String operator;
        int questionType = 0;                   // default question type of addition
        if (value1 < value2) {                  // allow addition or multiplication to occur
            questionType = rand.nextInt(2);
        } else if (value1 > value2) {           // allow addition, multiplication or subtraction operator to occur
            questionType = rand.nextInt(3);
        } else if (value1 % value2 == 0) {      // allow addition, multiplication, subtraction or division operator to occur
            questionType = rand.nextInt(4);
        }
        switch(questionType) {
            case 0:
              operator = "+";
              break;
            case 1:
              operator = "*";
              break;
              case 2:
              operator = "-";
              break;
              case 3:
              operator = "/";
              break;
              default:
              operator = "+";
              break;
            }
            return operator;
        }
        
    private void playGame() {
        ArrayList<Question> questions = new ArrayList<Question>();
        long startTime = System.currentTimeMillis();
        Scanner userInput = new Scanner(System.in);
        score = 0;
        int guessCounter = 0;
        
        for(int i = 0; i < 10; i++) {
            int value1 = rand.nextInt(12) + 1;
            int value2 = rand.nextInt(12) + 1;
            String operator = getOperator(rand, value1, value2);
            Question question = new Question(value1, value2, operator);
            questions.add(question);
        }

        for(int i = 0; i < questions.size(); i++) {
            System.out.printf("%nScore: %d%n", score);
            questions.get(i).showQuestion();
            while (!userInput.hasNextInt()) {                           // handles non integer inputs
                System.out.println("Please enter a valid integer");
                userInput.next();
            }
            int userGuess = userInput.nextInt();
            questions.get(i).checkAnswer(userGuess);
            if (questions.get(i).good && guessCounter < 10) {
                score++;
                guessCounter++;
            } else if (!questions.get(i).good){
                questions.add(questions.get(i));
                guessCounter++;
            }
        }

        highscore.updateHighscore(score);
        long timeElapsed = (System.currentTimeMillis() - startTime) / 1000;
        if (timeElapsed < 10) {
            System.out.printf("%nWell done! you answered all the questions in %d seconds%n", timeElapsed);
        } else {
            System.out.printf("%nTime elapsed: %d seconds%n", timeElapsed);
        }
        if (score >= 8) {
            System.out.printf("Congratulations, you got %d/10 correct!%n", score);
        } else if (score >= 5 && score <= 8) {
            System.out.printf("Well done, you got %d/10 correct! Keep at it%n", score);
        } else {
            System.out.printf("You got %d/10 correct. Good start, can you practice to improve your score?%n", score);
        }
        highscore.showHighscore();
    }

    private void playMultipleGames() {
        for (int i = 0; i < 5; i++) {
            playGame();
        }
    }
}