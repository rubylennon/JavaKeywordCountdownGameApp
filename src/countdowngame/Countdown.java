/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdowngame;
/*
 *Countdown.java
 *@Author: Ruby Lennon
 *Student Number: x19128355
 *2nd April 2020
 */

import java.util.Random;

public class Countdown{
	//data members
	private int vowelsTotal, consonantsTotal;
	private int lettersTotal;
	private String vowels = "aeoiu";
	//letter 'Z' excluded from consonant array due to keyword "synchronized" being removed as it contains more than 9 letters
	//letter 'J' excluded from consonant array due to none of the keywords containing the letter J
	private String consonants = "bcdfghklmnoqrtvwxy";
	private String randomVowels, randomConsonants;
	private String randomLettersCombined;
	private String answerOne, answerTwo;
	private int validGuessScoreOne, validGuessScoreTwo;
	private boolean validGuessOneBool, validGuessTwoBool;
	private int letterCheckerOne, letterCheckerTwo;
	private int doubleLetterCheckerOne, doubleLetterCheckerTwo;
	private int randomDoubleLetterCheckerOne, randomDoubleLetterCheckerTwo;
	private boolean correctLettersOne, correctLettersTwo;
	private boolean correctDoubleLettersOne, correctDoubleLettersTwo;
	private int roundScoreOne, roundScoreTwo;
	private int gameScoreOne, gameScoreTwo;
	private String roundWinner, gameWinner;
	//"implements" / "instanceof" /  "synchronized" keywords excluded from java keyword array
	// as they contain more than 9 letters and are therefore invalid answers
	private String[] javaKeywords = {"abstract", "assert", "boolean", "break",
	"byte", "case", "catch", "char", "class", "continue", "default", "do", "double",
	"else", "enum", "extends", "final", "finally", "float", "for", "if",
	"import", "int", "interface", "long", "native", "new", "package",
	"private", "protected", "public", "return", "short", "static", "strictfp", "super",
	"switch", "this", "throw", "throws", "transient", "try", "void", "volatile", "while" };

	//create objects
	Random rand = new Random();

	//constructor
	public Countdown(){
		consonantsTotal = 0;
		vowelsTotal = 0;
		lettersTotal = 0;
		randomVowels = "";
		randomConsonants = "";
		randomLettersCombined = "";
		validGuessScoreOne = 0;
		validGuessScoreTwo = 0;
		letterCheckerOne = 0;
		letterCheckerTwo = 0;
		doubleLetterCheckerOne = 0;
		doubleLetterCheckerTwo = 0;
		randomDoubleLetterCheckerOne = 0;
		randomDoubleLetterCheckerTwo = 0;
		roundScoreOne = 0;
		roundScoreTwo = 0;
		roundWinner = "";
		gameScoreOne = 0;
		gameScoreTwo = 0;
		gameWinner = "";
		correctDoubleLettersOne = true;
		correctDoubleLettersTwo = true;
	}

	//set method - vowel total input by user
	public void setVowelsTotal(int vowelsTotal){
		this.vowelsTotal = vowelsTotal;
	}

	//set method - consonant total input by user
	public void setConsonantsTotal(int consonantsTotal){
		this.consonantsTotal = consonantsTotal;
	}

	//set method - player 1 answer input
	public void setAnswerOne(String answerOne){
		this.answerOne = answerOne;
	}

	//set method - player 2 answer input
	public void setAnswerTwo(String answerTwo){
		this.answerTwo = answerTwo;
	}

	//process - Game Score Resetter - resets game scores to zero when game restarts
	public void gameScoreResetter(){
		gameScoreOne = 0;
		gameScoreTwo = 0;
		gameWinner = "";
	}

	//process - random Letters Generator
	public void randomLettersGenerator(){

		//adds total vowels and consonant totals input by user
		lettersTotal = consonantsTotal + vowelsTotal;

		//generates random string of vowels
		char[] text1 = new char[vowelsTotal];

		for(int i = 0; i < vowelsTotal; i++){
			text1[i] = vowels.charAt(rand.nextInt(vowels.length()));
		}

		for (int i = 0; i < text1.length; i++){
			randomVowels += text1[i];
		}

		//generates random string of consonants
		char[] text2 = new char[consonantsTotal];

			for(int j = 0; j < consonantsTotal; j++){
				text2[j] = consonants.charAt(rand.nextInt(consonants.length()));
			}

			for (int j = 0; j < text2.length; j++){
				randomConsonants += text2[j];
			}

		//combines the random vowel & consonant strings together into one string
		randomLettersCombined = randomVowels + randomConsonants;
	}

	//process - string resetter - resetting the strings to blank
	public void stringResetter(){
		randomVowels = "";
		randomConsonants = "";
		randomLettersCombined = "";
		roundWinner = "";
	}

	//process - round score resetter - resets the round scores & the valid guess values
	public void roundScoreResetter(){
		//resets word scores to zero
		roundScoreOne = 0;
		roundScoreTwo = 0;

		//resets valid guess scores to zero
		validGuessScoreOne = 0;
		validGuessScoreTwo = 0;

		//resets boolean values to default value of true/false
		validGuessOneBool = false;
		validGuessTwoBool = false;
		correctLettersOne = false;
		correctLettersTwo = false;
		correctDoubleLettersOne = true;
		correctDoubleLettersTwo = true;

		//resets valid letter scores to zero
		letterCheckerOne = 0;
		letterCheckerTwo = 0;
		doubleLetterCheckerOne = 0;
		doubleLetterCheckerTwo = 0;
		randomDoubleLetterCheckerOne = 0;
		randomDoubleLetterCheckerTwo = 0;
	}

	//process - answer checker - word and round score generator - word/letter validity checker
	public void answerChecker(){

		//checks if player 1 answer is a valid java keyword
		for(int i = 0; i < 45; i++){
			if(answerOne.equalsIgnoreCase(javaKeywords[i])){
				validGuessScoreOne++;
				roundScoreOne = answerOne.length();
				}
			}

		//checks if player 2 answer is a valid java keyword
		for(int j = 0; j < 45; j++){
			if(answerTwo.equalsIgnoreCase(javaKeywords[j])){
				validGuessScoreTwo++;
				roundScoreTwo = answerTwo.length();
				}
			}

		//checks if answer 1 contains correct random letters
		for(int i = 0;i < answerOne.length();i = i +1){
			if(answerOne.charAt(i)==randomLettersCombined.charAt(0)
			||answerOne.charAt(i)==randomLettersCombined.charAt(1)
			||answerOne.charAt(i)==randomLettersCombined.charAt(2)
			||answerOne.charAt(i)==randomLettersCombined.charAt(3)
			||answerOne.charAt(i)==randomLettersCombined.charAt(4)
			||answerOne.charAt(i)==randomLettersCombined.charAt(5)
			||answerOne.charAt(i)==randomLettersCombined.charAt(6)
			||answerOne.charAt(i)==randomLettersCombined.charAt(7)
			||answerOne.charAt(i)==randomLettersCombined.charAt(8)){
				letterCheckerOne++;
				}
			}

		//checks if answer 2 contains correct random letters
		for(int i = 0;i < answerTwo.length();i = i +1){
			if(answerTwo.charAt(i)==randomLettersCombined.charAt(0)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(1)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(2)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(3)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(4)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(5)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(6)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(7)
			||answerTwo.charAt(i)==randomLettersCombined.charAt(8)){
				letterCheckerTwo++;
				}
			}

		//sets boolean true/false value for use of valid letters in answer 1
		if(letterCheckerOne == answerOne.length()){
			correctLettersOne = true;
		}

		//sets boolean true/false value for use of valid letters in answer 2
		if(letterCheckerTwo == answerTwo.length()){
			correctLettersTwo = true;
		}

		//below code checks if players used letters correct amount of times for keywords that contain the same letter more than once
		//java keywords which contain duplicate letters: "abstract", "assert", "boolean", "catch", "class", "else", "extends",
		//"finally", "interface", "package", "protected", "static", "strictfp", "transient", "volatile"

		//KEYWORD (REPEATING LETTER)

		//abstract (A , T)
		//player 1 check
		if(answerOne.equalsIgnoreCase("abstract")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='a')
				||(answerOne.charAt(i)=='t')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='a')
				||(randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("abstract")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='a')
				||(answerTwo.charAt(i)=='t')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='a')
				||(randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//assert (S)
		//player 1 check
		if(answerOne.equalsIgnoreCase("assert")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='s')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='s')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("assert")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='s')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='s')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//boolean (O)
		//player 1 check
		if(answerOne.equalsIgnoreCase("boolean")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='o')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='o')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("boolean")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='o')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='o')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//catch (C)
		//player 1 check
		if(answerOne.equalsIgnoreCase("catch")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='c')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='c')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("catch")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='c')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='c')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//class (S)
		//player 1 check
		if(answerOne.equalsIgnoreCase("class")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='s')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='s')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("class")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='s')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='s')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//else (E)
		//player 1 check
		if(answerOne.equalsIgnoreCase("else")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='e')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("else")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='e')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//extends (E)
		//player 1 check
		if(answerOne.equalsIgnoreCase("extends")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='e')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("extends")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='e')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//finally (l)
		//player 1 check
		if(answerOne.equalsIgnoreCase("finally")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='l')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='l')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("finally")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='l')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='l')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//interface (E)
		//player 1 check
		if(answerOne.equalsIgnoreCase("interface")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='e')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("interface")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='e')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//package (a)
		//player 1 check
		if(answerOne.equalsIgnoreCase("package")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='a')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='a')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("package")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='a')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='a')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//protected (E , T)
		//player 1 check
		if(answerOne.equalsIgnoreCase("protected")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='e')
				||(answerOne.charAt(i)=='t')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')
				||(randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("protected")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='e')
				||(answerTwo.charAt(i)=='t')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='e')
				||(randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//static (T)
		//player 1 check
		if(answerOne.equalsIgnoreCase("static")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='t')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("static")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='t')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//strictfp (T)
		//player 1 check
		if(answerOne.equalsIgnoreCase("strictfp")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='t')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("strictfp")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='t')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//transient (T)
		//player 1 check
		if(answerOne.equalsIgnoreCase("transient")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='t')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("transient")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='t')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='t')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//volatile (T)
		//player 1 check
		if(answerOne.equalsIgnoreCase("volatile")){
			//checks player 1 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerOne.length();i = i +1){
				if((answerOne.charAt(i)=='l')){
					doubleLetterCheckerOne++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='l')){
					randomDoubleLetterCheckerOne++;
					}
				}
			}

		//player 2 check
		if(answerTwo.equalsIgnoreCase("volatile")){
			//checks player 2 answer and counts the amount of times the repeating letter appears
			for(int i = 0;i < answerTwo.length();i = i +1){
				if((answerTwo.charAt(i)=='l')){
					doubleLetterCheckerTwo++;
					}
				}
			//checks random letter string and counts the amount of times the repeating letter appears
			for(int i = 0;i < randomLettersCombined.length();i = i +1){
				if((randomLettersCombined.charAt(i)=='l')){
					randomDoubleLetterCheckerTwo++;
					}
				}
			}

		//player 1 - compares double letter checker values - sets correct double letters used boolean value
		if(doubleLetterCheckerOne > randomDoubleLetterCheckerOne){
			correctDoubleLettersOne = false;
		}

		//player 2 - compares double letter checker values - sets correct double letters used boolean value
		if(doubleLetterCheckerTwo > randomDoubleLetterCheckerTwo){
			correctDoubleLettersTwo = false;
		}

		//sets boolean 'ValidGuessOneBool' to true/false value for player answer/guess if all required conditions are met
		if(validGuessScoreOne >= 1 && correctLettersOne == true && correctDoubleLettersOne == true){
			validGuessOneBool = true;
		}

		//sets boolean 'ValidGuessTwoBool' to true/false value for player answer/guess if all required conditions are met
		if(validGuessScoreTwo >= 1 && correctLettersTwo == true && correctDoubleLettersTwo == true){
			validGuessTwoBool = true;
		}

		//calculates who the winner of the round is & updates game score each round
		if(validGuessOneBool == true && validGuessTwoBool == false){
			roundWinner = "Player 1 has won this round!";
			gameScoreOne++;
		} else if(validGuessOneBool == false && validGuessTwoBool == true){
			roundWinner = "Player 2 has won this round!";
			gameScoreTwo++;
		} else if((validGuessOneBool == true && validGuessTwoBool == true) && (roundScoreOne == roundScoreTwo)){
			roundWinner = "It's a tie!";
			gameScoreOne++;
			gameScoreTwo++;
		} else if((validGuessOneBool == true && validGuessTwoBool == true) && (roundScoreOne > roundScoreTwo)){
			roundWinner = "Player 1 has won this round!";
			gameScoreOne++;
		} else if((validGuessOneBool == true && validGuessTwoBool == true) && (roundScoreOne < roundScoreTwo)){
			roundWinner = "Player 2 has won this round!";
			gameScoreTwo++;
		} else {
			roundWinner = "There are no winners in this round.";
		}
	}

	//winner - process - gameWinner String computer
	public void winnerCompute(){
			//calculates who the winner of the game is
			if(gameScoreOne > gameScoreTwo){
				gameWinner = "Player 1 has won the game!";
			} else if(gameScoreOne < gameScoreTwo){
				gameWinner = "Player 2 has won the game!";
			} else if((gameScoreOne == gameScoreTwo) && (gameScoreOne + gameScoreTwo) != 0){
				gameWinner = "It's a tie!";
			} else if((gameScoreOne + gameScoreTwo) == 1){
				gameWinner = "There are no game winners!";
			} else {
				gameWinner = "There are no winners.";
		}
	}

	//get methods - one for every output
	public String getRandomVowels(){
		return randomVowels;
	}

	public String getRandomConsonants(){
		return randomConsonants;
	}

	public String getRandomLettersCombined(){
		return randomLettersCombined;
	}

	public int getLettersTotal(){
		return lettersTotal;
	}

	public int getRoundScoreOne(){
		return roundScoreOne;
	}

	public int getRoundScoreTwo(){
		return roundScoreTwo;
	}

	public int getValidGuessScoreOne(){
		return validGuessScoreOne;
	}

	public int getValidGuessScoreTwo(){
		return validGuessScoreTwo;
	}

	public boolean getValidGuessOneBool(){
		return validGuessOneBool;
	}

	public boolean getValidGuessTwoBool(){
		return validGuessTwoBool;
	}

	public String getRoundWinner(){
		return roundWinner;
	}

	public int getLetterCheckerOne(){
		return letterCheckerOne;
	}

	public int getLetterCheckerTwo(){
		return letterCheckerTwo;
	}

	public int getDoubleLetterCheckerOne(){
		return doubleLetterCheckerOne;
	}

	public int getDoubleLetterCheckerTwo(){
		return doubleLetterCheckerTwo;
	}

	public int getRandomDoubleLetterCheckerOne(){
		return randomDoubleLetterCheckerOne;
	}

	public int getRandomDoubleLetterCheckerTwo(){
		return randomDoubleLetterCheckerTwo;
	}

	public boolean getCorrectLettersOne(){
		return correctLettersOne;
	}

	public boolean getCorrectLettersTwo(){
		return correctLettersTwo;
	}

	public boolean getCorrectDoubleLettersOne(){
		return correctDoubleLettersOne;
	}

	public boolean getCorrectDoubleLettersTwo(){
		return correctDoubleLettersTwo;
	}

	public int getGameScoreOne(){
		return gameScoreOne;
	}

	public int getGameScoreTwo(){
		return gameScoreTwo;
	}

	public String getGameWinner(){
		return gameWinner;
	}
}