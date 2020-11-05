package com.escuelait;

public class Mastermind {

	private GestorIO gestorIO;
	private Board board;

	public Mastermind() {
		gestorIO = new GestorIO();
		board = new Board();
	}

	public void play() {
		
		boolean resume = true;		

		do {
			board.show();
			board.getNewProposalCombination(); 
			board.processProposalCombination();
			
			if(board.gameEnded()) {
				gestorIO.out("RESUME? (y/n): ");
				if (gestorIO.inChar() != 'y')
					resume = false;
				else
					board = new Board();
			}
		} while (resume);
		
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
