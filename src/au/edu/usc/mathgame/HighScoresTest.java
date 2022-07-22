package au.edu.usc.mathgame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * This class handles testing the HighScores class.
 *
 * @author Logan Engle
 */
public class HighScoresTest {

    @Test
    public void testHighscoreHigher() {
        HighScores testHighscore = new HighScores();
        int testScore = 2;
        testHighscore.updateHighscore(testScore);
        testScore = 5;
        testHighscore.updateHighscore(testScore);
        assertTrue(testHighscore.getHighscore() == 5);
    }

    @Test
    public void testHighscoreLower() {
        HighScores testHighscore = new HighScores();
        int testScore = 8;
        testHighscore.updateHighscore(testScore);
        testScore = 5;
        testHighscore.updateHighscore(testScore);
        assertTrue(testHighscore.getHighscore() == 8);
    }
}