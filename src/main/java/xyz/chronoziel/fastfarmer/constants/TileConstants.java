package xyz.chronoziel.fastfarmer.constants;

public class TileConstants {

	private TileConstants() {
	}

	private final static int SECONDS = 1000;
	private final static int MINUTES = SECONDS * 60;

	public final static int DRY_SOIL_TIMEOUT = MINUTES * 1;
	public final static int WET_SOIL_TIMEOUT = MINUTES * 2;
	public final static int SOIL_TIMEOUT_VARIANCE = SECONDS * 30;

	public final static int SEED_TIMEOUT = MINUTES * 1;
	public final static int SPROUT_TIMEOUT = MINUTES * 1 + SECONDS * 30;
	public final static int PLANT_TIMEOUT = MINUTES * 2;
	public final static int CROP_TIMEOUT_VARIANCE = SECONDS * 30;

}
