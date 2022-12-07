
import javax.swing.text.BadLocationException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class State {

    enum Player{Red, Blue}
    private String[][] boardState;
    List<State> childList = new ArrayList<>();
    Player lastMove;
    int boardSize,stoneCount = 18;
    int moves;
    
    public State(int size) throws Exception{//Birden fazla parametre alan state constructoru o anki boardı oluşturmak için
        createBoard(size);
        clearBoard();
        createStones(boardSize);
    }
    public void clearBoard(){
        try {
            for(int i = 0; i < boardSize; i++){
                for(int j = 0; j < boardSize; j++){
                    boardState[i][j] = " -";
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void createStones(int size){
        this.stoneCount = (size/2) - 1;//3

        for(int i = 0; i < stoneCount; i++){
            for(int j = 0; j < stoneCount; j++){
                boardState[i][j] = " B";
            }
        }

        for(int i = size-1; i >= size-stoneCount; i--){
            for(int j = size-1; j >= size-stoneCount; j--){
                boardState[i][j] = " R";
            }
        }

    }
    public State(State st) throws Exception{
        this.boardState = st.boardState;
    }
    public void sizeValidity(int size) {
        if(size < 3 || size % 2 != 0){
            boardSize = 8;
        }
        else
            boardSize = size;
    }
    public void createBoard(int size) throws Exception {
        sizeValidity(size);
        this.boardState = new String[boardSize][boardSize];

    }
    public String winsState(){
        String redWin = "R", blueWin = "B";
        if(lastMove == Player.Red){;
            for(int i = boardSize; 0 < i ;i--){
                for(int j = 0;j < 3;j++){
                    //HEPSİ REDE EŞİTSE İFE GİRMEZ REDWİN TRUE OLARAK KALIR
                    if(boardState[i][j] != " R"){
                        redWin = "N";
                        break;
                    }
                }
            }
        }
        if(lastMove == Player.Blue){
            String winner = "B";
            for(int i = boardSize; 0 < i ;i--){
                for(int j = 0;j < 3;j++){
                    //HEPSİ BLUE EŞİTSE İFE GİRMEZ BLUEWİN TRUE OLARAK KALIR
                    if(boardState[i][j] != " B"){
                        blueWin = "N";
                        break;
                    }
                }
            }
        }
        if(redWin == "R")
            return redWin;
        if(blueWin == "B")
            return blueWin;
        return "N";
    }
    
    public void move(State st){
        Player p = Player.Red;
        switch(moves){
            case 1: break;
            case 2: break;
            default: break;
        }
    }
    public void printBoard(){
        try {
            System.out.println("-------------------------------------------");
            for(int i = 0; i < boardSize; i++){
                for(int j = 0; j < boardSize; j++){
                    System.out.print(boardState[i][j] + "");
                }
                System.out.println("");
            }
            System.out.println("-------------------------------------------");
        } catch (Exception e) {
            throw e;
        }


    }
}
