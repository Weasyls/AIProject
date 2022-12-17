
import java.util.Scanner;
 
/*
 * @author Emran ft. ParadisEmre
 */

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Board Size: ");
        int board_size = sc.nextInt();

        State board = new State(board_size);
        board.super_secret_test_case();
        board.printBoard();
        do {
            board.play();
        } while (board.winCondition() == "N");
    }
}
