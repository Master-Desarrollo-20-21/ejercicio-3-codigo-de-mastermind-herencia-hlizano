public class Knight extends Piece{

	public Knight(char name, String color) {
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
		if(originX-2  == destinyX && (originY-1 == destinyY || originY+1 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}	
		if(originX+2  == destinyX && (originY-1 == destinyY || originY+1 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}
		if(originX-1  == destinyX && (originY-2 == destinyY || originY+2 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}
		if(originX+1  == destinyX && (originY-2 == destinyY || originY+2 == destinyY) && !board.getPiece(destiny).getColor().equals(color)) {
			return "";
		}
		return "ERROR a la hora de querer mover el caballo";
	}	
}