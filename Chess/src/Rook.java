public class Rook extends Piece{

	public Rook(char name, String color) {
		super(name,color);
	}

	@Override
	protected String validate(Board board, Player player, Coordinate origin, Coordinate destiny) {
		this.originX = origin.getRow();
		this.originY = origin.getColumn();
		this.destinyX = destiny.getRow();
		this.destinyY = destiny.getColumn();
		return this.validate(board, destiny, color);			

	}

	private String validate(Board board, Coordinate destiny, String color) {
		if( originX  == destinyX && originY!= destinyY && !board.getPiece(destiny).getColor().equals(color)) {
			boolean freeRoad = this.isFreeHorizontalPath(board, originY, destinyY);
			if(freeRoad) 
				return "";
			else 
				return "Error, hay piezas en medio del camino";
		}
		if( originY == destinyY && originX!=destinyX && !board.getPiece(destiny).getColor().equals(color)) {
			boolean freeRoad = this.isFreeVerticalPath(board, originX, destinyX);
			if(freeRoad) 
				return "";
			else 
				return "Error, hay piezas en medio del camino";
		}
		return "ERROR a la hora de querer mover la torre";
	}
	
	protected boolean isFreeHorizontalPath(Board board, int coordY1, int coordY2 ) {
		if(coordY1<coordY2) {
			for(int i = coordY1+1; i<coordY2; i++) {
				if(board.getPiece(new Coordinate(originX, i)).getName()!='_') {
					return false;
				}
			}
			return true;
		}
		if(coordY1>coordY2) {
			for(int i = coordY2+1; i<coordY1; i++) {
				if(board.getPiece(new Coordinate(originX, i)).getName()!='_') {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	protected boolean isFreeVerticalPath(Board board, int coordX1, int coordX2 ) {
		if(coordX1<coordX2) {
			for(int i = coordX1+1; i<coordX2; i++) {
				if(board.getPiece(new Coordinate(i, originY)).getName()!='_') {
					return false;
				}
			}
			return true;
		}
		if(coordX1>coordX2) {
			for(int i = coordX2+1; i<coordX1; i++) {
				if(board.getPiece(new Coordinate(i, originY)).getName()!='_') {
					return false;
				}
			}
			return true;
		}
		return false;
	}
}