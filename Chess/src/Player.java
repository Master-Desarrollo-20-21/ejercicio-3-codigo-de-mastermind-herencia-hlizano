
public class Player {
	private int movements;
	
	private String color;
	
	public Player(String color){
		this.color = color;	
		this.movements = 0;
	}
	
	public boolean firstMovement() {
		return movements == 0;
	}

	public void movePiece(Board board) {
		new GestorIO().out("\nToca mover al jugador con fichas de color: " + color + "\n");		
		Coordinate origin = new Coordinate();
        Coordinate destiny = new Coordinate();
        String error = "";
        do {
            origin.position("Escoja la posición de la ficha que quiere mover \n");
            Piece piece = board.getPiece(origin);            
            destiny.position("Escoja la posición donde quiere poner la ficha");            
            error = this.validateMove(board, piece, origin, destiny);
            if (!error.equals("")) {
                new GestorIO().out(error + "\n");
            }
        } while (!error.equals(""));	
        this.movements++;
		board.movePiece(origin, destiny);
	}

	private String validateMove(Board board, Piece piece, Coordinate origin, Coordinate destiny) {	      
		if (piece.color != this.color) {
			return "Solo puede mover en coordenadas donde existan fichas suyas";
		}
		return piece.validate(board, this, origin, destiny);
	}
	
	public void victory() {
		new GestorIO().out("He ganado!! " + color + "\n");
		
	}
	
}
