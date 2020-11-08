
public class EmptySquare extends Piece{

	public EmptySquare(char name, String color) {
		super(name,color);
	}

	@Override
	protected String validate(Board board, Player player, Coordinate origin, Coordinate destiny) {
		// TODO Auto-generated method stub
		return null;
	}

}
