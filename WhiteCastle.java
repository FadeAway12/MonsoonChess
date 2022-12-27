    import java.util.ArrayList;
import java.util.Scanner;

public class WhiteCastle {
	public static boolean shortPathClear() {
		if (!ChessGame.whiteCanShortCastle) {
			return false;
		}
		if (ChessGame.board[0][5] != 0 || ChessGame.board[0][6] != 0) {
			return false;
		}
		ArrayList<String> list = GenerateLegalMoveBlack.legalMoves(ChessGame.board, false);
		for (String s : list) {
			Scanner check = new Scanner(s);
			check.next();
			String to = check.next();
			if (to.equals("f1") || to.equals("g1") || to.equals("e1")) {
				return false;
			}
		}
		return true;
	}
	public static boolean longPathClear() {
		if (!ChessGame.whiteCanLongCastle) {
			return false;
		}
		if (ChessGame.board[0][1] != 0 || ChessGame.board[0][2] != 0 || ChessGame.board[0][3] != 0) {
			return false;
		}
		ArrayList<String> list = GenerateLegalMoveBlack.legalMoves(ChessGame.board, false);
		for (String s : list) {
			Scanner check = new Scanner(s);
			check.next();
			String to = check.next();
			if (to.equals("e1") || to.equals("b1") || to.equals("c1") || to.equals("d1")) {
				return false;
			}
		}
		return true;
	}
}

    