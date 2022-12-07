/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Board {

    private char[][] board;
    private int size = 8;
    int stoneCount = 18;
    public Board(int size) throws Exception {
        this.size = size;
        createBoard(size);
        clearBoard();
        createStones(size);
    }

    public void createStones(int size){
        this.stoneCount = (size/2) - 1;//3
        
        for(int i = 0; i < stoneCount; i++){
            for(int j = 0; j < stoneCount; j++){
                board[i][j] = 'B';
            }
        }
        
        for(int i = size-1; i >= size-stoneCount; i--){
            for(int j = size-1; j >= size-stoneCount; j--){
                board[i][j] = 'R';
            }
        }
        
    }
    
    public boolean sizeValidity(int size) {
        return !(size < 3 || size % 2 != 0);
    }

    public void createBoard(int size) throws Exception {
        if (sizeValidity(size)) {
            this.board = new char[size][size];
            

        } else {
            throw new Exception("Size Invalid");
        }
    }
    
    public void clearBoard(){
        try {
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    board[i][j] = '-';
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void printBoard(){
        try {
            System.out.println("-------------------------------------------");
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println("");
            }
            System.out.println("-------------------------------------------");
        } catch (Exception e) {
            throw e;
        }
        
        
    }

    
        
}
