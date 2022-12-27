import java.util.ArrayList;

public class PGNmaker {
	public static void PGNMaker(String move) {
		int[][] arr = new int[8][8];
		for (int i = 0; i<8; i++) {
			for (int k = 0; k<8; k++) {
				arr[i][k] = ChessGame.board[i][k];
			}
		}
		GenerateBotMoves.executeMove(move, arr);
		String let = "abcdefgh";
		int[] moveInfo = GenerateBotMoves.moveInfo(move, ChessGame.board);
		String moveText = "";
		if (move.equals("O-O")) {
			moveText = "O-O";
			if (ChessGame.moveNum%2 == 1)
				ChessGame.PGN += " " + (ChessGame.moveNum+1)/2 + ". " + moveText;
			else
				ChessGame.PGN += " " + moveText;
			return;
		}
		if (move.equals("O-O-O")) {
			moveText = "O-O-O";
			if (ChessGame.moveNum%2 == 1)
				ChessGame.PGN += " " + (ChessGame.moveNum+1)/2 + ". " + moveText;
			else
				ChessGame.PGN += " " + moveText;
			return;
		}
		if (moveInfo[0] == 2) {
			moveText+="N";
		}
		if (moveInfo[0] == 3) {
			moveText+="B";
		}
		if (moveInfo[0] == 4) {
			moveText+="R";
		}
		if (moveInfo[0] == 5) {
			moveText+="Q";
		}
		if (moveInfo[0] == 6) {
			moveText+="K";
		}
		if (moveInfo[0] == -2) {
			moveText+="N";
		}
		if (moveInfo[0] == -3) {
			moveText+="B";
		}
		if (moveInfo[0] == -4) {
			moveText+="R";
		}
		if (moveInfo[0] == -5) {
			moveText+="Q";
		}
		if (moveInfo[0] == -6) {
			moveText+="K";
		}
		if (moveInfo[0]>0) {
			ArrayList<String> list = GenerateLegalMove.legalMoves(arr, false);
			WhiteCheckChecker.filterValid(list, arr);
			boolean thing = false;
			for (String move2 : list) {
				int[] moveInfo2 = GenerateBotMoves.moveInfo(move2, arr);
				if (moveInfo2[0] == moveInfo[0] && moveInfo2[3] == moveInfo[3] && moveInfo[4] == moveInfo2[4]) {
					thing = true;
				}
			}
			if (thing)
				moveText+= let.substring(moveInfo[2], moveInfo[2]+1);
		}
		if (ChessGame.board[moveInfo[3]][moveInfo[4]] != 0) {
			if (moveInfo[0] == 1 || moveInfo[0] == -1) {
				moveText+= let.substring(moveInfo[2], moveInfo[2]+1);
			}
			moveText +="x";
		}
		String col = let.substring(moveInfo[4], moveInfo[4]+1);
		int row = moveInfo[3]+1;
		moveText += col+row;
		if (moveInfo[0] == 1 && moveInfo[3] == 7) {
			if (arr[moveInfo[3]][moveInfo[4]] == 5)
				moveText+="=Q";
			if (arr[moveInfo[3]][moveInfo[4]] == 2)
				moveText+="=N";
			if (arr[moveInfo[3]][moveInfo[4]] == 3)
				moveText+="=B";
			if (arr[moveInfo[3]][moveInfo[4]] == 4)
				moveText+="=R";
		}
		if (moveInfo[0] == -1 && moveInfo[3] == 0) {
			if (arr[moveInfo[3]][moveInfo[4]] == -5)
				moveText+="=Q";
			if (arr[moveInfo[3]][moveInfo[4]] == -2)
				moveText+="=N";
			if (arr[moveInfo[3]][moveInfo[4]] == -3)
				moveText+="=B";
			if (arr[moveInfo[3]][moveInfo[4]] == -4)
				moveText+="=R";
		}
		//System.out.println((ChessGame.moveNum+1)/2 + ". " + moveText);
		if (ChessGame.moveNum%2 == 1)
			ChessGame.PGN += " " + (ChessGame.moveNum+1)/2 + ". " + moveText;
		else
			ChessGame.PGN += " " + moveText;
	}
}
