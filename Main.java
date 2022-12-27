    import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static ChessGUI window = new ChessGUI();
	public static void main(String args[]) {
		ChessGame.fillBoard();
		System.out.println("Would you like to do player vs player or play a bot? (enter 1 or 2 for the equivalent options. 3 for bot vs random bot (black)");
		Scanner input = new Scanner(System.in);
		String option = input.next();
		if (option.equals("1")) {
			pvp();
		}
		else if (option.equals("3")) {
			botVbot();
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
	public static void botVbot() {
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate && !ChessGame.stalemate) { //will change to not in check/stalemate later
			
			if (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate && !ChessGame.stalemate)
				GenerateBotMoves.chooseMoveWhite();
			ChessGame.moveNum++;
			window.repaint();
			ChessGame.enPassantWhite.clear();
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate && !ChessGame.stalemate)
				GenerateBotMoves.randomBlack();
			ChessGame.moveNum++;
			window.repaint();
			ChessGame.enPassantBlack.clear();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
			ChessGame.PGN += "# 1-0";
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
			ChessGame.PGN += "# 0-1";
		}
		else {
			System.out.println("Stalemate!");
			ChessGame.PGN += " 1/2-1/2";
		}
		System.out.println(ChessGame.PGN);
	}
	public static void pvp() {
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate && !ChessGame.stalemate) { //will change to not in check/stalemate later
			GenerateLegalMove.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate && !ChessGame.stalemate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			window.repaint();
			ChessGame.enPassantWhite.clear();
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.blackInCheckMate && !ChessGame.blackInCheckMate && !ChessGame.stalemate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			window.repaint();
			ChessGame.enPassantBlack.clear();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
			ChessGame.PGN += "# 1-0";
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
			ChessGame.PGN += "# 0-1";
		}
		else {
			System.out.println("Stalemate!");
			ChessGame.PGN += " 1/2-1/2";
		}
		System.out.println(ChessGame.PGN);
	}
	
	public static void playAsWhite() {
		System.out.println("You are playing as white!");
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate && !ChessGame.stalemate) {
			GenerateLegalMove.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate && !ChessGame.stalemate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			ChessGame.enPassantWhite.clear();
			window.repaint();
			//make black ai move
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate && !ChessGame.stalemate)
				GenerateBotMoves.chooseMoveBlack();
			ChessGame.moveNum++;
			ChessGame.enPassantBlack.clear();
			window.repaint();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
			ChessGame.PGN += "# 1-0";
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
			ChessGame.PGN += "# 0-1";
		}
		else {
			System.out.println("Stalemate!");
			ChessGame.PGN += " 1/2-1/2";
		}
		System.out.println(ChessGame.PGN);
	}
	
	public static void playAsBlack() {
		System.out.println("You are playing as black!");
		while (!ChessGame.blackInCheckMate && !ChessGame.whiteInCheckMate && !ChessGame.stalemate) {
			GenerateLegalMove.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate && !ChessGame.stalemate)
				GenerateBotMoves.chooseMoveWhite();
			ChessGame.moveNum++;
			ChessGame.enPassantWhite.clear();
			window.repaint();
			GenerateLegalMoveBlack.legalMoves(ChessGame.board, true);
			if (!ChessGame.whiteInCheckMate && !ChessGame.blackInCheckMate && !ChessGame.stalemate)
				ChessMove.getMove();
			ChessGame.moveNum++;
			ChessGame.enPassantBlack.clear();
			window.repaint();
		}
		if (ChessGame.blackInCheckMate) {
			System.out.println("White wins!");
			ChessGame.PGN += "# 1-0";
		}
		else if (ChessGame.whiteInCheckMate) {
			System.out.println("Black wins!");
			ChessGame.PGN += "# 0-1";
		}
		else {
			System.out.println("Stalemate!");
			ChessGame.PGN += " 1/2-1/2";
		}
		System.out.println(ChessGame.PGN);
	}
}

    