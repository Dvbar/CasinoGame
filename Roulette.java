import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Roulette {
    static JFrame frame = new JFrame("Roulette");

    static JMenuBar grayMenu = new JMenuBar();
    static JLabel title = new JLabel("Roulette");

    //Input the name and starting amount of the player
    static JLabel name = new JLabel("Name:");
    static JTextField inputName = new JTextField();
    static JLabel startingAmount = new JLabel("Money:");
    static JTextField inputStartingAmount = new JTextField();
    static JButton submitNameAndMoney = new JButton("Submit");

    /* Information used for betting */
    static JButton submitBet = new JButton("Bet");
    //Used for drop down menus
    //One main type of bet, one for subtypes
    static String[] betPossibilities = new String[] {"1-18", "19-36", "1st Twelve", "2nd Twelve", "3rd Twelve", "Basket", "Color", "Column", "Corner", "Even/Odd", "Single", "Six Line", "Split", "Street"};
    static String[] basketSubBets = new String[] {"{0,1,2}", "{0,2,3}"};
    static String[] colorSubBets = new String[] {"Red", "Black"};
    static String[] columnSubBets = new String[] {"Top", "Middle", "Bottom"};
    static String[] cornerSubBets = new String[] {"{1,2,4,5}", "{2,3,5,6}", "{4,5,7,8}", "{5,6,8,9}", "{7,8,10,11}", "{8,9,11,12}", "{10,11,13,14}", "{11,12,14,15}", "{13,14,16,17}", "{14,15,17,18}", "{16,17,19,20}", "{17,18,20,21}", "{19,20,22,23}", "{20,21,23,24}", "{22,23,25,26}", "{23,24,26,27}", "{25,26,28,29}", "{26,27,29,30}", "{28,29,31,32}", "{29,30,32,33}", "{31,32,34,35}", "{32,33,35,36}"};
    static String[] evenOddSubBets = new String[] {"Even", "Odd"};
    static String[] singleSubBets = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36"};
    static String[] sixLineSubBets = new String[] {"{1,2,3,4,5,6}", "{4,5,6,7,8,9}", "{7,8,9,10,11,12}", "{10,11,12,13,14,15}", "{16,17,18,19,20,21}", "{19,20,21,22,23,24}", "{22,23,24,25,26,27}", "{25,26,27,28,29,30}", "{28,29,30,31,32,33}", "{31,32,33,34,35,36}"};
    static String[] splitSubBets = new String[] {"{1,2}", "{1,4}", "{2,3}", "{2,5}", "{3,6}", "{4,5}", "{4,7}", "{5,6}", "{5,8}", "{6,9}", "{7,8}", "{7,10}", "{8,9}", "{8,11}", "{9,12}", "{10,11}", "{10,13}", "{11,12}", "{11,14}", "{12,15}", "{13,14}", "{13,16}", "{14,15}", "{14,17}", "{15,18}", "{16,17}", "{16,19}", "{17,18}", "{17,20}", "{18,21}", "{19,20}", "{19,22}", "{20,21}", "{20,23}", "{21,24}", "{22,23}", "{22,25}", "{23,24}", "{23,26}", "{24,27}", "{25,26}", "{25,28}", "{26,27}", "{26,29}", "{27,30}", "{28,29}", "{28,31}", "{29,30}", "{29,32}", "{30,33}", "{31,32}", "{31,34}", "{32,33}", "{32,35}", "{33,36}", "{34,35}", "{35,36}"};
    static String[] streetSubBets = new String[] {"{1,2,3}", "{4,5,6}", "{7,8,9}", "{10,11,12}", "{13,14,15}", "{16,17,18}", "{19,20,21}", "{22,23,24}", "{25,26,27}", "{28,29,30}", "{31,32,33}", "{34,35,36}"};
    final static JComboBox<String> betComboBox = new JComboBox<String>(betPossibilities);
    final static JComboBox<String> basketSubComboBox = new JComboBox<String>(basketSubBets);
    final static JComboBox<String> colorSubComboBox = new JComboBox<String>(colorSubBets);
    final static JComboBox<String> columnSubComboBox = new JComboBox<String>(columnSubBets);
    final static JComboBox<String> cornerSubComboBox = new JComboBox<String>(cornerSubBets);
    final static JComboBox<String> evenOddSubComboBox = new JComboBox<String>(evenOddSubBets);
    final static JComboBox<String> singleSubComboBox = new JComboBox<String>(singleSubBets);
    final static JComboBox<String> sixLineSubComboBox = new JComboBox<String>(sixLineSubBets);
    final static JComboBox<String> splitSubComboBox = new JComboBox<String>(splitSubBets);
    final static JComboBox<String> streetSubComboBox = new JComboBox<String>(streetSubBets);

    static Random generator = new Random();

    private static int spin() {
        return generator.nextInt(37);
    }

    private static void payout() {
    }

    public static void main(String[] args) {
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        grayMenu.setOpaque(true);
        grayMenu.setBackground(new Color(211,211,211));
        grayMenu.setPreferredSize(new Dimension(800,20));

        name.setBounds(50,450,30,25);
        inputName.setBounds(100,450,100,25);
        startingAmount.setBounds(50,415,30,25);
        inputStartingAmount.setBounds(100,415,100,25);
    }
}
