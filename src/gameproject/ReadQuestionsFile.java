package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *This class contains the functionalities related to reading the file and saving the questions in the object
 * @author Amritpal Kaur 14865526
 */
public class ReadQuestionsFile {
    // variable declarations
    File f;
    FileReader fr;
    BufferedReader br;
    String question = "";
    String answer = ""; 
    String[] options = new String[4];          // the options related to the question
    /**
     * Constructor instantiates the file, file reader and buffered reader
     */
    public ReadQuestionsFile(){
         try {
            f = new File("questions.txt");                                                           //instantiated a text file called questions
            fr = new FileReader(f);                                                                  // passing that file to the file reader
            br = new BufferedReader(fr);                                                            // passing it to the buffered reader for reading
         } catch (FileNotFoundException e) {
            System.out.println("The file questions.txt could not be found");
        }
    }
    
    /**
     * Sets and displays the quiz ques
     * @param quiz 
     */
    public void showQuizQues(Questions quiz){
        this.setQuestionsAndOptions();
        quiz.setOptions(this.options);
        quiz.setQuestion(this.question);
        quiz.setAnswer(this.answer);
        System.out.println(quiz.toString());                                 // print the ques and options
    }
    
    /**
     * This method reads the lines in the file to set the questions,options and answer accordingly
     * @param quiz 
     */
    public void setQuestionsAndOptions(){
        String line;
        
        int nextLineLimit = 5;                    // the number of lines in the text file after the question that need to be processed
        int currentLine = 0;
        int currentOption = 0;                     // array index of the options
         try {
                while ((line = br.readLine()) != null && currentLine <= nextLineLimit) {                // keep the loop running until no text in the file
                    if (line.contains("?")) {
                        
                        this.question = line;                                                          //store the question
                    }
                    if (line.contains(":")) {
                        this.options[currentOption++] = line;                                           // store all the options
                    }
                    if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":")) {
                       this.answer = line;                                                                  // store the answer
                    }
                    currentLine++;                                                              // increases to process the next line in the file
                                           
                }

            } catch (IOException e) {
                System.out.println("Unable to read the questions.txt file");
            } catch (NullPointerException e){
                System.out.println("There is nothing in the file.");
            }
            
            nextLineLimit += 6;                                                  // 4 options, an answer and a free line taken into account
            currentOption = 0;                                                   // reset the array index
          
    }
    
   
}
