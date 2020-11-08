//import static util.Constants.A;


public class Board {

	private Square[][] square;
	
	public Board() {
		square = new Square[8][8];
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				square[i][j] = new Square();
			}
		}
		this.initializePieces();
	}	
	
	private void initializePieces() {
		this.putEmptySquares();
		this.putPawns();
		this.putRooks();
		this.putKnights();
		this.putBishops();
		this.putQueens();
		this.putKings();
	}		

	private void putKings() {
		square[0][3].setPiece(new King('K', "white"));
		square[7][3].setPiece(new King('k', "black"));
		
	}

	private void putQueens() {
		square[0][4].setPiece(new Queen('Q', "white"));
		square[7][4].setPiece(new Queen('q', "black"));
		
	}

	private void putBishops() {
		square[0][2].setPiece(new Bishop('B', "white"));
		square[0][5].setPiece(new Bishop('B', "white"));
		square[7][2].setPiece(new Bishop('b', "black"));
		square[7][5].setPiece(new Bishop('b', "black"));		
	}

	private void putKnights() {
		square[0][1].setPiece(new Knight('H', "white"));
		square[0][6].setPiece(new Knight('H', "white"));
		square[7][1].setPiece(new Knight('h', "black"));
		square[7][6].setPiece(new Knight('h', "black"));
		
	}

	private void putRooks() {
		square[0][0].setPiece(new Rook('R', "white"));
		square[0][7].setPiece(new Rook('R', "white"));
		square[7][0].setPiece(new Rook('r', "black"));
		square[7][7].setPiece(new Rook('r', "black"));				
	}

	private void putPawns() {
		for(int i = 0; i<8; i++) {
			square[1][i].setPiece(new Pawn('P', "white"));
			square[6][i].setPiece(new Pawn('p', "black"));			
//			square[1][i].setPiece(new EmptySquare('_', "none"));
//			square[6][i].setPiece(new EmptySquare('_', "none"));
		}		
	}	
	
	private void putEmptySquares() {
		for(int i = 2; i<6; i++) {
			for(int j = 0; j<8; j++) {
				square[i][j].setPiece(new EmptySquare('_', "none"));
			}			
		}		
	}	
	
	public void show() {
		GestorIO gestorIO = new GestorIO();
		gestorIO.out(" ");
		for(int i = 0; i<8; i++) {
			gestorIO.out(" ");
			gestorIO.out(i+1);
		}
		gestorIO.out("\n");
		for(int i = 0; i<8; i++) {
			gestorIO.out(i+1);
			for(int j = 0; j<8; j++) {
				square[i][j].getPiece().show();
			}
			gestorIO.out("\n");
		}		
	}

	public boolean isMate() {
		int kingQuantity = 0;
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				char piece = square[i][j].getPiece().getName();
				if(piece =='k' || piece == 'K') {
					kingQuantity++;
				} 
			}
		}
		return kingQuantity == 1;
	}

	public void movePiece(Coordinate origin, Coordinate destiny) {
		square[destiny.getRow()][destiny.getColumn()].setPiece(square[origin.getRow()][origin.getColumn()].getPiece());
		square[origin.getRow()][origin.getColumn()].setPiece(new EmptySquare('_', "none"));
	}

	public Piece getPiece(Coordinate origin) {		
		return square[origin.getRow()][origin.getColumn()].getPiece();
	}
	
	public Square getSquare(int row, int column) {
		return square[row][column];
	}

}
