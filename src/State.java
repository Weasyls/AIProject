
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

    enum Player{Red, Blue};
    List<State> childList = new ArrayList<>();
    int moves;
    Board board;
    
    public State(int size) throws Exception{//Birden fazla parametre alan state constructoru o anki boardı oluşturmak için
        this.board = new Board(size);
    }
    public State(State st) throws Exception{
        this.board = st.board;
    }
    public boolean gameOverState(){
        
        return false;
    }
    
    public void move(State st){
        Player p = Player.Red;
        switch(moves){
            case 1: break;
            case 2: break;
            default: break;
        }
    }
}
