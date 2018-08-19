/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Amrit
 */
public class ReadQuestionsFile {
    private String[] options;
    private String answer;
    private String question;
    private String name;
    File f;
    FileReader fr;
    BufferedReader br;
    Scanner keyboard;
    Lifelines lifeline;
    private int moneyWon = 0;
    Questions quizQues;
    LeaderBoard leaderboard;

    public ReadQuestionsFile(String n) throws IOException {
        setName(n);
        this.answer = "";
        this.question = "";
        this.options = new String[4];
        
        f = new File("questions.txt");
        fr = new FileReader(f);
        br = new BufferedReader(fr);
        leaderboard = new LeaderBoard();
        keyboard = new Scanner(System.in);

    }

    public void setMoneyWon(int money) {
        this.moneyWon = money;
    }

    public int getMoneyWon() {
        return this.moneyWon;
    }

    public void getQuestions() throws IOException {
        quizQues = new Questions(this.question, this.options, this.answer);
        String userAnswer = "";
        String line;
        int questionNumber = 1;
        int limit = 5;
        int currentLine = 0;
        int count = 0;
        lifeline = new Lifelines();
        leaderboard.sortedBoard();
        
        while (questionNumber <= 22 && !userAnswer.equalsIgnoreCase("Q")) {
            while ((line = br.readLine()) != null && currentLine <= limit) {
                if (line.contains("?")) {
                    this.question = line;
                }
                if (line.contains(":")) {
                    this.options[count++] = line;
                }
                if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":")) {
                    this.answer = line;
                }
                currentLine++;
            }

            limit += 6;
            count = 0;
            quizQues.setQuestion(this.question);
            quizQues.setAnswer(this.answer);
            quizQues.setOptions(this.options);
            System.out.println(quizQues.toString());

            System.out.println("Would you like to use one of the life lines? If so, type \"YES\" else please type a LETTER to submit your answer or \"Q\" to quit the game.");
            userAnswer = keyboard.nextLine();
            if (!validUserInput(userAnswer)) {
                do {
                    System.out.println("Please enter a A,B,C,D or \"yes\" to access lifelines.");
                    userAnswer = keyboard.nextLine();
                } while (!validUserInput(userAnswer));
            }

            if (userAnswer.equalsIgnoreCase("Yes") || userAnswer.equalsIgnoreCase("Y")) {
                do {
                    useLifeLine(lifeline, quizQues, options, answer, question);
                System.out.println("Would you like to use one of the life lines? If so, type yes else please type a LETTER to submit your answer or Q to quit the game.");
                userAnswer = keyboard.nextLine();
                if (!validUserInput(userAnswer)) {
                    do {
                        System.out.println("Please enter a A,B,C,D or \"yes\" to access lifelines.\n");
                        userAnswer = keyboard.nextLine();
                    } while (!validUserInput(userAnswer));
                }
                }while (userAnswer.equalsIgnoreCase("yes"));
                

            }

            if (userAnswer.equalsIgnoreCase("Q")) {
                System.exit(0);
            }

            this.setMoneyWon(checkAnswer(userAnswer, answer, moneyWon));
            questionNumber++;

        }
        leaderboard.addToTheFile(this.name, this.getMoneyWon());
        br.close();
        fr.close();
    }

    public int checkAnswer(String userAnswer, String answer, int moneyWon) throws FileNotFoundException, IOException {

        if (userAnswer.equalsIgnoreCase(answer)) {
            if (moneyWon == 0) {
                moneyWon = 100;
            } else {
                moneyWon *= 2;
                if (moneyWon == 400 || this.moneyWon == 600) {
                    moneyWon -= 100;
                } else if (moneyWon == 128000) {
                    moneyWon -= 3000;
                }
            }
            System.out.println("Correct Answer! You've reached " + moneyWon + " dollars.\n"); //money
        } else {
            if (moneyWon >= 1000) {
                moneyWon = 1000;
            } else if (this.moneyWon >= 32000) {
                moneyWon = 32000;
            } else {
                moneyWon = 0;
            }
            System.out.println("Wrong Answer :(. The correct answer is " + answer + ". You are on " + moneyWon);
        }

        return moneyWon;
    }

    private void useLifeLine(Lifelines lifeline, Questions quizQues, String[] options, String answer, String question) {
        String chosenLifeLine = "";

        System.out.println("Type the related NUMBER to pick an option "
                + "\n1. 50:50"
                + "\n2. Phone a friend"
                + "\n3. Audience Vote");
        chosenLifeLine = keyboard.nextLine();
        if (!validLifeLineUserInput(chosenLifeLine)) {
            do {
                System.out.println("\nPlease choose 1, 2 or 3.");
                chosenLifeLine = keyboard.nextLine();
            } while (!validLifeLineUserInput(chosenLifeLine));
        }

        if (!chosenLifeLine.equalsIgnoreCase("Q")) {
            if (chosenLifeLine.equalsIgnoreCase("1")) {
                String[] resultedOption = lifeline.setFiftyFiftyOptions(options, answer, question);
                quizQues.setOptions(resultedOption);
                System.out.println(quizQues.toString());
            }
            if (chosenLifeLine.equalsIgnoreCase("2")) {
                lifeline.setPhoneAFriendOptions(options, answer, question);
                System.out.println(quizQues.toString());
            }
            if (chosenLifeLine.equalsIgnoreCase("3")) {
                quizQues.setOptions(lifeline.setAudienceVoteOptions(options, answer, question));
                System.out.println(quizQues.toString());
            }
        } else {
            System.exit(0);
        }

    }

    private boolean validUserInput(String userAnswer) {
        if (userAnswer.equalsIgnoreCase("Q") || userAnswer.equalsIgnoreCase("Yes")
                || userAnswer.equalsIgnoreCase("A") || userAnswer.equalsIgnoreCase("B")
                || userAnswer.equalsIgnoreCase("C") || userAnswer.equalsIgnoreCase("D")) {
            return true;
        }
        return false;
    }

    private boolean validLifeLineUserInput(String userChoice) {
        if (userChoice.equalsIgnoreCase("Q") || userChoice.equalsIgnoreCase("1")
                || userChoice.equalsIgnoreCase("2") || userChoice.equalsIgnoreCase("3")) {
            return true;
        }
        return false;
    }

    public void setName(String n) {
        this.name = n;
    }
    
    public String getName(){
       return this.name;
    }
}
