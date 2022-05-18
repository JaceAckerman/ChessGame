
public class Pawn extends Piece{
	public boolean promotion = false;
	public boolean firstMove = true;
	public Pawn(boolean iW) {
		super(iW);

		if(!iW) {
			this.setWhite(false);
		}
	}

	public boolean getFirstMove() {
		return firstMove;
	}
	public void setFirstMove(boolean f) {
		firstMove = f;
	}

	public boolean canMove(Board b, Position start, Position end) {
		if( end.getPiece() != null) {
			if(end.getPiece().isSameColor(start.getPiece())) {

				return false;
			}
		}
		//for black pawns
		if(!this.isWhite()) {
			//check if can move forward twice
			if(firstMove && end.getRank() == start.getRank() + 2 || end.getRank() == start.getRank() + 1 )
			{
				if(b.getPosition(end.getRank(), end.getFile()).isOccupied()) {
					return false;
				}
				return true;
			}
			if(!firstMove && end.getRank() == start.getRank() +1) {
				if(b.getPosition(end.getRank(), end.getFile()).isOccupied()) {
					return false;
				}
				return true;
			}

			return false;
		}
		//for white pawns
		else {
			if(b.getPosition(end.getRank(), end.getFile()).isOccupied() && 
					(b.getPosition(start.getRank() - 1 , start.getFile() +1).equals(end) ||
							b.getPosition(start.getRank() - 1 , start.getFile() -1).equals(end))) {
				
				return true;
			}
			//check if can move forward twice
			if(firstMove && end.getRank() == start.getRank() - 2 || end.getRank() == start.getRank() - 1 )
			{
				if(b.getPosition(end.getRank(), end.getFile()).isOccupied()) {
					return false;
				}
				return true;
			}
			if(!firstMove && end.getRank() == start.getRank() -1) {
				if(b.getPosition(end.getRank(), end.getFile()).isOccupied()) {
					return false;
				}
				return true;
			}


			return false;
		}
	}
	
	

}
