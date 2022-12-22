    import java.util.ArrayList;
import java.util.Scanner;

public class ChessMove {
		
	public static void getMove() {
		boolean isLegal = false;
		String move = "";
		while (!isLegal) {
			Scanner input = new Scanner(System.in);
			System.out.println("Enter your move (current pos then pos to move to).");
			move = input.nextLine();
			isLegal = CheckLegal.checkLegal(move);
			if (!isLegal) {
				System.out.println("Please reinput the information.");
			}
		}
		Scanner check = new Scanner(move);
		String from = check.next();
		String to = check.next();
		char coll = from.charAt(0);
		int col = ChessGame.col.indexOf(coll);
		int row = Integer.parseInt(from.substring(1))-1;
		int piece = ChessGame.board[row][col];
		//UNCHARTED TERRITORY
		ChessGame.board[row][col] = 0;
		col = ChessGame.col.indexOf(to.charAt(0));
		row = Integer.parseInt(to.substring(1))-1;
		ChessGame.board[row][col] = piece;
	}
}
    
