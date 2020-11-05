package com.escuelait;

public class ProposalCombination extends Combination {

	private int whites;
	private int blacks;
	private GestorIO gestorIO;
	
	public ProposalCombination(String colors, int blacks, int whites) {
		this.colors = colors;
		this.blacks = blacks;
		this.whites = whites;
		gestorIO = new GestorIO();
	}

	public ProposalCombination() {
		this.colors = "";
		this.blacks = 0;
		this.whites = 0;
		gestorIO = new GestorIO();
	}

	@Override
	public String toString() {
		return colors + " --> " + blacks + " blacks " + "and " + whites + " whites";
	}

	public static boolean checkLength(String colors) {		
		return colors.length()==4;
	}

	public static boolean isValidColors(String colors) {	
		boolean isValid = false;
		for(int i = 0; i< colors.length(); i++) {
			String color = Character.toString(colors.charAt(i));
			for(Color c : Color.values()) {
				if(c.name().equals(color)) {
					isValid = true;
				}
			}			
		}		
		return isValid;
	}
	
	public boolean checkProposalCombination(String colors) {
		if (!checkLength(colors)) {
			gestorIO.out("Wrong proposed combination length\n");
			return false;
		}

		if (!isValidColors(colors)) {
			gestorIO.out("Wrong colors, they must be: rbygop\n");
			return false;
		}
		return true;
	}
	
	public int getBlacks() {
		return this.blacks;
	}
}
