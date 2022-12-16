
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author Administrator
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Board Size: ");
        int board_size = sc.nextInt();
        
        State board = new State(board_size);
        board.printBoard();
        System.out.println(board.winCondition());
        board.super_secret_test_case();
        board.printBoard();
        do{     
            board.play();
            board.printBoard();
        }
        while(board.winCondition() == "N");        
        switch (board.winner) {
            case "B":
                System.out.println("BLUE WINS");
                break;
            case "R":
                System.out.println("RED WINS");
                break;
        }
        
        /* WINSTATE TESTLERI SİLMEYİN
        System.out.println(board.winsState());
        for(int i = 0; i < (board.boardSize/2) - 1;i++){
            for(int j = 0;j < (board.boardSize/2) - 1;j++){
                board.boardState[i][j] = " R";
            }
        }
        board.printBoard();
        System.out.println(board.winsState());
        board.boardState[0][2] = " B";
        board.printBoard();
        System.out.println(board.winsState());
        for(int i = 7; 4 < i ;i--){
            for(int j = 7;4 <j;j--){
                board.boardState[i][j] = " B";
            }
        }
        board.printBoard();
        System.out.println(board.winsState());

        board.boardState[7][7] = " R";
        board.printBoard();
        System.out.println(board.winsState());
        */

        /* ANA OYUN DÖNGÜSÜ OLACAK
        * do{

        }while(board.winsState() != "N");
        System.out.println(board.winsState());
        */
    }
    
}
