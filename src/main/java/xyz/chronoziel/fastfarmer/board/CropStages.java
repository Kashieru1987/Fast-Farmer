package xyz.chronoziel.fastfarmer.board;

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
	
}
