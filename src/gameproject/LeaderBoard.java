///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package gameproject;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
///**
// *
// * @author Amrit
// */
//public class LeaderBoard {
//    List<String> players = new ArrayList<String>();
//    List<String> name = new ArrayList<String>();
//    List<String> money = new ArrayList<String>();
//    
//    public LeaderBoard() {
//        fetchData();
//        
//    }
//
//    public void fetchData() {
//        
//       int currentValue = 0;
//       File file = new File("UserInfo.txt");
//        if (file.exists()) {
//            try {
//                players = Files.readAllLines(file.toPath(), Charset.defaultCharset());
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
//            if (players.isEmpty()) {
//                return;
//            }
//        }
//        for (String lines : players) {
//            System.out.println(lines);
//            for (int i = 0; i< lines.length(); i++){
//                String[] res = lines.split(":");
//                String name = res[0];
//                String money = res[1];
//               
//                
//            }
////            String[] res = lines.split(":");
////            for (String s : res){
////                System.out.println(s);
////            }
////            name.add(res[0]);
////            money.add(res[1]);
//        }
//        
//        Collections.sort(money);
//        System.out.println("Sorted money" + money);
//     
//    }
//
//}
