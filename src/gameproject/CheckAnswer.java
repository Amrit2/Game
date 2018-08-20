/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author Amrit
 */
public class CheckAnswer {
    
    public CheckAnswer(){
        
    }
    
    /**
     * This method checks the user's answer
     * @param userAnswer: the user's answer
     * @param player
     * @param quizQues
     * @param leaderboard
     * @return the amount of money won by the player after processing the answer
     */
    public int check(String userAnswer, PlayerInfo player, Questions quizQues, LeaderBoard leaderboard){
        int currentMoney = player.getMoney();
        
        // checks if the user answered correctly and sets the money won accordingly
        if (userAnswer.equalsIgnoreCase(quizQues.getAnswer())) {
            if (player.getMoney() == 0) {
                player.setMoney(100);
            } else {
                player.setMoney(player.getMoney()*2);
                if (player.getMoney() == 400 || player.getMoney()== 600) {
                    player.setMoney(player.getMoney() - 100);
                } else if (player.getMoney() == 128000) {
                    player.setMoney(player.getMoney() - 3000);
                }
            }
            System.out.println("Correct Answer! \nYou've reached " + player.getMoney() + " dollars.\n"); //money
        } else {
            
            // if the user gets a question wrong their money is decreased to the corresponding thresh hold. 
            // If they were above $1000 and get a ques wrong, they come down to $1000, if they were above $32000 it comes down to 
            // $32000.
            if (player.getMoney() >= 1000 && player.getMoney() < 32000) {
                player.setMoney(1000);
            } else if (player.getMoney() >= 32000) {
                player.setMoney(32000);
            } else {
                player.setMoney(0);
            }
            System.out.println("Wrong Answer :(. \n"
                    + "The correct answer is " + quizQues.getAnswer() + ". \nYou are on " + player.getMoney() + " dollars.");
        }
        
        //if the user was on $0 and gets a questions wrong, the game quits
        if ((currentMoney== 0 && player.getMoney() == 0) || (currentMoney== 1000 && player.getMoney() == 1000) || (currentMoney== 32000 && player.getMoney() == 32000)){
            leaderboard.addToTheFile(player.getName(), player.getMoney());
            leaderboard.displayLeaderBoard();
            System.out.println("You've lost the game.");
            System.exit(0);
        }
        return player.getMoney();
   }
    
}
