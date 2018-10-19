package gameproject;

/**
 *This class has the functions related to checking the players answer and setting the money 
 * @author Amritpal Kaur 14865526
 */
public class MoneyWon {
   private int currentMoney;
    
    public MoneyWon(){
        this.currentMoney = 0;
    }
    
    /**
     * This method checks the user's answer and set's the money accordingly
     * @param answerCorrect - the correct answer of the question
     * @param player
     */
    public void setMoneyWon(boolean answerCorrect, PlayerInfo player){
        this.currentMoney = player.getMoney();          
        
        // checks if the user answered correctly and sets the money won accordingly
       if (answerCorrect) {
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
           
        }
   }
    
   /**
    * This method compares the user's money won with their current value and if it's the same means the user got the answer wrong
    * and hence returns true else returns false
    * @param player
    * @return a boolean
    */
   public boolean answerWrongAtThreshhold(PlayerInfo player){
      return (currentMoney < 1000 && player.getMoney() == 0) || (currentMoney== 1000 && player.getMoney() == 1000) || (currentMoney== 32000 && player.getMoney() == 32000);
   }

}
