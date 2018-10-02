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
public class random {
    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is the user interface for the the csc116 version
 * of who wants to be a millionaire.  
 *  
 * @author Brendan Bull
 */

public class MillionaireGameGUI extends JFrame implements ActionListener,
             WindowListener {
             
    private JScrollPane pnlScroll;
    private JTextArea txtQuestion;    
    private JLabel lblMoneyWon;
    private JLabel[] lblAnswers;
    private JButton[] btnAnswers;
    private JButton btnNextQuestion;
    private JButton btnQuit;
    private String imagePath =
    "images/";
    
    private Color backgroundColor = new Color (50,20,20);
    
    private MillionaireGame mg;
    
    private final int DISPLAYABLE_LINES = 5; //This number of lines
                                          //that can fit into the question
                                          //area without scroll bars.        
    private final int NUM_ANSWERS = 4;
    
    /** 
     * Createa a MillionaireGameGUI object and arranges the GUI
     * widgets.
     *
     * @param _mg a MillionaireGame object
     */
        
    public MillionaireGameGUI (MillionaireGame _mg) {
    
        mg = _mg;
        
        Container c = getContentPane();        
        c.setLayout (new BorderLayout());
        
        JPanel pnlCenter = new JPanel();
        pnlCenter.setLayout (new GridLayout (2,1));       
        pnlCenter.add (initLogoArea());
        pnlCenter.add (initAnswerPane());
       
        c.add (pnlCenter, BorderLayout.CENTER);                
        c.add(initBottomPane(), BorderLayout.SOUTH);
               
        addWindowListener(this);                
    	setTitle ("Who Wants to be a Millionaire");
        setLocation (300,300);
        setSize (430, 440);
	//setSize (645, 660);
        setResizable(false);
        show();
    }
    
    
    /**
     * Puts the who wants to be a millionaire image on a JPanel 
     * and returns the panel to the constructor.
     * 
     * @return a JPanel with the millionaire image on it.
     */
        
    private JComponent initLogoArea() {
        
       JPanel pnlLogo = new JPanel();
       ImageIcon logo = new ImageIcon (imagePath+"millionaire.jpg");
       
       //You can't add an image directly to a panel.  To get around this,
       //I've added the image to a JLabel and added the JLabel to the panel.
       pnlLogo.add (new JLabel(logo));
                     
       return pnlLogo;
    }
    
    /**
     * Create a panel that contains the question and answer widgets.
     *
     * @return a JPanel with the question/answer area.          
     */
    
    private JComponent initAnswerPane() {
    
        JPanel pnlAnswer = new JPanel();
        JPanel pnlCenter = new JPanel();        
        JPanel pnlSouth = new JPanel();    
        JPanel pnlNorth = new JPanel();
       
        pnlAnswer.setLayout (new BorderLayout());
        
        txtQuestion = new JTextArea(4,50);
	txtQuestion.setFont(new Font ("Courier", Font.PLAIN, 12));
	//txtQuestion = new JTextArea(8,100); 
	//txtQuestion.setFont(new Font ("Courier", Font.PLAIN, 18));                   
    	txtQuestion.setWrapStyleWord(true);  
    	txtQuestion.setForeground (Color.white);    
        txtQuestion.setBackground (backgroundColor);        
    	txtQuestion.setEditable(false);		
        
        //Makes the question scrollable in case the question is really long
        pnlScroll = new JScrollPane(txtQuestion);
        	       		 
        pnlNorth.setBackground (backgroundColor);
        pnlNorth.add (pnlScroll);    
        
        pnlNorth.setPreferredSize (new Dimension (410,70));
        //pnlNorth.setPreferredSize (new Dimension (410,120));    
        lblMoneyWon = new JLabel ("Money Won: $0");                
        pnlSouth.add (lblMoneyWon);   
        pnlSouth.setBackground (backgroundColor);
        lblMoneyWon.setForeground (Color.white);                 
                                                
        initBtnAnswers();
        initLblAnswers();
        
        String[] s = {"", "", "", ""};
        setLblAnswers(s);
        
        String[] btnLabels = {"A","B","C","D"};
        for (int i = 0; i < NUM_ANSWERS; i++) {
            btnAnswers[i].setPreferredSize (new Dimension (50,30));
	    //btnAnswers[i].setPreferredSize (new Dimension (50,60));        
            pnlCenter.add (btnAnswers[i]);                     
            lblAnswers[i].setPreferredSize (new Dimension (135, 30));
	    //lblAnswers[i].setPreferredSize (new Dimension (135, 60));  
            pnlCenter.add (lblAnswers[i]);              
            btnAnswers[i].setBackground (backgroundColor);  
            btnAnswers[i].setForeground (Color.white);
            lblAnswers[i].setForeground (backgroundColor);             
        }
        
        enableBtnAnswer(false);   
        pnlAnswer.add (pnlNorth, BorderLayout.NORTH);     
        pnlAnswer.add (pnlCenter ,BorderLayout.CENTER);       
        pnlAnswer.add (pnlSouth, BorderLayout.SOUTH);
                               
        return pnlAnswer;                                 
    }
    
   /**
    * Create a panel that contains the "quit" and "next question"
    * buttons.
    *
    * @return a JPanel with the "quit" and "next question" buttons.
    */
        
    private JComponent initBottomPane () {
    
        JPanel pnlBottom = new JPanel();
        pnlBottom.setLayout (new GridLayout (1,2));
                
        Icon question = new ImageIcon (imagePath +"question.gif");
        
        btnNextQuestion = new JButton ("<html><font size = -1><b><u>N</u>ext Question", question);
        btnNextQuestion.addActionListener(this);
       
        Icon stop = new ImageIcon (imagePath+"stop.gif");
        
        btnQuit = new JButton ("<html><b><u>Q</u>uit", stop);
        btnQuit.addActionListener(this);       
                
        pnlBottom.add (btnNextQuestion);         
        pnlBottom.add (btnQuit);
                 
        return pnlBottom;
    }
    
    /**
     * Creates the labels used to display the answers.
     */
    
    private void initLblAnswers() {
    
        lblAnswers = new JLabel[NUM_ANSWERS]; 
        
        for (int i = 0; i < NUM_ANSWERS; i++) {
            lblAnswers[i] = new JLabel();
        }
    }
    
    /**
     * Creates the buttons used for answering questions.     
     */
    
    private void initBtnAnswers() {
    
        String[] btnLabels = {"A","B","C","D"};
        btnAnswers = new JButton[NUM_ANSWERS];
        
        for (int i = 0; i < NUM_ANSWERS; i++) {
            btnAnswers[i] = new JButton(btnLabels[i]);
            btnAnswers[i].addActionListener(this);
        }
    }
    
    /**
     * Changes the text of the answer labels.
     *
     * @param answers An array of strings that contains possible answers.
     *                answers[0] = answer a, answers[1] = answer b, etc.
     */
    
    public void setLblAnswers(String[] answers) {
    
        if (answers.length < NUM_ANSWERS) 
            return;
            
        for (int i = 0; i < NUM_ANSWERS; i++) {
            lblAnswers[i].setText(answers[i]);
        }            
    }
    
    /**
     * Enables or disables all of the answer buttons.
     *
     * @param enable - The answer buttons are enabled if "enable" is true.
     *                 They are disabled of "enable" is false.
     */
    
    public void enableBtnAnswer (boolean enable) {
       
       for (int i = 0; i < NUM_ANSWERS; i++) { 
            btnAnswers[i].setEnabled(enable);
        }
    }
    
    /**
     * Called when a button is clicked.
     *     
     * @param e The source of the button click.
     */
    
    public void actionPerformed (ActionEvent e) {
    
        //User pressed get next question
    
        if (e.getSource() == btnNextQuestion) {
            
            btnNextQuestion.setEnabled(false);
            enableBtnAnswer(true);	    
	        mg.nextQuestion();	    
            txtQuestion.setText(mg.getQuestion());          
                                 
            //Creates an array of Strings used to set the label text            
            String[] answers = new String[NUM_ANSWERS];
            for (int i = 0; i < NUM_ANSWERS; i++) {
                answers[i] = mg.getTextForAnswer(btnAnswers[i].getText());
            }
            setLblAnswers (answers);                                                 
        }
        
        //Quit button pressed
        
        if (e.getSource() == btnQuit) {
            System.exit(0);
        }
        
        //One of the answer buttons was pressed
        
        for (int i = 0; i < NUM_ANSWERS; i++) {
        
            if (e.getSource() == btnAnswers[i]) {
            
                btnNextQuestion.setEnabled(true);
                boolean correct = mg.isCorrectAnswer (btnAnswers[i].getText());
                
                //The player got the answer correct
                if (correct) {
                    if (mg.hasWon()) {
                        lblMoneyWon.setText("You won 1 million dollars!!!");
                        btnNextQuestion.setEnabled(false);
                    }
                    else {
                        lblMoneyWon.setText("Money Won: " + mg.getMoneyWon());
                    }
                }
                
                //The player got the answer wrong
                else {
                    lblMoneyWon.setText("You lose");
                    btnNextQuestion.setEnabled(false);
                }                      
                              
                enableBtnAnswer(false);                
            }
        }    
    }
    
    /**
     * Exits the program when the window is closed.
     *
     * @param we - The event triggered by the window closing.
     */
    
    public void windowClosing (WindowEvent we) {
       System.exit(0);  
    }
        
    // Because this class is implementing WindowListener, I'm required
    // to provide implementations for these methods.  However, I don't
    // want anything special to happen when these window events are 
    // triggered so I've just provided dummy implementations to make the
    // the compiler happy.
    
    public void windowClosed(WindowEvent we) {}
    public void windowActivated (WindowEvent we) {}
    public void windowOpened (WindowEvent we) {}    
    public void windowDeactivated (WindowEvent we) {}
    public void windowDeiconified (WindowEvent we) {}
    public void windowIconified (WindowEvent we) {}
        
    /**
     * Gets everything started
     */                    
    
    public static void main (String[] args) {
    
        new MillionaireGameGUI(new MillionaireGame());
    }
}
        
                
    
}
