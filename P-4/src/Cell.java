/**
 * Each cell of a puzzle
 */
public class Cell {
	
	private Integer entry;
	private int row;
	private int col;
	
	public Cell(int row, int col, Integer entry) {
		this.entry = entry;
		this.row = row;
		this.col = col;
	}
	
	public Cell clone() {
		Integer new_entry = this.entry;
		int new_row = this.row;
		int new_col = this.col;
		return new Cell(new_row, new_col, new_entry);
	}

	public Integer getEntry() {
		return entry;
	}
	
	public void setEntry(Integer num) {
		this.entry = num;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}	
}
