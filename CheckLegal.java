    import java.util.ArrayList;

public class CheckLegal {

	public static boolean checkLegal(String move) {
		
		boolean legal = false;
		
		if (ChessGame.moveNum%2 == 1) {
			ArrayList<String> moves = GenerateLegalMove.legalMoves(ChessGame.board, true);
			for (String s : moves) {
				if (s.equals(move)) {
					legal = true;
				}
			}
		}
		else {
			ArrayList<String> moves = GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			for (String s : moves) {
				if (s.equals(move)) {
					legal = true;	
				}
			}
		}
		
		return legal;
	}
	
}

    