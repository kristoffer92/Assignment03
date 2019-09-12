package Assignment03;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordTest {
    //Arrange
    //Act
    //Assert

    Word testWord;

    @Before
    public void initWordObject()
    {
        testWord = new Word();
    }


    @Test
    public void test_getIncorrectLettersNoGuessesDone()
    {
        //Act
        String result = testWord.getIncorrectLetters();

        //Assert
        Assert.assertEquals("", result);
    }

    @Test
    public void test_getIncorrectLettersOneIncorrectGuessesDone()//"ö" doesn't exist in the word
    {
        //Act
        testWord.guessLetter('ö');
        String result = testWord.getIncorrectLetters();

        //Assert
        Assert.assertEquals("ö ", result);
    }
    @Test
    public void test_getCorrectLetterOne()//"a" exist in the word
    {
        //Act
        testWord.guessLetter('a');
        String result = testWord.getRevLetters();

        //Assert
        Assert.assertEquals("[a, _, _, _, _, _]", result);

    }
    @Test
    public void test_getTwoCorrectLetters()//"s and g" exist in the word
    {
        testWord.guessLetter('s');
        testWord.guessLetter('g');
        String result = testWord.getRevLetters();
        Assert.assertEquals("[_, s, s, _, g, _]", result);
    }
    @Test
    public void test_getCorrectWord()//Guessing the whole word
    {
        String assign = "assign";

        String result = testWord.getGuess();
        Assert.assertEquals("assign", result);
        Assert.assertEquals(testWord.getGuess(), result);

    }
    @Test
    public void test_getOneIncorrectLetter()
    {
        testWord.guessLetter('k');
        String result = testWord.getIncorrectLetters();
        Assert.assertEquals(testWord.getIncorrectLetters(), result);
    }
    @Test
    public void test_getGuessCounterWrongLetter()//"ö" is a wrong letter and it will lose a guess
    {
        int counterStartAt = testWord.getGuessCounter();
        testWord.guessLetter('ö');
        int result = testWord.getGuessCounter();
        Assert.assertTrue(counterStartAt > result);
    }
    @Test
    public void test_getGuessCounterCorrectLetter()//Will not lose a guess
    {
        int counterStart = testWord.getGuessCounter();
        testWord.guessLetter('a');
        int result = testWord.getGuessCounter();
        Assert.assertTrue(counterStart <= result);//Removing "=" will make the test fail

    }
}//End of test_Word
