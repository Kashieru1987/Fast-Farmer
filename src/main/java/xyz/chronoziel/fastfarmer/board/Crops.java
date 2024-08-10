package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public enum Crops {

	WHEAT(Color.YELLOW),
	PUMPKIN(Color.ORANGE);

	private Color color;
	
	private Crops(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

}
