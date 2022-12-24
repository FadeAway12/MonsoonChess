    import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static ChessGUI window = new ChessGUI();
	public static void main(String args[]) {
		ChessGame.fillBoard();
		System.out.println("Would you like to do player vs player or play a bot? (enter 1 or 2 for the equivalent options)");
		Scanner input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("1")) {
			pvp();
		}
		else {
		
		
		//PLAYER VS BOT BELOW!
		
			System.out.print("Would you like to play as white or black? (W for white, B for black)");
		
			String text = input.next();
			while (!text.equals("W") && !text.equals("B")) {
				System.out.println("Invalid input. Please re-enter. ");
				text = input.next();
			}
			if (text.equals("W")) {
				playAsWhite();
			}
			else {
				playAsBlack();
			}
		}
	}
	
	public static void pvp() {
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate) { //will change to not in check/stalemate later
			GenerateLegalMove.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			window.repaint();
			ChessGame.enPassantWhite.clear();
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.blackInCheckMate && !ChessGame.blackInCheckMate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			window.repaint();
			ChessGame.enPassantBlack.clear();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
		}
	}
	
	public static void playAsWhite() {
		System.out.println("You are playing as white!");
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate) {
			GenerateLegalMove.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			ChessGame.enPassantWhite.clear();
			window.repaint();
			//make black ai move
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate)
				GenerateBotMoves.chooseMoveBlack();
			ChessGame.moveNum++;
			ChessGame.enPassantBlack.clear();
			window.repaint();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
		}
	}
	
	public static void playAsBlack() {
		System.out.println("You are playing as black!");
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate) {
			GenerateLegalMove.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate)
				GenerateBotMoves.chooseMoveWhite();
			ChessGame.moveNum++;
			ChessGame.enPassantWhite.clear();
			window.repaint();
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			ChessGame.enPassantBlack.clear();
			window.repaint();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
		}
	}
}

    
