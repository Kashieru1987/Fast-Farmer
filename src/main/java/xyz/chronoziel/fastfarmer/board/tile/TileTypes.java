package xyz.chronoziel.fastfarmer.board.tile;

import java.awt.Color;

public enum TileTypes {

	GRASS(new Color(0, 128, 0)),
	DRY_SOIL(new Color(111, 78, 55)),
	WET_SOIL(new Color(101, 67, 33));

	Color color;

	private TileTypes(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}

}
