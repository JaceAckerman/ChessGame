import java.util.ArrayList;

public class Board {

	private Position[][] myBoard;
	
	public Board() {
		
		myBoard = new Position[8][8];
		for(int r = 0; r < myBoard.length; r++) {
			
			for(int c=0; c<myBoard[0].length; c++) {
				myBoard[r][c] = new Position(r,c, null);
			}
		}
	}
	
	public int getRows() {
		return myBoard.length;
	}
	
	public int getCols() {
		return myBoard[0].length;
	}
	
	public Position getPosition(int r, int f) {
		return myBoard[r][f];
	}
	

	
	public void setPosition(Position p, int x, int y) {
		myBoard[x][y] = p;
	}
	
	
	
	
//	public boolean outOfBounds(Piece e) {
//		if(0 < e.getMyPosition().getRank() || e.getMyPosition().getRank() > getRows() 
//				&& 0 < e.getMyPosition().getFile() || e.getMyPosition().getFile() > getCols()) {
//			return true;
//		}
//		return false;
//	}
		
	
	public String toString() {
		String temp = " ";
	
		for(int r = 0; r < myBoard.length; r++) {
			
			for(int c = 0; c<myBoard[0].length; c++) {
				
			
				temp = temp + myBoard[r][c].toString() +" ";	
			}
		}
			temp = temp+ "\n";
		
		return temp;
	}
}

