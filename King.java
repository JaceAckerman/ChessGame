import java.util.ArrayList;

public class King extends Piece {
	//public boolean checkMate = false;
	public King(boolean iW) {
		super(iW);
		
		if(!iW) {
			this.setWhite(false);
		}
	}
	
	public boolean canMove(Board b, Position start, Position end) {
		if( end.getPiece() != null) {
			if(end.getPiece().isSameColor(start.getPiece()))  {
		
				return false;
			}
		}

		int x = Math.abs(start.getFile() - end.getFile());
        int y = Math.abs(start.getRank() - end.getRank());
        
        if ((x + y == 1 || x + y == 2) && !isFutureCheck(b,start, end)) {
        	return true;
        }
        return false;
	}
	
	/*
	 * checks if the kings next move will move to
	 */
	private boolean isFutureCheck(Board b, Position currP ,Position nextP) {
		
		for(int r = 0; r < b.getRows(); r++) {
			for(int c = 0; c < b.getRows(); c++) {
				if(b.getPosition(r,c).getPiece() != null && !b.getPosition(r,c).equals(currP)) {
					if(b.getPosition(r,c).getPiece().canMove(b, b.getPosition(r,c), nextP) && 
							!b.getPosition(r,c).getPiece().isSameColor(currP.getPiece())) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/*
	 * checks if the king is currently checked
	 * currP is the king's current position
	 * possP is the position that possibly checks the king.
	 */
	public boolean isChecked(Board b, Position currP,Position possP) {
		if(possP.getPiece().canMove(b, possP, currP )) {
			return true;
		}
		return false;
	}

	/*
	 * passes the king's current position and
	 * adds all the possible moves the king has and
	 * sees if the king can move to them.
	 */
	public boolean checkMate(Board b, Position currP) {
		
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		
		//adding positions
		possibleMoves.add(b.getPosition(currP.getRank() + 1, currP.getFile()));
		possibleMoves.add(b.getPosition(currP.getRank() + 1, currP.getFile() + 1));
		possibleMoves.add(b.getPosition(currP.getRank(), currP.getFile() + 1));
		possibleMoves.add(b.getPosition(currP.getRank() + 1, currP.getFile() -1 ));
		possibleMoves.add(b.getPosition(currP.getRank() -1, currP.getFile()));
		possibleMoves.add(b.getPosition(currP.getRank() - 1, currP.getFile() -1));
		possibleMoves.add(b.getPosition(currP.getRank() , currP.getFile() -1 ));
		possibleMoves.add(b.getPosition(currP.getRank() -1, currP.getFile() + 1));
		
		for(int i = 0; i < possibleMoves.size(); i++) {
			if(this.canMove(b,currP, possibleMoves.get(i))) {
				return false;
			}
		}
		
		return true;
	}
}
