package CardGame;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Card extends JPanel implements MouseListener {
	final static int IMG_1X = 100;
	final static int IMG_2X = 300;
	final static int IMG_3X = 500;
	final static int IMG_Y = 125;

	// private boolean game ;
	private boolean clicked;
	BufferedImage img;
	private Rectangle c1, c2, c3;
	private int randomGen;
	private Menu myMenu;

	public Card(Menu m) {
		myMenu = m;
		c1 = new Rectangle(IMG_1X, IMG_Y, 100, 150);
		c2 = new Rectangle(IMG_2X, IMG_Y, 100, 150);
		c3 = new Rectangle(IMG_3X, IMG_Y, 100, 150);
		randomGen = (int) (1 + Math.random() * 3);
		clicked = false;
		// game = true;
		addMouseListener(this);
	}

	public void resetGame() {
		// game = true;
		clicked = false;
		randomGen = (int) (1 + Math.random() * 3);
		myMenu.reset();
		repaint();
	}

	public void paintComponent(Graphics g) {
		if (clicked) {
			try {
				img = ImageIO.read(new File("king.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(img, IMG_1X, IMG_Y, this);
			g.drawImage(img, IMG_2X, IMG_Y, this);
			g.drawImage(img, IMG_3X, IMG_Y, this);

			try {
				img = ImageIO.read(new File("queen.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (randomGen) {
			case 1:
				g.drawImage(img, IMG_1X, IMG_Y, this);
				break;
			case 2:
				g.drawImage(img, IMG_2X, IMG_Y, this);
				break;
			case 3:
				g.drawImage(img, IMG_3X, IMG_Y, this);
				break;
			}
		} else {
			try {
				img = ImageIO.read(new File("back.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Cannot Read Image");
			}
			g.drawImage(img, IMG_1X, IMG_Y, this);
			g.drawImage(img, IMG_2X, IMG_Y, this);
			g.drawImage(img, IMG_3X, IMG_Y, this);
		}
	}

	public void mouseClicked(MouseEvent e) {
		Point p = new Point(e.getX(), e.getY());
		int c = 0;

		// System.out.printf("X-Coord: %s , Y-Coord: %s %n",p.getX(),p.getY());
		if (myMenu.checkBet()) {
			if (c1.contains(p) || c2.contains(p) || c3.contains(p)) {
				clicked = true;

				if (c1.contains(p)) {
					c = 1;
				} else if (c2.contains(p)) {
					c = 2;
				} else {
					c = 3;
				}

				if (c == randomGen) {
					myMenu.addWin();

				} else {
					myMenu.lost();
				}

				repaint();

			}
		}
	}

	public void mousePressed(MouseEvent evnt) {
	}

	public void mouseReleased(MouseEvent evnt) {
	}

	public void mouseEntered(MouseEvent evnt) {
	}

	public void mouseExited(MouseEvent evnt) {
	}

}
