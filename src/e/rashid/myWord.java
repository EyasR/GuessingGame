/* 
 * CS211 Assignment 03 (Word Guessing Game)
 * Eyas Rashid - rashid_e@hotmail.com
 * Student ID: 985 762 980
 * 2018.05.11 - Spring Quarter
 *
 *This program is a game that produces a shuffled word
 *for the user to answer.  The program tracks the amount of time it
 *takes for each response and if the user got the answer correct or not
 *then produces information based on the game instance. (how many correct answers
 *
 */
package e.rashid;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
 
public class myWord {
	
	 static Scanner console = new Scanner(System.in);
	 
    public static void main(String[] args) throws FileNotFoundException {
        
    	// keeps track of correctly answered questions.
        int correctAnswerCount = 0;
        // keeps track of the total time spent answer questions in an instance.
        double totalTimeCounter = 0;
        // this variable determines how many words the user is asked to solve.
        int howManyTimes = 0;

        gameInstance(totalTimeCounter, howManyTimes, correctAnswerCount);
        

    }
    //this method displays all of the information collected from the game instance.
    // the overall response time, average response time and number of words correctly guessed.
   
    public static void gameOver (double totalTimeCounter, int howManyTimes, int correctAnswerCount) {
    	
    	double averageResponseTime = totalTimeCounter / howManyTimes / 1000.0;
    	System.out.println("Game Over");
    	System.out.println("Your Overall Response Time: " + totalTimeCounter / 1000.0 + " seconds");
        System.out.printf("Your Average Response Time: %.3f seconds", averageResponseTime );
        System.out.println();
        System.out.println("you got " + correctAnswerCount + " out of " + howManyTimes +" correct!");
    
    }
    
    //this method runs an instance of the game.
    public static void gameInstance(double totalTimeCounter, int howManyTimes, int correctAnswerCount) throws FileNotFoundException {
       
    	Word211 word = new Word211();
        word.readFile("fruit.txt");
        // asks user to select a number of words to try and figure out
    	System.out.println("How many scrambbled words would you like to try and figure out?");
         howManyTimes = console.nextInt();
        
        //this for loop runs however many times the user has selected
        // it will generate a shuffled word and present it to the user
        // while tracking the time spent answering each question
        for (int i = 1; i <= howManyTimes; i++) {
            HashMap<String, String> w = word.getNextWord();
            for (String q : w.keySet()) {
                String question = q;
                String answer = w.get(question);
                
                double startTime = System.currentTimeMillis();
                System.out.println("Can you guess what word this is?");
                System.out.println(question);
 
                String userAnswer = console.next();
 
                //if the answer to the shuffled word is not correct this statement will execute
                // it will inform the user that the answer is wrong, tell them the correct answer,
                // and tell them how long it took them to respond with a wrong answer.
                if (!userAnswer.equalsIgnoreCase(answer)) {
                	double endTime = System.currentTimeMillis();
                	double totalTime = endTime - startTime;
                	totalTimeCounter += totalTime;
                	System.out.println("Wrong Answer");
                    System.out.println("The correct word is: " + answer);
                    System.out.println("Response Time: " + totalTime / 1000.0 + " sec");
                    System.out.println();
 
                //if the answer to the shuffled word is correct this statement will execute
                // it will inform the user that the answer is correct,
                // and tell them how long it took them to respond with a wrong answer.
                } else {
                	double endTime = System.currentTimeMillis();
                	double totalTime = endTime - startTime;
                	System.out.println("correct!!");
                	System.out.println("Response Time: " + totalTime / 1000.0 + " seconds");
                	System.out.println();
                    correctAnswerCount++;
                    totalTimeCounter += totalTime;
                }
 
            }
           
        } 
        gameOver(totalTimeCounter, howManyTimes, correctAnswerCount);
    }
}
