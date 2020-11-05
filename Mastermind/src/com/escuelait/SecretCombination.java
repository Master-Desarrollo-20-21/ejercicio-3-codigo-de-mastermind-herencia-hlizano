package com.escuelait;

public class SecretCombination extends Combination {
	
	public SecretCombination() {
				
		for (int i = 0; i < 4; i++) {
			String color = "";
			color += Color.getRandomColor();
			for(int j = 0; j<i; j++) {
				String colorList = String.valueOf(this.colors.charAt(j));
				while(color.equals(colorList)) {
					color = Color.getRandomColor();
				} 		
			}	
			this.colors += color;
		}
	}
	
}
