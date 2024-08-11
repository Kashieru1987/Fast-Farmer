package xyz.chronoziel.fastfarmer.board.tile;

import xyz.chronoziel.fastfarmer.constants.TileConstants;

public enum CropStages {

	SEED(4),
	SPROUT(8),
	PLANT(16);
	
	private int size;
	
	private CropStages(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}

	public CropStages getNextCropStage() {
		return switch(this) {
		case SEED -> SPROUT;
		case SPROUT -> PLANT;
		case PLANT -> PLANT;
		};
	}

	public int getTimeout() {
		return switch(this) {
		case SEED -> TileConstants.SEED_TIMEOUT;
		case SPROUT -> TileConstants.SPROUT_TIMEOUT;
		case PLANT -> TileConstants.PLANT_TIMEOUT;
		};
	}
	
}
