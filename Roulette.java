import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Roulette {
    static JFrame frame = new JFrame("Roulette");
    static JPanel login = new JPanel();
    static JPanel betting = new JPanel();

    static JLabel title = new JLabel("Roulette");

    //Input the name and starting amount of the playerA
    static String name;
    static int money = 0;
    static JLabel nameLabel = new JLabel("Name:");
    static JTextField inputName = new JTextField();
    static JLabel startingAmountLabel = new JLabel("Money:");
    static JTextField inputStartingAmount = new JTextField();
    static JButton submitNameAndMoney = new JButton("Submit");

    /* Information used for betting */
    static int bet = 0;
    static JLabel betLabel = new JLabel("Bet");
    static JTextField inputBet = new JTextField();
    static JButton submitBet = new JButton("Bet");
    static JButton finishBet = new JButton("Done");

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
    final static JComboBox<String> blankSubComboBox = new JComboBox<String>();

    static JComboBox<String> tempSubComboBox = new JComboBox<String>();
    static boolean replaced = false; //Checks to see if we have updated the SubComboBoxes before

    //Updates the ComboBoxes on the betting JPanel
    public static void update(String mainBet) {
        if (!replaced) {
            betting.remove(blankSubComboBox);
            replaced = true;
        }
        else betting.remove(tempSubComboBox);

        if (mainBet == "Basket")        tempSubComboBox = basketSubComboBox;
        else if (mainBet == "Color")    tempSubComboBox = colorSubComboBox;
        else if (mainBet == "Column")   tempSubComboBox = columnSubComboBox;
        else if (mainBet == "Corner")   tempSubComboBox = cornerSubComboBox;
        else if (mainBet == "Even/Odd") tempSubComboBox = evenOddSubComboBox;
        else if (mainBet == "Single")   tempSubComboBox = singleSubComboBox;
        else if (mainBet == "Six Line") tempSubComboBox = sixLineSubComboBox;
        else if (mainBet == "Split")    tempSubComboBox = splitSubComboBox;
        else if (mainBet == "Street")   tempSubComboBox = streetSubComboBox;
        else                            tempSubComboBox = blankSubComboBox;
        betting.add(tempSubComboBox);
    }

    //A vector that will hold every submitted bet
    static Vector<Integer> vecBets = new Vector<Integer>();
    static Vector<String> vecBetTypes = new Vector<String>();
    static Vector<String> vecSubBetTypes = new Vector<String>();

    private static int ratio(String betType) {
        int odds = 0;
        if (betType.equals("1-18") || betType.equals("19-36") || betType.equals("Color") || betType.equals("Even/Odd")) odds = 1;
        else if (betType.equals("1st Twelve") || betType.equals("2nd Twelve") || betType.equals("3rd Twelve") || betType.equals("Column")) odds = 2;
        else if (betType.equals("Six Line")) odds = 5;
        else if (betType.equals("Corner")) odds = 8;
        else if (betType.equals("Basket") || betType.equals("Street")) odds = 11;
        else if (betType.equals("Split")) odds = 17;
        else odds = 35;
        return odds;
    }

    private static boolean checkBet(String mainBet, String subBet, int spinNum) {
        //Check each sub-bet and determine if the winning number is in that set of numbers
        //Check the main bet first for the ones w/o subtypes
        //True if the winning number is within the set
        //False if not
        if (spinNum == 0)
            if (subBet.equals("Even") || subBet.equals("0") || subBet.equals("{0,1,2}") || subBet.equals("{0,2,3}")) return true;

        else if (spinNum == 1)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("1") || subBet.equals("{1,2}") || subBet.equals("{1,4}") || subBet.equals("{0,1,2}") || subBet.equals("Red") || subBet.equals("Bottom") || subBet.equals("{1,2,3}") || subBet.equals("{1,2,3,4,5,6}") || subBet.equals("{1,2,4,5}")) return true;

        else if (spinNum == 2)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("2") || subBet.equals("{1,2}") || subBet.equals("{2,3}") || subBet.equals("{2,5}") || subBet.equals("{0,1,2}") || subBet.equals("{0,2,3}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{1,2,3}") || subBet.equals("{1,2,3,4,5,6}") || subBet.equals("{1,2,4,5}") || subBet.equals("{2,3,5,6}")) return true;

        else if (spinNum == 3)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("3") || subBet.equals("{2,3}") || subBet.equals("{3,6}") || subBet.equals("{0,2,3}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{1,2,3}") || subBet.equals("{1,2,3,4,5,6}") || subBet.equals("{2,3,5,6}")) return true;

        else if (spinNum == 4)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("4") || subBet.equals("{4,5}") || subBet.equals("{4,7}") || subBet.equals("{1,4}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{4,5,6}") || subBet.equals("{1,2,3,4,5,6}") || subBet.equals("{1,2,4,5}") || subBet.equals("{4,5,7,8}")) return true;

        else if (spinNum == 5)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("5") || subBet.equals("{4,5}") || subBet.equals("{5,6}") || subBet.equals("{5,8}") || subBet.equals("{2,5}") || subBet.equals("Red") || subBet.equals("Middle") || subBet.equals("{4,5,6}") || subBet.equals("{1,2,3,4,5,6}") || subBet.equals("{1,2,4,5}") || subBet.equals("{2,3,5,6}") || subBet.equals("{4,5,7,8}") || subBet.equals("{5,6,8,9}")) return true;

        else if (spinNum == 6)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("6") || subBet.equals("{3,6}") || subBet.equals("{5,6}") || subBet.equals("{6,9}") || subBet.equals("Black") || subBet.equals("Top") || subBet.equals("{4,5,6}") || subBet.equals("{1,2,3,4,5,6}") || subBet.equals("{2,3,5,6}") || subBet.equals("{5,6,8,9}")) return true;

        else if (spinNum == 7)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("7") || subBet.equals("{4,7}") || subBet.equals("{7,8}") || subBet.equals("{7,10}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{7,8,9}") || subBet.equals("{4,5,6,7,8,9}") || subBet.equals("{7,8,9,10,11,12}") || subBet.equals("{4,5,7,8}") || subBet.equals("{7,8,10,11}")) return true;

        else if (spinNum == 8)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("8") || subBet.equals("{5,8}") || subBet.equals("{7,8}") || subBet.equals("{8,9}") || subBet.equals("{8,11}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{7,8,9}") || subBet.equals("{4,5,6,7,8,9}") || subBet.equals("{7,8,9,10,11,12}") || subBet.equals("{4,5,7,8}") || subBet.equals("{5,6,8,9}") || subBet.equals("{7,8,10,11}") || subBet.equals("{8,9,11,12}")) return true;

        else if (spinNum == 9)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("9") || subBet.equals("{6,9}") || subBet.equals("{8,9}") || subBet.equals("{9,12}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{7,8,9}") || subBet.equals("{4,5,6,7,8,9}") || subBet.equals("{7,8,9,10,11,12}") || subBet.equals("{8,9,11,12}") || subBet.equals("{5,6,8,9}")) return true;

        else if (spinNum == 10)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("10") || subBet.equals("{7,10}") || subBet.equals("{10,11}") || subBet.equals("{10,13}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{10,11,12}") || subBet.equals("{7,8,9,10,11,12}") || subBet.equals("{10,11,12,13,14,15}") || subBet.equals("{7,8,10,11}") || subBet.equals("{10,11,13,14}")) return true;

        else if (spinNum == 11)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("11") || subBet.equals("{8,11}") || subBet.equals("{10,11}") || subBet.equals("{11,12}") || subBet.equals("{11,14}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{10,11,12}") || subBet.equals("{7,8,9,10,11,12}") || subBet.equals("{10,11,12,13,14,15}") || subBet.equals("{7,8,10,11}") || subBet.equals("{8,9,11,12}") || subBet.equals("{10,11,13,14}") || subBet.equals("{11,12,14,15}")) return true;

        else if (spinNum == 12)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("1st Twelve") || subBet.equals("12") || subBet.equals("{9,12}") || subBet.equals("{11,12}") || subBet.equals("{12,15}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{10,11,12}") || subBet.equals("{7,8,9,10,11,12}") || subBet.equals("{10,11,12,13,14,15}") || subBet.equals("{8,9,11,12}") || subBet.equals("{11,12,14,15}")) return true;

        else if (spinNum == 13)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("2nd Twelve") || subBet.equals("13") || subBet.equals("{10,13}") || subBet.equals("{13,14}") || subBet.equals("{13,16}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{13,14,15}") || subBet.equals("{10,11,12,13,14,15}") || subBet.equals("{13,14,15,16,17,18}") || subBet.equals("{10,11,13,14}") || subBet.equals("{13,14,16,17}")) return true;

        else if (spinNum == 14)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("2nd Twelve") || subBet.equals("14") || subBet.equals("{11,14}") || subBet.equals("{13,14}") || subBet.equals("{14,15}") || subBet.equals("{14,17}") || subBet.equals("Red") || subBet.equals("Middle") || subBet.equals("{13,14,15}") || subBet.equals("{10,11,12,13,14,15}") || subBet.equals("{13,14,15,16,17,18}") || subBet.equals("{10,11,13,14}") || subBet.equals("{11,12,14,15}") || subBet.equals("{13,14,16,17}") || subBet.equals("{14,15,17,18}")) return true;

        else if (spinNum == 15)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("2nd Twelve") || subBet.equals("15") || subBet.equals("{12,15}") || subBet.equals("{14,15}") || subBet.equals("{15,18}") || subBet.equals("Black") || subBet.equals("Top") || subBet.equals("{13,14,15}") || subBet.equals("{10,11,12,13,14,15}") || subBet.equals("{13,14,15,16,17,18}") || subBet.equals("{11,12,14,15}") || subBet.equals("{14,15,17,18}")) return true;

        else if (spinNum == 16)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("2nd Twelve") || subBet.equals("16") || subBet.equals("{13,16}") || subBet.equals("{16,17}") || subBet.equals("{16,19}") || subBet.equals("Red") || subBet.equals("Bottom") || subBet.equals("{16,17,18}") || subBet.equals("{13,14,15,16,17,18}") || subBet.equals("{16,17,18,19,20,21}") || subBet.equals("{13,14,16,17}") || subBet.equals("{16,17,19,20}")) return true;

        else if (spinNum == 17)
            if (subBet.equals("Odd") || mainBet.equals("1-18") || mainBet.equals("2nd Twelve") || subBet.equals("17") || subBet.equals("{14,17}") || subBet.equals("{16,17}") || subBet.equals("{17,18}") || subBet.equals("{17,20}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{16,17,18}") || subBet.equals("{13,14,15,16,17,18}") || subBet.equals("{16,17,18,19,20,21}") || subBet.equals("{13,14,16,17}") || subBet.equals("{14,15,17,18}") || subBet.equals("{16,17,19,20}") || subBet.equals("{17,18,20,21}")) return true;

        else if (spinNum == 18)
            if (subBet.equals("Even") || mainBet.equals("1-18") || mainBet.equals("2nd Twelve") || subBet.equals("18") || subBet.equals("{15,18}") || subBet.equals("{17,18}") || subBet.equals("{18,21}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{16,17,18}") || subBet.equals("{13,14,15,16,17,18}") || subBet.equals("{16,17,18,19,20,21}") || subBet.equals("{14,15,17,18}") || subBet.equals("{17,18,20,21}")) return true;

        else if (spinNum == 19)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("2nd Twelve") || subBet.equals("19") || subBet.equals("{16,19}") || subBet.equals("{19,20}") || subBet.equals("{19,22}") || subBet.equals("Red") || subBet.equals("Bottom") || subBet.equals("{19,20,21}") || subBet.equals("{16,17,18,19,20,21}") || subBet.equals("{19,20,21,22,23,24}") || subBet.equals("{16,17,19,20}") || subBet.equals("{19,20,22,23}")) return true;

        else if (spinNum == 20)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("2nd Twelve") || subBet.equals("20") || subBet.equals("{17,20}") || subBet.equals("{20,21}") || subBet.equals("{19,20}") || subBet.equals("{20,23}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{19,20,21}") || subBet.equals("{16,17,18,19,20,21}") || subBet.equals("{19,20,21,22,23,24}") || subBet.equals("{16,17,19,20}") || subBet.equals("{17,18,20,21}") || subBet.equals("{19,20,22,23}") || subBet.equals("{20,21,23,24}")) return true;

        else if (spinNum == 21)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("2nd Twelve") || subBet.equals("21") || subBet.equals("{18,21}") || subBet.equals("{20,21}") || subBet.equals("{21,24}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{19,20,21}") || subBet.equals("{16,17,18,19,20,21}") || subBet.equals("{19,20,21,22,23,24}") || subBet.equals("{17,18,20,21}") || subBet.equals("{20,21,23,24}")) return true;

        else if (spinNum == 22)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("2nd Twelve") || subBet.equals("22") || subBet.equals("{19,22}") || subBet.equals("{22,23}") || subBet.equals("{22,25}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{22,23,24}") || subBet.equals("{19,20,21,22,23,24}") || subBet.equals("{22,23,24,25,26,27}") || subBet.equals("{19,20,22,23}") || subBet.equals("{22,23,25,26}")) return true;

        else if (spinNum == 23)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("2nd Twelve") || subBet.equals("23") || subBet.equals("{20,23}") || subBet.equals("{22,23}") || subBet.equals("{23,24}") || subBet.equals("{23,26}") || subBet.equals("Red") || subBet.equals("Middle") || subBet.equals("{22,23,24}") || subBet.equals("{19,20,21,22,23,24}") || subBet.equals("{22,23,24,25,26,27}") || subBet.equals("{19,20,22,23}") || subBet.equals("{22,23,25,26}") || subBet.equals("{20,21,23,24}") || subBet.equals("{23,24,26,27}")) return true;

        else if (spinNum == 24)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("2nd Twelve") || subBet.equals("24") || subBet.equals("{21,24}") || subBet.equals("{23,24}") || subBet.equals("{24,27}") || subBet.equals("Black") || subBet.equals("Top") || subBet.equals("{22,23,24}") || subBet.equals("{19,20,21,22,23,24}") || subBet.equals("{22,23,24,25,26,27}") || subBet.equals("{20,21,23,24}") || subBet.equals("{23,24,26,27}")) return true;

        else if (spinNum == 25)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("25") || subBet.equals("{22,25}") || subBet.equals("{25,26}") || subBet.equals("{25,28}") || subBet.equals("Red") || subBet.equals("Bottom") || subBet.equals("{25,26,27}") || subBet.equals("{22,23,24,25,26,27}") || subBet.equals("25,26,27,28,29,30}") || subBet.equals("{22,23,25,26}") || subBet.equals("{25,26,28,29}")) return true;

        else if (spinNum == 26)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("26") || subBet.equals("{23,26}") || subBet.equals("{25,26}") || subBet.equals("{26,27}") || subBet.equals("{26,29}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{25,26,27}") || subBet.equals("{22,23,24,25,26,27}") || subBet.equals("25,26,27,28,29,30}") || subBet.equals("{22,23,25,26}") || subBet.equals("{23,24,26,27}") || subBet.equals("{25,26,28,29}") || subBet.equals("{26,27,29,30}")) return true;

        else if (spinNum == 27)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("27") || subBet.equals("{24,27}") || subBet.equals("{26,27}") || subBet.equals("{27,30}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{25,26,27}") || subBet.equals("{22,23,24,25,26,27}") || subBet.equals("25,26,27,28,29,30}") || subBet.equals("{23,24,26,27}") || subBet.equals("{26,27,29,30}")) return true;

        else if (spinNum == 28)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("28") || subBet.equals("{25,28}") || subBet.equals("{28,29}") || subBet.equals("{28,31}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{28,29,30}") || subBet.equals("{25,26,27,28,29,30}") || subBet.equals("{28,29,30,31,32,33}") || subBet.equals("{25,26,28,29}") || subBet.equals("{28,29,31,32}")) return true;

        else if (spinNum == 29)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("29") || subBet.equals("{26,29}") || subBet.equals("{28,29}") || subBet.equals("{29,30}") || subBet.equals("{29,32}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{28,29,30}") || subBet.equals("{25,26,27,28,29,30}") || subBet.equals("{28,29,30,31,32,33}") || subBet.equals("{25,26,28,29}") || subBet.equals("{26,27,29,30}") || subBet.equals("{28,29,31,32}") || subBet.equals("{29,30,32,33}")) return true;

        else if (spinNum == 30)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("30") || subBet.equals("{27,30}") || subBet.equals("{29,30}") || subBet.equals("{30,33}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{28,29,30}") || subBet.equals("{25,26,27,28,29,30}") || subBet.equals("{28,29,30,31,32,33}") || subBet.equals("{26,27,29,30}") || subBet.equals("{29,30,32,33}")) return true;

        else if (spinNum == 31)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("31") || subBet.equals("{28,31}") || subBet.equals("{31,32}") || subBet.equals("{31,34}") || subBet.equals("Black") || subBet.equals("Bottom") || subBet.equals("{31,32,33}") || subBet.equals("{28,29,30,31,32,33}") || subBet.equals("{31,32,33,34,35,36}")|| subBet.equals("{28,29,31,32}") || subBet.equals("{31,32,34,35}")) return true;

        else if (spinNum == 32)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("32") || subBet.equals("{31,32}") || subBet.equals("{29,32}") || subBet.equals("{32,33}") || subBet.equals("{32,35}") || subBet.equals("Red") || subBet.equals("Middle") || subBet.equals("{31,32,33}") || subBet.equals("{28,29,30,31,32,33}") || subBet.equals("{31,32,33,34,35,36}") || subBet.equals("{28,29,31,32}") || subBet.equals("{29,30,32,33}") || subBet.equals("{31,32,34,35}") || subBet.equals("{32,33,35,36}")) return true;

        else if (spinNum == 33)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("33") || subBet.equals("{30,33}") || subBet.equals("{32,33}") || subBet.equals("{33,36}") || subBet.equals("Black") || subBet.equals("Top") || subBet.equals("{31,32,33}") || subBet.equals("{28,29,30,31,32,33}") || subBet.equals("{31,32,33,34,35,36}") || subBet.equals("{29,30,32,33}") || subBet.equals("{32,33,35,36}")) return true;

        else if (spinNum == 34)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("34") || subBet.equals("{31,34}") || subBet.equals("{34,35}") || subBet.equals("Red") || subBet.equals("Bottom") || subBet.equals("{34,35,36}") || subBet.equals("{31,32,33,34,35,36}") || subBet.equals("{31,32,34,35}")) return true;

        else if (spinNum == 35)
            if (subBet.equals("Odd") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("35") || subBet.equals("{32,35}") || subBet.equals("{34,35}") || subBet.equals("{35,36}") || subBet.equals("Black") || subBet.equals("Middle") || subBet.equals("{34,35,36}") || subBet.equals("{31,32,33,34,35,36}") || subBet.equals("{31,32,34,35}") || subBet.equals("{32,33,35,36}")) return true;

        else if (spinNum == 36)
            if (subBet.equals("Even") || mainBet.equals("19-36") || mainBet.equals("3rd Twelve") || subBet.equals("36") || subBet.equals("{33,36}") || subBet.equals("{35,36}") || subBet.equals("Red") || subBet.equals("Top") || subBet.equals("{34,35,36}") || subBet.equals("{31,32,33,34,35,36}") || subBet.equals("{32,33,35,36}")) return true;

        return false;
    }

    //Used or initialized in the function: payout()
    static Random generator = new Random();
    static int payoutRatio = 0;
    static boolean winBet = false;

    public static String payout() {
        int netWinnings = 0;
        int spinNum = generator.nextInt(37);
        int vecSize = vecBets.size();
        for (int i = 0; i < vecSize; i++) {
            int curBet = vecBets.lastElement();
            payoutRatio = ratio(vecBetTypes.lastElement());
            winBet = checkBet(vecBetTypes.lastElement(), vecSubBetTypes.lastElement(), spinNum);
            if (winBet) netWinnings += payoutRatio * curBet;
            else netWinnings -= curBet;
            vecBets.remove(vecBets.size()-1);
            vecBetTypes.remove(vecBetTypes.size()-1);
            vecSubBetTypes.remove(vecSubBetTypes.size()-1);
        }
        money += netWinnings;
        String returnVal = "The winning number was: " + spinNum + ".\n";
        if (netWinnings < 0) returnVal += "You lost: " + -1*netWinnings + " dollars.";
        else if (netWinnings > 0) returnVal += "You won: " + netWinnings + " dollars.";
        else returnVal += "You broke even.";
        return returnVal;
    }

    static JLabel printSpin = new JLabel(payout());

    public static void lose() {
    }

    public static void main(String[] args) {
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        login.add(nameLabel);
        login.add(inputName);
        login.add(startingAmountLabel);
        login.add(inputStartingAmount);
        login.add(submitNameAndMoney);

        nameLabel.setBounds(50,450,30,25);
        inputName.setBounds(100,450,100,25);
        startingAmountLabel.setBounds(50,415,30,25);
        inputStartingAmount.setBounds(100,415,100,25);
        frame.add(login);

        frame.pack();
        frame.setVisible(true);
    }
}
