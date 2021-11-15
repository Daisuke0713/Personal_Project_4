import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Font;

/**
 * Panel Class
 */
public class Panel extends JPanel{
	
	private LinkedList<Square> squares = new LinkedList<Square>();
	private LinkedList<Circle> circles = new LinkedList<Circle>();
	
	public Panel() {
		// creating squares
		for(int i = 0; i <= 8; i++) {
			for(int j = 0; j <= 8; j++) {
				squares.add(new Square(2 + 50*i, 2 + 50*j, 48, Color.WHITE));	
			}
		}
		
		// creating circles
		for(int i = 1; i <= 9; i++) {
			circles.add(new Circle(15 + 48*(i-1), 520, 40, i));
		}
	}
	
	public LinkedList<Square> getSquares() {
		return this.squares;
	}
	
	public LinkedList<Circle> getCircles() {
		return this.circles;
	}
	
	public void change_color(Square s, Color c) {
		s.setColor(c);
		this.repaint();
	}
	
	public int number_blue() {
		int number = 0;
		for(Square s : squares) {
			if(s.getColor().equals(new Color(135, 206, 250))) {
				number += 1;
			}
		}
		return number;
	}
	
	public void paint(Graphics g) {
		this.setBackground(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(255,114,111));
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				g2.fillRect(150*i, 0, 2, 450);
				g2.fillRect(0, 150*j, 450, 2);
			}
		}
		
		g2.setColor(new Color(225,114,111));
		g2.fillRect(196, 590, 60, 30);
		g2.setColor(Color.BLACK);
		Font f = new Font ("Courier New", 1, 18);
		g2.setFont(f);
		g2.drawString("SOLVE", 198, 610);
		
		for(Square s : squares) {
			s.draw_square(g);
		}
		
		for(Circle c : circles) {
			c.draw_circle(g);
		}		
	}
}
