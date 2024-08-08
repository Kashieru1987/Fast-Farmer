package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public class Tile {

	Color color;

	public Tile(Color color) {
		this.color = color;
	}

	public Tile(Tiles tileType) {
		this(tileType.getColor());
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

}
