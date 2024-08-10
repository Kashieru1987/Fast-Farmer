package xyz.chronoziel.fastfarmer.board;

public enum CropStages {

	SEED(2),
	SPROUT(4),
	PLANT(8);
	
	private int size;
	
	private CropStages(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
}
