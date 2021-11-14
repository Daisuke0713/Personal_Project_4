import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.lang.Cloneable;
/**
 * Puzzle state with its current cell
 */
public class Puzzle{
	
	private ArrayList<ArrayList<Cell>> puzzle;
	private Cell curr_cell;
	private Boolean visited;
	//private ArrayList<Integer> available;

	public Puzzle(ArrayList<ArrayList<Cell>> p, Cell c) {
		super();
		
		this.puzzle = p;
		this.curr_cell = c;
		this.visited = false;
		//this.available = this.possible_list();
	}
	
	/**
	 * Modify the puzzle by creating a deep clone, change the current entry to num, and
	 * move the current cell by one.
	 */
	public Puzzle clone(){
		ArrayList<ArrayList<Cell>> new_puzzle = new ArrayList<ArrayList<Cell>>();
		for(ArrayList<Cell> cells : puzzle) {
			ArrayList<Cell> new_cells = new ArrayList<Cell>();
			for(Cell cell : cells) {
				Cell new_cell = cell.clone();
				new_cells.add(new_cell);
			}
			new_puzzle.add(new_cells);
		}
		
		return new Puzzle(new_puzzle, new_puzzle.get(this.curr_cell.getRow()).get(this.curr_cell.getCol()));
	}
	
	/**
	 * Modify the puzzle by creating a deep clone, change the current entry to num, and
	 * move the current cell by one.
	 */
	public Puzzle modify(Integer num) {
		Puzzle modified_puzzle = this.clone();
		// change the entry
		modified_puzzle.getPuzzle().get(this.curr_cell.getRow()).get(this.curr_cell.getCol()).setEntry(num);
		//move by one
		if(this.curr_cell.getCol() <= 7) {
			modified_puzzle.setCurr_cell(modified_puzzle.getPuzzle().get(this.curr_cell.getRow()).get(this.curr_cell.getCol()+1));
		} else if(this.curr_cell.getRow() != 8 || this.curr_cell.getCol() != 8) {
			modified_puzzle.setCurr_cell(modified_puzzle.getPuzzle().get(this.curr_cell.getRow()+1).get(0));
		}
		
		return modified_puzzle;
	}
	
	public ArrayList<ArrayList<Cell>> getPuzzle() {
		return puzzle;
	}
	
	public void setPuzzle(ArrayList<ArrayList<Cell>> new_puzzle) {
		this.puzzle = new_puzzle;
	}

	public Cell getCurr_cell() {
		return curr_cell;
	}
	
	public void setCurr_cell(Cell c) {
		this.curr_cell = c;
	}
	
	public Boolean getVisited() {
		return visited;
	}
	
	public void setVisited(Boolean B) {
		this.visited = B;
	}
	
	/**
	public ArrayList<Integer> getAvailable() {
		return available;
	}
	
	public void removeAvailable(Integer item) {
		this.available.remove(this.available.indexOf(item));
	}
	**/
	
	/**
	 * check whether a given puzzle is valid 
	 */
	public Boolean check_valid() {
		// check horizontal
		for(int i = 0; i < 9; i++) {
			if(check_duplicate(puzzle.get(i))) {
				return false;
			}
		}
		
		// check vertical
		ArrayList<Cell> v = new ArrayList<Cell>();
		for(int i = 0; i < 9; i++) {
			for(ArrayList<Cell> arr : puzzle) {
				v.add(arr.get(i));
			}
			if(check_duplicate(v)) {
				return false;
			}
			v.clear();
		}
		
		// check block
		ArrayList<Cell> b = new ArrayList<Cell>();
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
	private Boolean check_duplicate(ArrayList<Cell> list) {
		for(int i = 0; i < 9; i++) {
			for(int j = i+1; j < 9; j++) {
				if(list.get(i).getEntry() == list.get(j).getEntry() && list.get(i).getEntry() != null) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Check if the puzzle is full
	 */
	public Boolean check_full() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(puzzle.get(i).get(j).getEntry() == null) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * Returns a list of number between 1 and 9 that possibly go to the entry (row, col)
	 */
	public ArrayList<Integer> possible_list() {
		
		ArrayList<Integer> list = new ArrayList<Integer>(); // to be returned
		
		ArrayList<Cell> horizontal = puzzle.get(curr_cell.getRow()); // row
		
		ArrayList<Cell> vertical = new ArrayList<Cell>(); // vertical
		// fill vertical
		for(ArrayList<Cell> arr : puzzle) {
			vertical.add(arr.get(curr_cell.getCol()));
		}
		
		ArrayList<Cell> block = new ArrayList<Cell>(); // block (3 x 3)
		int b_num = -1;
		if(curr_cell.getRow() <= 2) {
			if(curr_cell.getCol() <= 2) {
				b_num = 0;
			} else if(curr_cell.getCol() <= 5) {
				b_num = 1;
			} else {
				b_num = 2;
			}
		} else if(curr_cell.getRow() <= 5) {
			if(curr_cell.getCol() <= 2) {
				b_num = 3;
			} else if(curr_cell.getCol() <= 5) {
				b_num = 4;
			} else {
				b_num = 5;
			}
		} else {
			if(curr_cell.getCol() <= 2) {
				b_num = 6;
			} else if(curr_cell.getCol() <= 5) {
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
		boolean exist = false;
		ArrayList <Cell> new_list = new ArrayList<Cell>();
		new_list.addAll(horizontal);
		new_list.addAll(vertical);
		new_list.addAll(block);
		
		for(int i = 1; i <= 9; i++) {
			exist = false;
			for(Cell c : new_list) {
				if(c.getEntry() != null && i == c.getEntry()) {
					exist = true;
					break;
				}
			}
			if(!exist) {
				list.add(i);
			}
		}
		
		
		return list;
	}	
}
