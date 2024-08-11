package xyz.chronoziel.fastfarmer.board.tile;

import java.awt.Color;

public class Tile {

	private TileTypes tileType;
	private Color color;


	public Tile(TileTypes tileType) {
		this.tileType = tileType;
		this.color = tileType.getColor();
	}

	public Color getColor() {
		return this.color;
	}

	public TileTypes getTileType() {
		return tileType;
	}

}
