import java.util.ArrayList;
import java.util.Scanner;

public class GenerateBotMoves {
	public static void chooseMoveBlack() {
		ArrayList<String> moves = GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
		int length = moves.size();
		int random = (int)(Math.random()*(length));
		executeMove(moves.get(random));
	}
	public static void chooseMoveWhite() {
		ArrayList<String> moves = GenerateLegalMove.legalMoves(ChessGame.board, true);
		int length = moves.size();
		int random = (int)(Math.random()*(length));
		executeMove(moves.get(random));
	}
	public static void executeMove(String move) {
		Scanner check = new Scanner(move);
		String from = check.next();
		String to = "";
		if (check.hasNext())
			to = check.next();
		char coll = from.charAt(0);
		int col = ChessGame.col.indexOf(coll);
		int row = -1;
		if (!move.equals("O-O") && !move.equals("O-O-O") && !ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate)
			row = Integer.parseInt(from.substring(1))-1;
		int piece = 0;
		if (col != -1 && row != -1)
			piece = ChessGame.board[row][col];
		if (move.equals("O-O") && ChessGame.moveNum%2 == 1) {
			ChessGame.board[0][4] = 0;
			ChessGame.board[0][5] = 4;
			ChessGame.board[0][7] = 0;
			ChessGame.board[0][6] = 6;
		}
		else if (move.equals("O-O-O") && ChessGame.moveNum%2 == 1) {
			ChessGame.board[0][4] = 0;
			ChessGame.board[0][3] = 4;
			ChessGame.board[0][2] = 6;
			ChessGame.board[0][0] = 0;
		}
		else if (move.equals("O-O")) {
			ChessGame.board[7][4] = 0;
			ChessGame.board[7][5] = -4;
			ChessGame.board[7][7] = 0;
			ChessGame.board[7][6] = -6;
		}
		else if (move.equals("O-O-O")) {
			ChessGame.board[7][4] = 0;
			ChessGame.board[7][3] = -4;
			ChessGame.board[7][2] = -6;
			ChessGame.board[7][0] = 0;
		}
		else if (from.charAt(1) == '2' && piece == 1 && to.charAt(1) == '4' && ((col+1<8 && ChessGame.board[row+2][col+1] == -1) || 
				(col-1>=0 && ChessGame.board[row+2][col-1] == -1))) {
			ChessGame.board[row][col] = 0;
			if (col+1<8 && ChessGame.board[row+2][col+1] ==-1) {
				int rowTo = row+2;
				int rowFrom = row+3;
				char colFrom= ChessGame.col.charAt(col+1);
				char colTo = ChessGame.col.charAt(col);
				ChessGame.enPassantBlack.add("" + colFrom+ rowFrom + " " + colTo + rowTo);
			}
			else if (col-1>=0 && ChessGame.board[row+2][col-1] == -1) {
				int rowTo = row+2;
				int rowFrom = row+3;
				char colFrom= ChessGame.col.charAt(col-1);
				char colTo = ChessGame.col.charAt(col);
				ChessGame.enPassantBlack.add("" + colFrom+ rowFrom + " " + colTo + rowTo);
			}
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			ChessGame.board[row][col] = piece;
		}
		else if (from.charAt(1) == '7' && piece == -1 && to.charAt(1) == '5' && ((col+1<8 && ChessGame.board[row-2][col+1] == 1) || 
				(col-1>=0 && ChessGame.board[row-2][col-1] == 1))) {
			ChessGame.board[row][col] = 0;
			if (col+1<8 && ChessGame.board[row-2][col+1] ==1) {
				int rowTo = row;
				int rowFrom = row-1;
				char colFrom= ChessGame.col.charAt(col+1);
				char colTo = ChessGame.col.charAt(col);
				ChessGame.enPassantWhite.add("" + colFrom+ rowFrom + " " + colTo + rowTo);
			}
			else if (col-1>=0 && ChessGame.board[row-2][col-1] == 1) {
				int rowTo = row;
				int rowFrom = row-1;
				char colFrom= ChessGame.col.charAt(col-1);
				char colTo = ChessGame.col.charAt(col);
				ChessGame.enPassantWhite.add("" + colFrom+ rowFrom + " " + colTo + rowTo);
			}
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			ChessGame.board[row][col] = piece;
		}
		else {
			if (piece == 6) {
				ChessGame.whiteCanLongCastle = false;
				ChessGame.whiteCanShortCastle = false;
			}
			if (piece == -6) {
				ChessGame.blackCanLongCastle = false;
				ChessGame.blackCanShortCastle = false;
			}
			if (piece == 4 && from.equals("a1")) {
				ChessGame.whiteCanLongCastle = false;
			}
			else if (piece == 4 && from.equals("h1")) {
				ChessGame.whiteCanShortCastle = false;
			}
			if (piece == -4 && from.equals("h8")) {
				ChessGame.blackCanShortCastle = false;
			}
			else if (piece == -4) {
				ChessGame.blackCanLongCastle = false;
			}
			//UNCHARTED TERRITORY

			ChessGame.board[row][col] = 0;
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			for (String s : ChessGame.enPassantBlack) {
				if (move.equals(s)) {
					ChessGame.board[row+1][col] = 0;
				}
			}
			for (String s : ChessGame.enPassantWhite) {
				if (move.equals(s)) {
					ChessGame.board[row-1][col] = 0;
				}
			}
			ChessGame.board[row][col] = piece;
	}
}
}
