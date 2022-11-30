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
    private int size;

    public Board(int size) throws Exception {
        createBoard(size);
    }

    public boolean sizeValidity(int size) {
        return !(size < 3 || size % 2 != 0);
    }

    public void createBoard(int size) throws Exception {
        if (sizeValidity(size)) {
            this.size = size;
            this.board = new char[size][size];

        } else {
            throw new Exception("Size Invalid");
        }
    }
    
    public void clearBoard(){
        try {
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    board[i][j] = 'E';
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
