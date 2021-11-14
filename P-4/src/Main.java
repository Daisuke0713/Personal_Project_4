import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Cell>> puzzle = new ArrayList<ArrayList<Cell>>();
		
		ArrayList<Cell> row0 = new ArrayList<Cell>(Arrays.asList(new Cell(0,0,2), new Cell(0,1,null), new Cell(0,2,null), 
				new Cell(0,3,null), new Cell(0,4,8), new Cell(0,5,null), new Cell(0,6,null), new Cell(0,7,1), new Cell(0,8,null)));
		ArrayList<Cell> row1 = new ArrayList<Cell>(Arrays.asList(new Cell(1,0,null), new Cell(1,1,4), new Cell(1,2,null), 
				new Cell(1,3,1), new Cell(1,4,null), new Cell(1,5,null), new Cell(1,6,3), new Cell(1,7,null), new Cell(1,8,null)));
		ArrayList<Cell> row2 = new ArrayList<Cell>(Arrays.asList(new Cell(2,0,null), new Cell(2,1,null), new Cell(2,2,null), 
				new Cell(2,3,null), new Cell(2,4,9), new Cell(2,5,null), new Cell(2,6,null), new Cell(2,7,null), new Cell(2,8,null)));
		ArrayList<Cell> row3 = new ArrayList<Cell>(Arrays.asList(new Cell(3,0,null), new Cell(3,1,null), new Cell(3,2,null), 
				new Cell(3,3,7), new Cell(3,4,null), new Cell(3,5,null), new Cell(3,6,8), new Cell(3,7,4), new Cell(3,8,null)));
		ArrayList<Cell> row4 = new ArrayList<Cell>(Arrays.asList(new Cell(4,0,null), new Cell(4,1,9), new Cell(4,2,null), 
				new Cell(4,3,null), new Cell(4,4,2), new Cell(4,5,1), new Cell(4,6,null), new Cell(4,7,null), new Cell(4,8,null)));
		ArrayList<Cell> row5 = new ArrayList<Cell>(Arrays.asList(new Cell(5,0,null), new Cell(5,1,null), new Cell(5,2,6), 
				new Cell(5,3,null), new Cell(5,4,null), new Cell(5,5,null), new Cell(5,6,null), new Cell(5,7,null), new Cell(5,8,null)));
		ArrayList<Cell> row6 = new ArrayList<Cell>(Arrays.asList(new Cell(6,0,null), new Cell(6,1,3), new Cell(6,2,null), 
				new Cell(6,3,null), new Cell(6,4,null), new Cell(6,5,null), new Cell(6,6,5), new Cell(6,7,8), new Cell(6,8,null)));
		ArrayList<Cell> row7 = new ArrayList<Cell>(Arrays.asList(new Cell(7,0,1), new Cell(7,1,null), new Cell(7,2,null), 
				new Cell(7,3,8), new Cell(7,4,null), new Cell(7,5,null), new Cell(7,6,null), new Cell(7,7,null), new Cell(7,8,7)));
		ArrayList<Cell> row8 = new ArrayList<Cell>(Arrays.asList(new Cell(8,0,null), new Cell(8,1,2), new Cell(8,2,7), 
				new Cell(8,3,null), new Cell(8,4,5), new Cell(8,5,3), new Cell(8,6,null), new Cell(8,7,null), new Cell(8,8,null)));
		
		puzzle.add(row0);puzzle.add(row1); puzzle.add(row2);puzzle.add(row3);puzzle.add(row4);
		puzzle.add(row5);puzzle.add(row6);puzzle.add(row7);puzzle.add(row8);
		
		Puzzle p1 = new Puzzle(puzzle, row0.get(0));
		Solver s = new Solver();
		Puzzle solution = s.SOLVE(p1);
		
		for(int i = 0; i <= 8; i++) {
			for(int j = 0; j <= 8; j++) {
				System.out.print(solution.getPuzzle().get(i).get(j).getEntry());
			}
			System.out.println();
		}
	}
}
