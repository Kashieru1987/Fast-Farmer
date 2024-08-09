package xyz.chronoziel.fastfarmer.constants;

import java.awt.Color;
import java.awt.Dimension;

public class GeneralConstants {

	private GeneralConstants() {
	}

	public final static String TITLE = "Fast Farmer";
	public final static int FRAME_WIDTH_OFFSET = 16;
	public final static int FRAME_HEIGHT_OFFSET = 39;
	public final static Dimension SIZE = new Dimension(FRAME_WIDTH_OFFSET + 800, FRAME_HEIGHT_OFFSET + 639);
	public final static Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	public static final Color GRID_LINE_COLOR = Color.DARK_GRAY;
	public final static Dimension DEFAULT_BOARD_SIZE = new Dimension(10, 10);

}
