//Adrian Sharpless
//Last modification Date: 12/31/18

package CardApp;

import java.util.Random;
import javax.swing.JOptionPane;

public class hand
  {
   
   String L_Suit; //Left card.
   String M_Suit; //Middle card.
   String R_Suit; //Right card.
   String [] Suits = {"C","D","H","S"}; //All the types of card that are used.
   String [] chance = {"C","D","H","S","R"}; //All the types of cards used plus random card.
   
   Random randInt = new Random(); //Constructor variable for a random object.
   String Shuffle; //Variable used to hold the value obtained from random.
   String displaySuits; //Used to display all three cards side by side.
   int pressed; //Variable for when buttons are pressed.

   public int Discard(int pressedNumber)
   {

     pressed = pressedNumber; //is given the value of which number is pressed.
     Randomize(); //calls random function.
     return pressed;

   }

   public void Randomize()
   {

    int randSuitNum = randInt.nextInt(4); //gives random number from 0 to 3.
    int randNum     = randInt.nextInt(5); //gives random number from 0 to 4.

    if(pressed == 1)
      L_Suit = Suits[randSuitNum]; //random number corresponds with a value in suits.

    if(pressed == 2)
      M_Suit = Suits[randSuitNum]; //random number corresponds with a value in suits.

    if(pressed == 3)
      R_Suit = Suits[randSuitNum]; //random number corresponds with a value in suits.

    Shuffle = chance[randNum]; //random number corresponds with a value in chance.

    if(Shuffle.equals("R") || pressed == 0) //The 1 in 5 chance that sets cards to random.
      {
       JOptionPane.showMessageDialog(null,"Randomized Hand!");
       //Sets all three cards to random cards.
       int leftNum  = randInt.nextInt(4);
       int midNum   = randInt.nextInt(4);
       int rightNum = randInt.nextInt(4);
       //Changes the cards to their new value.
       L_Suit = Suits[leftNum];
       M_Suit = Suits[midNum];
       R_Suit = Suits[rightNum];
      }

    }

   public String Display () //Displays the suits in the JPanel window.
   {
    displaySuits = (L_Suit + M_Suit + R_Suit);
    return displaySuits;
   }

   public void Success() // compares cards with each other to determine if all are the same.
   {
    if (L_Suit.equals(M_Suit) && M_Suit.equals(R_Suit) && R_Suit.equals(L_Suit))
    {
     JOptionPane.showMessageDialog(null, "Winner!");
     System.exit(0); //Ends the program
    }

   }
}
