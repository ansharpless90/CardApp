//Adrian Sharpless
//last modification date: 12/30/18

package CardApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class cardApp extends JFrame implements ActionListener
    {
     //JButton Variables
     private JButton buttonOne,
                     buttonTwo,
                     buttonThree;

     private JTextField TextField = new JTextField(3); //constructs a new JPanel textfield.

     hand handObject = new hand(); //constructs new Hand object
     
     private int pressedNumber;


     public cardApp()
          {
           JPanel buttonPanel = new JPanel(new GridLayout(1, 3)); //Grid layout constructed

           //constructors for buttons 1,2, and 3.
           buttonOne = new JButton("1");
           buttonTwo = new JButton("2");
           buttonThree = new JButton("3");

           //Action variables are attributed to buttons.
           buttonOne.addActionListener(this);
           buttonTwo.addActionListener(this);
           buttonThree.addActionListener(this);

           //Places respective buttons 1,2, and 3, onto JPanel Window.
           buttonPanel.add(buttonOne);
           buttonPanel.add(buttonTwo);
           buttonPanel.add(buttonThree);

           //Border layout spevifications for JPanel Window.
           JPanel mainPanel = new JPanel(new BorderLayout());
           getContentPane().add(mainPanel);
           mainPanel.add(TextField, BorderLayout.CENTER);
           mainPanel.add(buttonPanel, BorderLayout.SOUTH);

           setTitle("CardAPP");
           setSize(250, 100);
           setVisible(true);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           handObject.Discard(pressedNumber); //Discard function is passed to JPanel.
           TextField.setText(handObject.Display()); //text from Display is passed to JPanel.


        }

     public void actionPerformed(ActionEvent e) //Actions that come with button presses
        {
         if(e.getSource() == buttonOne)
           {
            pressedNumber = 1;
            handObject.Discard(pressedNumber);
           }

         if(e.getSource() == buttonTwo)
           {
            pressedNumber = 2;
            handObject.Discard(pressedNumber);
           }

         if(e.getSource() == buttonThree)
           {
            pressedNumber = 3;
            handObject.Discard(pressedNumber);
           }

         TextField.setText(handObject.Display()); //Puts new text into JPanel.
         handObject.Success(); //Calls success function to determine if winner.

       }


    public static void main(String[] args)
    {
     
       cardApp c = new cardApp();
   
    }

}
