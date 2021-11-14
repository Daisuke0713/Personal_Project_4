import java.util.Stack;

/**
 * Keeps track of the current puzzle state
 */
public class Solver {
	
	/**
	 * Returns a solution puzzle
	 */
	public Puzzle SOLVE(Puzzle puzzle) {
		
		// Representing a solution
		Stack<Puzzle> stack = new Stack<Puzzle>();
		
		// Return null if the puzzle is not valid
		if(!puzzle.check_valid()) {
			return null;
		}
		
		// Push the first 
		Puzzle curr_puzzle = puzzle.clone();
		stack.push(curr_puzzle);
		
		while(!stack.isEmpty()) {
			curr_puzzle = stack.peek();
			// if the puzzle is complete
			if(curr_puzzle.check_full()) {
				Puzzle solution = stack.peek();
				stack.clear();
				return solution;
			}
			
			if(curr_puzzle.getVisited()) {
				stack.pop();
			} else {
				if(curr_puzzle.getCurr_cell().getEntry() == null) {
					for(Integer num : curr_puzzle.possible_list()) {
						Puzzle possible_puzzle = curr_puzzle.modify(num);
						stack.push(possible_puzzle);
					}
					curr_puzzle.setVisited(true);
				} else {
					int row = curr_puzzle.getCurr_cell().getRow();
					int col = curr_puzzle.getCurr_cell().getCol();
					if(col <= 7) {
						curr_puzzle.setCurr_cell(curr_puzzle.getPuzzle().get(row).get(col+1));
					} else {
						curr_puzzle.setCurr_cell(curr_puzzle.getPuzzle().get(row+1).get(0));
					}
					continue;
				}
			}	
		}	
		// this should never happen
		return null;
	}
}