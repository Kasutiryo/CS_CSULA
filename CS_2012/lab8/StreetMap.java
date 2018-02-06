package lab8;

public class StreetMap {

	protected Coordinate[][] map;
	
	public StreetMap() {
		
		this.map = new Coordinate[20][25];
		
//		for (int row = 0; row < 20; row++) {
//			
//			for (int col = 0; col < 25; col++) {
//				
//				this.map[row][col] = new Coordinate(row, col, 'X');
//			}
//		}
	}
}
