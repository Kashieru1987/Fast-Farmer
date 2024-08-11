package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

public abstract class Crop extends Tile {

	private CropStages cropStage;
	protected Color color;

	private Crop() {
		super(Tiles.WET_SOIL);
		this.cropStage = CropStages.SEED;
	}

	public Color getColor() {
		return this.color;
	}
	
	public CropStages getCropStage() {
		return this.cropStage;
	}

	public static class Wheat extends Crop {
		
		public Wheat() {
			super();
			this.color = Color.YELLOW;
		}
		
	}
	
	public static class Pumpkin extends Crop {
		
		public Pumpkin() {
			super();
			this.color = Color.ORANGE;
		}

	}

}
