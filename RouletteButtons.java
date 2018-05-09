import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

class RouletteButtons extends Roulette implements Runnable {
    public void run() {
        submitNameAndMoney.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Update the JFrame when a player and money amount is submitted
                name = inputName.getText();
                money = Integer.parseInt(inputStartingAmount.getText());
                frame.remove(login);
                frame.add(betting);
                frame.repaint();
            }
        });

        betComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (betComboBox.getSelectedIndex() == -1)
                    return;
                update(betComboBox.getSelectedItem().toString());
            }
        });

        submitBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Submit a bet and update the JFrame
                if (betComboBox.getSelectedIndex() == -1)
                    return;
                bet = Integer.parseInt(inputBet.getText());
                vecBets.add(bet);
                vecBetTypes.add(betComboBox.getSelectedItem().toString());
                vecSubBetTypes.add(tempSubComboBox.getSelectedItem().toString());
            }
        });

        finishBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Finish betting and update the JFrame
            }
        });
    }
}
