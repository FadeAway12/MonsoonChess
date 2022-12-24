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
		setSize(900, 900);
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
		
		//drawing row and column numbers
		ImageIcon knight = new ImageIcon("A.jpeg");
		Image img = knight.getImage();
		Image imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		ImageIcon knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 0, 850, null);
		knight = new ImageIcon("B image.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 100, 850, null);
		knight = new ImageIcon("C image transparent.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 200, 850, null);
		knight = new ImageIcon("D image transparent.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 300, 850, null);
		knight = new ImageIcon("e image transparent.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 400, 850, null);
		knight = new ImageIcon("f image transparent.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 500, 850, null);
		knight = new ImageIcon("G.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 600, 850, null);
		knight = new ImageIcon("H.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 700, 850, null);
		
		knight = new ImageIcon("1.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 750, null);
		knight = new ImageIcon("2.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 650, null);
		knight = new ImageIcon("3.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 550, null);
		knight = new ImageIcon("4.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 450, null);
		knight = new ImageIcon("5.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 350, null);
		knight = new ImageIcon("6.png");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 250, null);
		knight = new ImageIcon("7.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 150, null);
		knight = new ImageIcon("8.jpeg");
		img = knight.getImage();
		imgScale = img.getScaledInstance(70, 70, EXIT_ON_CLOSE);
		knightSprite = new ImageIcon(imgScale);
		g.drawImage(imgScale, 850, 50, null);
	}
	
}

    
