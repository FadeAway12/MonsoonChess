import java.util.ArrayList;

/**
 * EACH square will be occupied by a piece represented by a char. Capital is white
 * 1 = pawn, 2 = knight, 3 = bishop, 4 = rook, 5 = queen, 6 = king, 0 = empty
 * Negative for black
 */
public class ChessGame {
	
	static int[][] board = new int[8][8]; //the chessboard
	/**
	 * 0, 1, 2, 3, 4, 5, 6, 7 = 1 2 3 4 5 6 7 8 (rows)
	 * 0 1 2 3 4 5 6 7 = a b c d e f g h (cols)
	 */
	static String PGN = "";
	static String col = "abcdefgh";
	static ArrayList<String> enPassantBlack = new ArrayList<String>();
	static ArrayList<String> enPassantWhite = new ArrayList<String>();
	static boolean isWhite;
	static boolean whiteInCheckMate = false;
	static boolean blackInCheckMate = false;
	static boolean stalemate = false;
	static boolean whiteCanLongCastle = true;
	static boolean blackCanLongCastle = true;
	static boolean whiteCanShortCastle = true;
	static boolean blackCanShortCastle = true;
	static boolean whiteChecked;
	static boolean blackChecked;
	static int moveNum = 1;
	public static void fillBoard() {
		for (int i = 0; i<8; i++) {
			board[1][i] = 1; //change back to 1
			board[6][i] = -1;
		}
		board[0][0] = 4;
		
		board[0][7] = 4;
		board[0][1] = 2;
		board [0][6] = 2;
		board [0][2] = 3;
		board [0][5] = 3;
		board [0][3] = 5;
		board [0][4] = 6;
		board[7][0] = -4;
		board[7][7] = -4;
		board[7][1] = -2;
		board[7][2] = -3;
		board[7][3]= -5; 
		
		board [7][4] = -6;
		board [7][5] = -3;
		board [7][6] = -2;
		for (int i = 2; i<=5; i++) {
			for (int k = 0; k<8; k++) {
				board[i][k] = 0;
			}
		}
		for (int i = 7; i>=0; i--) {
			for (int k = 0; k<8; k++) {
				System.out.print(board[i][k]);
			}
			System.out.println();
		}
	}
}

    

    