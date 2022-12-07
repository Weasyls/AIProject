
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
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Board Size: ");
        int board_size = sc.nextInt();
        
        State board = new State(board_size);
        board.printBoard();
        
    }
    
}
