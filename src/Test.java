
import java.util.Scanner;
 
/*
 * @author Emran ft. ParadisEmre
 */

public class Test {

    public static void main(String[] args) {
        System.out.print("Enter Board Size: ");
        State board = new State(new Scanner(System.in).nextInt());
        
        board.printBoard();
        
        do {
            board.play();
        } while (board.winCondition() == "N");
    }
}
