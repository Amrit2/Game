package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *This class contains the functionalities related to reading the file and saving the questions in the object
 * @author Amritpal Kaur 14865526
 */
public class ReadQuestionsFile {
    // variable declarations
    File f;
    FileReader fr;
    BufferedReader br;
    
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
     * This method reads the lines in the file to set the questions,options and answers
     * @param quiz 
     */
    public void getQuestionsAndOptions(Questions quiz){
        String line;
        String question = "";
        String answer = ""; 
        String[] options = new String[4];          // the options related to the question 
        int nextLineLimit = 5;                    // the number of lines in the text file after the question that need to be processed
        int currentLine = 0;
        int currentOption = 0;                     // array index of the options
         try {
                while ((line = br.readLine()) != null && currentLine <= nextLineLimit) {                // keep the loop running until no text in the file
                    if (line.contains("?")) {
                        question = line;                                                          //store the question
                    }
                    if (line.contains(":")) {
                        options[currentOption++] = line;                                           // store all the options
                    }
                    if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":")) {
                       answer = line;                                                                  // store the answer
                    }
                    currentLine++;                                                              // increases to process the next line in the file
                                           
                }

            } catch (IOException e) {
                System.out.println("Unable to read the questions.txt file");
            } catch (NullPointerException e){
                System.out.println("There is nothing in the file.");
            }
         
            // store it in the questions object
            quiz.setOptions(options);
            quiz.setQuestion(question);
            quiz.setAnswer(answer);
            System.out.println(quiz.toString());                                 // print the ques and options
            
            nextLineLimit += 6;                                                  // 4 options, an answer and a free line taken into account
            currentOption = 0;                                                   // reset the array index
          
    }
}
