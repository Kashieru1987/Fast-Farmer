package xyz.chronoziel.fastfarmer.constants;

public class TileConstants {

	private TileConstants() {
	}

	private final static int SECONDS = 1000;

	public final static int DRY_SOIL_TIMEOUT = SECONDS * 30;
	public final static int WET_SOIL_TIMEOUT = SECONDS * 60;
	public final static int SOIL_TIMEOUT_VARIANCE = SECONDS * 20;

}
