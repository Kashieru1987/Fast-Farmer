package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public enum Tiles {

	GRASS(Color.GREEN),
	SOIL(new Color(101,67,33));

	Color color;

	private Tiles(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

}
