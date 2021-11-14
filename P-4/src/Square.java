import java.awt.Graphics;
import java.awt.Color;

/**
 * Square Class
 */
public class Square {
	
	private int x;
	private int y;
	private int size;
	private Color color;
	
	public Square(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public void draw_square(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, size, size);
	}	
}
