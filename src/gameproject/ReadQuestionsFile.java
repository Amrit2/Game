package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 *This class contains the functionalities related to reading the file and saving the questions in the object
 * @author Amritpal Kaur 14865526
 */
public class ReadQuestionsFile {
    // variable declarations
    private File f;
    private FileReader fr;
    private BufferedReader br;
    private String question = "";
    private String answer = ""; 
    private String[] options = new String[4];          // the options related to the question
   
    //create a map
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
     * This method reads the lines in the file and adds it to the hash map
     * @param hMap
     * @param quiz 
     */
    public void setQuizQuestions( Map<Integer, Questions> hMap){
        int quesNumber = 0;
        String line;
        int currentOption = 0;                                                          // array index of the options
         try {
                while ((line = br.readLine()) != null) {                                // keep the loop running until no text in the file
                    
                    if (line.contains("?")) {
                        
                        this.question = line;                                                          //store the question
                    }
                    if (line.contains(":")) {
                        this.options[currentOption++] = line;                                           // store all the options
                    }
                    if ((line.contains("A") || line.contains("B") || line.contains("C") || line.contains("D")) && !line.contains(":") && !line.contains("?")) {
                       this.answer = line;                                                                  // store the answer
                    }
                    
                    if (line.isEmpty()){
                        hMap.put(quesNumber, new Questions(this.question, this.options, this.answer));
                        quesNumber++;
                        currentOption = 0;
                    }
                    
                }

            } catch (IOException e) {
                System.out.println("Unable to read the questions.txt file");
            } catch (NullPointerException e){
                System.out.println("There is nothing in the file.");
            }
            
    }
}
