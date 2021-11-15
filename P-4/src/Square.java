import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

/**
 * Square Class
 */
public class Square {
	
	private int x;
	private int y;
	private int size;
	private Color color;
	private Integer entry = null;
	
	public Square(int x, int y, int size, Color color) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.color = color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color c) {
		this.color = c;
	}
	
	public Integer getEntry() {
		return this.entry;
	}
	
	public void setEntry(Integer num) {
		this.entry = num;
	}
	
	public void draw_square(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		if(entry == null) {
			g2.setColor(color);
			g2.fillRect(x, y, size, size);
		} else {
			g2.setColor(color);
			g2.fillRect(x, y, size, size);
			g2.setColor(Color.BLACK);
			Font f = new Font ("Courier New", 1, 35);
			g2.setFont(f);
			g2.drawString(String.valueOf(entry), x+15, y+35);
		}

	}	
}
