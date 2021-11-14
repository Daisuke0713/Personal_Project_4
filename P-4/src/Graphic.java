import java.util.*;
import java.awt.Graphics; // Abstract Graphics Class: need this always to work with graphics 
import java.awt.Point; // Supports x-y plane to indicate a location
import java.awt.event.MouseAdapter; // Receives mouse events (movements like clicks)
import java.awt.event.MouseEvent; // Receives mouse events like curving
import java.awt.event.MouseMotionAdapter; // Receives mouse motion events
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame; 
import javax.swing.JPanel;

/**
 * Graphic class
 */
public class Graphic {
	
	JFrame window;
	
	public Graphic() {
		
		window = new JFrame("9 x 9 Sudoku Puzzle");
		
		Panel panel = new Panel();
		window.setContentPane(panel);
		panel.addMouseListener(new Click(panel));
		
		window.getContentPane().setBackground(Color.BLACK);
		window.setSize(450, 450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
}
