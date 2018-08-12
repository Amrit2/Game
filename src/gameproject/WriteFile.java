/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Amrit
 */
public class WriteFile {

    FileOutputStream userFile;
    PrintWriter info;

    public WriteFile(String name) throws IOException  {
       addToTheFile(name);
    }
    
    public void addToTheFile (String name)throws FileNotFoundException, IOException{
         try {
            this.userFile = new FileOutputStream("UserInfo.txt");
            this.info = new PrintWriter(userFile, true);
            info.println(name);
            ReadFile file = new ReadFile(info);
        } catch (FileNotFoundException e) {
            System.out.print("Could not write to the file, error " + e);
        } finally {
             info.close();
        }
    }
}
