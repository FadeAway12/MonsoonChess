    import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;

public class ChessGUI extends JFrame {

	public ChessGUI() {

		setTitle("Monsoon Chess");
		setSize(1800, 1800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}
	
	public void paint(Graphics g) { //paints the board with a chess boaard
		String let = "abcdefgh";
		for (int i = 0; i<8; i++) { //repeats 8 TIMES (i*100 is y coord)
			for (int k = 0; k<8; k++) { //repeats THREE times
				if (i%2==0) {
					g.setColor(new Color(255, 255, 245));
					g.fillRect(k*150,i*150+30 , 150, 150);
					g.setColor(Color.gray);
					k++;
					g.fillRect(k*150, i*150+30, 150, 150);
				}
				else {
					g.setColor((Color.gray));
					g.fillRect(k*150, i*150+30, 150, 150);
					g.setColor(new Color (255, 255, 245));
					k++;
					g.fillRect(k*150, i*150+30, 150, 150);
				}
			}
		}
		
		for (int i = 0; i<8; i++) {
			for (int k = 0; k<8; k++) {
				if (i%2==0) {
					g.setColor((Color.gray));
					g.drawString("" + let.charAt(k) + (-i+8), k*150-30+150, i*150+15+150);
					k++;
					g.setColor(new Color (255, 255, 245));
					g.drawString("" + let.charAt(k) + (-i+8), k*150-30+150, i*150+15+150);
				}
				else {
					g.setColor(new Color (255, 255, 245));
					g.drawString("" + let.charAt(k) + (-i+8), k*150-30+150, i*150+15+150);
					k++;
					g.setColor((Color.gray));
					g.drawString("" + let.charAt(k) + (-i+8), k*150-30+150, i*150+15+150);
				}
			}
		}
		for (int i = 7; i>=0; i--) {
			for (int k = 0; k<8; k++) {
				if (ChessGame.board[i][k] == 2) {
					ImageIcon knight = new ImageIcon("KnightW.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(135, 135, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == 1) {
					ImageIcon knight = new ImageIcon("PawnW.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150+20, 1095-i*150, null);
				}
				if (ChessGame.board[i][k] == 4) {
					ImageIcon knight = new ImageIcon("RookW.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(125, 140, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150+10, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == 3) {
					ImageIcon knight = new ImageIcon("BishopW.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(135, 135, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == 5) {
					ImageIcon knight = new ImageIcon("QueenW.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(140, 140, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == 6) {
					ImageIcon knight = new ImageIcon("KingW.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(150, 150, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == -2) {
					ImageIcon knight = new ImageIcon("Knight.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(135, 135, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == -1) {
					ImageIcon knight = new ImageIcon("Pawn.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150+20, 1095-i*150, null);
				}
				if (ChessGame.board[i][k] == -4) {
					ImageIcon knight = new ImageIcon("Rook.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(125, 140, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150+10, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == -3) {
					ImageIcon knight = new ImageIcon("Bishop.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(135, 135, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == -5) {
					ImageIcon knight = new ImageIcon("Queen.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(150, 150, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
				if (ChessGame.board[i][k] == -6) {
					ImageIcon knight = new ImageIcon("King.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(150, 150, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*150, 1080-i*150, null);
				}
			}
		}
		
		//drawing row and column numbers
		/**ImageIcon knight = new ImageIcon("A.jpeg");
		Image img = knight.getImage();
		Image imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		ImageIcon knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 0, 1275, null);
		knight = new ImageIcon("B image.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 150, 1275, null);
		knight = new ImageIcon("C image transparent.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 300, 1275, null);
		knight = new ImageIcon("D image transparent.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 450, 1275, null);
		knight = new ImageIcon("e image transparent.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 600, 1275, null);
		knight = new ImageIcon("f image transparent.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 750, 1275, null);
		knight = new ImageIcon("G.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 900, 1275, null);
		knight = new ImageIcon("H.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1050, 1275, null);
		
		knight = new ImageIcon("1.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 1125, null);
		knight = new ImageIcon("2.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 975, null);
		knight = new ImageIcon("3.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 825, null);
		knight = new ImageIcon("4.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 675, null);
		knight = new ImageIcon("5.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 525, null);
		knight = new ImageIcon("6.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 375, null);
		knight = new ImageIcon("7.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 225, null);
		knight = new ImageIcon("8.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 1275, 75, null);*/
	}
	
}

    