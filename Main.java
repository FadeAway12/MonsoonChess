    import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	public static void main(String args[]) {
		ChessGame.fillBoard();
		ChessGUI window = new ChessGUI();
		
		while (ChessGame.moveNum<50) {
			ChessMove.getMove();
			ChessGame.moveNum++;
			for (int i = 7; i>=0; i--) {
				for (int k = 0; k<8; k++) {
					System.out.print(ChessGame.board[i][k]);
				}
				System.out.println();
			}
			window.repaint();
			ChessMove.getMove();
			ChessGame.moveNum++;
			for (int i = 7; i>=0; i--) {
				for (int k = 0; k<8; k++) {
					System.out.print(ChessGame.board[i][k]);
				}
				System.out.println();
			}
			window.repaint();
		}
		GenerateLegalMove.legalMoves(ChessGame.board, true);
	}
}

    
