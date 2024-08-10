package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public class Crop extends Tile {

	private Crops cropType;
	private CropStages cropStage;
	private Color color;

	public Crop(Crops cropType) {
		super(Tiles.WET_SOIL);
		this.cropType = cropType;
		this.color = cropType.getColor();
		this.cropStage = CropStages.SEED;
	}

	public Crops getCropType() {
		return this.cropType;
	}

	public Color getColor() {
		return this.color;
	}

	public CropStages getCropStage() {
		return this.cropStage;
	}

}
