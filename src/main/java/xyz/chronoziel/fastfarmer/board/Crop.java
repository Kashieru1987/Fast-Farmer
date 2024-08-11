package xyz.chronoziel.fastfarmer.board;

import java.awt.Color;

import xyz.chronoziel.fastfarmer.tools.Useable;

public abstract class Crop extends Tile implements Useable {

	private CropStages cropStage;
	protected Color color;

	private Crop(CropStages cropStage) {
		super(Tiles.WET_SOIL);
		this.cropStage = cropStage;
	}

	public Color getColor() {
		return this.color;
	}
	
	public CropStages getCropStage() {
		return this.cropStage;
	}

	public static class Wheat extends Crop {
		
		public Wheat() {
			this(CropStages.SEED);
		}

		public Wheat(CropStages cropStage) {
			super(cropStage);
			this.color = Color.YELLOW;
		}

		@Override
		public void use() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String toString() {
			return "Wheat";
		}
		
	}
	
	public static class Pumpkin extends Crop {
		
		public Pumpkin() {
			this(CropStages.SEED);
		}

		public Pumpkin(CropStages cropStage) {
			super(cropStage);
			this.color = Color.ORANGE;
		}

		@Override
		public void use() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String toString() {
			return "Pumpkin";
		}

	}

}
