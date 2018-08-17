/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Amrit
 */
public class ReadQuestionsFile {

    File f = new File("questions.txt");
    FileReader fr = new FileReader(f);
    BufferedReader br = new BufferedReader(fr);
    Scanner keyboard = new Scanner(System.in);
    Lifelines lifeline = new Lifelines();
    private int moneyWon = 0;
    Questions quizQuestion;

    public ReadQuestionsFile(String name) throws IOException {
        String answer = "";
        String question = "";
        String[] options = new String[4];
        quizQuestion = new Questions();
        getQuestions(quizQuestion, answer, question, options);

        System.out.println("End of the Game! To restart do ....");
        br.close();
        fr.close();
    }

    public void setMoneyWon(int money) {
        this.moneyWon = money;
    }

    public int getMoneyWon() {
        return this.moneyWon;
    }

    private void getQuestions(Questions quizQues, String question, String answer, String[] options) throws IOException {
        String userAnswer = "";
        String line;
        int questionNumber = 1;

        int limit = 5;
        int currentLine = 0;
        int count = 0;

        while (!userAnswer.equalsIgnoreCase("Q")) {
            while (questionNumber <= 22) {

                while ((line = br.readLine()) != null && currentLine <= limit) {
                    if (line.contains("?")) {
                        question = line;
                    }
                    if (line.contains(":")) {
                        options[count++] = line;
                    }
                    if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":")) {
                        answer = line;
                    }
                    currentLine++;
                }

                limit += 6;
                count = 0;
                quizQues.setQuestion(question);
                quizQues.setAnswer(answer);
                quizQues.setOptions(options);
                System.out.println(quizQues.toString());

                System.out.println("Would you like to use one of the life lines? If so, type yes else please type a letter to submit your answer");
                userAnswer = keyboard.nextLine();

                if (userAnswer.equalsIgnoreCase("Yes")) {
                    do {
                        useLifeLine(lifeline, quizQues, options, answer, question);
                        System.out.println("Would you like to use one of the life lines? If so, type yes else please type a LETTER to submit your answer");
                        userAnswer = keyboard.nextLine();
                    } while (userAnswer.equalsIgnoreCase("Yes"));
                }

                this.setMoneyWon(checkAnswer(userAnswer, answer, moneyWon));
                questionNumber++;
            }
        }
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
        if (chosenLifeLine.equalsIgnoreCase("1")) {
            quizQues.setOptions(lifeline.setFiftyFiftyOptions(options, answer, question));
            lifeline.setUsedFifty(true);

            System.out.println(quizQues.toString());
        }
        if (chosenLifeLine.equalsIgnoreCase("2")) {
            lifeline.setPhoneAFriendOptions(options, answer, question);
            lifeline.setUsedCall(true);
            System.out.println(quizQues.toString());
        }
        if (chosenLifeLine.equalsIgnoreCase("3")) {
            quizQues.setOptions(lifeline.setAudienceVoteOptions(options, answer, question));
            lifeline.setUsedAudience(true);
            System.out.println(quizQues.toString());
        }
    }

}
