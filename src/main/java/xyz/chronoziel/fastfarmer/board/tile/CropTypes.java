package xyz.chronoziel.fastfarmer.board.tile;

import java.awt.Color;

public enum CropTypes {
	WHEAT(Color.YELLOW),
	PUMPKIN(Color.ORANGE);

	private Color color;
	
	private CropTypes(Color color) {
		this.color = color;
	}

	public Color getCropColor() {
		return this.color;
	}

}
