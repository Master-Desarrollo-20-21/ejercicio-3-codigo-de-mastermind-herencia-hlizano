
public class Chess {
	private Board board;
	private Player[] players;
	private Turn turn;
	
	public Chess() {
		board = new Board();
		players = new Player[2];
		players[0] = new Player("white");
		players[1] = new Player("black");
		turn = new Turn();
	}
	
	public void play() {
		do {
			board.show();
			players[turn.toPlay()].movePiece(board);
			turn.change();				
		} while(!board.isMate());
		
		board.show();
		players[turn.notToPlay()].victory();
	}

	public static void main(String[] args) {
		new Chess().play();
	}

}
