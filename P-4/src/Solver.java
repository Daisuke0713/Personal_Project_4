import java.util.ArrayList;
import java.util.Arrays;
/**
 * Given a Sudoku puzzle, this class solves the puzzle
 */
public class Solver {
	
	private ArrayList<ArrayList<Integer>> puzzle;
	
	/**
	 * Every entry that has no number should be NULL
	 */
	public Solver(ArrayList<ArrayList<Integer>> puzzle) {
		super();
		this.puzzle = puzzle;
	}
	
	
	
	/**
	 * check whether a given puzzle is valid (solvable)
	 */
	private Boolean check_valid() {
		// check horizontal
		for(int i = 0; i < 9; i++) {
			if(check_duplicate(puzzle.get(i))) {
				return false;
			}
		}
		
		// check vertical
		ArrayList<Integer> v = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			for(ArrayList<Integer> arr : puzzle) {
				v.add(arr.get(i));
			}
			if(check_duplicate(v)) {
				return false;
			}
			v.clear();
		}
		
		// check block
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			for(int j = 3*(i%3); j <= 2+3*(i%3); j++) {
				for(int k = 3*((int)i/3); k <= 2+3*((int)i/3); k++) {
					b.add(puzzle.get(k).get(j));
				}
			}
			if(check_duplicate(b)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Check if there is duplicate in a list
	 */
	private Boolean check_duplicate(ArrayList<Integer> list) {
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(list.get(i) == list.get(j) && list.get(i) != null) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Returns a list of number between 1 and 9 that possibly go to the entry (row, col)
	 */
	private ArrayList<Integer> possible_list(int row, int col) {
		
		ArrayList<Integer> list = new ArrayList<Integer>(); // to be returned
		
		ArrayList<Integer> horizontal = puzzle.get(row); // row
		
		ArrayList<Integer> vertical = new ArrayList<Integer>(); // vertical
		// fill vertical
		for(ArrayList<Integer> arr : puzzle) {
			vertical.add(arr.get(col));
		}
		
		ArrayList<Integer> block = new ArrayList<Integer>(); // block (3 x 3)
		int b_num = -1;
		if(row <= 2) {
			if(col <= 2) {
				b_num = 0;
			} else if(col <= 5) {
				b_num = 1;
			} else {
				b_num = 2;
			}
		} else if(row <= 5) {
			if(col <= 2) {
				b_num = 3;
			} else if(col <= 5) {
				b_num = 4;
			} else {
				b_num = 5;
			}
		} else {
			if(col <= 2) {
				b_num = 6;
			} else if(col <= 5) {
				b_num = 7;
			} else {
				b_num = 8;
			}
		}
		
		// fill block
		for(int i = 3*(b_num%3); i <= 2+3*(b_num%3); i++) {
			for(int j = 3*((int)b_num/3); j <= 2+3*((int)b_num/3); j++) {
				block.add(puzzle.get(j).get(i));
			}
		}	
		
		// check 
		for(int i = 1; i <= 9; i++) {
			if(!horizontal.contains(i) && !vertical.contains(i) && !block.contains(i)) {
				list.add(i);
			}
		}
		return list;
	}	
}
