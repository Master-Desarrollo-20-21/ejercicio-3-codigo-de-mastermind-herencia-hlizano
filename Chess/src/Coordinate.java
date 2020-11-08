
public class Coordinate {
	private int row;
	private int column;
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public Coordinate() {
		// TODO Auto-generated constructor stub
	}

	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public boolean equal(Coordinate coordinate) {
		return this.row == coordinate.getRow() && this.column == coordinate.getColumn();
	}

    public void position(String msg) {
        boolean error = false;
        do {
            GestorIO gestorIO = new GestorIO();
            gestorIO.out(msg);
            gestorIO.out("Introduce fila [1,8]: ");
            this.row = gestorIO.inInt();
            this.row--;
            gestorIO.out("Introduce columna [1,8]: ");
            this.column = gestorIO.inInt();
            this.column--;
            error = !this.isValid();
            if (error) {
                new GestorIO().out("Error!!! Valores fuera de rango\n");
            }
        } while (error);
    }
	
    private boolean isValid() {
        return 0 <= this.row && this.row <= 7 &&
        		0 <= this.column && this.column <= 7;
    }
	
}
