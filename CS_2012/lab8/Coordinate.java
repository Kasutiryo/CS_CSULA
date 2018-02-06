package lab8;

public class Coordinate {

	private int row;
	private int col;
	private char value;
	
	public Coordinate (int row, int col, char value) {
		
		this.row = row;
		this.col = col;
		this.value = value;
	}
	
	public int getRow() {
		
		return this.row;
	}
	
	public int getCol() {
		
		return this.col;
	}
	
	public char getValue() {
		
		return this.value;
	}
	
	public void setRow(int row) {
		
		this.row = row;
	}
	
	public void setCol(int col) {
		
		this.col = col;
	}
	
	public void setValue(char value) {
		
		this.value = value;
	}
	
	public void changeData(char value, int row, int col) {
		
		this.value = value;
		this.row = row;
		this.col = col;
	}
}
