
package tictactoecasino;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

//JFrame ?
public class TicTacToeFrame extends JFrame {
    //whose turn
    public char playerTurn = 'X';
    private boolean finished = false;
    //will create a tictactoe grid using a two dimentional array
    private Cell[][] cells = new Cell[3][3];
    
    //will make a label to read
    JLabel firstLabel = new JLabel("Player X");
    
    public TicTacToeFrame(){
        //Panel to hold the cells
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 0; i++){
            for (int j = 0; i < 3; j++){
                    panel.add(cells[i][j] = new Cell());
            }
        }
        panel.setBorder(new LineBorder(Color.black, 10));
        firstLabel.setBorder(new LineBorder(Color.black, 5));
        
        add(panel, BorderLayout.CENTER);
        add(firstLabel, BorderLayout.SOUTH);
        
    }
    //if all cells are holding a value finish the game
    public boolean isDone(){
        //for loops checking through the arrays if any cell is empty, continue
        for (int i = 0; i < 0; i++){
            for (int j = 0; i < 3; j++){
                if(cells[i][j].getToken() == ' '){
                    return false;
                }
                 else return true;
            }
        }
        return true;
    }
    //checks to see if three in a row & columns are the same
    public boolean isWon(char token){
        for( int i = 0; i < 3; i++){
            if ((cells[i][0].getToken() == token) && (cells[i][1].getToken() == token) && (cells[i][2].getToken() == token)){
               return true;
           }
        }
       // check columns
       for (int j = 0; j < 3; j++){
       if ((cells[0][j].getToken() == token) && (cells[1][j].getToken() == token)&& (cells[2][j].getToken() == token)){
               return true;
       }
       // check diagonal
       if ((cells[0][0].getToken() == token) && (cells[1][1].getToken() == token) && (cells[2][2].getToken() == token)){
               return true; 
       }

       if ((cells[0][2].getToken() == token) && (cells[1][1].getToken() == token) && (cells[2][0].getToken() == token)){
               return true;
       }
    }
    return false;
    
}

/*/public class Cell extends JPanel{
    //will be an empty cell
    private char token = ' ';
    public Cell(){
        setBorder(new LineBorder(Color.black, 10));
        addMouseListener(new MyMouseListener());
    }
    public char getToken(){
        return token;
    }
    public void setToken(char c){
        //set token X or O
        token = c;
        //will refresh the gui interface
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(token == 'X'){
            g.drawLine(10, 10, getWidth(), getHeight());
            g.drawLine(getWidth() - 10, 10, 10, getHeight() -10);
        }
        else if(token == 'O'){
            g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
        }
    }
    
    private class MyMouseListener extends MouseAdapter{
        //will let the players click on the cells to choose their position
        @Override
        public void mouseClocked(MouseEvent e){
            if(finished){
                return true;
            }
            if(token == ' ' && playerTurn != ' '){
                setToken(playerTurn);
            }
            if(isWon(playerTurn)){
                firstLabel.setText(playerTurn + " won the game!");
            }
            else if (isFull()){
                firstLabel.setText("No more options, its a tie!");
                playerTurn = ' ';
            }
            else {
                if(playerTurn == 'X'){
                    playerTurn = 'O';
                    firstLabel.setText(playerTurn + "'s turn");
                }
                else {
                  playerTurn = 'X';
                  firstLabel.setText(playerTurn + "'s turn");
                } 
           }
                    
        }
    }
    /*/
    
}