import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;

/**
 * EClass Click
 */
public class Click extends MouseAdapter{
	
	private Panel panel;
	private boolean B;
	
	public Click(Panel p) {
		this.panel = p;
		this.B = false;
	}
	
	private Boolean locate(int x_1, int x_2, int y_1, int y_2, int x, int y) {
		return x_1 <= x && x <= x_2 && y_1 <= y && y <= y_2;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(B) {
			return;
		} 
		
		int x = e.getX();
		int y = e.getY();
		
		// if SOLVE is pressed
		if(locate(196, 256, 590, 620, x, y)) {
			B = true;
			// Create a puzzle
			ArrayList<ArrayList<Cell>> puzzle = new ArrayList<ArrayList<Cell>>();
			ArrayList<Cell> row0 = new ArrayList<Cell>(); ArrayList<Cell> row1 = new ArrayList<Cell>();
			ArrayList<Cell> row2 = new ArrayList<Cell>(); ArrayList<Cell> row3 = new ArrayList<Cell>();
			ArrayList<Cell> row4 = new ArrayList<Cell>(); ArrayList<Cell> row5 = new ArrayList<Cell>();
			ArrayList<Cell> row6 = new ArrayList<Cell>(); ArrayList<Cell> row7 = new ArrayList<Cell>();
			ArrayList<Cell> row8 = new ArrayList<Cell>();
			
			for(int i = 0; i <= 8; i++) {
				for(int j = 0; j <= 8; j++) {
					Integer entry = panel.getSquares().get(9*j+i).getEntry();
					if(j == 0) {
						if(entry != null) {
							row0.add(new Cell(j, i, entry));
						} else {
							row0.add(new Cell(j, i, null));
						}
					} else if(j == 1) {
						if(entry != null) {
							row1.add(new Cell(j, i, entry));
						} else {
							row1.add(new Cell(j, i, null));
						}
					} else if(j == 2) {
						if(entry != null) {
							row2.add(new Cell(j, i, entry));
						} else {
							row2.add(new Cell(j, i, null));
						}
					} else if(j == 3) {
						if(entry != null) {
							row3.add(new Cell(j, i, entry));
						} else {
							row3.add(new Cell(j, i, null));
						}
					} else if(j == 4) {
						if(entry != null) {
							row4.add(new Cell(j, i, entry));
						} else {
							row4.add(new Cell(j, i, null));
						}
					} else if(j == 5) {
						if(entry != null) {
							row5.add(new Cell(j, i, entry));
						} else {
							row5.add(new Cell(j, i, null));
						}
					} else if(j == 6) {
						if(entry != null) {
							row6.add(new Cell(j, i, entry));
						} else {
							row6.add(new Cell(j, i, null));
						}
					} else if(j == 7) {
						if(entry != null) {
							row7.add(new Cell(j, i, entry));
						} else {
							row7.add(new Cell(j, i, null));
						}
					} else if(j == 8) {
						if(entry != null) {
							row8.add(new Cell(j, i, entry));
						} else {
							row8.add(new Cell(j, i, null));
						}
					}	
				}
			}
			puzzle.add(row0); puzzle.add(row1); puzzle.add(row2); puzzle.add(row3); puzzle.add(row4); puzzle.add(row5); 
			puzzle.add(row6); puzzle.add(row7); puzzle.add(row8); 
			
			Puzzle P = new Puzzle(puzzle, row0.get(0));
			Solver S = new Solver();
			Puzzle solution = S.SOLVE(P);
			
			if(solution == null) {
				
				return;
			} else {
				// Put back answers to each entry of squares
				for(int i = 0; i <= 8; i++) {
					for(int j = 0; j <= 8; j++) {
						Integer entry = solution.getPuzzle().get(i).get(j).getEntry();
						panel.getSquares().get(9*i+j).setEntry(entry);
					}
				}
				panel.repaint();
				return;
			}
		}
		
		
		if(panel.number_blue() == 1) { // User clicks number
			int number = 0;
			// if the click is within one of the circle
			for(int i = 0; i <= 8; i++) {
				if(locate(15 + 48*i, 55 + 48*i, 524, 564, x, y)) {
					number = i+1;
					break;
				}
			}
			if(number != 0) {
				int entry = panel.getCircles().get(number-1).getNumber();
				// find the blue square
				for(Square s : panel.getSquares()) {
					if(s.getColor().equals(new Color(135, 206, 250))) {
						s.setEntry(entry);
						panel.change_color(s, Color.WHITE);
						break;
					}
				}
			}	
		} else if (panel.number_blue() == 0) { // User clicks one of the squares
			int location = -1;
			for(int i = 0; i<= 8; i++) {
				for(int j = 0; j <= 8; j++) {
					if(locate(2 + 50*i, 50 + 50*i, 2 + 50*j, 50 + 50*j, x, y)) {
						location = 9*i + j;
						break;
					}
				}
				if(location != -1) {
					break;
				}
			}
			
			if(location != -1 && panel.getSquares().get(location).getEntry() == null) {
				panel.change_color(panel.getSquares().get(location), new Color(135, 206, 250));
			}
		}		
	}
}
