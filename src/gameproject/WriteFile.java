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
    private String name;
    private int money;
    FileOutputStream userFile;
    PrintWriter info;

    public WriteFile(String name, int money) throws IOException  {
       setName(name);
       setMoney(money);
       addToTheFile();
    }
    
    public void addToTheFile ()throws FileNotFoundException, IOException{
         try {
            this.userFile = new FileOutputStream("UserInfo.txt");
            this.info = new PrintWriter(userFile, true);
            info.println(this.getName() + " " + this.getMoney());
            
        } catch (FileNotFoundException e) {
            System.out.print("Could not write to the file, error " + e);
        } finally {
             info.close();
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getMoney(){
        return this.money;
    }
    
}
