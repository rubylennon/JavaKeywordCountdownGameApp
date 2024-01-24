/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdowngame;
/*
 *CountdownApp.java
 *@Author: Ruby Lennon
 *Student Number: x19128355
 *2nd April 2020
 */

//keyboards Import
import javax.swing.JOptionPane;
import java.util.Scanner;

//main Class
public class CountdownApp{
	public static void main(String args[]){
		//declare variables used in main class
		int rounds;
		int vowelsTotal, consonantsTotal;
		int lettersTotal;
		String randomLettersCombined;
		String answerOne, answerTwo;
		String roundWinner;
		int gameScoreOne, gameScoreTwo;
		String gameWinner;
		String playAgain = "";

		//declare variables used in instantiable class processes to print in main class for testing purposes
		int roundScoreOne, roundScoreTwo;
		int validGuessScoreOne, validGuessScoreTwo;
		boolean validGuessOneBool, validGuessTwoBool;
		int letterCheckerOne, letterCheckerTwo;
		int doubleLetterCheckerOne, doubleLetterCheckerTwo;
		int randomDoubleLetterCheckerOne, randomDoubleLetterCheckerTwo;
		boolean correctLettersOne, correctLettersTwo;
		boolean correctDoubleLettersOne, correctDoubleLettersTwo;

		//declare objects
		Scanner keyboard;
		Countdown myCountdown;

		//create objects
		keyboard = new Scanner(System.in);
		myCountdown = new Countdown();

		//welcome message - appears at start of game
		JOptionPane.showMessageDialog(null,
		"Welcome to Java Keyword Countdown!"
		+ "\n"
		+ "\n" + "Game Objective:"
		+ "\n" + "The goal of the game is to try and make a java"
		+ "\n" + "keyword using as many of the randomly generated"
		+ "\n" + "letters as you can. This is a two player game."
		+ "\n"
		+ "\n" + "How to play:"
		+ "\n" + "1.  Enter how many rounds you want to play."
		+ "\n" + "2.  Enter a total of 9 vowels and consonants."
		+ "\n" + "3.  Each player enters their answer in turn."
		+ "\n" + "4.  N.B. You can only use each letter once."
		+ "\n" + "5.  A point will be rewarded in each round to the"
		+ "\n" + "player who enters the longest valid keyword."
		+ "\n"
		+ "\n" + "Good luck!");

		//play game again do while loop
		do{
                    //Process - Game score resetter & valid guess boolean resetter
                    myCountdown.gameScoreResetter();

                    //user inputs total rounds they want to play in game
                    rounds = Integer.parseInt(JOptionPane.showInputDialog(null,"How many rounds do you want to play?"));

                    //loop - rounds
                    for(int i=0; i<rounds; i=i+1){

                            //message asking user to input a total of 9 vowels and consonants
                            JOptionPane.showMessageDialog(null,"Please choose a combination of 9 vowels and consonants.");

                            //do while loop for input of letters by user
                            do {
                                    //input - vowels total
                                    vowelsTotal = Integer.parseInt(JOptionPane.showInputDialog(null,"How many vowels?"));
                                    myCountdown.setVowelsTotal(vowelsTotal);

                                    //input - consonants total
                                    consonantsTotal = Integer.parseInt(JOptionPane.showInputDialog(null,"How many consonants?"));
                                    myCountdown.setConsonantsTotal(consonantsTotal);

                                    //process - random letter generator based on total vowels & consonants chosen by user
                                    myCountdown.randomLettersGenerator();

                                    //gets letters total input by user to check if they chose the correct total of 9 letters or not
                                    lettersTotal = myCountdown.getLettersTotal();

                                    //checks correct number of letters is chosen by user
                                    if (lettersTotal == 9){
                                            //correct total of 9 vowels and consonants chosen
                                            JOptionPane.showMessageDialog(null,"You've chosen " + lettersTotal + " letters.");
                                    } else {
                                            //incorrect total of vowels and consonants chosen
                                            JOptionPane.showMessageDialog(null,"You've chosen " + lettersTotal + " letters, please choose 9 letters.");

                                            //process - reset the strings if incorrect total of letters are selected
                                            myCountdown.stringResetter();
                                    }
                            }

                            //asks users to select correct number of letters again if the total does not equal 9
                            while (lettersTotal != 9);{

                                    //ouput - randomly generated letters getter
                                    randomLettersCombined = myCountdown.getRandomLettersCombined();

                                    //player 1 - answer input
                                    answerOne = JOptionPane.showInputDialog(null,"Please see your letter combinations below:" + "\n" +
                                    "\n" + "Letters: " + randomLettersCombined + "\n" + "\n" +
                                    "Player 1 - Please give you answer (Type X to pass)");
                                    //player 1 - answer setter
                                    myCountdown.setAnswerOne(answerOne);

                                    //player 2 - answer input
                                    answerTwo = JOptionPane.showInputDialog(null,"Please see your letter combinations below:" + "\n" +
                                    "\n" + "Letters: " + randomLettersCombined + "\n" + "\n" +
                                    "Player 2 - Please give you answer (Type X to pass)");
                                    //player 2 - answer setter
                                    myCountdown.setAnswerTwo(answerTwo);

                                    //process - answer checker (Validity checker & Word Score calculator)
                                    myCountdown.answerChecker();

                                            /*

                                            //code used for testing the application

                                            //player 1 test code

                                            //outputs player 1 answer
                                            System.out.println("\n" + "Player 1 answer - " + answerOne);

                                            //outputs score awarded to player 1 if correct keyword is used
                                            validGuessScoreOne = myCountdown.getValidGuessScoreOne();
                                            System.out.println("Valid Answer Score: " + validGuessScoreOne);

                                            //outputs true/false value if player 1 answer is valid based on all required conditions
                                            validGuessOneBool = myCountdown.getValidGuessOneBool();
                                            System.out.println("Is valid answer: " + validGuessOneBool);

                                            //outputs player 1 round score (based on total letters used if answer is valid)
                                            roundScoreOne = myCountdown.getRoundScoreOne();
                                            System.out.println("Player 1 score: " + roundScoreOne);

                                            //outputs score based on how many correct letters player 1 uses
                                            letterCheckerOne = myCountdown.getLetterCheckerOne();
                                            System.out.println("Letter Checker Score: " + letterCheckerOne);

                                            //outputs score based on player 1 using letters correct amount of times
                                            doubleLetterCheckerOne = myCountdown.getDoubleLetterCheckerOne();
                                            System.out.println("Answer Double Letter Checker Score: " + doubleLetterCheckerOne);

                                            //outputs score based on player 1 using letters correct amount of times
                                            randomDoubleLetterCheckerOne = myCountdown.getRandomDoubleLetterCheckerOne();
                                            System.out.println("Random Double Letter Checker Score: " + randomDoubleLetterCheckerOne);

                                            //outputs true/false value based on if player 1 used letters correct amount of times
                                            correctDoubleLettersOne = myCountdown.getCorrectDoubleLettersOne();
                                            System.out.println("Correct Double letters used: " + correctDoubleLettersOne);

                                            //ouputs true/false value based on player 1 using correct letters
                                            correctLettersOne = myCountdown.getCorrectLettersOne();
                                            System.out.println("Correct letters used: " + correctLettersOne);

                                            //outputs player 1's cumulative game score
                                            gameScoreOne = myCountdown.getGameScoreOne();
                                            System.out.println("Game Score: " + gameScoreOne);

                                            //player 2 test code

                                            //outputs player 2 answer
                                            System.out.println("\n" + "Player 2 answer - " + answerTwo);

                                            //outputs score awarded to player 2 if correct keyword is used
                                            validGuessScoreTwo = myCountdown.getValidGuessScoreTwo();
                                            System.out.println("Valid Answer Score: " + validGuessScoreTwo);

                                            //outputs true/false value if player 2 answer is valid based on all required conditions
                                            validGuessTwoBool = myCountdown.getValidGuessTwoBool();
                                            System.out.println("Is valid answer: " + validGuessTwoBool);

                                            //outputs player 2 round score (based on total letters used if answer is valid)
                                            roundScoreTwo = myCountdown.getRoundScoreTwo();
                                            System.out.println("Player 2 score: " + roundScoreTwo);

                                            //outputs score based on how many correct letters player 2 uses
                                            letterCheckerTwo = myCountdown.getLetterCheckerTwo();
                                            System.out.println("Letter Checker Score: " + letterCheckerTwo);

                                            //outputs score based on player 2 using letters correct amount of times
                                            doubleLetterCheckerTwo = myCountdown.getDoubleLetterCheckerTwo();
                                            System.out.println("Answer Double Letter Checker Score: " + doubleLetterCheckerTwo);

                                            //outputs score based on player 2 using letters correct amount of times
                                            randomDoubleLetterCheckerTwo = myCountdown.getRandomDoubleLetterCheckerTwo();
                                            System.out.println("Random Double Letter Checker Score: " + randomDoubleLetterCheckerTwo);

                                            //outputs true/false value based on player 2 using letters correct amount of times
                                            correctDoubleLettersTwo = myCountdown.getCorrectDoubleLettersTwo();
                                            System.out.println("Correct Double letters used: " + correctDoubleLettersTwo);

                                            //ouputs true/false value based on player 2 using correct letters
                                            correctLettersTwo = myCountdown.getCorrectLettersTwo();
                                            System.out.println("Correct letters used: " + correctLettersTwo);

                                            //outputs player 2's cumulative game score
                                            gameScoreTwo = myCountdown.getGameScoreTwo();
                                            System.out.println("Game Score: " + gameScoreTwo);

                                            */

                                    //round winner announced
                                    roundWinner = myCountdown.getRoundWinner();
                                    JOptionPane.showMessageDialog(null, roundWinner);

                                    //process - resets round score & valid guess boolean values
                                    myCountdown.roundScoreResetter();

                                    //process - resets the strings (e.g. vowel string, consonant string, random letters combined strings etc.)
                                    myCountdown.stringResetter();
                            }
                    }
		//process - calculates who the winner of the game is
		myCountdown.winnerCompute();

		//score totals displayed & game winner announced
		gameScoreOne = myCountdown.getGameScoreOne();
		gameScoreTwo = myCountdown.getGameScoreTwo();
		gameWinner = myCountdown.getGameWinner();
		JOptionPane.showMessageDialog(null,"Game Score Totals: " + "\n" + "\n" +
		"Player 1:   " + gameScoreOne + "\n" +
		"Player 2:   " + gameScoreTwo +
		"\n" + "\n" + gameWinner);

		//input - ask user if they want to play again
		playAgain = JOptionPane.showInputDialog(null, "Type yes to play again.");
		//play game again if playAgain value equals yes
		}while (playAgain.equalsIgnoreCase("yes"));

		//out of loops - game ends
		JOptionPane.showMessageDialog(null, "Thanks for playing!");
	}
}