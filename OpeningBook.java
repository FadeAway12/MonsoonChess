
public class OpeningBook {
	static boolean inOpening = true;
	static int move = 0;
	public static String londonWhite() {
		if (ChessGame.moveNum == 1) {
			return "d2 d4";
		}
		if (ChessGame.moveNum == 3) {
			if (ChessGame.board[4][3] == -1) { //1. d4 d5 (queen's pawn)
				move = 0;
				return "c1 f4";
			}
			if (ChessGame.board[5][5] == -2) { //1. d4 Nxf6 (indian game)
				move = 1;
				return "c2 c4";
			}
			if (ChessGame.board[4][4] == -1) { //1. d4 e5 (englund gambit)
				move = 2;
				return "d4 e5";
			}
			if (ChessGame.board[5][4] == -1) { //1. d4 e6 (horwitz defense)
				move = 3;
				return "c2 c4";
			}
			if (ChessGame.board[4][2] == -1) { //1. d4 c5 (old benoni)
				move = 4;
				return "d4 d5";
			}
			if (ChessGame.board[4][5] == -1) { //1. d4 f5 (dutch defense);
				return "c2 c4";
			}
			if (ChessGame.board[5][2] == -2) { //1. d4 Nxc6 (mikenas defense)
				return "d4 d5";
			}
			if (ChessGame.board[5][6] == -1) { //1. d4 g6 (modern defense)
				return "e2 e4";
			}
			if (ChessGame.board[5][2] == -1) { //1. d4 c5 (old benoni)
				return "d4 d5";
			}
			if (ChessGame.board[5][1] == -1) { //1. d4 b6 (english defense)
				return "e2 e4";
			}
			if (ChessGame.board[4][1] == -1) { //1. d4 b5 (polish defense)
				return "e2 e4";
			}
		}
		if (ChessGame.moveNum == 5) {
			if (move == 0) { //queen's pawn
				if (ChessGame.board[5][5] == -2) { //d4 d5 Bf4 Nxf6 Nxf3
					move = 0;
					return ("g1 f3");
				}
				if (ChessGame.board[4][2] == -1) { //d4 d5 Bf4 c5 e3
					move = 1;
					return ("e2 e3");
				}
				if (ChessGame.board[5][4] == -1) { //d4 d5 Bf4 e6 Nxf3
					move = 2;
					return ("g1 f3");
				}
				if (ChessGame.board[5][2] == -1) { //d4 d5 Bf4 Nxf6 Nxf3
					return ("g1 f3");
				}
			}
			if (move == 1) { //indian game
				if (ChessGame.board[5][4] == -1) { //d4 Nxf6 c4 e6 Nxf3
					move = 3;
					return ("g1 f3");
				}
				if (ChessGame.board[5][6] == -1) { //d4 Nxf6 c4 g6 c3
					move = 4;
					return ("b1 c3");
				}
				if (ChessGame.board[4][2] == -1) { //d4 Nxf6 c4 c5 d5
					return ("d4 d5");
				}
			}
			if (move == 2) { //englund
				if (ChessGame.board[5][2] == -2) { //d4 e5 d5 Nxc6 Nxf3
					move = 5;
					return ("g1 f3");
				}
				if (ChessGame.board[5][5] == -1) { //d4 Nxf6 c4 c5 d5
					return ("e5 f6");
				}
			}
			if (move == 3) { //horwitz
				if (ChessGame.board[5][5] == -2) { //d4 e6 c4 Nxf6 Nxf3
					return("g1 f3");
				}
				if (ChessGame.board[4][3] == -1) { //d4 e6 c4 d5 Nxf3
					return("g1 f3");
				}
			}
			if (move == 4) { //old benoni
				if (ChessGame.board[4][4] == -1) {
					return ("e2 e4");
				}
			}
		}
		if (ChessGame.moveNum== 7) {
			if (move == 0) { //d4 d5 Bf4 Nxf6 Nxf3
				if (ChessGame.board[4][2] == -1) { //d4 d5 Bf4 Nxf6 Nxf3 c5 e3
					move = 0;
					return ("e2 e3");
				}
				if (ChessGame.board[5][4] == -1) { //d4 d5 Bf4 Nxf6 Nxf3 e6 e3
					move = 1;
					return ("e2 e3");
				}
				if (ChessGame.board[5][2] == -1) {
					return ("e2 e3");
				}
			}
			if (move == 1) { //d4 d5 Bf4 c5 e3
				if (ChessGame.board[5][5] == -2) { //d4 d5 Bf4 c5 e3 Nxf6 Nxfc3
					move =3 ;
					return ("b1 c3");
				}		
				if (ChessGame.board[5][2] == -2) { //d4 d5 Bf4 c5 e3 Nxc6 c3
					return ("c2 c3");
				}
			}
			if (move == 2) { //d4 d5 Bf4 e6 Nxf3 Nxf6 e3
				if (ChessGame.board[5][5] == -2) {
					move = 4;
					return("e2 e3");
				}
			}
			if (move == 3) { //d4 Nxf6 c4 e6 Nxf3
				if (ChessGame.board[4][3] == -1) { //d4 Nxf6 c4 e6 Nxf3 d5 Nxc3
					move = 5;
					return("b1 c3");
				}
				if (ChessGame.board[5][1] == -1) {
					return ("a1 a3");
				}
				if (ChessGame.board[3][1] == -3) {
					return("c1 d2");
				}
			}
			if (move == 4) { //d4 Nxf6 c4 g6 c3
				if (ChessGame.board[6][6] == -3) {
					return ("e2 e4");
				}
				if (ChessGame.board[4][5] == -1) {
					return("c4 d5");
				}
			}
			if (move == 5) {
				if (ChessGame.board[6][4] == -5) {
					return ("c1 g5");
				}
			}
		}
		if (ChessGame.moveNum == 9) {
			if (move == 0) { //d4 d5 Bf4 Nxf6 Nxf3 c5 e3
				if (ChessGame.board[5][2] == -2) { //d4 d5 Bf4 Nxf6 Nxf3 c5 e3 Nxc6 c3
					move = 0;
					return "c2 c3";
				}
				if (ChessGame.board[5][4] == -1) { //d4 d5 Bf4 Nxf6 Nxf3 c5 e3 e6 Nxd2 
					move = 1;
					return "b1 d2";
				}
			}
			if (move == 1) { //d4 d5 Bf4 Nxf6 Nxf3 e6 e3
				if (ChessGame.board[3][3] == -1) { //d4 d5 Bf4 Nxf6 Nxf3 e6 e3 c5 Nxd2
					move = 2;
					return "b1 d2";
				}
				if (ChessGame.board[5][3] == -2) { //d4 d5 Bf4 Nxf6 Nxf3 e6 Bd6 Bg3
					
					return "f4 g3";
				}
			}
			if (move == 2) { //d4 d5 Bf4 c5 e3 Nxf6 Nxfc3
				if (ChessGame.board[5][2] == -2) { //d4 d5 Bf4 c5 e3 Nxf6 Nxfc3 Nxc6 c3
					move = 3;
					return "c2 c3";
				}
				if (ChessGame.board[5][4] == -1) {
					return "f1 e2";
				}
			}
			if (move == 3) { //d4 d5 Bf4 c5 e3 Nxf6 Nxfc3
				if (ChessGame.board[5][2] == -2) {
					return "d4 d5";
				}
				if (ChessGame.board[4][5] == -1) {
					return "f1 e2";
				}
			}
			if (move == 4) { //d4 d5 Bf4 e6 Nxf3 Nxf6 e3
				if (ChessGame.board[4][2] == -1) {
					return "f1 e2";
				}
				if (ChessGame.board[5][3] == -2) {
					return "f4 g3";
				}
			}
			if (move == 5) { //d4 Nxf6 c4 e6 Nxf3 d5 Nxc3
					if (ChessGame.board[3][2] == -1) {
						return "e2 e4";
					}
					if (ChessGame.board[6][3] == -2) {
						return "c1 f4";
					}
			}
		}
		if (ChessGame.moveNum == 11) {
			if (move == 0) { //d4 d5 Bf4 Nxf6 Nxf3 c5 e3 Nxc6 c3
				if (ChessGame.board[5][4] == -1) {
					return "b1 d2";
				}
			}
			if (move == 1) { //d4 d5 Bf4 Nxf6 Nxf3 c5 e3 e6 Nxd2 
				if (ChessGame.board[5][2] == -2) {
					return "f1 b5";
				}
			}
			if (move == 2) { //d4 d5 Bf4 Nxf6 Nxf3 e6 e3 c5 Nxd2
				if (ChessGame.board[5][2] == -2) {
					return "c2 c3";
				}	
			}
			if (move == 3) { //d4 d5 Bf4 c5 e3 Nxf6 Nxfc3 Nxc6 c3
				if (ChessGame.board[3][3] == -1) {
					return "e3 d4";
				}
			}
		}
		inOpening = false;
		return "";
	}
}
