package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public enum Tiles {

	GRASS(new Color(0, 128, 0)),
	DRY_SOIL(new Color(111, 78, 55)),
	WET_SOIL(new Color(101, 67, 33));

	Color color;

	private Tiles(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

}
