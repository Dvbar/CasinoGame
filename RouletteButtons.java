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
                betting.setLayout(new GridLayout(2,4,5,0));

                createBetting(name,money);
                frame.revalidate();
                frame.repaint();
            }
        });

        betComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (betComboBox.getSelectedIndex() == -1)
                    return;
                update(betComboBox.getSelectedItem().toString());
                betting.revalidate();
                betting.repaint();
                frame.revalidate();
                frame.repaint();
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
                update("All");
                betComboBox.setSelectedIndex(-1);
                replaced = false;
                betting.revalidate();
                betting.repaint();
                frame.revalidate();
                frame.repaint();
            }
        });

        finishBet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Finish betting and update the JFrame
                String s = payout();
                printSpin.setText(s);
                betting.add(printSpin);
                update("All");
                betComboBox.setSelectedIndex(-1);
                replaced = false;
                betting.revalidate();
                betting.repaint();
                frame.revalidate();
                frame.repaint();
                if (money <= 0) lose();
            }
        });
    }
}
