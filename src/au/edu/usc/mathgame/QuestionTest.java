package au.edu.usc.mathgame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This class handles testing the Question class.
 *
 * @author Logan Engle
 */
public class QuestionTest {
    Random rand = new Random();
    @Test 
    public void testAddition() {
        Question q = new Question(4, 3, "+");
        assertTrue(q.checkAnswer(7));
    }

    @Test
    public void testSubtraction() {
        Question q = new Question(4, 3, "-");
        assertTrue(q.checkAnswer(1));
    }

    @Test
    public void testMultiplication() {
        Question q = new Question(4, 3, "*");
        assertTrue(q.checkAnswer(12));
    }

    @Test
    public void testDivision() {
        Question q = new Question(12, 3, "/");
        assertTrue(q.checkAnswer(4));
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void out() {
        Question q = new Question(4, 3, "+");
        q.showQuestion();
        assertEquals("What is 4 + 3 = ", outContent.toString());
    } 
}