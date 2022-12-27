import java.util.ArrayList;
import java.util.Scanner;

public class GenerateBotMoves {
	public static ArrayList<String> sortMoves(ArrayList<String> moves, int[][] board) {
		
		ArrayList<String> movesSorted = new ArrayList<>();
		for (String move : moves) {
			int[] moveInfo = moveInfo(move, board); //{piece, fromRow, fromCol, toRow, toCol};
			int[][] boardCopy = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardCopy[i][k] = board[i][k];
				}
			}
			int row = moveInfo[3];
			int col = moveInfo[4];
			executeMove(move, boardCopy);
			if (BlackCheckChecker.blackInCheck(boardCopy)) {
				movesSorted.add(move);
			}
				
		}
		for (String move : moves) {
			int[] moveInfo = moveInfo(move, board); //{piece, fromRow, fromCol, toRow, toCol};
			int[][] boardCopy = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardCopy[i][k] = board[i][k];
				}
			}
			int row = moveInfo[3];
			int col = moveInfo[4];
			executeMove(move, boardCopy);
			if (board[row][col] < 0) {
				movesSorted.add(move);
			}
		}
		for (String move : moves) {
			int[] moveInfo = moveInfo(move, board); //{piece, fromRow, fromCol, toRow, toCol};
			int[][] boardCopy = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardCopy[i][k] = board[i][k];
				}
			}
			int row = moveInfo[3];
			int col = moveInfo[4];
			executeMove(move, boardCopy);
			if (moveInfo[0] == 1 && moveInfo[2] != moveInfo[4]) {
				movesSorted.add(move);
			}
		}
		for (String move : moves) {
			int[] moveInfo = moveInfo(move, board); //{piece, fromRow, fromCol, toRow, toCol};
			int[][] boardCopy = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardCopy[i][k] = board[i][k];
				}
			}
			int row = moveInfo[3];
			int col = moveInfo[4];
			executeMove(move, boardCopy);
			if ((moveInfo[0] == 2 || moveInfo[0] == 3) && ChessGame.moveNum<15) {
				movesSorted.add(move);
			}
		}
		for (String move : moves) {
			int[] moveInfo = moveInfo(move, board); //{piece, fromRow, fromCol, toRow, toCol};
			int[][] boardCopy = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardCopy[i][k] = board[i][k];
				}
			}
			int row = moveInfo[3];
			int col = moveInfo[4];
			executeMove(move, boardCopy);
			if (moveInfo[3]>=2 && moveInfo[4] >=2 && moveInfo[4]<=5) {
				movesSorted.add(move);
			}
		}
		for (String move : moves) {
			movesSorted.add(move);
		}
		ArrayList<String> prunedList = new ArrayList<>();
		for (String move : movesSorted) {
			if (!prunedList.contains(move)) {
				prunedList.add(move);
			}
		}
		return prunedList;
	}
	public static void chooseMoveWhite() {
		if (OpeningBook.inOpening) {
			String mov = OpeningBook.londonWhite();
			if (mov.length()>2) {
				System.out.println(mov);
				PGNmaker.PGNMaker(mov);
				executeMove(mov, ChessGame.board);
				return;
			}
		}
		int maxEval = Integer.MIN_VALUE;
		int indexBest = 0;
		ArrayList<String> movesW = GenerateLegalMove.legalMoves(ChessGame.board, true);
		movesW = sortMoves(movesW, ChessGame.board);
		for (String move : movesW) {
			int[][] boardClone = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardClone[i][k] = ChessGame.board[i][k];
				}
			}
			executeMove(move, boardClone);
			int eval = miniMax(boardClone, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
			int[] moveInfo = moveInfo(move, ChessGame.board);
			if (move.equals("O-O") || move.equals("O-O-O")) {
				eval+=2;
			}
			if (eval>maxEval) {
				maxEval = eval;
				indexBest = movesW.indexOf(move);
			}
			
		}
		if (movesW.size()>0) {
			String bestMove = movesW.get(indexBest);
			PGNmaker.PGNMaker(bestMove);
			executeMove(bestMove, ChessGame.board);
		}
	}
	public static void randomBlack() {
		ArrayList<String> moves = GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
		int length = moves.size();
		int random = (int)(Math.random()*(length));
		PGNmaker.PGNMaker(moves.get(random));
		executeMove(moves.get(random), ChessGame.board);
	}
	public static void chooseMoveBlack() {
		int minEval = Integer.MAX_VALUE;
		int indexBest = 0;
		ArrayList<String> movesW = GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
		for (String move : movesW) {
			int[][] boardClone = new int[8][8];
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					boardClone[i][k] = ChessGame.board[i][k];
				}
			}
			executeMove(move, boardClone);
			int eval = miniMax(boardClone, 1, Integer.MIN_VALUE, Integer.MAX_VALUE, true);
			int[] moveInfo = moveInfo(move, ChessGame.board);
			if (moveInfo[3]<6 && moveInfo[4]>2 && moveInfo[4]<6) {
				System.out.println((move + ": " + eval));
				eval+=1;
			}
			if (eval<minEval) {
				minEval = eval;
				indexBest = movesW.indexOf(move);
			}
		}
		executeMove(movesW.get(indexBest), ChessGame.board);
	}
	public static int miniMax (int[][] board, int depth, int alpha, int beta, boolean maximizingPlayer) {
		ArrayList<String> movesW = GenerateLegalMove.legalMoves(board, false);
		WhiteCheckChecker.filterValid(movesW, board);
		ArrayList<String> movesB = GenerateLegalMove.legalMoves(board, false);
		BlackCheckChecker.filterValid(movesB, board);
		if (depth == 0 || (WhiteCheckChecker.whiteInCheck(board) && movesW.size() == 0) || (BlackCheckChecker.blackInCheck(board) && movesB.size() == 0)) {
			int sum = 0;
			for (int i = 0; i<8; i++) {
				for (int k = 0; k<8; k++) {
					sum+=board[i][k];
				}
			}
			if (WhiteCheckChecker.whiteInCheck(board) && movesW.size() == 0) {
				sum = -318;
			}
			else if (movesW.size() == 0) {
				sum = 0;
			}
			if (BlackCheckChecker.blackInCheck(board) && movesB.size() == 0) {
				sum = 318;
			}
			else if (movesB.size() == 0) {
				sum = 0;
			}
			return sum;
		}
		if (maximizingPlayer) {
			int maxEval = Integer.MIN_VALUE;
			ArrayList<String> moves = GenerateLegalMove.legalMoves(board, true);
			for (String move : moves) {
				int[][] boardClone = new int[8][8];
				for (int i = 0; i<8; i++) {
					for (int k = 0; k<8; k++) {
						boardClone[i][k] = board[i][k];
					}
				}
				executeMove(move, boardClone);
				int eval = miniMax(boardClone, depth-1, alpha, beta, false);
				maxEval = Math.max(eval, maxEval);
				alpha = Math.max(eval, alpha);
				if (alpha>=beta) {
					break;
				}
			}
			return maxEval;
		}
		else {
			int minEval = Integer.MAX_VALUE;
			ArrayList<String> moves = GenerateLegalMoveBlack.legalMoves(board, true);
			for (String move : moves) {
				int[][] boardClone = new int[8][8];
				for (int i = 0; i<8; i++) {
					for (int k = 0; k<8; k++) {
						boardClone[i][k] = board[i][k];
					}
				}
				executeMove(move, boardClone);
				int eval = miniMax(boardClone, depth-1, alpha, beta,  true);
				minEval = Math.min(minEval, eval);
				beta = Math.min(beta, eval);
				if (beta<=alpha) {
					break;
				}
			}
			return minEval;
		}

	}
	public static int[] moveInfo(String move, int[][] board) {
		String alph = "abcdefgh";
		Scanner check = new Scanner(move);
		String from = "";
		String to = "";
		from = check.next();
		if (check.hasNext()) {
			to = check.next();
			
			int fromCol = alph.indexOf(from.charAt(0));
			int toCol = alph.indexOf(to.charAt(0));
			int fromRow = Integer.parseInt(from.substring(1))-1;
			int toRow = Integer.parseInt(to.substring(1))-1;
			int piece = board[fromRow][fromCol];
			int[] arr = {piece, fromRow, fromCol, toRow, toCol};
			return arr;
		}
		else {
			int[] arr = {100, 100, 100, 100, 100, 100};
			return arr;
		}
	}
	public static void executeMove(String move, int[][] board) {
		boolean isReal = true;
		for (int i = 0; i<8; i++) {
			for (int k = 0; k<8; k++) {
				if (ChessGame.board[i][k] != board[i][k]) {
					isReal = false;
				}
			}
		}
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
			piece = board[row][col];
		if (move.equals("O-O") && ChessGame.moveNum%2 == 1) {
			board[0][4] = 0;
			board[0][5] = 4;
			board[0][7] = 0;
			board[0][6] = 6;
		}
		else if (move.equals("O-O-O") && ChessGame.moveNum%2 == 1) {
			board[0][4] = 0;
			board[0][3] = 4;
			board[0][2] = 6;
			board[0][0] = 0;
		}
		else if (move.equals("O-O")) {
			board[7][4] = 0;
			board[7][5] = -4;
			board[7][7] = 0;
			board[7][6] = -6;
		}
		else if (move.equals("O-O-O")) {
			board[7][4] = 0;
			board[7][3] = -4;
			board[7][2] = -6;
			board[7][0] = 0;
		}
		else if (from.charAt(1) == '2' && piece == 1 && to.charAt(1) == '4' && ((col+1<8 && board[row+2][col+1] == -1) || 
				(col-1>=0 && board[row+2][col-1] == -1))) {
			board[row][col] = 0;
			if (col+1<8 && board[row+2][col+1] ==-1) {
				int rowTo = row+2;
				int rowFrom = row+3;
				char colFrom= ChessGame.col.charAt(col+1);
				char colTo = ChessGame.col.charAt(col);
				//ChessGame.enPassantBlack.add("" + colFrom+ rowFrom + " " + colTo + rowTo); - IMPLEMENT LATER **
			}
			else if (col-1>=0 && board[row+2][col-1] == -1) {
				int rowTo = row+2;
				int rowFrom = row+3;
				char colFrom= ChessGame.col.charAt(col-1);
				char colTo = ChessGame.col.charAt(col);
				//ChessGame.enPassantBlack.add("" + colFrom+ rowFrom + " " + colTo + rowTo); - IMPLEMENT LATER **
			}
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			board[row][col] = piece;
		}
		else if (from.charAt(1) == '7' && piece == -1 && to.charAt(1) == '5' && ((col+1<8 && board[row-2][col+1] == 1) || 
				(col-1>=0 && board[row-2][col-1] == 1))) {
			board[row][col] = 0;
			if (col+1<8 && board[row-2][col+1] ==1) {
				int rowTo = row;
				int rowFrom = row-1;
				char colFrom= ChessGame.col.charAt(col+1);
				char colTo = ChessGame.col.charAt(col);
				ChessGame.enPassantWhite.add("" + colFrom+ rowFrom + " " + colTo + rowTo);
			}
			else if (col-1>=0 && board[row-2][col-1] == 1) {
				int rowTo = row;
				int rowFrom = row-1;
				char colFrom= ChessGame.col.charAt(col-1);
				char colTo = ChessGame.col.charAt(col);
				ChessGame.enPassantWhite.add("" + colFrom+ rowFrom + " " + colTo + rowTo);
			}
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			board[row][col] = piece;
		}
		else {
			if (piece == 6 && isReal) {
				ChessGame.whiteCanLongCastle = false;
				ChessGame.whiteCanShortCastle = false;
			}
			if (piece == -6 && isReal) {
				ChessGame.blackCanLongCastle = false;
				ChessGame.blackCanShortCastle = false;
			}
			if (piece == 4 && from.equals("a1") && isReal) {
				ChessGame.whiteCanLongCastle = false;
			}
			else if (piece == 4 && from.equals("h1") && isReal) {
				ChessGame.whiteCanShortCastle = false;
			}
			if (piece == -4 && from.equals("h8") && isReal) {
				ChessGame.blackCanShortCastle = false;
			}
			else if (piece == -4 && isReal) {
				ChessGame.blackCanLongCastle = false;
			}
			//UNCHARTED TERRITORY
			if (piece==1 && row == 6){
				piece=5;
			}
			if (piece==-1 && row == 1){
				piece=-5;
			}
			if (row>=0 && col>=0) {
				board[row][col] = 0;
			}
			col = ChessGame.col.indexOf(to.charAt(0));
			row = Integer.parseInt(to.substring(1))-1;
			for (String s : ChessGame.enPassantBlack) {
				if (move.equals(s)) {
					board[row+1][col] = 0;
				}
			}
			for (String s : ChessGame.enPassantWhite) {
				if (move.equals(s)) {
					board[row-1][col] = 0;
				}
			}
			board[row][col] = piece;
	}
}
}