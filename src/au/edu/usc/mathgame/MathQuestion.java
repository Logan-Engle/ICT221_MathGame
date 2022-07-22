package au.edu.usc.mathgame;

/**
 * This class creates a maths question.
 *
 * Given 2 integer values and an operator
 * constructs a maths question and determines
 * the correct answer to the question
 *
 * @author Logan Engle
 */
public class MathQuestion {
    public String question;
    public int answer;
    public boolean good;

    MathQuestion(int value1, int value2, String operator) {
        question = String.format("What is %d %s %d = ", value1, operator, value2);
        if (operator == "+") {
            answer = value1 + value2;
        } else if (operator == "-"){
            answer = value1 - value2;
        } else if (operator == "*"){
            answer = value1 * value2;
        } else if (operator == "/"){
            answer = value1 / value2;
        }
    }

    /**
    * This method prints the question to the console.
    *
    * @author Logan Engle
    */
    public void showQuestion() {
        System.out.printf(question);
    }

    /**
    * This method checks if the user input is
    * correct and returns a boolean
    *
    * @author Logan Engle
    */
    public Boolean checkAnswer(int userInput) {
        if (userInput == answer) {
            System.out.println("Correct!");
            good = true;
            return true;
        } else {
            System.out.println("Not quite..");
            good = false;
            return false;
        }
    }
}
