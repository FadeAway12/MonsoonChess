import java.util.ArrayList;

public class GenerateLegalMove {
	public static ArrayList<String> legalMoves(int[][] board, boolean first) { //set boolean to TRUE if you're calling from the main to prevent stack overflow
		ArrayList<String> totalMoves = new ArrayList<String>();
		ArrayList<String> pieceMoves = new ArrayList<String>();
		for (int i = 0; i<8; i++) {
			for (int k = 0; k<8; k++) {
				 if (board[i][k] == (1)) {
					 pieceMoves = pawnLegal(i, k, board);
					 for (String n : pieceMoves) {
						 totalMoves.add(n);
					 }
				 }
				 if (board[i][k] == 2) {
					 pieceMoves = knightLegal(i, k, board);
					 for (String n : pieceMoves) {
						 totalMoves.add(n);
					 }
				 }
				 if (board[i][k] == 4) {
					 pieceMoves = rookLegal("rook", i, k, board);
					 for (String n : pieceMoves) {
						 totalMoves.add(n);
					 }
				 }
				 if (board[i][k] == 3) {
					 pieceMoves = bishopLegal("bishop", i, k, board);
					 for (String n : pieceMoves) {
						 totalMoves.add(n);
					 }
				 }
				 if (board[i][k] == 5) {
					 pieceMoves = queenLegal(i, k, board);
					 for (String n : pieceMoves) {
						 totalMoves.add(n);
					 }
				 }
				 if (board[i][k] == 6) {
					 pieceMoves = kingLegal(i, k, board);
					 for (String n : pieceMoves) {
						 totalMoves.add(n);
					 }
				 }
			}
		}
		if (first && WhiteCheckChecker.whiteInCheck(ChessGame.board)) {
			totalMoves = WhiteCheckChecker.filterValid(totalMoves);
			if (totalMoves.size() == 0) { //remove if it doesnt work
				System.out.println("CHECKMATE!"); //remove if it doesnt work
			}
		}
		if (first &&!WhiteCheckChecker.whiteInCheck(ChessGame.board)) { //remove if it doesnt work
			totalMoves = WhiteCheckChecker.filterValid(totalMoves);
			if (totalMoves.size() == 0) {
				System.out.println("STALEMATE!");
			}
		}
		return totalMoves;
		
	}

	public static String makeMove(int row, int col, int rowTo, int colTo) {
		//System.out.println("" + ChessGame.col.charAt(col) + (row+1) + " " + ChessGame.col.charAt(colTo) + (rowTo+1));
		return ("" + ChessGame.col.charAt(col) + (row+1) + " " + ChessGame.col.charAt(colTo) + (rowTo+1));
		
	}
	public static ArrayList<String> pawnLegal(int row, int col, int[][] board) { //will add en passant later
		
		ArrayList<String> moves = new ArrayList<String>();
		//capturing
		if (row+1<8 && col+1<8 && board[row+1][col+1] < 0) {
			moves.add(makeMove(row, col, row+1, col+1));
		}
		//capturing
		if (row+1<8 && col-1>=0 && board[row+1][col-1] < 0) {
			moves.add(makeMove(row, col, row+1, col-1));
		} 
		if (row+1<8 && board[row+1][col] == 0) {
			moves.add(makeMove(row ,col, row+1, col));
		}
		if (row == 1 && board[row+1][col] == 0 && board[row+2][col] == 0) {
			moves.add(makeMove(row, col, row+2, col));
		}
		return moves;
		
	}
	public static ArrayList<String> knightLegal(int row, int col, int[][] board) {
		ArrayList<String> moves = new ArrayList<String>();
		if (row+2<8 && col+1<8 && board[row+2][col+1] <=0) {
			moves.add(makeMove(row, col, row+2, col+1));
		}
		if (row+1<8 && col+2<8 && board[row+1][col+2] <=0) {
			moves.add(makeMove(row, col, row+1, col+2));
		}
		if (row-1>=0 && col+2<8 && board[row-1][col+2] <=0) {
			moves.add(makeMove(row, col, row-1, col+2));
		}
		if (row-2>=0 && col+1<8 && board[row-2][col+1] <=0) {
			moves.add(makeMove(row, col, row-2, col+1));
		}
		if (row-2>=0 && col-1>=0 && board[row-2][col-1] <=0) {
			moves.add(makeMove(row, col, row-2, col-1));
		}
		if (row-1>=0 && col-2>=0 && board[row-1][col-2] <=0) {
			moves.add(makeMove(row, col, row-1, col-2));
		}
		if (row+1<8 && col-2>=0 && board[row+1][col-2] <=0) {
			moves.add(makeMove(row, col, row+1, col-2));
		}
		if (row+2<8 && col-1>=0 && board[row+2][col-1] <=0) {
			moves.add(makeMove(row, col, row+2, col-1));
		}
		return moves;
	}
	private static ArrayList<String> rookLegal(String piece, int row, int col, int[][] board) {
		ArrayList<String> moves = new ArrayList<String>();
		
		//vertically up
		int i = 1;
		boolean notHitEnemy = true;
		while (row+i<8 && board[row+i][col] <= 0 && notHitEnemy) {
			if (board[row+i][col] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row+i, col));
			i++;
		}
		//vertically down
		i = 1;
		notHitEnemy = true;
		while (row-i>=0 && board[row-i][col] <= 0 && notHitEnemy) {
			if (board[row-i][col] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row-i, col));
			i++;
		}
		//to right
		i = 1;
		notHitEnemy = true;
		while (col+i<8 && board[row][col+i] <= 0 && notHitEnemy) {
			if (board[row][col+i] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row, col+i));
			i++;
		}
		//to left
		i = 1;
		notHitEnemy = true;
		while (col-i>=0 && board[row][col-i] <= 0 && notHitEnemy) {
			if (board[row][col-i] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row, col-i));
			i++;
		}
		return moves ;
		
	}
	private static ArrayList<String> bishopLegal(String piece, int row, int col, int[][] board) {
		ArrayList<String> moves = new ArrayList<String>();
		//top right
		int i = 1;
		boolean notHitEnemy = true;
		while (row+i<8 && col+i <8 && board[row+i][col+i]<=0 && notHitEnemy) {
			if (board[row+i][col+i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row+i, col+i));
			i++;
		}
		//top left
		i = 1;
		notHitEnemy = true;
		while (row+i<8 && col-i >=0 && board[row+i][col-i]<=0 && notHitEnemy) {
			if (board[row+i][col-i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row+i, col-i));
			i++;
		}
		//bottom right
		i = 1;
		notHitEnemy = true;
		while (row-i>=0 && col+i <8 && board[row-i][col+i]<=0 && notHitEnemy) {
			if (board[row-i][col+i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row-i, col+i));
			i++;
		}
		//bottom left
		i = 1;
		notHitEnemy = true;
		while (row-i>=0 && col-i>=0 && board[row-i][col-i]<=0 && notHitEnemy) {
			if (board[row-i][col-i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(row, col, row-i, col-i));
			i++;
		}
		return moves;
	}
	
	private static ArrayList<String> queenLegal(int row, int col, int[][] board) {
		
		ArrayList<String> moves = new ArrayList<String>();
		ArrayList<String> diagonal = bishopLegal("queen", row, col, board);
		ArrayList<String> horVert = rookLegal("queen", row, col, board);
		for (int i = 0; i<diagonal.size(); i++) {
			moves.add(diagonal.get(i));
		}
		for (int i = 0; i<horVert.size(); i++) {
			moves.add(horVert.get(i));
		}
		return moves;
	}
	
	private static ArrayList<String> kingLegal(int row, int col, int[][] board) {
		ArrayList<String> moves = new ArrayList<String>();
		
		//straight up
		if (row+1<8 && board[row+1][col]<=0) {
			moves.add(makeMove(row, col, row+1, col));
		}
		//straight down
		if (row-1>=0 && board[row-1][col]<=0) {
			moves.add(makeMove(row, col, row-1, col));
		}
		//right
		if (col+1<8 && board[row][col+1]<=0) {
			moves.add(makeMove(row, col, row, col+1));
		}
		//left
		if (col-1>=0 && board[row][col-1]<=0) {
			moves.add(makeMove(row, col, row, col-1));
		}
		//top right
		if (row+1<8 && col+1<8 && board[row+1][col+1]<=0) {
			moves.add(makeMove(row, col, row+1, col+1));
		}
		//top left
		if (row+1<8 && col-1>=0 && board[row+1][col-1]<=0) {
			moves.add(makeMove(row, col, row+1, col-1));
		}
		//bottom left
		if (row-1>=0 && col-1>=0 && board[row-1][col-1]<=0) {
			moves.add(makeMove(row, col, row-1, col-1));
		}
		//bottom right
		if (row-1>=0 && col+1<8 && board[row-1][col+1]<=0) {
			moves.add(makeMove(row, col, row-1, col+1));
		}
		return moves;
	}
	
	/**public static String makeMove(String piece, int rowTo, int colTo) {
		System.out.println(piece + " " + ChessGame.col.charAt(colTo) + (rowTo+1));
		return piece + " " + ChessGame.col.charAt(colTo) + (rowTo+1);
		
	}
	public static ArrayList<String> pawnLegal(int row, int col) { //will add en passant later
		
		ArrayList<String> moves = new ArrayList<String>();
		//capturing
		if (row+1<8 && col+1<8 && board[row+1][col+1] != 0) {
			moves.add(makeMove("pawn", row+1, col+1));
		}
		//capturing
		if (row+1<8 && col-1>=0 && board[row+1][col-1] != 0) {
			moves.add(makeMove("pawn", row+1, col-1));
		} 
		if (row+1<8 && board[row+1][col] == 0) {
			moves.add(makeMove("pawn", row+1, col));
		}
		if (row == 1 && board[row+1][col] == 0 && board[row+2][col] == 0) {
			moves.add(makeMove("pawn", row+2, col));
		}
		return moves;
		
	}
	public static ArrayList<String> knightLegal(int row, int col) {
		ArrayList<String> moves = new ArrayList<String>();
		if (row+2<8 && col+1<8 && board[row+2][col+1] <=0) {
			moves.add(makeMove("knight", row+2, col+1));
		}
		if (row+1<8 && col+2<8 && board[row+1][col+2] <=0) {
			moves.add(makeMove("knight", row+1, col+2));
		}
		if (row-1>=0 && col+2<8 && board[row-1][col+2] <=0) {
			moves.add(makeMove("knight", row-1, col+2));
		}
		if (row-2>=0 && col+1<8 && board[row-2][col+1] <=0) {
			moves.add(makeMove("knight", row-2, col+1));
		}
		if (row-2>=0 && col-1>=0 && board[row-2][col-1] <=0) {
			moves.add(makeMove("knight", row-2, col-1));
		}
		if (row-1>=0 && col-2>=0 && board[row-1][col-2] <=0) {
			moves.add(makeMove("knight", row-1, col-2));
		}
		if (row+1<8 && col-2>=0 && board[row+1][col-2] <=0) {
			moves.add(makeMove("knight", row+1, col-2));
		}
		if (row+2<8 && col-1>=0 && board[row+2][col-1] <=0) {
			moves.add(makeMove("knight", row+2, col-1));
		}
		return moves;
	}
	private static ArrayList<String> rookLegal(String piece, int row, int col) {
		ArrayList<String> moves = new ArrayList<String>();
		
		//vertically up
		int i = 1;
		boolean notHitEnemy = true;
		while (row+i<8 && board[row+i][col] <= 0 && notHitEnemy) {
			if (board[row+i][col] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row+i, col));
			i++;
		}
		//vertically down
		i = 1;
		notHitEnemy = true;
		while (row-i>=0 && board[row-i][col] <= 0 && notHitEnemy) {
			if (board[row-i][col] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row-i, col));
			i++;
		}
		//to right
		i = 1;
		notHitEnemy = true;
		while (col+i<8 && board[row][col+i] <= 0 && notHitEnemy) {
			if (board[row][col+i] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row, col+i));
			i++;
		}
		//to left
		i = 1;
		notHitEnemy = true;
		while (col-i>=0 && board[row][col-i] <= 0 && notHitEnemy) {
			if (board[row][col-i] < 0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row, col-i));
			i++;
		}
		return moves ;
		
	}
	private static ArrayList<String> bishopLegal(String piece, int row, int col) {
		ArrayList<String> moves = new ArrayList<String>();
		//top right
		int i = 1;
		boolean notHitEnemy = true;
		while (row+i<8 && col+i <8 && board[row+i][col+i]<=0 && notHitEnemy) {
			if (board[row+i][col+i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row+i, col+i));
			i++;
		}
		//top left
		i = 1;
		notHitEnemy = true;
		while (row+i<8 && col-i >=0 && board[row+i][col-i]<=0 && notHitEnemy) {
			if (board[row+i][col-i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row+i, col-i));
			i++;
		}
		//bottom right
		i = 1;
		notHitEnemy = true;
		while (row-i>=0 && col+i <8 && board[row-i][col+i]<=0 && notHitEnemy) {
			if (board[row-i][col+i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row-i, col+i));
			i++;
		}
		//bottom left
		i = 1;
		notHitEnemy = true;
		while (row-i>=0 && col-i>=0 && board[row-i][col-i]<=0 && notHitEnemy) {
			if (board[row-i][col-i]<0) {
				notHitEnemy = false;
			}
			moves.add(makeMove(piece, row-i, col-i));
			i++;
		}
		return moves;
	}
	
	private static ArrayList<String> queenLegal(int row, int col) {
		
		ArrayList<String> moves = new ArrayList<String>();
		ArrayList<String> diagonal = bishopLegal("queen", row, col);
		ArrayList<String> horVert = rookLegal("queen", row, col);
		for (int i = 0; i<diagonal.size(); i++) {
			moves.add(diagonal.get(i));
		}
		for (int i = 0; i<horVert.size(); i++) {
			moves.add(horVert.get(i));
		}
		return moves;
	}
	
	private static ArrayList<String> kingLegal(int row, int col) {
		ArrayList<String> moves = new ArrayList<String>();
		
		//straight up
		if (row+1<8 && board[row+1][col]<=0) {
			moves.add(makeMove("king", row+1, col));
		}
		//straight down
		if (row-1>=0 && board[row-1][col]<=0) {
			moves.add(makeMove("king", row-1, col));
		}
		//right
		if (col+1<8 && board[row][col+1]<=0) {
			moves.add(makeMove("king", row, col+1));
		}
		//left
		if (col-1>=0 && board[row][col-1]<=0) {
			moves.add(makeMove("king", row, col-1));
		}
		//top right
		if (row+1<8 && col+1<8 && board[row+1][col+1]<=0) {
			moves.add(makeMove("king", row+1, col+1));
		}
		//top left
		if (row+1<8 && col-1>=0 && board[row+1][col-1]<=0) {
			moves.add(makeMove("king", row+1, col-1));
		}
		//bottom left
		if (row-1>=0 && col-1>=0 && board[row-1][col-1]<=0) {
			moves.add(makeMove("king", row-1, col-1));
		}
		//bottom right
		if (row-1>=0 && col+1<8 && board[row-1][col+1]<=0) {
			moves.add(makeMove("king", row-1, col+1));
		}
		return moves;
	}*/
}

    
