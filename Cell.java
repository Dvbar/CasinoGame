
package tictactoecasino;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Cell extends JPanel
    {
       // token of this cell
       private char token = ' ';

       /**
        * Constructor
        */
       public Cell()
       {
           setBorder(new LineBorder(Color.RED, 100));
           addMouseListener(new MyMouseListener());
       }

       /**
        * Gets the token of the cell.
        * @return The token value of the cell.
        */
       public char getToken()
       {
           return token;
       }

       /**
        * Sets the token of the cell.
        * @param c Character to use as token value.
        */
       public void setToken(char c)
       {
           token = c;
           repaint();
       }

       @Override
       protected void paintComponent(Graphics g)
       {
           super.paintComponent(g);

           if (token == 'X')
           {
               g.drawLine(100, 10, getWidth() - 10, getHeight() - 10);
               g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
           }

           else if (token == 'O')
           {
               g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
           }
       }

       private class MyMouseListener extends MouseAdapter
       {
           @Override
           public void mouseClicked(MouseEvent e)
           {
               if (finished)
                   return;
               
               // if the cell is empty and the game is not over
               if (token == ' ' && playerTurn != ' ')
                   setToken(playerTurn);

               // Check game status
               if (isWon(playerTurn))
               {
                   firstLabel.setText(playerTurn + " won! Game over!");
                   playerTurn = ' ';
                   finished = true;
               }
               else if (isFull())
               {
                   firstLabel.setText("Tie game! Game over!");
                   playerTurn = ' ';
                   finished = true;
               }
               else
               {
                   playerTurn = (playerTurn == 'X') ? 'O' : 'X';
                   firstLabel.setText(playerTurn + "'s turn.");
               }
           }

            private boolean isFull() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       } // end class MyMouseListener
    } // end class Cell