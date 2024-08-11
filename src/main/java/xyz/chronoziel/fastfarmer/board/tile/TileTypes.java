package xyz.chronoziel.fastfarmer.board.tile;

import java.awt.Color;

import xyz.chronoziel.fastfarmer.constants.TileConstants;

public enum TileTypes {

	GRASS(new Color(0, 128, 0), 0),
	DRY_SOIL(new Color(111, 78, 55), TileConstants.DRY_SOIL_TIMEOUT),
	WET_SOIL(new Color(101, 67, 33), TileConstants.WET_SOIL_TIMEOUT);

	private Color color;
	private int timeout;

	private TileTypes(Color color, Integer timeout) {
		this.color = color;
		this.timeout = timeout;
	}
	
	public Color getColor() {
		return this.color;
	}

	public int getTimeout() {
		return this.timeout;
	}

	public TileTypes getNextRegression() {
		return switch(this) {
		case GRASS -> GRASS;
		case DRY_SOIL -> GRASS;
		case WET_SOIL -> DRY_SOIL;
		};
	}

}
