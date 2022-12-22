import java.util.ArrayList;
import java.util.Scanner;

public class BlackCheckChecker {
	public static boolean blackInCheck(int[][] board) {
		boolean checked = false;
		int row = 0;;
		int col = 0;;
		for (int i = 0; i<8; i++) {
			for (int k = 0; k<8; k++) {
				if (board[i][k] == -6) {
					row = i;
					col = k;
				}
			}
		}
		ArrayList<String> legalMoves = GenerateLegalMove.legalMoves(board, false);
		for (int i = 0; i<legalMoves.size(); i++) {
			String move = legalMoves.get(i);
			Scanner check = new Scanner(move);
			String from = check.next();
			String to = check.next();
			char coll = ChessGame.col.charAt(col);
			
			String kingPos = coll+""+(row+1);
			if (kingPos.equals(to)) {
				
				checked = true;
			}
		}
		return checked;
	}
	public static ArrayList<String> filterValid(ArrayList<String> legalMoves) { //test if the resultant position from a black move puts the black king out of check (blocking, capturing, moving)
		ArrayList<String> list = new ArrayList<String>();
		int[][] board2 = new int[8][8];
		for (String n : legalMoves) {
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					board2[i][k] = ChessGame.board[i][k];
				}//making a copy of board array
			}
			Scanner check = new Scanner(n);
			String from = check.next();
			String to = check.next();
			char coll = from.charAt(0);
			int col = ChessGame.col.indexOf(coll);
			int row = Integer.parseInt(from.substring(1))-1;
			int piece = board2[row][col];
			//UNCHARTED TERRITORY
			board2[row][col] = 0;
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			board2[row][col] = piece;
			if (!blackInCheck(board2)) {
				list.add(n);
			}
		} 
		
		return list;
	}
}

    
