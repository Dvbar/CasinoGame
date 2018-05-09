
package tictactoecasino;

import javax.swing.JFrame;

public class TicTacToeCasino {

    public static void main(String[] args) {
        JFrame TicTacToeCasino = new TicTacToeFrame();
        //sets the size of the interface on the screen
        TicTacToeCasino.setSize(500, 500);
        TicTacToeCasino.setTitle("Casino style Tic Tac Toe !");
        //makes the interface load in the middle of the screen
        TicTacToeCasino.setLocationRelativeTo(null);
        //allows you to see it
        TicTacToeCasino.setVisible(true);
        //will stop it running if you click escape/X
        TicTacToeCasino.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }
    
}
