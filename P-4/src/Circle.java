import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

/**
 * Square Class
 */
public class Circle {
	
	private int x;
	private int y;
	private int r;
	private int number;
	
	public Circle(int x, int y, int r, int number) {
		this.x = x;
		this.y = y;
		this.r = r;
		this.number = number;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	public void draw_circle(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(new Color(225,114,111));
		g2.fillOval(x, y, r, r);
		g2.setColor(Color.BLACK);
		Font f = new Font ("Courier New", 1, 30);
		g2.setFont(f);
		g2.drawString(String.valueOf(number), 26 + 48*(number-1), 550);
	}	
}