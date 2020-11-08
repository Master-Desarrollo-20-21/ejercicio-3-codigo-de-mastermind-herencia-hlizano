
public class Turn {
	
	private int value;
	
	public Turn() {
	value = 0;
	}

	public int toPlay() {
		return value;
	}
	
	public int notToPlay() {
		return (value + 1) % 2;
	}

	public void change() {
		this.value = this.notToPlay();		
	}

}
