
import java.util.Scanner;

/*
 * @author Emran ft. ParadisEmre
 */
public class Test {

    public static void main(String[] args) {
        //System.out.print("Enter Board Size: ");
        //State board = new State(new Scanner(System.in).nextInt());
        State board = new State(8);
        board.printBoard();
        board.utilityTest();
        board.printBoard();
        do {
            board.play();
        } while (board.winCondition() == "N");
        switch (board.winner) {
            case "B":
                System.out.println("BLUE WINS");
                break;
            case "R":
                System.out.println("RED WINS");
                break;
        }
    }
}
