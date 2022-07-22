package au.edu.usc.mathgame;

/**
 * This class stores the highscore.
 *
 * @author Logan Engle
 */
public class HighScores {
    public int highscore;
    
    HighScores() {
        highscore = 0; 
    }

    /**
    * This method updates the highscore.
    *
    * @author Logan Engle
    */
    public void updateHighscore(int score) {
        if (highscore < score) {
            highscore = score;
        }
    }

    /**
    * This method returns the highscore.
    *
    * @author Logan Engle
    */   
    public int getHighscore() {
        return highscore;
    }

    /**
    * This method prints the highscore to the console.
    *
    * @author Logan Engle
    */
    public void showHighscore() {
        System.out.printf("%nYour high score is %d/10%n", highscore);
    }
}
