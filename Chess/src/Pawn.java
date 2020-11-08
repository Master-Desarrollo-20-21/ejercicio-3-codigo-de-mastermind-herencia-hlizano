public class Pawn extends Piece{
	
	public Pawn(char name, String color) {
		super(name,color);
	}	

	@Override
	protected String validate(Board board, Player player, Coordinate origin, Coordinate destiny) {
		this.originX = origin.getRow();
		this.originY = origin.getColumn();
		this.destinyX = destiny.getRow();
		this.destinyY = destiny.getColumn();
		switch(this.getName()) {
		case 'P':
			return this.validateWhites(board, player, destiny);			
		case 'p':
			return this.validateBlacks(board, player, destiny);		
		}
		return "ERROR ficha inválida";
		
	}

	private String validateWhites(Board board, Player player, Coordinate destiny) {
		if(originX + 1 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(player.firstMovement() && originX + 2 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(originX + 1 == destinyX && originY-1 == destinyY && board.getPiece(destiny).getColor().equals("black")) {
			return "";
		}
		if(originX + 1 == destinyX && originY+1 == destinyY && board.getPiece(destiny).getColor().equals("black")) {
			return "";
		}		
		return "ERROR a la hora de querer mover el peon blanco";
	}

	private String validateBlacks(Board board, Player player, Coordinate destiny) {
		if(originX - 1 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(player.firstMovement() && originX - 2 == destinyX && originY == destinyY && board.getPiece(destiny).getName()=='_') {
			return "";
		}
		if(originX - 1 == destinyX && originY-1 == destinyY && board.getPiece(destiny).getColor().equals("white")) {
			return "";
		}
		if(originX - 1 == destinyX && originY+1 == destinyY && board.getPiece(destiny).getColor().equals("white")) {
			return "";
		}		
		return "ERROR a la hora de querer mover el peon negro";
	}

}
