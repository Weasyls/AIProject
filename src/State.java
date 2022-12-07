
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
    String[][] boardState; //GEÇİCİ OLARAK PRİVATE KALDIRDIM MAİNDE MOVE KULLANMADNA DEĞİŞTİRİP DEBUG İÇİN
    List<State> childList = new ArrayList<>();
    String winner = "N";
    int boardSize, stoneCount = 18;
    int moves;
    
    public State(int size){//Birden fazla parametre alan state constructoru o anki boardı oluşturmak için
        createBoard(size);
        resetBoard();
    }
    public State(State st){
        this.boardState = st.boardState;
        this.winner = st.winner;
        this.boardSize = st.boardSize;
        this.stoneCount = st.stoneCount;
    }
    public void resetBoard(){  //CLEAR BOARDDAN İNİTİALA ÇEVİRDİM TAŞLARI DA BURDA KOYUYOR
        try {
            for(int i = 0; i < boardSize; i++){
                for(int j = 0; j < boardSize; j++){
                    boardState[i][j] = " -";
                }
            }
            createStones(boardSize);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void createStones(int size){ // DEĞİŞMEDİ
        this.stoneCount = (size/2) - 1;//8-3 6-2 4-1  (N+1)*2 = boardSize

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
    public void sizeValidity(int size) { // SIZE KURALLARA UYMUYORSA DEFAULT OLARAK 8 YAPIYOR UYUYORSA PARAMETREYI KULLANIYOR
        if(size < 3 || size % 2 != 0){
            this.boardSize = 8;
        }
        else
            this.boardSize = size;
    }
    public void createBoard(int size){
        sizeValidity(size);
        this.boardState = new String[boardSize][boardSize];

    }
    public String winCondition(){
        String redWin = "R", blueWin = "B";
        winner = "N";

        for(int i = 0; i < (boardSize/2) -1;i++){
            for(int j = 0;j < (boardSize/2) -1;j++){
                //HEPSİ REDE EŞİTSE İFE GİRMEZ REDWİN TRUE OLARAK KALIR
                if(boardState[i][j] != " R"){
                    redWin = "N";
                    break;
                }
            }
        }
        for(int i = boardSize - 1; (boardSize/2) < i ;i--){
            for(int j = boardSize - 1;(boardSize/2) < j;j--){
                //HEPSİ BLUE EŞİTSE İFE GİRMEZ BLUEWİN TRUE OLARAK KALIR
                if(boardState[i][j] != " B"){
                    blueWin = "N";
                    break;
                }
            }
        }
        // BURA DAHA TEMİZ YAZILABİLİR AMA KAFAM ÇALIŞMADIĞI İÇİN BÖYLE YAPTIM
        if(redWin == "R")
            winner = "R";
        if(blueWin == "B")
            winner = "B";
        return winner;
    }
    
    public void move(State st){
        Player p = Player.Red;
        Player T = Player.Blue;
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
