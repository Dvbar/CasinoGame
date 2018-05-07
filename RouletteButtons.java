import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class RouletteButtons extends Roulette implements Runnable {
    public void run() {
        submitNameAndMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Update the JFrame when a player and money amount is submitted
                name = inputName.getText();
                money = inputStartingAmount.getText();
                frame.remove(login);
                frame.add(betting);
                frame.repaint();
            }
        });

        submitBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Submit a bet and update the JFrame
            }
        });

        finishBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Finish betting and update the JFrame
            }
        });
    }
}
