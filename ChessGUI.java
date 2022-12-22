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
		setSize(800, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);


	}
	
	public void paint(Graphics g) { //paints the board with a chess boaard
		for (int i = 0; i<8; i++) { //repeats 8 TIMES (i*100 is y coord)
			for (int k = 0; k<7; k++) { //repeats THREE times
				if (i%2==0) {
					g.setColor(new Color(255, 255, 245));
					g.fillRect(k*100,i*100+30 , 100, 100);
					g.setColor(Color.gray);
					k++;
					g.fillRect(k*100, i*100+30, 100, 100);
				}
				else {
					g.setColor(Color.gray);
					g.fillRect(k*100, i*100+30, 100, 100);
					g.setColor(new Color (255, 255, 245));
					k++;
					g.fillRect(k*100, i*100+30, 100, 100);
				}
			}
		}
		for (int i = 7; i>=0; i--) {
			for (int k = 0; k<8; k++) {
				if (ChessGame.board[i][k] == 2) {
					ImageIcon knight = new ImageIcon("KnightSprite.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == 1) {
					ImageIcon knight = new ImageIcon("pawn.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == 4) {
					ImageIcon knight = new ImageIcon("rook.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == 3) {
					ImageIcon knight = new ImageIcon("Bishop.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == 5) {
					ImageIcon knight = new ImageIcon("queen.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == 6) {
					ImageIcon knight = new ImageIcon("king.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == -2) {
					ImageIcon knight = new ImageIcon("knightblack.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == -1) {
					ImageIcon knight = new ImageIcon("pawn black.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == -4) {
					ImageIcon knight = new ImageIcon("rookblack.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == -3) {
					ImageIcon knight = new ImageIcon("bishopblack.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == -5) {
					ImageIcon knight = new ImageIcon("queen black.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
				if (ChessGame.board[i][k] == -6) {
					ImageIcon knight = new ImageIcon("kingblack.png");
					Image img = knight.getImage();
					Image imgScale = img.getScaledInstance(100, 100, EXIT_ON_CLOSE);
					ImageIcon knightSprite = new ImageIcon(imgScale);
					g.drawImage(imgScale, k*100, 720-i*100, null);
				}
			}
		}
	}
	
}
