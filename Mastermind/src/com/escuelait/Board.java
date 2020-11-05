package com.escuelait;

public class Board {
	private int attempt;
	String colors;
	private SecretCombination secretCombination;
	private ProposalCombination[] proposalCombinations;	
	
	private static final int MAX_ATTEMPTS = 11;
	
	private GestorIO gestorIO;
	
	public Board() {
		secretCombination = new SecretCombination();
		proposalCombinations = new ProposalCombination[MAX_ATTEMPTS];
		attempt = 0;
		colors = "";
		gestorIO = new GestorIO();
	}
		
	public void show() {		
		gestorIO.out("-----MASTERMIND-----\n");
		for (int i = 0; i<attempt; i++) {
			gestorIO.out(i + " attempt(s):\n");
			gestorIO.out(secretCombination.colors);
			gestorIO.out("  <-- xxxx secret for tests\n");
	
			if (attempt > 0) {					
				gestorIO.out(proposalCombinations[i].toString() + "\n");			
			}
		}
	}
		
	public void getNewProposalCombination() {				
		boolean isValid;
		ProposalCombination tempPC = new ProposalCombination();
		do {
			colors = "";
			gestorIO.out("Propose a combination: ");
			colors = gestorIO.inString().toLowerCase();
			isValid = tempPC.checkProposalCombination(colors);
		} while (!isValid);
	}

	public void processProposalCombination() {
		int whites = 0, blacks = 0;
		for(int i = 0; i<4; i++) {
			char colorProposal = colors.charAt(i);

			for(int j = 0; j<4; j++) {	
				char colorSecret = secretCombination.colors.charAt(j);
				if(Character.compare(colorProposal, colorSecret) == 0 && i==j) {
					blacks++;
				} else {
					if(Character.compare(colorProposal, colorSecret) == 0 ) {
						whites++;
					}
				}		
			}			
		}
		proposalCombinations[attempt] = new ProposalCombination(colors, blacks, whites);
		attempt++;
	}
	
	public boolean gameEnded() {
		if(proposalCombinations[attempt-1].getBlacks()== 4) {
			gestorIO.out("You've won!!! ;-)");
			return true;
		}
		if(attempt==MAX_ATTEMPTS) {
			gestorIO.out("You've lost!!! :-(");
			return true;
		}
		return false;		
	}
	
}

