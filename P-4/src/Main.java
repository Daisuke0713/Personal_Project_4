import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> puzzle = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row0 = new ArrayList<Integer>(Arrays.asList(2, null, null, null, 8, null, null, 1, null));
		ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(null, 4, null, 1, null, null, 3, null, null));
		ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(null, null, null, null, 9, null, null, null, null));
		ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(null, null, null, 7, null, null, 8, 4, null));
		ArrayList<Integer> row4 = new ArrayList<Integer>(Arrays.asList(null, 9, null, null, 2, 1, null, null, null));
		ArrayList<Integer> row5 = new ArrayList<Integer>(Arrays.asList(null, null, 6, null, null, null, null, null, null));
		ArrayList<Integer> row6 = new ArrayList<Integer>(Arrays.asList(null, 3, null, null, null, null, 5, 8, null));
		ArrayList<Integer> row7 = new ArrayList<Integer>(Arrays.asList(1, null, null, 8, null, null, null, null, 7));
		ArrayList<Integer> row8 = new ArrayList<Integer>(Arrays.asList(null, 2, 7, null, 5, 3, null, null, null));
		puzzle.add(row0);
		puzzle.add(row1); 
		puzzle.add(row2);
		puzzle.add(row3);
		puzzle.add(row4);
		puzzle.add(row5);
		puzzle.add(row6);
		puzzle.add(row7);
		puzzle.add(row8);
		
		Solver s = new Solver(puzzle);

	}

}
