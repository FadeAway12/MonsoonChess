    import java.util.ArrayList;
import java.util.Scanner;

public class BlackCastle {
	public static boolean shortPathClear() {
		if (!ChessGame.blackCanShortCastle) {
			return false;
		}
		if (ChessGame.board[7][5] != 0 || ChessGame.board[7][6] != 0) {
			return false;
		}
		ArrayList<String> list = GenerateLegalMove.legalMoves(ChessGame.board, false);
		for (String s : list) {
			Scanner check = new Scanner(s);
			check.next();
			String to = check.next();
			if (to.equals("f8") || to.equals("g8") || to.equals("e8")) {
				return false;
			}
		}
		return true;
	}
	public static boolean longPathClear() {
		if (!ChessGame.blackCanLongCastle) {
			return false;
		}
		if (ChessGame.board[7][1] != 0 || ChessGame.board[7][2] != 0 || ChessGame.board[7][3] != 0) {
			return false;
		}
		ArrayList<String> list = GenerateLegalMove.legalMoves(ChessGame.board, false);
		for (String s : list) {
			Scanner check = new Scanner(s);
			check.next();
			String to = check.next();
			if (to.equals("b8") || to.equals("c8") || to.equals("d8") || to.equals("e8")) {
				return false;
			}
		}
		return true;
	}
}

    
