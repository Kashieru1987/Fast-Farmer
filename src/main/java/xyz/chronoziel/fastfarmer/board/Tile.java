package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public class Tile {

	private Tiles tileType;
	private Color color;


	public Tile(Tiles tileType) {
		this.tileType = tileType;
		this.color = tileType.getColor();
	}

	public Color getColor() {
		return this.color;
	}

	public Tiles getTileType() {
		return tileType;
	}

}
