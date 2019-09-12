package Assignment03;

import java.util.Arrays;
import java.util.Scanner;

public class Word {

    static Scanner scanner = new Scanner(System.in);

    private String assign;
    private StringBuilder incorrect;
    private char[] revLetters;//CharArray for letters
    int guessCounter = 8;

    public Word() {
        assign = "assign";
        incorrect = new StringBuilder();
        revLetters = new char[assign.length()];
        Arrays.fill(revLetters, '_');
    }//End of Word

    public void makeMain() {
        System.out.println("--------------------Hangman--------------------");
        System.out.println("------------------Information------------------");
        System.out.println("You win by guessing the whole word correctly, guessing the wrong word will make you lose!\nYou guess by writing a letter, you can also guess the word itself!");
        System.out.println("The Secretword contains 6 letters!");
        System.out.println("You have 8 guesses to make it, good luck!");
        System.out.println("-----------------------------------------------");
    }//End of makeMain

    public void guess() {

        System.out.println("Make an option:\n1. Play Hangman\n2. Quit");
        int loop = -1;
        loop = scanner.nextInt();
        boolean loopSwitch = true;
        while (loopSwitch) {
            switch (loop) {
                case 1:
                    makeGuess();
                    break;
                case 2:
                    System.out.println("You decided to quit!");
                    loopSwitch = false;
                    break;
                default:
                    System.out.println("Error");
            }
            return;
        }
        return;
    }//End of guess

    public void makeGuess() {


        boolean winsFails = true;
        while(winsFails && guessCounter > 0){


            System.out.println("\nYou have " + guessCounter + " more guesses: ");
            for (char x : revLetters ) {
                System.out.print(x + " ");
            }//End of the forLoop

            System.out.println("\nIncorrect letters so far: " +incorrect);

            System.out.print("\nWrite your guess: ");

            String Guess = scanner.next();
            int guessLength = Guess.length();

            if (guessLength > 1) {//Checking for the whole word
                System.out.println("You guessed the word: " + " " + Guess);
                if (Guess.equals(assign)) {
                    System.out.println("Correct word: "+assign+"\nThe incorrect letters you used was: "+incorrect+"\n----------------You Won----------------\n-----You guessed the correct word!-----");
                    winsFails = false;

                } else {
                    System.out.println("You failed to guess the word, game over!");
                    winsFails = false;
                }//End of else
            }//End of If-statement



            else {//Checking for the letter
                //You have 7 more guesses:
                guessLetter(Guess.charAt(0));

                if (winsFails)
                {
                    winsFails = checkWin();
                }
            }//End of else
        }//End of while
    }//End of makeGuess


    private boolean isNewLetter(boolean[] Guess) {
        for (boolean name : Guess){
            if(name){
                return true;
            }
        }
        return false;
    }//End of isNewLetter

    private boolean checkWin() {
        for (char letter : revLetters) {
            if (letter == '_')
            {
                return true;
            }
        }
        return false;
    }//End of checkWin

    public void guessLetter(char letter) {
        boolean foundLetter[] = new boolean[assign.length()];
        for (int i = 0; i < assign.length(); i++) {
            if (assign.charAt(i) == letter) {
                revLetters[i] = letter;
                foundLetter[i] = true;
            }
        }
        if (isNewLetter(foundLetter)) {//Letter exist within the word
            System.out.println("\nThe letter "+letter+ " is in the word!");

        }
        else{//Letter doesn't exist within the word (No repeated letters)
            if(incorrect.indexOf(String.valueOf(letter)) >= 0)
            {
                System.out.println("You already tried the letter: "+letter);
            }
            else {//Letter doesn't exist within the word (lose a guess)
                guessCounter--;
                incorrect.append(letter).append(' ');
                System.out.println("\nThe letter " +letter+ " is not within the word!");
            }
        }
    }//End of guessLetter

    public String getIncorrectLetters()
    {
        return incorrect.toString();
    }

    public String getRevLetters()
    {
        return Arrays.toString(revLetters);
    }

    public int getGuessCounter()
    {
        return guessCounter;
    }
    public String getGuess(){
        return assign;
    }
}//End of Word