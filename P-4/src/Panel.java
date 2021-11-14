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
	
	public Panel() {
		for(int i = 0; i <= 9; i++) {
			for(int j = 0; j <= 9; j++) {
				squares.add(new Square(1 + 50*i, 1 + 50*j, 49, Color.WHITE));
			}
		}
	}
	
	public void change_color(Square s, Color c) {
		s.setColor(c);
		this.repaint();
	}
	
	public void paint(Graphics g) {
		for(Square s : squares) {
			s.draw_square(g);
		}
	}
}
