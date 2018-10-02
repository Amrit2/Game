/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Amrit
 */
public class random2 
{
    private Image image;
    Graphics g;
    
    public random2(){
        JFrame frame = new JFrame("Who Wants To Be A Millionaire");
        frame.setSize(580, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new random3());
        
//        JPanel panelPhoto = new JPanel();
//        panelPhoto.setSize(580, 480);
//        panelPhoto.setBackground(Color.red);
//        frame.add(panelPhoto, BorderLayout.SOUTH);
//   
    }
    public static void main (String[] args){
        new random2();
    }
    
}
