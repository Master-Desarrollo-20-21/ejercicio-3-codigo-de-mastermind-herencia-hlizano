package com.escuelait;

import java.util.Random;

public enum Color {
	r, y, g, o, b, p;

	public static String getRandomColor() {
		Random random = new Random();
		return values()[random.nextInt(values().length)].toString();
	}

}