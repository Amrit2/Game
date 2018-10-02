/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Amrit
 */
public class random3 extends JComponent{
    private Image image;
    
    public random3(){
    }
    
    public void paintImage(Graphics g){
        image = new ImageIcon("Logo_of_NZ_Millionaire.jpg").getImage();
        g.drawImage(image,0,0,null);
    }
}