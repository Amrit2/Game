///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gameproject;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// *
// * @author Amrit
// */
//public class WritePlayerInfo {
////     FileOutputStream userFile;
//    PrintWriter info;
//
//    public WritePlayerInfo(String name, int money) throws IOException{
//        addToTheFile(name, money);
//    }
//    
//     public void addToTheFile (String name, int money)throws FileNotFoundException, IOException{
//         try {
//            info = new PrintWriter( new FileOutputStream(("UserInfo.txt"), true));
//            
////            info.println(name);
////            info.println(money);
////            
//        } catch (FileNotFoundException e) {
//            System.out.print("Could not write to the file, error " + e);
//        } finally {
//             info.close();
//        }
//    }
//}
